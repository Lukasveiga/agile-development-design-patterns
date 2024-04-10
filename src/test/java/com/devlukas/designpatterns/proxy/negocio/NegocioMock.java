package com.devlukas.designpatterns.proxy.negocio;

import com.devlukas.designpatterns.structural.proxy.negocio.InterfaceNegocio;

public class NegocioMock implements InterfaceNegocio {

    private boolean foiAcessado = false;

    @Override
    public void executaTransacao() {
        this.foiAcessado = true;
    }

    @Override
    public void cancelaTransacao() {
        this.foiAcessado = true;
    }

    public boolean foiAcessado() {
        return foiAcessado;
    }
}
