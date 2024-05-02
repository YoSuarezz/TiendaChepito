package co.edu.uco.tiendachepito.data.dao;

import co.edu.uco.tiendachepito.data.dao.general.ActualizarDAO;
import co.edu.uco.tiendachepito.data.dao.general.ConsultarDAO;
import co.edu.uco.tiendachepito.data.dao.general.CrearDao;
import co.edu.uco.tiendachepito.data.dao.general.EliminarDAO;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

public interface CiudadDAO extends CrearDao <CiudadEntity>, ActualizarDAO <CiudadEntity>,
        EliminarDAO, ConsultarDAO <CiudadEntity>  {

}