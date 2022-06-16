package com.proyecto.test.app.controller;

import com.proyecto.test.app.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendMailController {
    
    @Autowired
    private SendMailService sendMailService;
    
    @PostMapping(value="/contacto")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail,@RequestParam("body") String body) {
        String message = "Datos de contacto: " + "\n Nombre: " + name + "\n Email: " + mail + "\n Consulta: " + body;
        sendMailService.sendMail("marcojime23@gmail.com", "marcojime23@gmail.com", "Formulario de Contacto CodeForFree", message);
        return "contacto";
    }
    
    /*
    @PostMapping(value={"/","/inicio"})
    public String suscription(@RequestParam("mail") String mail) {
        String message = "Por este medio le comunicamos que usted se ha suscrito satisfactoriamente al boletín de CodeForFree con el correo: ".concat(mail);
        sendMailService.sendMail("marcojime23@gmail.com", "marcojime23@gmail.com", "Suscripción boletín de Librería Nacional", message);
        return "inicio";
    }
    */
    
}
