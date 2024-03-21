package com.neogiciel.model;

import java.beans.JavaBean;

import com.neogiciel.util.Trace;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Context;

/*
 * @ApplicationScoped permet de declare un Bean 
 * Le fait de déclarer cette classe comme Bean a pour role de la charger au boot
 * Le constructeur de la classe est automatiquement appellé au boot
 */
@Startup
//@ApplicationScoped
//@RequestScoped
@Singleton
public class B {
    
    String display;
    
    public B(){
        Trace.info("[B] constructeur");
        display = "classe B";
    }

    @Inject
    public void init(){
        Trace.info("[B] init");
        display = "classe Init";
    }
    public void set(String display){
        this.display = display;
    }

    public String get() {
        Trace.info("[B] get: "+ display);
        return display;
    }
}
