package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/revenda")
public class RevendaController {

    private final UsuarioService usuarioService;

    @Autowired
    public RevendaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

     @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        return new ModelAndView("/revenda/revenda", "revenda", new Object());
    }

}
