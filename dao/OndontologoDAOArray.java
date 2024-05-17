package Examen1.dao;


import Examen1.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OndontologoDAOArray implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private List<Odontologo> odontologos = null;

    public OndontologoDAOArray() {
        odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontologo añadido a la lista");
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        for (Odontologo odontologo : odontologos) {
            System.out.println("Odontólogo ID: " + odontologo.getId() +
                    ", Matrícula: " + odontologo.getMatricula()+
                    ", Nombre: " + odontologo.getNombre() +
                    ", Apellido: " + odontologo.getApellido());
        }
        return new ArrayList<>(odontologos);
    }
}
