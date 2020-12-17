package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titular;
    private Integer agencia;
    private Integer numero;
    private Double saldo;
    // region Notes about @OneToMany Notation
    // If we leave with @OneToMany, JPA will create a new relationship. So, we wold
    // have 2 relatioships:
    // conta -> movimentacao
    // movimentacao -> conta
    // MappedBy option sets that the relation alredy exist and shold have 2 hands or
    // 2 ways.
    // By default all the relationship ToMany is lazy, that is, the info is loaded
    // as they are requested, not previously.
    // If you want preload the info right on the mais select, you msut specify it
    // with fetch = FetchType.EAGER
    // It will load it even if the information is not used.
    // *** Be carefull ***. It could compromise the application performance because
    // JPA will perform one select on
    // Movimentacao for every conta (N+1 problem).
    // FetchType.EAGER is default in relationships ToOne
    // Altough, when you set FetchType.EAGER, the information will be load even if
    // it is not necessary or directly requested,.
    // endregion
    @OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacoes;

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Movimentacao> getmovimentacoes() {

        return movimentacoes;
    }
}
