package Examen1;


import Examen1.dao.BD;
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

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(odontologo);
        odontologoService.guardarOdontologo(odontologo1);

        List<Odontologo> ondontologos = null;
        ondontologos = odontologoService.listarTodos();

        Assertions.assertTrue(ondontologos!=null);

    }
}
