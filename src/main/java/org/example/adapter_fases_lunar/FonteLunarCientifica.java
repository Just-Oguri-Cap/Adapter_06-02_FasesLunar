package org.example.adapter_fases_lunar;

import java.time.LocalDate;

public interface FonteLunarCientifica {
    int getDiaDoCiclo(LocalDate data);
    double getPercentualIluminacao(LocalDate data);
}