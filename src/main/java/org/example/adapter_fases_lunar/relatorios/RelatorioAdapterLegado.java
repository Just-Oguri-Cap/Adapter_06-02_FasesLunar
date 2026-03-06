package org.example.adapter_fases_lunar.relatorios;

import org.example.adapter_fases_lunar.FaseLunar;
import org.example.adapter_fases_lunar.Lua;

public class RelatorioAdapterLegado implements GerarRelatorio {
    private final RelatorioLegado relatorioLegado;
    public RelatorioAdapterLegado() {
        relatorioLegado = new RelatorioLegado();
    }

    // Converte o Double diaDoCiclo em FaseLunar permitindo o resto do programa usar o RelatórioLegado
    @Override
    public String getDetalheFase(double diaDoCiclo) {
        FaseLunar fase = Lua.calcularFase(diaDoCiclo);
        return relatorioLegado.gerarDetalhes(fase);
    }
}
