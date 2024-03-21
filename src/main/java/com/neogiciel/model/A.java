package com.neogiciel.model;

import com.neogiciel.util.Trace;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Context;

/*
 * @Singleton permet de declare un Bean 
 * Le fait de déclarer cette classe comme Bean a pour role de la charger au boot si @Startup
 * Sinon au lancement.  Le constructeur de la classe est automatiquement appellé
 * 
 * Il existe plusieurs scope d'application: @ApplicationScoped, @RequestScoped, @Singleton
 * Le fait d'ajouter @Startup permet de lancer l injection au boot 
 */
@Startup
//@ApplicationScoped
//@RequestScoped
@Singleton
public class A {

    /*Variables*/
    String display;

    /*
     * Il existent deux modes d'injection de dépendence :
     * Choix 1: Commenter le constructeur public A(B b), laissé Inject sur la variable 
     * Choix 2: Commenter @Inject, Commenter le constructeur public A()
     * 
     * @Context peut être utilisé dans cas pour charger la classe
     */
    @Inject
    private B b;
    

    /*
     *Constructeur 
     */
    public A(){
        Trace.info("[A] constructeur");
        this.display = "Classe A";
    }

    /*/
     *Constructeur 
     */
    public A(B b){
        Trace.info("[A] constructeur avec paremtre");
        Trace.info("[A] b.get()"+b.get());
        this.b = b;
    }

    /*
     * Si la méthode est annoté avec un Bean @Inject
     * Elle seras initilisé au boot
     */
    @Inject
    public void init(){
        Trace.info("[A] init");
        display = "classe Init";
    }


    /*
     *set(String display)
     */
    public void set(String display){
        Trace.info("[A] set");
        //b.set(display);
    }

    /*
     *get() 
     */
    public String get() {
        Trace.info("[A] get");
        return b.get();
    }

     /*
     *test()
     */
    public String test() {
        Trace.info("[A] test");
        return "test";
    }
}
