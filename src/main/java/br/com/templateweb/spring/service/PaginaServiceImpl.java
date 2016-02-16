package br.com.templateweb.spring.service;

import br.com.templateweb.spring.dao.PaginaDAO;
import br.com.templateweb.spring.model.Pagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("paginaService")
public class PaginaServiceImpl implements PaginaService {

    private final PaginaDAO paginaDAO;

    @Autowired
    public PaginaServiceImpl(PaginaDAO paginaDAO) {
        this.paginaDAO = paginaDAO;
    }

    @Override
    public boolean salvarOuAtualizar(Pagina pagina) {

        if (pagina.hasID()) {
            paginaDAO.update(pagina);
        } else {
            paginaDAO.save(pagina);
        }

        return true;
    }

    @Override
    public void deletar(Long id) {
        if (id != null) {
            paginaDAO.deleteById(id);
        }
    }

    @Override
    public List<Pagina> pesquisar(Pagina pagina) {
        List<Pagina> paginas = paginaDAO.pesquisar(pagina);
        if (paginas == null) {
            return Collections.emptyList();
        }
        return paginas;
    }

    @Override
    public List<Pagina> listar() {
        List<Pagina> paginas = paginaDAO.findByNamedQuery(Pagina.LISTAR_TODOS_NQ);
        if (paginas == null) {
            return Collections.emptyList();
        }
        return paginas;
    }

    @Override
    public Pagina recuperar(Long id) {
        Pagina pagina = null;
        if (id != null) {
            pagina = paginaDAO.findById(id);
        }
        return pagina;
    }

}
