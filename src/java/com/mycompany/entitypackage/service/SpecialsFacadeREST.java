/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import com.group2.vtdt.Specials;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author patrickxavier
 */
@Stateless
@Path("com.group2.vtdt.specials")
public class SpecialsFacadeREST extends AbstractFacade<Specials> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    public SpecialsFacadeREST() {
        super(Specials.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Specials entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Specials entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Specials find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Produces("application/json")
    @Path("findByBar/{bar}")
    public List<Specials> findByBar(@PathParam("bar") Integer bar) {
        Query query = em.createNamedQuery("Specials.findByBar");
        query.setParameter("bar", bar);
        return query.getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("findByDays/{days}")
    public List<Specials> findByDays(@PathParam("days") String days) {
        Query query = em.createNamedQuery("Specials.findByDays");
        query.setParameter("days", "%" + days + "%");
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Specials> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Specials> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
