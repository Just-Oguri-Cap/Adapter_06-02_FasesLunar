package org.example.adapter_fases_lunar.relatorios;

public interface GerarRelatorio {
    // Interface que o programa usa, mas o relatório legado não consegue se comunicar com essa interface
    // então precisamos do adapterlegado para adaptar para relatorio legado interagir com o programa
    String getDetalheFase(double diaDoCiclo);
}