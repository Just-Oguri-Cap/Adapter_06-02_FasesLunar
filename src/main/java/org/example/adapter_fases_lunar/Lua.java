package org.example.adapter_fases_lunar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Lua {

    private static Lua instancia;
    private LocalDate dataSelecionada;
    private FaseLunar faseAtual;

    // Lua Nova real confirmada: 29 de janeiro de 2025 às 12:36 UTC
    // Fonte: https://www.timeanddate.com/moon/phases/
    private static final LocalDateTime LUA_NOVA_REFERENCIA = LocalDateTime.of(2025, 1, 29, 12, 36, 0);
    private static final double CICLO_LUNAR = 29.530589; // ciclo sinódico médio real

    private Lua() {
        this.dataSelecionada = LocalDate.now();
        this.faseAtual = calcularFase(this.dataSelecionada);
    }

    public static Lua getInstancia() {
        if (instancia == null) {
            instancia = new Lua();
        }
        return instancia;
    }

    public int getDiaDoCiclo() {
        // Calcula em minutos para aproveitar o horário exato da lua nova
        long minutosDesdeReferencia = ChronoUnit.MINUTES.between(
                LUA_NOVA_REFERENCIA,
                dataSelecionada.atStartOfDay()
        );
        double cicloPreciso = (minutosDesdeReferencia / (CICLO_LUNAR * 24 * 60)) % 1.0;
        if (cicloPreciso < 0) cicloPreciso += 1.0;
        return (int) Math.round(cicloPreciso * CICLO_LUNAR);
    }

    public double getPercentualIluminacao() {
        long minutosDesdeReferencia = ChronoUnit.MINUTES.between(
                LUA_NOVA_REFERENCIA,
                dataSelecionada.atStartOfDay()
        );
        double faseEmCiclo = (minutosDesdeReferencia / (CICLO_LUNAR * 24 * 60)) % 1.0;
        if (faseEmCiclo < 0) faseEmCiclo += 1.0;

        // Cálculo trigonométrico real da iluminação
        double angulo = faseEmCiclo * 2 * Math.PI;
        return (1 - Math.cos(angulo)) / 2.0 * 100;
    }

    private FaseLunar calcularFase(LocalDate data) {
        long minutosDesdeReferencia = ChronoUnit.MINUTES.between(
                LUA_NOVA_REFERENCIA,
                data.atStartOfDay()
        );
        double cicloPreciso = (minutosDesdeReferencia / (CICLO_LUNAR * 24 * 60)) % 1.0;
        if (cicloPreciso < 0) cicloPreciso += 1.0;

        double dia = cicloPreciso * CICLO_LUNAR;
        return Lua.calcularFase(dia);
    }

    public static FaseLunar calcularFase(double diaDaFase) {
        if (diaDaFase < 1.85) {
            return FaseLunar.NOVA;
        } else if (diaDaFase < 7.38) {
            return FaseLunar.CRESCENTE_NOVA;
        } else if (diaDaFase < 11.07) {
            return FaseLunar.QUARTO_CRESCENTE;
        } else if (diaDaFase < 14.76) {
            return FaseLunar.CRESCENTE_GIBOSA;
        } else if (diaDaFase < 18.45) {
            return FaseLunar.CHEIA;
        } else if (diaDaFase < 22.14) {
            return FaseLunar.MINGUANTE_GIBOSA;
        } else if (diaDaFase < 25.83) {
            return FaseLunar.QUARTO_MINGUANTE;
        } else {
            return FaseLunar.MINGUANTE_NOVA;
        }
    }
    public LocalDate getDataSelecionada() {
        return dataSelecionada;
    }

    public void setDataSelecionada(LocalDate dataSelecionada) {
        this.dataSelecionada = dataSelecionada;
        this.faseAtual = calcularFase(dataSelecionada);
    }

    public FaseLunar getFaseAtual() {
        return faseAtual;
    }
}