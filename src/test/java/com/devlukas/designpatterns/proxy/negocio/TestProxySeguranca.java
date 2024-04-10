package com.devlukas.designpatterns.proxy.negocio;

import com.devlukas.designpatterns.structural.proxy.negocio.InterfaceNegocio;
import com.devlukas.designpatterns.structural.proxy.negocio.SegurancaNegocio;
import com.devlukas.designpatterns.structural.proxy.negocio.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestProxySeguranca {

    @Test
    void testAutorizaAcesso() {
        var u = new Usuario("Lukas");
        u.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        var mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, u);
        n.executaTransacao();
        Assertions.assertThat(mock.foiAcessado()).isTrue();
    }

    @Test
    void testNaoAutorizadoAcesso() {
        var u = new Usuario("Lukas");
        u.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        var mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, u);
        try {
            n.cancelaTransacao();
            fail();
        } catch (Exception e) {
            Assertions.assertThat(mock.foiAcessado()).isFalse();
        }
    }
}
