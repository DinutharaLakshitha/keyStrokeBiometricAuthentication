/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import utility.DbConnector;
import view.loginUI;
import view.receptionUI;

/**
 *
 * @author Dinuthara
 */
public class authSyestem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        receptionUI ui = new receptionUI();
        ui.show();
       
        DbConnector conn = new DbConnector();
        conn.createTable();
        conn.insertIntoTable("Nethma");
        conn.insertIntoTable("Dinuthara");
        conn.getUser();
        
        
    }
    
}