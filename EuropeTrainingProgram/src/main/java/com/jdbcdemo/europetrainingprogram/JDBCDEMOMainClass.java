/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.jdbcdemo.europetrainingprogram;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author labuser
 */
public class JDBCDEMOMainClass {

    public static void main(String[] args) throws SQLException {
        JdbcDaoDemo jdbcdaodemo = new JdbcDaoDemo();
        jdbcdaodemo.insert_record(1001, "Nath", "Ram", 37);
        jdbcdaodemo.insert_record(1002, "Smith", "Adams", 56);
        jdbcdaodemo.insert_record(1003, "Doe", "John", 76);
        jdbcdaodemo.insert_record(1004, "Abraham", "John", 32);
        jdbcdaodemo.update_record(1001, 67);
        jdbcdaodemo.delete_record(1001);
        ArrayList<Persons> p = jdbcdaodemo.view_records();
        if (p.isEmpty()) {
            System.out.println("There are no entries present");
        } else {
            for (Persons person : p) {
                System.out.println(person.getId() + "\t"
                        + person.getLastname() + "\t" + "\t"
                        + person.getFirstname() + "\t" + "\t"
                        + person.getAge() + "\t");
            }
        }
    }
}
