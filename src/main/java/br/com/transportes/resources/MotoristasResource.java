package br.com.transportes.resources;

import br.com.transportes.models.Motoristas;
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
@Path("motoristas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MotoristasResource {

  @PersistenceContext(unitName = "TranspPU")
    EntityManager entityManager;
    
    @GET
    public List<Motoristas> get() {
        return entityManager
                .createQuery("SELECT a FROM Motoristas a", Motoristas.class)
                .getResultList();
    }
    
    @POST
    public Response add(Motoristas a) {
        entityManager.persist(a);
        return Response
                .status(Response.Status.CREATED)
                .entity(a)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Motoristas get(@PathParam("id") UUID id) {
        return entityManager.find(Motoristas.class, id);
    }
        
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") UUID id) {
        Motoristas a = entityManager.find(Motoristas.class, id);
        entityManager.remove(a);
    }
    
    @PUT
    @Path("{id}")
    public Motoristas update(@PathParam("id") UUID id, Motoristas a) {
        a.setId(id);
        entityManager.merge(a);
        return a;
    }
}
