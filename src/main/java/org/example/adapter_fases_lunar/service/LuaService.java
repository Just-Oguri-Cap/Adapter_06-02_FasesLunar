package org.example.adapter_fases_lunar.service;

import org.example.adapter_fases_lunar.Lua;
import org.example.adapter_fases_lunar.relatorios.GerarRelatorio;
import org.example.adapter_fases_lunar.relatorios.RelatorioCientifico;
import org.example.adapter_fases_lunar.relatorios.RelatorioAdapterLegado;

import java.time.LocalDate;

public class LuaService {

    private final Lua lua; // Service embrulhado

    public LuaService(Lua lua) {
        this.lua = lua;
    }

    public String getNomeFase(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getFaseAtual().getNome();
    }

    public String getEmojiDaFase(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getFaseAtual().getEmoji();
    }

    // Gera o detalhe da fase se comunicando com o RelatórioAdpterLegado
    public String getDescricaoDetalhada(LocalDate data) {
        return getDescricaoDetalhada(data, true);
    }

    // Escolhe o relatório com base na seleção do usuário e passa a FaseLunar diretamente
    public String getDescricaoDetalhada(LocalDate data, boolean cientifico) {
        lua.setDataSelecionada(data);

        GerarRelatorio relatorio = cientifico
                ? new RelatorioCientifico()
                : new RelatorioAdapterLegado();

        // RelatorioCientifico recebe diaDoCiclo, RelatorioAdpterLegado traduz FaseLunar para o legado
        return relatorio.getDetalheFase(lua.getDiaDoCiclo());
    }

    public int getDiaDoCiclo(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getDiaDoCiclo();
    }

    public double getPercentualIluminacao(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getPercentualIluminacao();
    }
}