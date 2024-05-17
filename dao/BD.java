package Examen1.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);
    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";

    public static void crearTablas(){
        Connection connection = null;

        try{
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(SQL_DROP_CREATE);
            logger.info("Tabla creada con exito");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/odontologosExamen", "sa", "sa");
    }
}
