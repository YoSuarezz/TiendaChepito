package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.util.ArrayList;
import java.util.List;

public final class PaisEntityDomainAssembler implements EntityDomainAssembler<PaisDomain, PaisEntity> {

    private static final EntityDomainAssembler<PaisDomain, PaisEntity> instancia = new PaisEntityDomainAssembler();

    private PaisEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<PaisDomain, PaisEntity> obtenerInstancia(){
        return instancia;
    }


    @Override
    public final PaisDomain ensamblarDominio(final PaisEntity entidad) {
        var paisEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad,PaisEntity.build(0));
        return PaisDomain.crear(paisEntityTmp.getId(), paisEntityTmp.getNombre());
    }

    @Override
    public final PaisEntity ensamblarEntidad(final PaisDomain dominio) {
        var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio,PaisDomain.crear());
        return PaisEntity.build(paisDomainTmp.getId(), paisDomainTmp.getNombre());
    }

    @Override
    public final List<PaisDomain> ensamblarListaDominios(List<PaisEntity> listaEntidades) {
        var listaEntidaesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<PaisEntity>());
        var resultados = new ArrayList<PaisDomain>();

        for (PaisEntity paisEntity : listaEntidaesTmp) {
            var paisDomainTmp = ensamblarDominio(paisEntity);
            resultados.add(paisDomainTmp);
        }
        return resultados;
    }
}
