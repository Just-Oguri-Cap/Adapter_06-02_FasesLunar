package org.example.adapter_fases_lunar.relatorios;

public class RelatorioCientifico implements GerarRelatorio{
    // Recebe o diaDoCiclo e retorna uma descrição detalhada da fase lunar
    public String getDetalheFase(double diaDoCiclo) {
        if (diaDoCiclo < 1.85) {
            return "Lua em conjunção com o Sol. Face iluminada voltada ao Sol, face noturna voltada à Terra. Invisível a olho nu.";
        } else if (diaDoCiclo < 7.38) {
            return "Fina faixa iluminada começa a aparecer no horizonte oeste após o pôr do sol. Elongação solar ainda pequena.";
        } else if (diaDoCiclo < 11.07) {
            return "Quarto crescente: metade da face visível iluminada. Terminador reto, sombras acentuadas nos craters.";
        } else if (diaDoCiclo < 14.76) {
            return "Crescente gibosa: mais da metade iluminada. Lua nasce à tarde e se põe após a meia-noite.";
        } else if (diaDoCiclo < 18.45) {
            return "Lua em oposição ao Sol. Face visível totalmente iluminada. Magnitude visual pode chegar a -12,7.";
        } else if (diaDoCiclo < 22.14) {
            return "Minguante gibosa: iluminação em queda. Lua nasce após o pôr do sol e se põe antes do meio-dia.";
        } else if (diaDoCiclo < 25.83) {
            return "Quarto minguante: metade iluminada visível ao amanhecer. Terminador reto, espelhado ao quarto crescente.";
        } else {
            return "Minguante final: fina faixa visível antes do nascer do sol. Lua se aproxima da conjunção.";
        }
    }
}