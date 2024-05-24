package co.edu.uco.tiendachepito.business.usecase.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.concrete.CiudadEntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;

public class RegistrarCiudadImpl implements RegistrarCiudad {

    private final DAOFactory factory;

    public RegistrarCiudadImpl(final DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void ejecutar(CiudadDomain ciudad) {
        // POL.1 Validar que los datos sean validados a nivel de tipo de dato, longitud, obligatoriedad, formato, rango.
        //validarNoExistenciaCiudad(ciudad.getNombre(), ciudad.getDepartamento().getId());
        // POL.2 No debe existir una ciudad con el mismo nombre para el mismo departamento.
        var ciudadEntity = CiudadEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(ciudad);
        // POL.3 Guardar la informacion de la nueva ciudad.
    }
}
