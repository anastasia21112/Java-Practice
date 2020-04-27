//package com.practice;

import java.rmi.*;
import java.rmi.server.*;

interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;
}

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public String sayHello() {
	return "Server says, 'Hey'";
    }

    public MyRemoteImpl() throws RemoteException {}

    public static void main(String[] args) {

	try {
	    MyRemote service = new MyRemoteImpl();
	    Naming.rebind("Remote", service);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
