package com.proyecto.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class IndexController {
    
    @RequestMapping(value={"/","/inicio"})
    public String inicio() {
        return "inicio";
    }
    
    @RequestMapping(value="/contacto")
    public String contacto () {
        return "contacto";
    }
    
    @RequestMapping(value="/preguntas")
    public String preguntas () {
        return "preguntas";
    }
    
    @RequestMapping(value="/nosotros")
    public String nosotros () {
        return "nosotros";
    }
    
    @RequestMapping(value="/cursos")
    public String cursos () {
        return "cursos";
    }
    
    @RequestMapping(value="/blog")
    public String blog () {
        return "blog";
    }
    
    @RequestMapping(value="/blog1")
    public String blog1 () {
        return "blog1";
    }
    
    @RequestMapping(value="/blog2")
    public String blog2 () {
        return "blog2";
    }
    
    @RequestMapping(value="/blog3")
    public String blog3 () {
        return "blog3";
    }
    
    @RequestMapping(value="/blog4")
    public String blog4 () {
        return "blog4";
    }
    
    @RequestMapping(value="/blog5")
    public String blog5 () {
        return "blog5";
    }
    
    @RequestMapping(value="/blog6")
    public String blog6 () {
        return "blog6";
    }
}
