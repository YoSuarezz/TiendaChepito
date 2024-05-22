package co.edu.uco.tiendachepito.data.dao.sql;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import java.sql.Connection;
import java.util.List;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

    public CiudadAzureSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final CiudadEntity entidad) {

    }

    @Override
    public final List<CiudadEntity> consultar(final CiudadEntity entidad) {
        return List.of();
    }

    @Override
    public final void crear(final CiudadEntity entidad) {

    }

    @Override
    public final void eliminar(final int id) {

    }
}
