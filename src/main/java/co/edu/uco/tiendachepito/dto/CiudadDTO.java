package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class CiudadDTO {
    private int id;
    private String nombre;
    private DepartamentoDTO departamento;

    public CiudadDTO() {
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoDTO.build());
    }

    public CiudadDTO(final int id, final String nombre, final DepartamentoDTO departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public int getId() {
        return id;
    }

    public CiudadDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CiudadDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public final CiudadDTO setDepartamento(final DepartamentoDTO departamento) {
        this.departamento = departamento;
        return this;
    }
}
