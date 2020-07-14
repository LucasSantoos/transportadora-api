package br.com.transportes.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "caminhoes", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Caminhoes.findAll", query = "SELECT l FROM Caminhoes l")
})
public class Caminhoes implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String placa;
    
    @Column
    private BigDecimal capacidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MOTORISTA", referencedColumnName = "ID")
    private Motoristas motorista;
    
    public Caminhoes() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }
    
    public Motoristas getMotorista() {
        return motorista;
    }

    public void setMotorista(Motoristas motorista) {
        this.motorista = motorista;
    }    
}
