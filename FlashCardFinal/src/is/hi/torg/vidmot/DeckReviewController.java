/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.torg.vidmot;

import is.hi.torg.vinnsla.Deck;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Sigríður Ösp sos42@hi.is
 */
public class DeckReviewController implements Initializable {

    @FXML
    private Label virktSpil;
    @FXML
    private Button nextButton;
    @FXML
    private AnchorPane nDialog;
    @FXML
    private Label deckName;

    private int virkurIndex = 0;
    private MultipleSelectionModel msl;
    private Deck deck;
    
    private boolean kanji = true;
    private boolean reading = false;
    private boolean trans = false;
    @FXML
    private Button backButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Birtir review dialog gluggann
     * @param r 
     */
    public void deckLidurBirta(Deck r) {
        // Innihald dialogs búið til 
        DialogPane p = new DialogPane();
        nDialog.setVisible(true);

        deck = r;
        setjaGogn();

        p.setContent(nDialog);

        Dialog<ButtonType> d = new Dialog();

        d.setDialogPane(p);
        d.setTitle("Study");

        ButtonType haetta = new ButtonType("Finish Review",
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(haetta);

        d.showAndWait();
    }
    
    /**
     * Skyptir á milli mismunandi hliðir á spilinu þegar smellt er á það
     * @param event 
     */
    @FXML
    private void spilFlip(MouseEvent event) {
        if (kanji == true) {
            virktSpil.setText(deck.getCards().get(virkurIndex).getReading());
            kanji = false;
            reading = true;
        }
        else if (reading == true) {
            virktSpil.setText(deck.getCards().get(virkurIndex).getTrans());
            reading = false;
            trans = true;
        }
        else if (trans == true) {
            virktSpil.setText(deck.getCards().get(virkurIndex).getKanji());
            trans = false;
            kanji = true;
        }
    }
    
    /**
     * Sýnir næsta spil
     * @param event 
     */
    @FXML
    private void nextButtonHandler(ActionEvent event) {
        virkurIndex = (virkurIndex + 1) % deck.getCards().size();
        setjaGogn();
    }

    /**
     * Setja gögn í samtalsgluggann. Nafn stokksins og virkt spil
     * @param r dagskrá sem á að birta
     */
    public void setjaGogn() {
        deckName.setText(deck.getTitle());
        virktSpil.setText(deck.getCards().get(virkurIndex).getKanji());
    }

    @FXML
    private void backButtonHandler(ActionEvent event) {
        if (virkurIndex > 0){
            virkurIndex = (virkurIndex -1) % deck.getCards().size();
        }
        else {
            virkurIndex = deck.getCards().size();
            virkurIndex = (virkurIndex -1) % deck.getCards().size();
        }
            
        setjaGogn();
    }
    
    
}
