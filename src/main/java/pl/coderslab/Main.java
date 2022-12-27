package pl.coderslab;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//Tworzy bazę danych workshop3 (jeśli nie istnieje)

public class Main {

    private static final String CREATE_DATABASE_QUERY = "create database if not exists workshop3;";
    private static final String CREATE_TABLE_QUERY = "create table if not exists workshop3.users (\n" +
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
    }
}