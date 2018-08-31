/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.torg.vidmot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Sigríður Ösp sos42@hi.is
 */
public class MenuListController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
    /***
     * Lokar forritinu
     * @param event 
     */
    @FXML
    private void closeHandler(ActionEvent event) {
        Platform.exit();
    }
    
    /***
     * Opnar Alert dialog með upplýsingum um forritið
     * @param event 
     */
    @FXML
    private void aboutHandler(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About this program");
        alert.setContentText("This flash card program is designed for people who need more than just two sides to a card such as students of Asian languages learning new writing styles.\n" +
"\n" +
"Once a deck is chosen a new window will open on the first card of the deck. The sides of the card can be flipped through by pressing the card itself. To review the next card the 'Next' button is pressed. When you'd like to finish your review press the 'End Review' button.");

        alert.showAndWait();
    }

    @FXML
    private void newDeckHandler(ActionEvent event) {
    }

    
}
