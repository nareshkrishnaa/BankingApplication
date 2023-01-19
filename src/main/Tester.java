/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Tester {
    public static void main(String args[]){
        try{
            ConnectionHelper ch = new ConnectionHelper();
            Connection con= ch.getConnection();
            Statement stmt = con.createStatement();
            
            String query1 ="update customerdetails set BankBalance=BankBalance+10 where accNo='1014'";
            String query2 ="update customerdetails set BankBalance=bankBalance-10 where accNo='1'";
            System.out.println(query1);
            System.out.println(query2);
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
        }catch(SQLException ex){
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
