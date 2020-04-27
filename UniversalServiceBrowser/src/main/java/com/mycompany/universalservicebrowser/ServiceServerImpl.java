/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universalservicebrowser;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

/**
 *
 * @author AnastasiaDunca
 */
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    
    HashMap serviceList; 
    /* the services will be stored in a HashMap collection. Instead of putting ONE object in the collection, 
    you put TWO -- a key object (like a String) and a value object (whatever you want). 
    */
    
    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }
    
    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }
    
    public Object[] getServiceList() {
       System.out.println("in remote");
       return serviceList.keySet().toArray();
    }
    
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }
    
    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote service is running");
    }
}
