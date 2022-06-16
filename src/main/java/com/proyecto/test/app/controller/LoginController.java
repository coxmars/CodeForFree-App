package com.proyecto.test.app.controller;

import com.proyecto.test.app.model.Cliente;
import com.proyecto.test.app.service.IClienteService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private IClienteService clienteService;
    
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model, Principal principal, RedirectAttributes flash) {
        if (principal != null) {
            flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
        }
        if (logout != null) {
            model.addAttribute("success", "Ha cerrado sesión con éxito!");
        }
        return "login";
    }
    
    @RequestMapping(value="/auth/registro")
    public String form (Model model) {
        model.addAttribute("usuario", new Cliente());
        return "registro";
    }
    
    @PostMapping("auth/registro")
    public String guardarUsuario(@Valid @RequestBody @ModelAttribute Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/auth/registro";
        }
        else {
            model.addAttribute("usuario",clienteService.registrar(cliente));
        }
        return "redirect:/login";
    }
}
