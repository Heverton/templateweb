package br.com.templateweb.spring.controller;

import br.com.templateweb.spring.model.Pagina;
import br.com.templateweb.spring.service.PaginaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/site")
public class SiteController {

    private static final String PAGINA_KEY = "pagina";
    private static final String PAGINAS_KEY = "paginas";
    private final PaginaService paginaService;

    @Autowired
    public SiteController(PaginaService paginaService) {
        this.paginaService = paginaService;
    }

    /**
     * Inicializa a index já realizando uma busca no banco de dados
     * quando é realizado a busca das informações de GALERIA e INSTITUCIONAL
     * 
     * @return 
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView index() {

        paginaService.listar();
        
        List<Pagina> paginas = new ArrayList<>();
        
        ModelAndView model = new ModelAndView("site/index", PAGINAS_KEY, paginas);
        
        paginas.add(new Pagina("PAGINA DE INSTITUCIONAL"));
        paginas.add(new Pagina("PAGINA DE GALERIA"));
        
        //CARGA INICIAL DE DADOS COM PAGINAS
        for (Pagina pagina : paginas) {
            if (paginaService.salvarOuAtualizar(pagina)) {
                model.addObject("title", "Pagina Index");
                model.addObject("message", "Iniciado com sucesso...");                
            } else {
                model.addObject("message", "Iniciado com falha...");
                break;
            }
        }
        
        return model;
    }

    @RequestMapping(value = {"/paginstitucional"}, method = RequestMethod.GET)
    public String institucional(Model model) {
        model.addAttribute("title", "Pagina Institucional");
        model.addAttribute("message", "Bem-vindo");
        model.addAttribute(PAGINA_KEY, new Pagina());
        model.addAttribute(PAGINAS_KEY, paginaService.listar());
        return "redirect:/site/institucional";
        //return new ModelAndView("site/institucional");
    }

    @RequestMapping(value = {"/paggaleria"}, method = RequestMethod.GET)
    public String galeria(Model model) {
        model.addAttribute("title", "Pagina Galeria");
        model.addAttribute("message", "Bem-vindo");
        model.addAttribute(PAGINA_KEY, new Pagina());
        model.addAttribute(PAGINAS_KEY, paginaService.listar());
        return "redirect:/site/galeria";
        //return new ModelAndView("site/galeria");
    }
}
