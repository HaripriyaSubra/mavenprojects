package com.jdbcdemo.europetrainingprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author labuser
 */
public class JdbcDaoDemo {
    public  Connection connect() throws SQLException{
        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost/JDBCDEMO";
        String user = "root";
        String pass = "Root123$";
        conn = DriverManager.getConnection(dbURL,user,pass);
        return conn;
    }
    
    public  ArrayList<Persons> view_records() throws SQLException{
        ArrayList<Persons> person = new ArrayList<Persons>();
         Connection conn = connect();
        if(conn!=null){
            Statement stmt  = conn.createStatement();
              String sql = "SELECT * " +
                     "FROM persons";
               ResultSet rs    = stmt.executeQuery(sql);
                                   System.out.println("------------------------------------------------------------------------");

               System.out.println("ID" + "\t" + 
                                   "LastName"  + "\t" +
                                   "FirstName"+ "\t" + 
                                    "Age");
                                   System.out.println("------------------------------------------------------------------------");

                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String last_name= rs.getString("LastName");
                    String first_name= rs.getString("FirstName");
                    int age = rs.getInt("Age");
                    Persons p = new Persons(id,last_name,first_name,age);
                    person.add(p);
            }
        }
        return person;
    }    
    
  public void insert_record(int id,String last_name,String first_name,int age) throws SQLException{
        Connection conn = connect();
        String sql = "insert into persons values(?,?,?,?)";
        PreparedStatement myStmt = conn.prepareStatement(sql);
        myStmt.setInt(1, id);
        myStmt.setString(2, last_name);
        myStmt.setString(3, first_name);
        myStmt.setInt(4, age);
        myStmt.execute();
        System.out.println("Insert complete.");
            
        }  
  
  public void delete_record(int id) throws SQLException{
      Connection conn = connect();
      String sql = "delete from persons where id=?";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setInt(1, id);
      pst.execute();   
  }
  
  public void update_record(int id,int age)throws SQLException{
            Connection conn = connect();
            String sql = "update persons set age=? where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
             pst.setInt(1, age);
             pst.setInt(2, id);
             pst.execute();   
  }

}