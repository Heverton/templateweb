package br.com.templateweb.spring.dao;

import br.com.thiaguten.persistence.dao.GenericBaseDAO;
import br.com.thiaguten.persistence.spi.PersistenceProvider;
import br.com.templateweb.spring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends GenericBaseDAO<Usuario, Long> implements UsuarioDAO {

    private PersistenceProvider persistenceProvider;

    @Override
    public PersistenceProvider getPersistenceProvider() {
        return persistenceProvider;
    }

    @Autowired
    @Qualifier("jpaPersistenceProvider")
    public void setPersistenceProvider(PersistenceProvider persistenceProvider) {
        this.persistenceProvider = persistenceProvider;
    }

    @Override
    public List<Usuario> pesquisar(Usuario u) {
        Map<String, Object> params = null;
        StringBuilder jpql = new StringBuilder("SELECT u FROM Usuario u ");
        if (u != null) {

            jpql.append("WHERE 1=1 ");
            params = new HashMap<>();

            if (StringUtils.hasText(u.getNome())) {
                jpql.append("AND UPPER(u.nome) LIKE :nome ");
                params.put("nome", "%" + u.getNome().toUpperCase() + "%");

            } else if (StringUtils.hasLength(u.getEmail())) {
                jpql.append("AND UPPER(u.email) LIKE :email ");
                params.put("email", "%" + u.getEmail().toUpperCase() + "%");

            } else if (u.getIdade() != null) {
                jpql.append("AND u.idade = :idade ");
                params.put("idade", u.getIdade());
            }

        }
        return getPersistenceProvider().findByQueryAndNamedParams(getEntityClass(), jpql.toString(), params);
    }

    @Override
    public Long contarPorEmail(Usuario u) {
        Map<String, Object> params = null;
        StringBuilder jpql = new StringBuilder("SELECT COUNT(u) FROM Usuario u ");
        if (u != null) {

            jpql.append("WHERE 1=1 ");
            params = new HashMap<>();

            if (u.hasID()) {
                jpql.append("AND u.id != :id ");
                params.put("id", u.getId());
            }
            if (StringUtils.hasText(u.getEmail())) {
                jpql.append("AND UPPER(u.email) LIKE :email");
                params.put("email", u.getEmail().toUpperCase());
            }
        }
        return getPersistenceProvider().countByQueryAndNamedParams(Long.class, jpql.toString(), params);
    }

}
