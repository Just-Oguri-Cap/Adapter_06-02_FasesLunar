package org.example.adapter_fases_lunar;

import java.time.LocalDate;

public class LuaAdapter implements FonteLunarAmigavel, FonteLunarCientifica {

    private final Lua lua; // Service embrulhado

    public LuaAdapter(Lua lua) {
        this.lua = lua;
    }

    // ---- FonteLunarAmigavel ----
    @Override
    public String getNomeFase(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getFaseAtual().getNome();
    }

    @Override
    public String getEmojiDaFase(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getFaseAtual().getEmoji();
    }

    @Override
    public String getDescricaoDetalhada(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getDetalheFase();
    }

    // ---- FonteLunarCientifica ----
    @Override
    public int getDiaDoCiclo(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getDiaDoCiclo();
    }

    @Override
    public double getPercentualIluminacao(LocalDate data) {
        lua.setDataSelecionada(data);
        return lua.getPercentualIluminacao();
    }
}