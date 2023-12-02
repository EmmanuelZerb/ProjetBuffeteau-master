package sio.helplerebours;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import sio.helplerebours.Entities.Matiere;
import sio.helplerebours.Entities.User;
import sio.helplerebours.Tools.ConnexionBDD;
import sio.helplerebours.Tools.ServiceMatiere;
import sio.helplerebours.Tools.ServiceUser;
import javafx.scene.control.ListCell;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelpLeReboursController implements Initializable
{

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
    private ChoiceBox cCreerSesCompetencesSousMatiere;
    @FXML
    private ComboBox cCreerSesCompetencesMatiere;
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
    ServiceMatiere ServiceMatiere;
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            uneCnx = new ConnexionBDD();
            ServiceMatiere serviceMatiere = new ServiceMatiere();

            // Pour l'affichage des cellules dans la liste déroulante
            cbCréerDemandeMatiere.setCellFactory(param -> new ListCell<Matiere>() {
                @Override
                protected void updateItem(Matiere matiere, boolean empty) {
                    super.updateItem(matiere, empty);
                    if (empty || matiere == null) {
                        setText(null);
                    } else {
                        setText(matiere.getDesignation());
                    }
                }
            });
            // Définition du convertisseur pour la ComboBox
            cbCréerDemandeMatiere.setConverter(new StringConverter<Matiere>() {
                @Override
                public String toString(Matiere matiere) {
                    return matiere == null ? null : matiere.getDesignation();
                }

                @Override
                public Matiere fromString(String string) {
                    return null; // Si vous avez besoin d'une conversion inverse
                }
            });

            cbCréerDemandeMatiere.getItems().addAll(serviceMatiere.GetAllMatiere());
            cCreerSesCompetencesMatiere.getItems().addAll(serviceMatiere.GetAllMatiere());

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
