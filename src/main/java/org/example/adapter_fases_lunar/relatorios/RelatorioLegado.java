package org.example.adapter_fases_lunar.relatorios;

import org.example.adapter_fases_lunar.FaseLunar;

public class RelatorioLegado {
    public String gerarDetalhes(FaseLunar fase) {
        String resultado = switch (fase) {
            case NOVA -> "Lua Nova: energias se renovam! Momento ideal para iniciar novos projetos e plantar sementes de intenção. Arianos e Escorpiões sentirão a força do recomeço.";
            case CRESCENTE_NOVA -> "Lua Crescente Nova: a maré está a seu favor! Ótimo período para assinar contratos e firmar parcerias. Evite decisões impulsivas, Sagitarianos.";
            case QUARTO_CRESCENTE -> "Quarto Crescente: obstáculos surgem para testar sua determinação. Geminianos, revisem seus planos antes de avançar. A persistência será recompensada.";
            case CRESCENTE_GIBOSA -> "Lua Crescente Gibosa: sua intuição está aguçada! Confie no seu instinto, Piscianos. Momento propício para cuidar da saúde e ajustar a alimentação.";
            case CHEIA -> "Lua Cheia: emoções à flor da pele! Leoninos e Aquarianos devem evitar discussões hoje. Sonhos serão intensos e reveladores — anote-os ao acordar.";
            case MINGUANTE_GIBOSA -> "Lua Minguante Gibosa: hora de agradecer e liberar o que não serve mais. Cancerianos, soltem relacionamentos tóxicos. A cura começa pelo desapego.";
            case QUARTO_MINGUANTE -> "Quarto Minguante: energia de limpeza e encerramento de ciclos. Ideal para reorganizar ambientes e pensamentos. Virginianos, o descanso também é produtivo.";
            case MINGUANTE_NOVA -> "Lua Minguante Nova: o silêncio interno fala mais alto. Capricornianos e Toureanos são chamados à introspecção. Medite e ouça o que sua alma pede.";
        };

        return resultado;
    }
}