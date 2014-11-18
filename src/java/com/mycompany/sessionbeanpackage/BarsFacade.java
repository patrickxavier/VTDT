/*
 * Created by Patrick Sherman on 2014.11.02  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.sessionbeanpackage;

import com.group2.vtdt.Bars;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author patrickxavier
 */
@Stateless
public class BarsFacade extends AbstractFacade<Bars> {
    @PersistenceContext(unitName = "VTDTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BarsFacade() {
        super(Bars.class);
    }
    
}
