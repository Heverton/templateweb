package br.com.templateweb.spring.model;

import br.com.thiaguten.persistence.Versionable;
import br.com.thiaguten.persistence.entity.BaseEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIO")
@NamedQueries({
        @NamedQuery(name = Usuario.RECUPERAR_NQ, query = "SELECT u FROM Usuario u WHERE u.id = :id"),
        @NamedQuery(name = Usuario.LISTAR_TODOS_NQ, query = "SELECT u FROM Usuario u")})
public class Usuario extends BaseEntity<Long> implements Versionable {

    private static final long serialVersionUID = -5736075612009729696L;

    public static final String RECUPERAR_NQ = "Usuario.findById";
    public static final String LISTAR_TODOS_NQ = "Usuario.findAll";

    @Transient
//    @Version
//    @Column(name = "VERSION")
    private long version;

    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{NotBlank.usuario.nome}")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotNull(message = "{NotNull.usuario.idade}")
    @Digits(integer = 3, fraction = 0, message = "{Digits.usuario.idade}")
    @Column(name = "IDADE", nullable = false)
    private Short idade;

    @NotBlank(message = "{NotBlank.usuario.email}")
    @Email(message = "{Email.usuario.email}")
    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    private String email;

    public Usuario() {
        super();
    }

    public Usuario(Long id, String nome, Short idade, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
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

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "version=" + version +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}
