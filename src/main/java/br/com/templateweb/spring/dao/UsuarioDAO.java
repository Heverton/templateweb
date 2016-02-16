package br.com.templateweb.spring.dao;

import br.com.thiaguten.persistence.dao.BaseDAO;
import br.com.templateweb.spring.model.Usuario;


import java.util.List;

public interface UsuarioDAO extends BaseDAO<Usuario, Long> {

    List<Usuario> pesquisar(Usuario u);

    Long contarPorEmail(Usuario u);

}
