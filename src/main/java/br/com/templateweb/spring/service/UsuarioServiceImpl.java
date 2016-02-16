
package br.com.templateweb.spring.service;

import br.com.templateweb.spring.dao.UsuarioDAO;
import br.com.templateweb.spring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public boolean emailJaExiste(Usuario usuario) {
        return (usuarioDAO.contarPorEmail(usuario) > 0);
    }

    @Override
    public boolean salvarOuAtualizar(Usuario usuario) {
        if (!emailJaExiste(usuario)) {
            if (usuario.hasID()) {
                usuarioDAO.update(usuario);
            } else {
                usuarioDAO.save(usuario);
            }
            return true;
        }
        return false;
    }

    @Override
    public void deletar(Long id) {
        if (id != null) {
            usuarioDAO.deleteById(id);
        }
    }

    @Override
    public List<Usuario> pesquisar(Usuario usuario) {
        List<Usuario> usuarios = usuarioDAO.pesquisar(usuario);
        if (usuarios == null) {
            return Collections.emptyList();
        }
        return usuarios;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = usuarioDAO.findByNamedQuery(Usuario.LISTAR_TODOS_NQ);
//        List<Usuario> usuarios = usuarioDAO.findAll();
        if (usuarios == null) {
            return Collections.emptyList();
        }
        return usuarios;
    }

    @Override
    public Usuario recuperar(Long id) {
        Usuario usuario = null;
        if (id != null) {
            usuario = usuarioDAO.findById(id);
        }
        return usuario;
    }

}
