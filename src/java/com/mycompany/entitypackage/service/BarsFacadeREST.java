/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import com.group2.vtdt.Bars;
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
@Path("com.group2.vtdt.bars")
public class BarsFacadeREST extends AbstractFacade<Bars> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    public BarsFacadeREST() {
        super(Bars.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Bars entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Bars entity) {
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
    public Bars find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByName/{name}")
    @Produces({"application/json"})
    public List<Bars> findByName(@PathParam("name") String name) {
        Query query = em.createNamedQuery("Bars.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Bars> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Bars> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
