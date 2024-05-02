package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public final class PaisEntity {
    private int id;
    private String nombre;

    private PaisEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }

    private PaisEntity(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final PaisEntity build(final int id) {
        return new PaisEntity(id);
    }

    public static final PaisEntity build(final int id, final String nombre) {
        return new PaisEntity(id,nombre);
    }

    protected static final PaisEntity build() {
        return new PaisEntity(NumericHelper.ZERO);
    }

    private final void setId(int id) {
        this.id = id;
    }

    private final void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
