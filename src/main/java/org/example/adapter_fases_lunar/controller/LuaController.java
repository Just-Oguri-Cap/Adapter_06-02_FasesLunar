package org.example.adapter_fases_lunar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.example.adapter_fases_lunar.Lua;
import org.example.adapter_fases_lunar.service.LuaService;

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
    @FXML private RadioButton rbCientifico;
    @FXML private RadioButton rbAstrologico;

    private final ToggleGroup grupoRelatorio = new ToggleGroup();
    private final LuaService luaService;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LuaController() {
        this.luaService = new LuaService(Lua.getInstancia());
    }

    @FXML
    public void initialize() {
        // Vincula os RadioButtons ao mesmo grupo para comportamento exclusivo
        rbCientifico.setToggleGroup(grupoRelatorio);
        rbAstrologico.setToggleGroup(grupoRelatorio);

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

    @FXML
    private void aoTrocarRelatorio(ActionEvent evento) {
        // Apenas re-renderiza a tela com o relatório selecionado
        atualizarTela();
    }

    private boolean isCientificoSelecionado() {
        return rbCientifico.isSelected();
    }

    private void atualizarTela() {
        LocalDate data = Lua.getInstancia().getDataSelecionada();

        lblDia.setText(String.format("Data: %s | Dia do ciclo: %d/29",
                data.format(FORMATADOR),
                luaService.getDiaDoCiclo(data)));

        lblFase.setText(luaService.getNomeFase(data));
        lblDetalhe.setText(luaService.getDescricaoDetalhada(data, isCientificoSelecionado()));
        lblEmojiGigante.setText(luaService.getEmojiDaFase(data));

        double percentual = luaService.getPercentualIluminacao(data);
        barraIluminacao.setProgress(percentual / 100.0);
        lblPercentual.setText(String.format("%.0f%%", percentual));
    }
}