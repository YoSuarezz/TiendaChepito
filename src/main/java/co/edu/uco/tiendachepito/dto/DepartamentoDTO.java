package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class DepartamentoDTO {
    private int id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO() {
        setNombre(TextHelper.EMPTY);
        setPais(PaisDTO.build());
    }

    public DepartamentoDTO(final int id,final String nombre,final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public static final DepartamentoDTO build() {
        return new DepartamentoDTO();
    }

    public final PaisDTO getPais() {
        return pais;
    }

    public final void setPais(final PaisDTO pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisDTO.build());
    }
}
