package br.com.templateweb.spring.dao;

import br.com.templateweb.spring.model.Pagina;
import br.com.thiaguten.persistence.dao.BaseDAO;

import java.util.List;

public interface PaginaDAO extends BaseDAO<Pagina, Long> {

    List<Pagina> pesquisar(Pagina u);

    Long contarPorEmail(Pagina u);

}
