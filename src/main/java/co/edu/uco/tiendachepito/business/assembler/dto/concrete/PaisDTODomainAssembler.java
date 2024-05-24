package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

public final class PaisDTODomainAssembler implements DTODomainAssembler <PaisDomain, PaisDTO> {

    private  static final DTODomainAssembler <PaisDomain, PaisDTO> instancia = new PaisDTODomainAssembler();

    PaisDTODomainAssembler(){
        super();
    }

    public static final DTODomainAssembler <PaisDomain, PaisDTO> obtenerInstancia(){
        return instancia;
    }

    @Override
    public PaisDomain ensamblarDominio(PaisDTO dto) {
        var paisDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new PaisDTO());
        return PaisDomain.crear(paisDtoTmp.getId(), paisDtoTmp.getNombre());
    }

    @Override
    public PaisDTO ensamblarDTO(PaisDomain dominio) {
        var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, new PaisDomain(dominio.getId(), dominio.getNombre()));
        return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());

    }

    @Override
    public final List<PaisDTO> ensamblarListaDTO(final List<PaisDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper()
                .getDefault(listaDominios, new ArrayList<PaisDomain>());
        var resultados = new ArrayList<PaisDTO>();

        for (PaisDomain paisDomain : listaDominiosTmp){
            resultados.add(ensamblarDTO(paisDomain));
        }
        return resultados;
    }

}
