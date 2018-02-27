
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DbConnector
{
private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
private static final String JDBC_URL = "jdbc:derby:appDB;create = true;user = dinu;password=dinu";
Connection conn;
    public DbConnector()
    {
    try {
        this.conn= DriverManager.getConnection(JDBC_URL);
        if(this.conn != null){
        System.out.println("Connected");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
    public void createTable(){
        
    try {
        Statement stmtt=conn.createStatement();
        if(!conn.getMetaData().getSchemas().next())
        {
            stmtt.execute("create schema appDB");
        }
        if(!conn.getMetaData().getTables(null, null, "USERS", null).next())
        {
        conn.createStatement().execute("create table users(name varchar(100))");
        }
    } catch (SQLException ex) {
        Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void insertIntoTable(String name){
    try {
        PreparedStatement prestmt = conn.prepareStatement("insert into users (name) values (?)");
        prestmt.setString(1,name);
        prestmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void getUser(){
    
    try {
        Statement stmt = this.conn.createStatement();
        ResultSet res = stmt.executeQuery("select * from users");
        while(res.next()){
            System.out.println(res.getString("name"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
    
   