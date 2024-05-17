package Examen1.dao;


import Examen1.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo>{
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";
    private static final String SQL_SEARCH_ALL = "SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try{
            connection = BD.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, odontologo.getId());
            psInsert.setInt(2, odontologo.getMatricula());
            psInsert.setString(3, odontologo.getNombre());
            psInsert.setString(4, odontologo.getApellido());
            psInsert.execute();
            logger.info("Odonologo guardado correctamente");

        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            connection = BD.getConnection();
            PreparedStatement pSearchAll = connection.prepareStatement(SQL_SEARCH_ALL);
            ResultSet rs = pSearchAll.executeQuery();

            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
            }

            logger.info("Odontologos encontrados");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return odontologos;
    }
}
