package com.devlukas.designpatterns.composite;

import com.devlukas.designpatterns.structural.composite.OriginDestinationScalesNotMatchException;
import com.devlukas.designpatterns.structural.composite.TrechoAereoComConexao;
import com.devlukas.designpatterns.structural.composite.TrechoAereoComEscala;
import com.devlukas.designpatterns.structural.composite.TrechoAereoSimples;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTrechosCompostos {

    @Test
    void trechoComEscala() {
        var t1 = new TrechoAereoSimples("GRU", "FOR", 200, 2000);
        var t2 = new TrechoAereoSimples("FOR", "NAT", 100, 800);
        var escala = new TrechoAereoComEscala(t1, t2);

        Assertions.assertThat(escala.origem()).isEqualTo(t1.origem());
        Assertions.assertThat(escala.destino()).isEqualTo(t2.destino());
        Assertions.assertThat(escala.custo()).isEqualTo(t1.custo() + t2.custo());
        Assertions.assertThat(escala.distancia()).isEqualTo(t1.distancia() + t2.distancia());
    }

    @Test
    void trechoComEscalaErrorAeroportosDiferentes() {
        var t1 = new TrechoAereoSimples("GRU", "BSB", 200, 2000);
        var t2 = new TrechoAereoSimples("FOR", "NAT", 100, 800);

        Assertions.assertThatThrownBy(() -> new TrechoAereoComEscala(t1, t2))
                .isInstanceOf(OriginDestinationScalesNotMatchException.class)
                .hasMessage("Origem e destino das escalas não coincidem.");
    }

    @Test
    void trechoComConexao() {
        var t1 = new TrechoAereoSimples("GRU", "FOR", 200, 2000);
        var t2 = new TrechoAereoSimples("FOR", "NAT", 100, 800);
        var conexao = new TrechoAereoComConexao(t1, t2, 80);

        Assertions.assertThat(conexao.origem()).isEqualTo(t1.origem());
        Assertions.assertThat(conexao.destino()).isEqualTo(t2.destino());
        Assertions.assertThat(conexao.custo()).isEqualTo(t1.custo() + t2.custo() + 80);
        Assertions.assertThat(conexao.distancia()).isEqualTo(t1.distancia() + t2.distancia());
    }

    @Test
    void trechoComEscalaEConexao() {
        var t1 = new TrechoAereoSimples("GRU", "FOR", 200, 2000);
        var t2 = new TrechoAereoSimples("FOR", "NAT", 100, 800);
        var escala = new TrechoAereoComEscala(t1, t2);
        var t3 = new TrechoAereoSimples("NAT", "BSB", 300, 1200);
        var conexao = new TrechoAereoComConexao(escala, t3, 100);

        Assertions.assertThat(conexao.origem()).isEqualTo(t1.origem());
        Assertions.assertThat(conexao.destino()).isEqualTo(t3.destino());
        Assertions.assertThat(conexao.custo()).isEqualTo(t1.custo() + t2.custo() + t3.custo() + 100);
        Assertions.assertThat(conexao.distancia()).isEqualTo(t1.distancia() + t2.distancia() + t3.distancia());
    }
}
