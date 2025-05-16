package ar.edu.unahur.obj2.filters;


import java.util.List;

import ar.edu.unahur.obj2.model.Pais;



public class FiltroOr extends FiltroCompuesto { /*hereda del filtro compuesto */

    public FiltroOr(List<IFiltro> filtros) {
        this.filtros = filtros;
    }

    public FiltroOr(IFiltro actual, IFiltro nuevo) {
        this.addFiltro(actual);
        this.addFiltro(nuevo);
    }

    @Override
    public Boolean apply(Pais pais) {
        return this.filtros.stream().anyMatch(f -> f.apply(pais));
    }

    @Override
    public IFiltro and(IFiltro filtro) {
        return new FiltroAnd(this, filtro);
    }
}
