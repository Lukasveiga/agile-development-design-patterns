package com.devlukas.designpatterns.structural.proxy.negocio;


public class SegurancaNegocio implements InterfaceNegocio {

    private InterfaceNegocio encapsulado;
    private Usuario u;

    public SegurancaNegocio(InterfaceNegocio encapsulado, Usuario u) {
        this.encapsulado = encapsulado;
        this.u = u;
    }

    @Override
    public void executaTransacao() {
        if(u.verificaPermissao("InterfaceNegocio", "executaTransacao")) {
            encapsulado.executaTransacao();
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public void cancelaTransacao() {
        if(u.verificaPermissao("InterfaceNegocio", "cancelaTransacao")) {
            encapsulado.cancelaTransacao();
        } else {
            throw new RuntimeException();
        }
    }
}
