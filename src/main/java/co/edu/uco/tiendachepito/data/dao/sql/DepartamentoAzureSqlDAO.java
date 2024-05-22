package co.edu.uco.tiendachepito.data.dao.sql;

import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

import java.sql.Connection;
import java.util.List;

public final class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {

    public DepartamentoAzureSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final DepartamentoEntity entidad) {

    }

    @Override
    public final List<DepartamentoEntity> consultar(final DepartamentoEntity entidad) {
        return List.of();
    }

    @Override
    public final void crear(final DepartamentoEntity entidad) {

    }

    @Override
    public final void eliminar(final int id) {

    }
}
