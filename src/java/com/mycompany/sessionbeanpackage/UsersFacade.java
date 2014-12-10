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
}
