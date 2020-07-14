package br.com.transportes.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "transportes", schema = "public")
public class Transportes implements Serializable {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String status;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CAMINHAO", referencedColumnName = "ID")
    private Caminhoes caminhao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CARGA", referencedColumnName = "ID")
    private Cargas carga;

    public Transportes() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Caminhoes getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhoes caminhao) {
        this.caminhao = caminhao;
    }

    public Cargas getCarga() {
        return carga;
    }

    public void setCarga(Cargas carga) {
        this.carga = carga;
    }
}
