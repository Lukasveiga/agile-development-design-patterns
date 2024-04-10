package com.devlukas.designpatterns.structural.composite;

public class TrechoAereoComConexao extends TrechoAereoComEscala {

    private final int conectionFee;


    public TrechoAereoComConexao(TrechoAereo t1, TrechoAereo t2, int conectionFee) {
        super(t1, t2);
        this.conectionFee = conectionFee;
    }

    @Override
    public int custo() {
        return super.custo() + this.conectionFee;
    }
}
