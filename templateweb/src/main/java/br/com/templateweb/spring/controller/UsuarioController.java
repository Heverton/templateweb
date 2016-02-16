
package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.model.Usuario;
import br.com.templateweb.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private static final String LISTAR_PAGE = "/usuario/listarUsuario";
    private static final String MANTER_PAGE = "/usuario/manterUsuario";
    private static final String USUARIO_KEY = "usuario";
    private static final String USUARIOS_KEY = "usuarios";

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        return new ModelAndView(MANTER_PAGE, USUARIO_KEY, new Usuario());
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute(USUARIO_KEY, new Usuario());
        model.addAttribute(USUARIOS_KEY, usuarioService.listar());
        return LISTAR_PAGE;
    }

    @RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
    public String remover(@PathVariable("id") long id) {
        this.usuarioService.deletar(id);
        return "redirect:/usuario/listar";
    }

    @RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") long id) {
        return new ModelAndView(MANTER_PAGE, USUARIO_KEY, usuarioService.recuperar(id));
    }

    @RequestMapping(value = "/manter", method = {RequestMethod.GET, RequestMethod.POST})
    public String manter(@Valid @ModelAttribute(USUARIO_KEY) Usuario usuario,
                         BindingResult result, SessionStatus status, Model model) {

        if (!result.hasErrors()) {
            boolean sucesso = this.usuarioService.salvarOuAtualizar(usuario);
            if (sucesso) {
                status.setComplete();
                return "redirect:/usuario/listar";
            } else {
                setMensagemNegocial(model, "Usuário já cadastrado");
            }
        }
        return MANTER_PAGE;
    }

    @RequestMapping(value = "/pesquisar", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView pesquisar(@ModelAttribute(USUARIO_KEY) Usuario usuario, Model model) {
        List<Usuario> usuarios = usuarioService.pesquisar(usuario);
        if (usuarios == null || usuarios.isEmpty()) {
            setMensagemNegocial(model, "Nenhum usuário encontrado");
        }
        return new ModelAndView(LISTAR_PAGE, USUARIOS_KEY, usuarios);
    }

    private void setMensagemNegocial(Model model, String mensagem) {
        model.addAttribute("usuario_mensagem_negocial", mensagem);
    }
}
