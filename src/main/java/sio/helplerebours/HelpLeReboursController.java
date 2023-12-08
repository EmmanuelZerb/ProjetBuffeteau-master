package sio.helplerebours;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import sio.helplerebours.Entities.Competence;
import sio.helplerebours.Entities.Demande;
import sio.helplerebours.Entities.Matiere;
import sio.helplerebours.Entities.User;
import sio.helplerebours.Tools.*;
import javafx.scene.control.ListCell;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;


import java.io.Serial;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelpLeReboursController implements Initializable
{

    ServiceCompetence serviceCompetence;
    @FXML
    private DatePicker dpDateLimiteEtudiant;
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
    ConnexionBDD uneCnx;
    ServiceUser unService = new ServiceUser();
    ServiceMatiere serviceMatiere;

    User user;
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
    private ComboBox cboCréerDemandeMatiere;
    @FXML
    private ComboBox cboCréerDemandeSousMatiere;
    @FXML
    private ComboBox cboCreerSesCompetencesMatiere;
    @FXML
    private ComboBox cboCreerSesCompetencesSousMatiere;
    @FXML
    private TableColumn tcVisuCompetencePrenom;
    @FXML
    private TableColumn tcVisuCompetenceNom;
    @FXML
    private TableColumn tcVisuCompetenceClasse;
    @FXML
    private TableColumn tcVisuCompetenceMatiere;
    @FXML
    private TableColumn tcVisuCompetenceSousMatiere;
    @FXML
    private TableColumn tcVisuCompetenceDateLimite;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            uneCnx = new ConnexionBDD();
            ServiceMatiere serviceMatiere = new ServiceMatiere();
            ServiceDemande serviceDemande = new ServiceDemande();
            /*   CRÉE COMPETENCES   */
            cboCréerDemandeMatiere.getItems().addAll(serviceDemande.GetMatiere());
            String designation = (String) cboCréerDemandeMatiere.getSelectionModel().getSelectedItem();
            cboCréerDemandeSousMatiere.getItems().addAll(serviceDemande.GetSousMatiere(designation));
            /*   CRÉE COMPETENCES   */

            /*  VISUALISER COMPETENCE   */
            serviceCompetence = new ServiceCompetence();
            tcVisuCompetencePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            tcVisuCompetenceNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tcVisuCompetenceClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));
            tcVisuCompetenceMatiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
            tcVisuCompetenceSousMatiere.setCellValueFactory(new PropertyValueFactory<>("SousMatiere"));
            tcVisuCompetenceDateLimite.setCellValueFactory(new PropertyValueFactory<>("DateLimite"));
            tvVisualiserCompetencesEtudiant.setItems(serviceCompetence.getCompetence());
            /*           VISUALISER COMPETENCE                    */

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }



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
    }
}
