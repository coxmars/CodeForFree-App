package com.proyecto.test.app.controller;

import com.proyecto.test.app.model.Cliente;
import com.proyecto.test.app.service.IClienteService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value="/private")
public class PrivateController {
    
    @Autowired
    private IClienteService clienteService;
    
    @GetMapping("/index")
    public String index (Authentication auth, HttpSession session,RedirectAttributes flash) {
        String username = auth.getName();
        if (session.getAttribute("usuario")==null) {
            Cliente cliente = clienteService.findByUsername(username);
            cliente.setPasswd(null);
            String flashMessage = "Bienvenido a Code for free";
            flash.addFlashAttribute("success", flashMessage);
            session.setAttribute("cliente", cliente);
        }
        return "index";
    }
    
}