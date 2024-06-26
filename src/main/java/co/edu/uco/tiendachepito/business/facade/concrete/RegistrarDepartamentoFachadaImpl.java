package co.edu.uco.tiendachepito.business.facade.concrete;

import co.edu.uco.tiendachepito.business.facade.RegistrarDepartamentoFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarDepartamento;
import co.edu.uco.tiendachepito.business.usecase.concrete.RegistrarDepartamentoImpl;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;

public final class RegistrarDepartamentoFachadaImpl implements RegistrarDepartamentoFachada {

    private DAOFactory factory;

    public RegistrarDepartamentoFachadaImpl() {
        factory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }

    @Override
    public final void ejecutar(DepartamentoDTO departamento) {
        try {
            factory.iniciarTransaccion();
            //var departamentoDomain = DepartamentoDTODomainAssembler.obtenerInstancia().ensamblarDominio(departamento);
            RegistrarDepartamento useCase = new RegistrarDepartamentoImpl(factory);
            useCase.ejecutar(null);
            factory.confirmarTransaccion();
        } catch (TiendaChepitoException exception) {
            factory.cancelarTransaccion();
            throw exception;
        } catch (Exception exception) {
            factory.cancelarTransaccion();
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la información del nuevo departamento";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar el nuevo departamento en el método ejecutar de la clase RegistrarDepartamentoFachadaImpl";

            throw new BusinessTiendaChepitoException(mensajeTecnico, mensajeUsuario);
        } finally {
            factory.cerrarConexion();
        }
    }
}
