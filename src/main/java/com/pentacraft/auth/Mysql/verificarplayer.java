package com.pentacraft.auth.Mysql;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.concurrent.CompletableFuture;

public class verificarplayer {
    private String nick;
    private Boolean resposta;
    public verificarplayer(String nick){
        this.nick = nick;

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
                ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE nick = '%s'", nick));
                if (resultSet.next()) {
                    connection.close();
                    resposta = true;
                } else {
                    connection.close();
                    resposta = false;
                }
            } catch (SQLException sqlException) {
                Bukkit.getConsoleSender().sendMessage(sqlException.toString());

            }


    }

    public Boolean getResposta() {
        return resposta;
    }
}
