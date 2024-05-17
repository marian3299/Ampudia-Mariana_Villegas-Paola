package Examen1;


import Examen1.dao.BD;
import Examen1.dao.OdontologoDAOH2;
import Examen1.dao.OndontologoDAOArray;
import Examen1.model.Odontologo;
import Examen1.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

public class OdontologoTest {
    @Test
    public void listarOdontologos(){
        Odontologo odontologo = new Odontologo(1, 11111, "Sofia", "Gonzalez");
        Odontologo odontologo1 = new Odontologo(2, 22222, "Andres", "Cardenas");
        BD.crearTablas();

        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());
        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo1);

        OdontologoService odontologoService1 = new OdontologoService(new OndontologoDAOArray());
        odontologoService1.guardarOdontologo(odontologo);
        odontologoService1.guardarOdontologo(odontologo1);

        List<Odontologo> ondontologos = null;
        ondontologos = odontologoService.listarTodos();

        List<Odontologo> odontologos1 = null;
        odontologos1 = odontologoService1.listarTodos();

        Assertions.assertTrue(ondontologos!=null);
        Assertions.assertTrue(odontologos1!=null);

    }
}
