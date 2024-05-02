package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;

public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {

    public PaisAzureSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE pais");
        sentenciaSql.append(" SET nombre = :'Venezuela' ");
        sentenciaSql.append("WHERE id = 1 ");

    }

    @Override
    public final List<PaisEntity> consultar(final PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id, nombre");
        sentenciaSql.append(" FROM pais");
        sentenciaSql.append(" ORDER BY nombre ASC ");
        return null;
    }

    @Override
    public final void crear(final PaisEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO pais (nombre)");
        sentenciaSql.append(" VALUES ('Colombia')");
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM pais");
        sentenciaSql.append(" WHERE id = 1");
    }
}
