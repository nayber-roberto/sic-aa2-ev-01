import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String user = "root";
        String password = "Jehovayire142927*";
        String url = "jdbc:mysql://localhost:3306/sicdb";

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM TIPO_SERVICIO");

            // Verificar si el ResultSet tiene filas
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt("id_tipo_servicio") + " | " + rs.getString("servicio"));
                } while (rs.next());
            } else {
                System.out.println("No se encontraron usuarios en la base de datos.");
            }

            //Insert
            statement.executeUpdate("INSERT INTO TIPO_SERVICIO VALUES(6, 'Cotizacion', 'Cotizacion de Servicios')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM TIPO_SERVICIO");

            // Verificar si el ResultSet tiene filas
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt("id_tipo_servicio") + " | " + rs.getString("servicio"));
                } while (rs.next());
            } else {
                System.out.println("No se encontraron usuarios en la base de datos.");
            }

            //Update
            statement.executeUpdate("UPDATE TIPO_SERVICIO SET servicio='Queja' WHERE id_tipo_servicio=1");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM TIPO_SERVICIO");

            // Verificar si el ResultSet tiene filas
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt("id_tipo_servicio") + " | " + rs.getString("servicio"));
                } while (rs.next());
            } else {
                System.out.println("No se encontraron usuarios en la base de datos.");
            }

            //Delete
            statement.executeUpdate("DELETE FROM TIPO_SERVICIO WHERE id_tipo_servicio=4");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM TIPO_SERVICIO");

            // Verificar si el ResultSet tiene filas
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt("id_tipo_servicio") + " | " + rs.getString("servicio"));
                } while (rs.next());
            } else {
                System.out.println("No se encontraron usuarios en la base de datos.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
