/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.transportes.resources;

import br.com.transportes.models.Cargas;
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
@Path("cargas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CargasResource {
    
     @PersistenceContext(unitName = "TranspPU")
    EntityManager entityManager;
    
    @GET
    public List<Cargas> get() {
        return entityManager
                .createQuery("SELECT a FROM Cargas a", Cargas.class)
                .getResultList();
    }
    
    @POST
    public Response add(Cargas a) {
        entityManager.persist(a);
        return Response
                .status(Response.Status.CREATED)
                .entity(a)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Cargas get(@PathParam("id") UUID id) {
        return entityManager.find(Cargas.class, id);
    }
        
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") UUID id) {
        Cargas a = entityManager.find(Cargas.class, id);
        entityManager.remove(a);
    }
    
    @PUT
    @Path("{id}")
    public Cargas update(@PathParam("id") UUID id, Cargas a) {
        a.setId(id);
        entityManager.merge(a);
        return a;
    } 
} 
