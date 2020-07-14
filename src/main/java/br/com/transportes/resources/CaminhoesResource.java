/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.transportes.resources;

import br.com.transportes.models.Caminhoes;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lucas
 */
@Stateless
@Path("caminhoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CaminhoesResource {
    
    @PersistenceContext(unitName = "TranspPU")
    EntityManager entityManager;
    
    @GET
    public List<Caminhoes> get() {
        return  entityManager
                    .createNamedQuery("Caminhoes.findAll", Caminhoes.class)
                    .getResultList();
    }
    
    @POST
    public Response add(Caminhoes autor) {
        entityManager.persist(autor);
        return Response
                .status(Response.Status.CREATED)
                .entity(autor)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Caminhoes get(@PathParam("id") UUID id) {
        return entityManager.find(Caminhoes.class, id);
    }
        
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") UUID id) {
        Caminhoes autor = entityManager.find(Caminhoes.class, id);
        entityManager.remove(autor);
    }
    
    @PUT
    @Path("{id}")
    public Caminhoes update(@PathParam("id") UUID id, Caminhoes a) {
        a.setId(id);
        entityManager.merge(a);
        return a;
    }
       
} 
