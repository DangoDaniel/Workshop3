package pl.coderslab;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String CREATE_DATABASE_QUERY = "create database if not exists workshop2;";
    private static final String CREATE_TABLE_QUERY = "create table if not exists workshop2.users (\n" +
            "    id int(11) auto_increment,\n" +
            "    email varchar(255) unique not null,\n" +
            "    username varchar(255) not null,\n" +
            "    password varchar(60) not null,\n" +
            "    PRIMARY KEY (id)\n" +
            ");";

    public static void main(String[] args) {
        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(CREATE_DATABASE_QUERY);
            statement.execute(CREATE_TABLE_QUERY);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        MainDao.create();
        System.out.println("Read record id: 1");
        MainDao.read(1);
        System.out.println("Read record id: 2");
        MainDao.read(2);
        System.out.println("\n" + "Update record id: 2");
        MainDao.update(2);
        System.out.println("\n" + "Read record id: 2");
        MainDao.read(2);
        System.out.println("\n" + "Delete record id: 1");
        MainDao.delete(1);
        System.out.println("\n" + "Print all records");
        MainDao.findAll();
    }
}