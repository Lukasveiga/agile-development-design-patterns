package com.devlukas.designpatterns.structural.composite;

public class TrechoAereoComEscala implements TrechoAereo {

    private final TrechoAereo t1;

    private final TrechoAereo t2;

    public TrechoAereoComEscala(TrechoAereo t1, TrechoAereo t2) {
        if(!t1.destino().equals(t2.origem())) {
            throw new OriginDestinationScalesNotMatchException("Origem e destino das escalas não coincidem.");
        }

        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String origem() {
        return t1.origem();
    }

    @Override
    public String destino() {
        return t2.destino();
    }

    @Override
    public int custo() {
        return t1.custo() + t2.custo();
    }

    @Override
    public int distancia() {
        return t1.distancia() + t2.distancia();
    }
}
