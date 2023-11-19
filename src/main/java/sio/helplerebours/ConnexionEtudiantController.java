package sio.helplerebours;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sio.helplerebours.Entities.User;
import sio.helplerebours.Tools.ConnexionBDD;
import sio.helplerebours.Tools.ServiceUser;

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
    ServiceUser unService;
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
    public void btnValiderConnexionClicked(Event event) {





    }


}
