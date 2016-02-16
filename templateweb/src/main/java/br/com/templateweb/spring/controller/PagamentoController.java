package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    private final UsuarioService usuarioService;

    @Autowired
    public PagamentoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @RequestMapping(value = {"/","/pagamento"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login Aceito");
        model.setViewName("pagamento/pagamento");
        return model;
    }
}
