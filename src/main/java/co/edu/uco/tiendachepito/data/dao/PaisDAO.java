package co.edu.uco.tiendachepito.data.dao;

import co.edu.uco.tiendachepito.data.dao.general.ActualizarDAO;
import co.edu.uco.tiendachepito.data.dao.general.ConsultarDAO;
import co.edu.uco.tiendachepito.data.dao.general.CrearDao;
import co.edu.uco.tiendachepito.data.dao.general.EliminarDAO;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public interface PaisDAO extends CrearDao <PaisEntity>, ActualizarDAO <PaisEntity>,
        EliminarDAO, ConsultarDAO <PaisEntity>  {


}
