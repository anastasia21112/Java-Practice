/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universalservicebrowser;

import java.awt.*;
import javax.swing.*;
import java.rmi.*;
import java.awt.event.*;

/**
 *
 * @author AnastasiaDunca
 */
public class ServiceBrowser {
    
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;
    
    public void buildGUI() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        
        Object[] services = getServicesList();
        
        serviceList = new JComboBox(services);
        frame.getContentPane().add(BorderLayout.NORTH, serviceList);
        
        serviceList.addActionListener(new MyListListener());
        
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
    void loadService(Object serviceSelection) {
        try {
            Service svc = server.getService(serviceSelection);
            
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Object[] getServicesList() {
        Object obj = null;
        Object[] services = null;
        
        try {
            
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        server = (ServiceServer) obj;
        
        try {
            
            services = server.getServiceList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return services;
    }
    
    class MyListListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }
    
    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
            
    
}
