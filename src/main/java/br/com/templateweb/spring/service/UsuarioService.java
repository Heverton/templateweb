package br.com.templateweb.spring.service;

import br.com.templateweb.spring.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean emailJaExiste(Usuario usuario);

    boolean salvarOuAtualizar(Usuario usuario);

    void deletar(Long id);

    Usuario recuperar(Long id);

    List<Usuario> pesquisar(Usuario usuario);

    List<Usuario> listar();

}
