package co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.sql.CiudadAzureSqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.DepartamentoAzureSqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.PaisAzureSqlDAO;

import java.sql.Connection;

public final class AzureSqlDAOFactory extends DAOFactory {

    private Connection connection;

    public AzureSqlDAOFactory() {
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        connection = null;
    }

    @Override
    public void iniciarTransaccion() {

    }

    @Override
    public void confirmarTransaccion() {

    }

    @Override
    public void cancelarTransaccion() {

    }

    @Override
    public void cerrarConexion() {

    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSqlDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSqlDAO(connection);
    }
}
