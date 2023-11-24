package sio.helplerebours;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.layout.AnchorPane;
import sio.helplerebours.Entities.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelpLeReboursController implements Initializable
{
    private User leUser;
    @FXML
    private ComboBox cbCréerDemandeMatiere;
    @FXML
    private DatePicker dpDateLimiteEtudiant;
    @FXML
    private ChoiceBox cbCréerDemandeSousMatiere;
    @FXML
    private Button btnCréerDemandesValider;
    @FXML
    private DatePicker dpCreerSesCompetencesDateLimite;
    @FXML
    private Button btnCréerSesCompetencesValider;
    @FXML
    private Button btnVisualiserSesDemandesValider;
    @FXML
    private TableView tvDemandeEtudiant1;
    @FXML
    private Button btnVisualiserDesDemandesValider;
    @FXML
    private ChoiceBox cbCreerSesCompetencesSousMatiere;
    @FXML
    private ComboBox cbCreerSesCompetencesMatiere;

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    private Button btnCréerDemandesEtudiant1;
    @FXML
    private Button btnVisualiserDemandeEtudiant1;
    @FXML
    private Button btnVisualiserCompétencesEtudiant1;
    @FXML
    private Button btnVisualiserDemandesEtudiant1;
    @FXML
    private Button btnStatistiquesEtudiant1;
    @FXML
    private Button btnCreerCompetencesEtudiant1;
    @FXML
    private AnchorPane apCréerDemandetudiant;
    @FXML
    private AnchorPane apVisuSesDemandeEtudiant;
    @FXML
    private TableView tvDemandeEtudiant;
    @FXML
    private AnchorPane apCreerCompetencesEtudiant;
    @FXML
    private AnchorPane apVisuCompetences;
    @FXML
    private TableView tvVisualiserCompetencesEtudiant;
    @FXML
    private AnchorPane apVisuDesDemandesEtudiant;
    @FXML
    private AnchorPane apStatistiquesEtudiant;

    @FXML
    public void CréerDemandeClicked(Event event) {
        apCréerDemandetudiant.toFront();
    }


    @FXML
    public void VisualiserSesDemandesClicked(Event event) {
        apVisuSesDemandeEtudiant.toFront();
    }


    @FXML
    public void VisualiserCompetencesClicked(Event event) {
        apVisuCompetences.toFront();
    }


    @FXML
    public void visualiserDesdemandesClicked(Event event) {
    apVisuDesDemandesEtudiant.toFront();
    }

    @FXML
    public void StatistiquesClicked(Event event) {
    apStatistiquesEtudiant.toFront();
    }

    @FXML
    public void CreerCompetencesClicked(Event event) {
    apCreerCompetencesEtudiant.toFront();
    }

    @FXML
    public void cbCréerDemandeMatiereClicked(Event event) throws SQLException {

        cbCréerDemandeMatiere.setButtonCell(new ChoiceBoxListCell("designation"));

    }


}
