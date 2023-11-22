package sio.helplerebours;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.helplerebours.Entities.User;
import sio.helplerebours.Tools.ConnexionBDD;
import sio.helplerebours.Tools.ServiceUser;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.net.URL;

public class ConnexionEtudiantController implements Initializable {
    @javafx.fxml.FXML
    private AnchorPane apConnexionEtudiant;
    @javafx.fxml.FXML
    private TextField tfMdpEtudiant;
    @javafx.fxml.FXML
    private TextField tfIdentifiantEtudiant;
    @javafx.fxml.FXML
    private Button btnValiderConnexionEtudiant;

    ConnexionBDD uneCnx;
    ServiceUser unService = new ServiceUser();
    User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    unService = new ServiceUser();
        try {
            uneCnx = new ConnexionBDD();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @javafx.fxml.FXML
    public void btnValiderConnexionClicked(Event event) throws SQLException, IOException {

        if (tfIdentifiantEtudiant.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisi");
            alert.setHeaderText("");
            alert.setContentText("Il faut rentrer l'email dans l'identifiant");
            alert.showAndWait();
        }
        if (tfMdpEtudiant.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisi");
            alert.setHeaderText("");
            alert.setContentText("Il faut rentrer un mot de passe dans Password");
            alert.showAndWait();
        }
        unService = new ServiceUser();
        user = unService.GetConnectionUser(tfIdentifiantEtudiant.getText(),tfMdpEtudiant.getText());

        if(user == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisi");
            alert.setHeaderText("");
            alert.setContentText("Email ou MDP incorrect");
            alert.showAndWait();
        }

        else{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("helplerebours-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            HelpLeReboursController modificationContactController = fxmlLoader.getController();
            //modificationContactController.initDatas(((User)btnValiderConnexionEtudiant.get().getSelectedItem()));
            Stage stage = new Stage();
            stage.setTitle("Modification d'un contact");
            stage.setScene(scene);
            stage.show();
        }








    }


}
