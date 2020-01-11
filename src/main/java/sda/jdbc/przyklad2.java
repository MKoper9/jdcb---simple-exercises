/*
 * przyklad2
 * Przyklad pokazuje jak podlaczyc sie do bazy danych, wykonac zapytanie SELECT
 * wykozystujac interface Statement i wyswietla wynik na konsoli.
 * */

package sda.jdbc;

import java.sql.*;

public class przyklad2 {
    public static void main(String arg[]) {
        Connection connection = null;
        Statement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ksiegarnia";
            String user = "sdatest";
            String password = "Start123!";
            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT id, imie, nazwisko as naz FROM autor");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id"); //indeksy tutaj licymy od 1
                String imie = resultSet.getString("imie");
                String nazwisko = resultSet.getString("naz");
                System.out.println(id + " " + imie + " " + nazwisko);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
