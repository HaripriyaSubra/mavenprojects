/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.jdbcdemo.trainingprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author labuser
 */
public class Trainingprogram {
    
    public static void main(String[] args) throws SQLException {
        JdbcDaoDemo jdbcdaodemo = new JdbcDaoDemo();
        //jdbcdaodemo.insert_record(1003, "Nath", "Ram", 37);
         //jdbcdaodemo.delete_record(1003);
          jdbcdaodemo.update_record(1002, 67);
         jdbcdaodemo.view_records();

       
    }
}
