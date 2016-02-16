package br.com.templateweb.spring.dao;

import br.com.templateweb.spring.model.Pagina;
import br.com.thiaguten.persistence.dao.GenericBaseDAO;
import br.com.thiaguten.persistence.spi.PersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("paginaDAO")
public class PaginaDAOImpl extends GenericBaseDAO<Pagina, Long> implements PaginaDAO {

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
    public List<Pagina> pesquisar(Pagina u) {
        Map<String, Object> params = null;
        StringBuilder jpql = new StringBuilder("SELECT u FROM Pagina u ");
        if (u != null) {

            jpql.append("WHERE 1=1 ");
            params = new HashMap<>();

            if (StringUtils.hasText(u.getNome())) {
                jpql.append("AND UPPER(u.nome) LIKE :nome ");
                params.put("nome", "%" + u.getNome().toUpperCase() + "%");
            }

        }
        return getPersistenceProvider().findByQueryAndNamedParams(getEntityClass(), jpql.toString(), params);
    }

    @Override
    public Long contarPorEmail(Pagina u) {
        Map<String, Object> params = null;
        StringBuilder jpql = new StringBuilder("SELECT COUNT(u) FROM Pagina u ");
        if (u != null) {

            jpql.append("WHERE 1=1 ");
            params = new HashMap<>();

            if (u.hasID()) {
                jpql.append("AND u.id != :id ");
                params.put("id", u.getId());
            }
        }
        return getPersistenceProvider().countByQueryAndNamedParams(Long.class, jpql.toString(), params);
    }

}
