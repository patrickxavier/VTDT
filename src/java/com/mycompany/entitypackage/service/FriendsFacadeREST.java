/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import com.group2.vtdt.Friends;
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
@Path("com.group2.vtdt.friends")
public class FriendsFacadeREST extends AbstractFacade<Friends> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    public FriendsFacadeREST() {
        super(Friends.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Friends entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Friends entity) {
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
    public Friends find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Produces("application/json")
    @Path("findByUser/{user}")
    public List<Friends> findByUser(@PathParam("user") String user) {
        Query query = em.createNamedQuery("Friends.findByUser");
        query.setParameter("user", user);
        return query.getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("findOnline/{user}")
    public List<Friends> findOnline(@PathParam("user") String user) {
        Query query = em.createNamedQuery("Friends.findOnline");
        query.setParameter("user", user);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Friends> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Friends> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
