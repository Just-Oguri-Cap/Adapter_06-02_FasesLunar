package org.example.adapter_fases_lunar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LuaController {

    @FXML private Label lblDia;
    @FXML private Label lblFase;
    @FXML private Label lblDetalhe;
    @FXML private Label lblEmojiGigante;
    @FXML private Label lblPercentual;
    @FXML private DatePicker seletorData;
    @FXML private ProgressBar barraIluminacao;

    private final FonteLunarAmigavel fonteAmigavel;
    private final FonteLunarCientifica fonteCientifica;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LuaController() {
        LuaAdapter adapter = new LuaAdapter(Lua.getInstancia());
        this.fonteAmigavel = adapter;
        this.fonteCientifica = adapter;
    }

    @FXML
    public void initialize() {
        seletorData.setValue(Lua.getInstancia().getDataSelecionada());
        atualizarTela();
    }

    @FXML
    private void aoSelecionarData(ActionEvent evento) {
        LocalDate dataSelecionada = seletorData.getValue();
        if (dataSelecionada != null) {
            Lua.getInstancia().setDataSelecionada(dataSelecionada);
            atualizarTela();
        }
    }

    @FXML
    private void aoDiaSeguinte(ActionEvent evento) {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().plusDays(1));
        seletorData.setValue(lua.getDataSelecionada());
        atualizarTela();
    }

    @FXML
    private void aoDiaAnterior(ActionEvent evento) {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().minusDays(1));
        seletorData.setValue(lua.getDataSelecionada());
        atualizarTela();
    }

    private void atualizarTela() {
        LocalDate data = Lua.getInstancia().getDataSelecionada();

        lblDia.setText(String.format("Data: %s | Dia do ciclo: %d/29",
                data.format(FORMATADOR),
                fonteCientifica.getDiaDoCiclo(data)));

        lblFase.setText(fonteAmigavel.getNomeFase(data));
        lblDetalhe.setText(fonteAmigavel.getDescricaoDetalhada(data));
        lblEmojiGigante.setText(fonteAmigavel.getEmojiDaFase(data));

        double percentual = fonteCientifica.getPercentualIluminacao(data);
        barraIluminacao.setProgress(percentual / 100.0);
        lblPercentual.setText(String.format("%.0f%%", percentual));
    }
}