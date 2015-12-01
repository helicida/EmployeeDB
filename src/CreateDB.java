import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by 46465442z on 01/12/15.
 */
public class CreateDB {

    public static void main(String[] args) {

        try {
            Connection conexion = null;
            Statement stmt = null;

            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://172.31.104.79/prueba", "sergi", "alumne");
            stmt = conexion.createStatement();

            System.out.println("Se ha accedido correctamente a la base de datos");
            System.out.println("----------------------------------------------------");
            System.out.println("Se procederá a crear las tablas.");
            System.out.println("----------------------------------------------------");

            // Hacemos dos tablas una para peliculas y otra para actores

            // La de peliculas tendrá la ID de la pelicula en la API, el título de la pelicula y la fecha de salida
            String createPeliculas = "CREATE TABLE EMPLOYEES"
                    + " (ID INT PRIMARY KEY     NOT NULL,"
                    + " FIRST_NAME TEXT,"
                    + " LAST_NAME TEXT,"
                    + " SALARY INT)";

            // Creamos las dos tablas con nuestros script SQL de arriba
            stmt.executeUpdate(createPeliculas);

            // Cerramos las conexiones a la base de datos
            stmt.close();
            conexion.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
