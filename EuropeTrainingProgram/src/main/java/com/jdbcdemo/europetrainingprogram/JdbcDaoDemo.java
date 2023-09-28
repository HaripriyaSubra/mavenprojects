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

    private static Connection conn = null;

    public Connection connect() throws SQLException {

        String dbURL = "jdbc:mysql://localhost/JDBCDEMO";
        String user = "root";
        String pass = "Root123$";
        conn = DriverManager.getConnection(dbURL, user, pass);
        return conn;
    }

    public ArrayList<Persons> view_records() throws SQLException {
        ArrayList<Persons> person = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * "
                + "FROM persons";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("ID" + "\t"
                + "LastName" + "\t"
                + "FirstName" + "\t"
                + "Age");
        System.out.println("------------------------------------------------------------------------");
        while (rs.next()) {
            int id = rs.getInt("Id");
            String last_name = rs.getString("LastName");
            String first_name = rs.getString("FirstName");
            int age = rs.getInt("Age");
            Persons p = new Persons(id, last_name, first_name, age);
            person.add(p);
        }
        return person;
    }

    public void insert_record(int id, String last_name, String first_name, int age) throws SQLException {
        String sql = "insert into persons values(?,?,?,?)";
        PreparedStatement myStmt = conn.prepareStatement(sql);
        myStmt.setInt(1, id);
        myStmt.setString(2, last_name);
        myStmt.setString(3, first_name);
        myStmt.setInt(4, age);
        myStmt.execute();
        System.out.println("Insert complete.");

    }

    public void drop_table() throws SQLException {
        String sql = "drop table persons";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        System.out.println("table persons dropped from database");
    }

    public void create_table() throws SQLException {
        String sql = "CREATE TABLE Persons (ID int NOT NULL,LastName varchar(255) NOT NULL,FirstName varchar(255),Age int,PRIMARY KEY (ID));";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }

    public void delete_record(int id) throws SQLException {
        String sql = "delete from persons where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
    }

    public void truncate_table() throws SQLException {
        String sql = "truncate persons";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
    }

    public void update_record(int id, int age, String lastname) throws SQLException {
        String sql = "update persons set age=?,lastname=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, age);
        pst.setString(2, lastname);
        pst.setInt(3, id);
        pst.execute();
    }
}
