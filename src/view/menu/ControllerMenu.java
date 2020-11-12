package view.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerMenu extends Application implements Initializable{

    @FXML
	private BorderPane borderpane;

	@FXML
	private Button btnMenus;

	@FXML
	private Button btnSettings;

	@FXML
	private JFXButton btnVisitante;

	@FXML
	private Button btnSignout;

	@FXML
	void Exit(ActionEvent event) {
		System.exit(1);
		;
	}

	@FXML
	private ListView<Painel> listView;

	private ArrayList<Painel> listaDePaineis = new ArrayList<>();

	// Trata o conteúdo do ListView
	// ============================
	private void criaDadosListView() {
		listaDePaineis.add(new Painel("Visitante", "../view/visitante/VisitTela.fxml"));

		listView.setItems(FXCollections.observableArrayList(listaDePaineis));
	}

	public void trataMenu(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnVisitante) {
			for (Painel painel : listaDePaineis) {
				Pane pane = carregaFXML(painel.FXML);
				borderpane.setCenter(pane);
			}
		}
	}

	// Trata o conteúdo do CENTRO
	// ===========================

	private Pane carregaFXML(String fxml) {
		try {
			return FXMLLoader.load(getClass().getResource(fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// @Descrição: Class ENTIDADE para cada página
	private class Painel {
		private String identificacao;
		private String FXML;

		public Painel(String identificacao, String fXML) {
			super();
			this.identificacao = identificacao;
			FXML = fXML;
		}

		@Override
		public String toString() {
			return identificacao;
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage) {

		try {
			Pane pane = FXMLLoader.load(getClass().getResource("TelaMenu.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
