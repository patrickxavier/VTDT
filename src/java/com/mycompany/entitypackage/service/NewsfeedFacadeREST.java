/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import com.group2.vtdt.Newsfeed;
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
@Path("com.group2.vtdt.newsfeed")
public class NewsfeedFacadeREST extends AbstractFacade<Newsfeed> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    public NewsfeedFacadeREST() {
        super(Newsfeed.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Newsfeed entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Newsfeed entity) {
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
    public Newsfeed find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Produces("application/json")
    @Path("findByUsername/{username}")
    public List<Newsfeed> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Newsfeed.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("findByBar/{bar}")
    public List<Newsfeed> findByBar(@PathParam("bar") int bar) {
        Query query = em.createNamedQuery("Newsfeed.findByBar");
        query.setParameter("bar", bar);
        return query.getResultList();
    }
    
    @GET
    @Produces({"application/json"})
    @Path("sorted")
    public List<Newsfeed> findAllSorted() {
        Query query = em.createNamedQuery("Newsfeed.findAllSorted");
        return query.getResultList();
    }
    

    @GET
    @Override
    @Produces({"application/json"})
    public List<Newsfeed> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Newsfeed> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
