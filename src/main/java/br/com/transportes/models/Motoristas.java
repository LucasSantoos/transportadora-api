package br.com.transportes.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "motoristas", schema = "public")
public class Motoristas implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String nome;
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
    private TipoHabilitacao habilitacao;
 
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)    
    private Date dtNascimento;
 
    public Motoristas() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoHabilitacao getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(TipoHabilitacao habilitacao) {
        this.habilitacao = habilitacao;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
