package br.com.templateweb.spring.service;

import br.com.templateweb.spring.model.Pagina;

import java.util.List;

public interface PaginaService {

    boolean salvarOuAtualizar(Pagina pagina);

    void deletar(Long id);

    Pagina recuperar(Long id);

    List<Pagina> pesquisar(Pagina pagina);

    List<Pagina> listar();

}
