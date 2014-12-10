/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import com.group2.vtdt.Users;
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
@Path("com.group2.vtdt.users")
public class UsersFacadeREST extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Users entity) {
        super.create(entity);
    }
    
    @GET
    @Path("isAdmin/{username}")
    public boolean isAdmin(@PathParam("username") String username) {
        Users u = null;
        Query query = em.createNamedQuery("Users.findByUsername");
        query.setParameter("username", username);
        try{
            u = (Users) query.getSingleResult();
         }
        catch(Exception e){

        }
        
        if(u == null)
        {
            return false;
        }
        else return u.getAdmin() == 1;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Produces("application/json")
    @Path("findByUsername/{username}")
    public List<Users> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Users.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("findByName/{name}")
    public List<Users> findByName(@PathParam("name") String name) {
        Query query = em.createNamedQuery("Users.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @GET
    @Produces("application/json")
    @Path("findByCheckedInBar/{checkedInBar}")
    public List<Users> findByCheckedInBar(@PathParam("checkedInBar") Integer checkedInBar) {
        Query query = em.createNamedQuery("Users.findByCheckedInBar");
        query.setParameter("checkedInBar", checkedInBar);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
