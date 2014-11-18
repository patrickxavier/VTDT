/*
 * Created by Patrick Sherman on 2014.10.28  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.sessionbeanpackage;

import com.group2.vtdt.Users;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author patrickxavier
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users>  implements Serializable{
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    /**
     *
     * @param username
     * @return
     */
    public boolean getUserByUsername(String username)
    {
        
        Users u = null;
        Query query = em.createNamedQuery("Users.findByUsername");
        query.setParameter("username", username);
        try{
            u = (Users) query.getSingleResult();
         }
        catch(Exception e){

        }
        
        System.out.println("username is " + username);
        
        if(u == null)
        {
            return false;
        }

        else if (u.getAdmin() == 1) {
            
             return true;
        } else {

            return false;
        }
        
    }
    
}
