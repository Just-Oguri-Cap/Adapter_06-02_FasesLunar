package org.example.adapter_fases_lunar.relatorios;

public interface GerarRelatorio {
    // Só recebe o FaseDaLua teoricamente
    String getDetalheFase(double diaDoCiclo);
}