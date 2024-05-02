package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;

public class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {
        this.connection = connection;
    }

    private void setConnection(Connection connection) {
        // TODO:Se debe validar que la conexion este abierta
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }
}
