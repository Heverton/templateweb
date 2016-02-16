package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.service.UsuarioService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UsuarioService usuarioService;

    @Autowired
    public AdminController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login Aceito");
        model.addObject("message", "Bem vindo");
        model.setViewName("admin/index");
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Logger logger = Logger.getLogger(AdminController.class.getName());
        logger.log(Level.CONFIG, "auth: "+auth.getName()+" - "+auth.toString());
        
        /**
        auth: admin - 
                org.springframework.security.authentication.UsernamePasswordAuthenticationToken@be653ef9: 
        Principal: 
            org.springframework.security.core.userdetails.User@586034f: 
                Username: 
                    admin; 
                Password: 
                    [PROTECTED]; 
                    Enabled: true; 
                    AccountNonExpired: true; 
                    credentialsNonExpired: true; 
                    AccountNonLocked: true; 
                    Granted Authorities: ROLE_USER; 
                    Credentials: [PROTECTED]; 
                    Authenticated: true; 
                    Details: 
                        org.springframework.security.web.authentication.WebAuthenticationDetails@fffe3f86: 
                    RemoteIpAddress: 127.0.0.1; 
                        SessionId: 12F8F75BE547ACF8DF3C0FEE2C0B789B; 
                    Granted Authorities: ROLE_USER
        */
        
        return model;

    }
}
