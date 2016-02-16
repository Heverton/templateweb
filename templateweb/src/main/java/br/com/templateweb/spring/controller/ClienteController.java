package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final UsuarioService usuarioService;

    @Autowired
    public ClienteController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = {"/","/cliente"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login Aceito");
        model.setViewName("cliente/cliente");
        return model;
    }
}
