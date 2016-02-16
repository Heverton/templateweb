package br.com.templateweb.spring.model;

import br.com.thiaguten.persistence.Versionable;
import br.com.thiaguten.persistence.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "PAGINA")
@NamedQueries({
        @NamedQuery(name = Pagina.RECUPERAR_NQ, query = "SELECT p FROM Pagina p WHERE p.id = :id"),
        @NamedQuery(name = Pagina.LISTAR_TODOS_NQ, query = "SELECT p FROM Pagina p")})
public class Pagina extends BaseEntity<Long> implements Versionable {

    private static final long serialVersionUID = -5736075612009729696L;

    public static final String RECUPERAR_NQ = "Pagina.findById";
    public static final String LISTAR_TODOS_NQ = "Pagina.findAll";

    @Transient
    private long version;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{NotBlank.pagina.nome}")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    public Pagina() {
        super();
    }

    public Pagina(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Pagina(String nome) {
        this.nome = nome;
    }
    
    @Override
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pagina{" +
                "version=" + version +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
