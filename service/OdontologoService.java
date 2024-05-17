package Examen1.service;



import Examen1.dao.IDao;
import Examen1.dao.OdontologoDAOH2;
import Examen1.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
        odontologoIDao = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontologoIDao.listarTodos();
    }


}
