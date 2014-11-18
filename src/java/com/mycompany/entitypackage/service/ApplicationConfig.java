/*
 * Created by Patrick Sherman on 2014.10.24  * 
 * Copyright © 2014 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entitypackage.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author patrickxavier
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.entitypackage.service.BarsFacadeREST.class);
        resources.add(com.mycompany.entitypackage.service.FriendsFacadeREST.class);
        resources.add(com.mycompany.entitypackage.service.NewsfeedFacadeREST.class);
        resources.add(com.mycompany.entitypackage.service.SpecialsFacadeREST.class);
        resources.add(com.mycompany.entitypackage.service.UsersFacadeREST.class);
    }
    
}
