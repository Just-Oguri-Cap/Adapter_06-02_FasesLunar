package org.example.adapter_fases_lunar;

import java.time.LocalDate;

public interface FonteLunarAmigavel {
    String getNomeFase(LocalDate data);
    String getEmojiDaFase(LocalDate data);
    String getDescricaoDetalhada(LocalDate data);
}