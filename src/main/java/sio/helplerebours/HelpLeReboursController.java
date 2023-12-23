package sio.helplerebours;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import sio.helplerebours.Entities.*;
import sio.helplerebours.Tools.*;
import javafx.scene.control.ListCell;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import java.io.Serial;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelpLeReboursController implements Initializable
{
    User user;

    ConnexionBDD uneCnx;
    ServiceUser unService;
    ServiceMatiere serviceMatiere;
    ServiceCompetence serviceCompetence;
    ServiceDemande serviceDemande;
    ServiceSoutien serviceSoutien;
    @FXML
    private Button btnCréerDemandesValider;
    @FXML
    private DatePicker dpCreerSesCompetencesDateLimite;
    @FXML
    private Button btnCréerSesCompetencesValider;
    @FXML
    private Button btnVisualiserDesDemandesValider;
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
    private ComboBox cboCreerSesCompetencesMatiere;
    @FXML
    private TableColumn tcVisuCompetenceMatiere;
    @FXML
    private TableColumn tcVisuCompetenceSousMatiere;
    @FXML
    private MenuButton cboCréerDemandeSousMatiere;
    @FXML
    private DatePicker dpDateLimiteDemande;
    @FXML
    private TableColumn tcIdVisualiserDemande;
    @FXML
    private TableColumn tcMatiereVisualiserDemande;
    @FXML
    private TableColumn tcSousMatiereVisualiserDemande;
    @FXML
    private TableColumn tcDateLimiteVisualiserDemande;
    @FXML
    private MenuButton cboCreerSesCompetencesSousMatiere;
    @FXML
    private Button btnModifierVisuCompetence;
    @FXML
    private AnchorPane apModifierCompetence;
    @FXML
    private ComboBox cboModifierMatiereCompetence;
    @FXML
    private MenuButton cboModifierSousMatiereCompetence;
    @FXML
    private Button btnValiderModifCompetence;
    @FXML
    private Button btnAnnulerModifCompetence;
    @FXML
    private Button btnModifierVisualiserSesDemandes;
    @FXML
    private AnchorPane apModifierDemande;
    @FXML
    private Button btnValiderModifierDemande;
    @FXML
    private DatePicker dpModifierDemande;
    @FXML
    private Button btnAnnulerModifierDemande;
    @FXML
    private ComboBox cboModifierMatiereDemande;
    @FXML
    private MenuButton cboModifierSousMatiereDemande;
    @FXML
    private TableView tvVisualiserAutresDemandes;
    @FXML
    private DatePicker dpDateDuSoutien;
    @FXML
    private TextArea txtDescriptionSoutien;
    @FXML
    private ComboBox cboMatiereSoutien;
    @FXML
    private AnchorPane apCreeSoutien;
    @FXML
    private TableColumn tcIdDesDemandes;
    @FXML
    private TableColumn tcSousMatiereDesDemande;
    @FXML
    private TableColumn tcDateLimiteDesDemande;
    @FXML
    private Button btnValiderSoutien;
    @FXML
    private Button btnAnnulerSoutient;
    @FXML
    private TableColumn tcMatiereDesDemandes;
    @FXML
    private MenuButton cboSousMatiereSoutien;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            uneCnx = new ConnexionBDD();
            serviceMatiere= new ServiceMatiere();
            serviceCompetence=new ServiceCompetence();
            serviceDemande = new ServiceDemande();
            serviceSoutien = new ServiceSoutien();
            serviceCompetence = new ServiceCompetence();
            ObservableList<Matiere> lesMatieres = serviceMatiere.GetLesMatieres();

            for(Matiere uneMatiere : lesMatieres)
            {
                cboCréerDemandeMatiere.getItems().add(uneMatiere.getDesignation());
                cboCreerSesCompetencesMatiere.getItems().add(uneMatiere.getDesignation());
            }
            /*  VISUALISER DEMANDE  */
            tcIdVisualiserDemande.setCellValueFactory(new PropertyValueFactory<>("idDemande"));
            tcMatiereVisualiserDemande.setCellValueFactory(new PropertyValueFactory<>("designation"));
            tcSousMatiereVisualiserDemande.setCellValueFactory(new PropertyValueFactory<>("sousMatiere"));
            tcDateLimiteVisualiserDemande.setCellValueFactory(new PropertyValueFactory<>("dateLimite"));


            /*  VISUALISER COMPETENCE   */
            tcVisuCompetenceMatiere.setCellValueFactory(new PropertyValueFactory<>("designation"));
            tcVisuCompetenceSousMatiere.setCellValueFactory(new PropertyValueFactory<>("sousMatiere"));

            /*  VISUALISER AUTRES DEMANDES   */
            tcDateLimiteDesDemande.setCellValueFactory(new PropertyValueFactory<>("dateLimite"));
            tcIdDesDemandes.setCellValueFactory(new PropertyValueFactory<>("idDemande"));
            tcMatiereDesDemandes.setCellValueFactory(new PropertyValueFactory<>("designation"));
            tcSousMatiereDesDemande.setCellValueFactory(new PropertyValueFactory<>("sousMatiere"));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        cboCréerDemandeMatiere.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    String matiereSelectionne = newValue;
                    try {
                        updateCboCréeDemandeSousMatieres(matiereSelectionne);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        cboCreerSesCompetencesMatiere.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    String matiereSelectionne = newValue;
                    try {
                        updateCboCréeCompetenceSousMatieres(matiereSelectionne);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Créé demande
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void updateCboCréeDemandeSousMatieres(String matiereSelectionne) throws SQLException
    {
        ObservableList<String> sousMatieres = serviceMatiere.GetLesSousMatieres(matiereSelectionne);
        cboCréerDemandeSousMatiere.getItems().clear();

        for (String sousMatiere : sousMatieres)
        {
            CustomMenuItem customMenuItem = new CustomMenuItem(new CheckBox(sousMatiere));
            customMenuItem.setHideOnClick(false);
            cboCréerDemandeSousMatiere.getItems().add(customMenuItem);
        }
    }
    @FXML
    public void btnCréerDemandesValider(Event event) throws SQLException {
        String dateUpdate = LocalDate.now().toString();
        int idMatiere = serviceMatiere.getIdMatiere(cboCréerDemandeMatiere.getSelectionModel().getSelectedItem().toString());
        Demande uneDemande = new Demande(user.getId(), idMatiere, recupererLesCasesCochees(cboCréerDemandeSousMatiere), dateUpdate, dpDateLimiteDemande.getValue().toString(), 1);
        serviceDemande.insertDemande(uneDemande);
    }
    @FXML
    public void CréerDemandeClicked(Event event) {
        apCréerDemandetudiant.toFront();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // visualiser demande
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void VisualiserSesDemandesClicked(Event event) throws SQLException {
        tvDemandeEtudiant.setItems(serviceDemande.getToutesLesDemandes(user.getId()));
        apVisuSesDemandeEtudiant.toFront();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Modifier Demande
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    public void btnModifierVisualiserSesDemandesClicked(Event event) throws SQLException {
        cboModifierSousMatiereDemande.getItems().clear();
        cboModifierMatiereDemande.setValue(((Demande) tvDemandeEtudiant.getSelectionModel().getSelectedItem()).getDesignation());
        dpModifierDemande.setValue(LocalDate.parse(((Demande) tvDemandeEtudiant.getSelectionModel().getSelectedItem()).getDateLimite()));
        ObservableList<String> lesSousMatieresSelect = StringEnObservableListe(((Demande) tvDemandeEtudiant.getSelectionModel().getSelectedItem()).getSousMatiere());
        ObservableList<String> lesSousMatieres = serviceMatiere.GetLesSousMatieres(((Demande) tvDemandeEtudiant.getSelectionModel().getSelectedItem()).getDesignation());
        for (String sousMatiere : lesSousMatieres) {
            CheckBox checkBox = new CheckBox(sousMatiere);
            CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
            customMenuItem.setHideOnClick(false);
            cboModifierSousMatiereDemande.getItems().add(customMenuItem);

            if (lesSousMatieresSelect.contains(sousMatiere)) {
                checkBox.setSelected(true);
            }
        }
        apModifierDemande.toFront();
    }
    @FXML
    public void btnValiderModifierDemandeClicked(Event event) throws SQLException {
        String dateUpdate = LocalDate.now().toString();
        serviceDemande.updateDemande(dateUpdate,dpModifierDemande.getValue().toString(),recupererLesCasesCochees(cboModifierSousMatiereDemande),((Demande)tvDemandeEtudiant.getSelectionModel().getSelectedItem()).getIdDemande());
        cboModifierSousMatiereDemande.getItems().clear();
        cboModifierMatiereDemande.setValue(null);
        tvDemandeEtudiant.setItems(serviceDemande.getToutesLesDemandes(user.getId()));
        apVisuSesDemandeEtudiant.toFront();
    }

    @FXML
    public void btnAnnulerModifierDemandeClicked(Event event) throws SQLException {
        tvVisualiserCompetencesEtudiant.setItems(serviceDemande.getToutesLesDemandes(user.getId()));
        apVisuSesDemandeEtudiant.toFront();
        cboModifierSousMatiereCompetence.getItems().clear();
        cboModifierMatiereCompetence.setValue(null);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Cree Competence
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void updateCboCréeCompetenceSousMatieres(String matiereSelectionne) throws SQLException
    {
        ObservableList<String> sousMatieres = serviceMatiere.GetLesSousMatieres(matiereSelectionne);
        cboCreerSesCompetencesSousMatiere.getItems().clear();

        for (String sousMatiere : sousMatieres)
        {
            CustomMenuItem customMenuItem = new CustomMenuItem(new CheckBox(sousMatiere));
            customMenuItem.setHideOnClick(false);
            cboCreerSesCompetencesSousMatiere.getItems().add(customMenuItem);
        }
    }
    @FXML
    public void CreerCompetencesClicked(Event event){
        apCreerCompetencesEtudiant.toFront();
    }
    @FXML
    public void btnCréerSesCompetencesValiderClicked(Event event) throws SQLException {
        int idMatiere = serviceMatiere.getIdMatiere(cboCreerSesCompetencesMatiere.getSelectionModel().getSelectedItem().toString());
        Competence maCompetence = new Competence(user.getId(),idMatiere,recupererLesCasesCochees(cboCreerSesCompetencesSousMatiere));
        serviceCompetence.insertCompetence(maCompetence);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Visualiser Compétence
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    public void VisualiserCompetencesClicked(Event event) throws SQLException {
        apVisuCompetences.toFront();
        tvVisualiserCompetencesEtudiant.setItems(serviceCompetence.getToutesLesCompetences(user.getId()));

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Mofifier Competence
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void btnModifierVisuCompetenceClicked(Event event) throws SQLException {
        cboModifierSousMatiereCompetence.getItems().clear();
        cboModifierMatiereCompetence.setValue(((Competence) tvVisualiserCompetencesEtudiant.getSelectionModel().getSelectedItem()).getDesignation());
        ObservableList<String> lesSousMatieresSelect = StringEnObservableListe(((Competence) tvVisualiserCompetencesEtudiant.getSelectionModel().getSelectedItem()).getSousMatiere());
        ObservableList<String> lesSousMatieres = serviceMatiere.GetLesSousMatieres(((Competence) tvVisualiserCompetencesEtudiant.getSelectionModel().getSelectedItem()).getDesignation());

        for (String sousMatiere : lesSousMatieres) {
            CheckBox checkBox = new CheckBox(sousMatiere);
            CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
            customMenuItem.setHideOnClick(false);
            cboModifierSousMatiereCompetence.getItems().add(customMenuItem);

            if (lesSousMatieresSelect.contains(sousMatiere)) {
                checkBox.setSelected(true);
            }
        }
        apModifierCompetence.toFront();
    }
    @FXML
    public void btnValiderModifCompetenceClicked(Event event) throws SQLException {
        tvVisualiserCompetencesEtudiant.setItems(null);
        tvVisualiserCompetencesEtudiant.setItems(serviceCompetence.getToutesLesCompetences(user.getId()));
        apVisuCompetences.toFront();
        serviceCompetence.updateCompetence(((Competence)tvVisualiserCompetencesEtudiant.getSelectionModel().getSelectedItem()).getId(),recupererLesCasesCochees(cboModifierSousMatiereCompetence));
        cboModifierSousMatiereCompetence.getItems().clear();
        cboModifierMatiereCompetence.setValue(null);
    }

    @FXML
    public void btnAnnulerModifCompetenceClicked(Event event) throws SQLException {
        tvVisualiserCompetencesEtudiant.setItems(null);
        tvVisualiserCompetencesEtudiant.setItems(serviceCompetence.getToutesLesCompetences(user.getId()));
        apVisuCompetences.toFront();
        cboModifierSousMatiereCompetence.getItems().clear();
        cboModifierMatiereCompetence.setValue(null);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Cree Soutien
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    public void visualiserDesdemandesClicked(Event event) throws SQLException {
        tvVisualiserAutresDemandes.setItems(serviceDemande.getlesAutresDemandes(user.getId()));
        apVisuDesDemandesEtudiant.toFront();
    }
    @FXML
    public void btnVisualiserDesDemandesValiderClicked(Event event) throws SQLException {
        cboSousMatiereSoutien.getItems().clear();
        cboMatiereSoutien.setValue(((Demande) tvVisualiserAutresDemandes.getSelectionModel().getSelectedItem()).getDesignation());
        ObservableList<String> lesSousMatieresSelect = StringEnObservableListe(((Demande) tvVisualiserAutresDemandes.getSelectionModel().getSelectedItem()).getSousMatiere());
        for (String sousMatiere : lesSousMatieresSelect) {
            CheckBox checkBox = new CheckBox(sousMatiere);
            CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);
            customMenuItem.setHideOnClick(false);
            cboSousMatiereSoutien.getItems().add(customMenuItem);
            checkBox.setSelected(true);
        }
        apCreeSoutien.toFront();
    }
    @FXML
    public void btnValiderSoutientClicked(Event event) throws SQLException {
        Demande demandeSelect=((Demande)tvVisualiserAutresDemandes.getSelectionModel().getSelectedItem());
        String dateUpdate = LocalDate.now().toString();
        int idCompetence = serviceCompetence.getUneCompetenceUser(user.getId(), demandeSelect.getDesignation());
        Soutien soutien = new Soutien(demandeSelect.getIdDemande(),idCompetence,dpDateDuSoutien.getValue().toString(),dateUpdate,txtDescriptionSoutien.getText());
        serviceSoutien.InsertSoutient(soutien);
        cboMatiereSoutien.setValue(null);
        cboSousMatiereSoutien.getItems().clear();
        txtDescriptionSoutien.clear();
        dpDateDuSoutien.setValue(null);
        tvVisualiserAutresDemandes.setItems(serviceDemande.getlesAutresDemandes(user.getId()));
        apVisuDesDemandesEtudiant.toFront();
    }
    @FXML
    public void btnAnnulerSoutientClicked(Event event) throws SQLException {
        cboMatiereSoutien.setValue(null);
        cboSousMatiereSoutien.getItems().clear();
        txtDescriptionSoutien.clear();
        dpDateDuSoutien.setValue(null);
        tvVisualiserAutresDemandes.setItems(serviceDemande.getlesAutresDemandes(user.getId()));
        apVisuDesDemandesEtudiant.toFront();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Statistique Etudiant
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    public void StatistiquesClicked(Event event) {
    apStatistiquesEtudiant.toFront();
    }

    @FXML
    public void cbCréerDemandeMatiereClicked(Event event) throws SQLException
    {

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// Fonction Generale
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setUser(User user) {
        this.user = user;
    }
    public String recupererLesCasesCochees(MenuButton menu) {
        String sousMatiere = "";
        ObservableList<MenuItem> items = menu.getItems();
        for (MenuItem item : items) {
            if (item instanceof CustomMenuItem) {
                CustomMenuItem customItem = (CustomMenuItem) item;
                CheckBox checkBox = (CheckBox) customItem.getContent();

                if (checkBox.isSelected()) {
                    String sousMatiereSelectioner = checkBox.getText();
                    sousMatiere += "#" + sousMatiereSelectioner;
                }
            }
        }
        return sousMatiere;
    }
    public ObservableList<String> StringEnObservableListe(String sousMatiere){
        ObservableList<String> leSousMatieres = FXCollections.observableArrayList();
        String[] splitSousMatiere = sousMatiere.split("#");
        for (String uneSousMatiere : splitSousMatiere)
        {
            if (!uneSousMatiere.isEmpty())
            {
                leSousMatieres.add(uneSousMatiere);
            }
        }
        return leSousMatieres;
    }
    @FXML
    public void cboModifierMatiereCompetenceClicked(Event event) {
    }

    @FXML
    public void cboModifierSousMatiereCompetenceClicked(Event event) {
    }
}
