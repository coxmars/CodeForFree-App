package com.proyecto.test.app.controller;

import com.proyecto.test.app.model.Cliente;
import com.proyecto.test.app.paginator.PageRender;
import com.proyecto.test.app.service.IClienteService;
import java.util.Map;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String list(@RequestParam(name = "page", defaultValue = "0") int pagina, Model model, Authentication authentication) {

        if (authentication != null) {
            logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
        }

        Pageable pageRequest = PageRequest.of(pagina, 5);
        Page<Cliente> cliente = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<Cliente>("/listar", cliente);
        model.addAttribute("titulo", "Listado de Clientes");
        model.addAttribute("clientes", cliente);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String create(Map<String, Object> model) {  // Here we use map as an alternative of Model
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de Cliente");
        return "form";
    }

    // This method is responsible for processing all the data
    @RequestMapping(value = "/form", method = RequestMethod.POST) // In the parameters we always need to put the object and BindingResult together
    public String save(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) { // Here we activate the validation with @Valid annotation
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        String flashMessage = cliente.getId() != null ? "El cliente ha sido editado correctamente" : "El cliente ha sido creado correctamente";
        clienteService.save(cliente);
        status.setComplete(); // This eliminate the customer object in the session, and finish the process
        flash.addFlashAttribute("success", flashMessage);
        return "redirect:listar"; // Redirect to the list page
    }

    @RequestMapping(value = "/form/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {  // With @PathVariable we pass the id
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findOne(id); // Here we get the customer by id
            if (cliente == null) {
                flash.addFlashAttribute("error", "El ID del cliente no existe en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del cliente no puede ser cero");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar cliente");
        return "form";
    }

    @RequestMapping(value = "/form/cuenta/{id}")
    public String editUserAccount(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {  // With @PathVariable we pass the id
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findOne(id); // Here we get the customer by id
            if (cliente == null) {
                flash.addFlashAttribute("error", "El ID del cliente no existe en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del cliente no puede ser cero");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar datos de la cuenta");
        model.put("boton", "Editar datos");
        return "form";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminate(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            clienteService.delete(id);
            flash.addFlashAttribute("success", "El cliente ha sido eliminado correctamente");
        }
        return "redirect:/listar";
    }

}
