package com.pentacraft.auth.Mysql;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.concurrent.CompletableFuture;

public class verificarlogin {
    private String nick;
    private String pass;
    private Boolean resposta;
    public verificarlogin(String nick, String pass){
        this.nick = nick;
        this.pass = pass;

    }
    public void verificar() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String url = "jdbc:mysql://134.65.26.201/pentacraft";
            String username = "isaacr";
            String password = "isaacroque0209";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE nick = '" + nick + "' AND password = '" + pass + "'");
                if (resultSet.next()) {
                    connection.close();
                    resposta = true;
                } else {
                    connection.close();
                    resposta = false;
                }
            } catch (SQLException sqlException) {
                Bukkit.getConsoleSender().sendMessage(sqlException.getMessage());
            }


    }

    public Boolean getResposta() {
        return resposta;
    }
}
