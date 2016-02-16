package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final String LOGIN_ERROR = "error";
    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Canal de Acesso");
        model.setViewName("login/login");
        return model;
    }
    
    @RequestMapping(value = {"/bemvindo"}, method = RequestMethod.GET)
    public String bemvindo() {
        return "redirect:/admin/index";
    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(HttpServletRequest request, HttpSession session) {
        ModelAndView model = new ModelAndView();
        model.addObject(LOGIN_ERROR, getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        model.setViewName("login/login?error");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView efetuarlogout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("login/");

        return model;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Usuário e Senha Inválido!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Usuário e Senha Inválido!";
        }

        return error;
    }

}
