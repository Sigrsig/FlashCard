/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.torg.vidmot;

import is.hi.torg.vinnsla.DeckKatalogur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import is.hi.torg.vinnsla.Deck;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


/**
 *
 * @author Sigríður Ösp sos42@hi.is
 * Controller class fyrir DeckOpen.fxml
 */
public class DeckOpenController implements Initializable {

    private DeckKatalogur minnDeck;
    private MultipleSelectionModel msl;

    private int virkurIndex = -1;
    @FXML
    private Button veljaButton;
    @FXML
    private ListView<Deck> deckList;
    @FXML
    private AnchorPane veljaDeck;
    @FXML
    private Button EydaButton;

    /**
     * Birtir gögn
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Setja inn listann af decks
        minnDeck = new DeckKatalogur();
        // Búum til hlut til að við getum náð í gögnin
        deckList.setItems(heildarListi());
        frumstillaGognHandlerListi();
        //leitaDagskraController.frumstillaGognHandlerTimaAfmorkun(this);

    }

    /**
     * *
     * Frumstillir gögn og atburðahandler fyrir lista af stokkum
     */
    private void frumstillaGognHandlerListi() {
        msl = deckList.getSelectionModel();
        msl.selectedItemProperty().addListener(new ChangeListener<Deck>() {
            @Override
            public void changed(ObservableValue<? extends Deck> observable, Deck oldValue, Deck newValue) {
                virkurIndex = msl.getSelectedIndex();
            }
        });
    }

    /**
     * Nær í stokka úr katalognum
     *
     * @return
     */
    ObservableList<Deck> heildarListi() {
        ObservableList<Deck> obl = FXCollections.observableArrayList(minnDeck.getDeckLidir());
        return obl;
    }

    /**
     * Velur virka indexinn og opnar viðeigandi stokk í nýjum dialog glugga
     * @param event
     * @throws Exception 
     */
    @FXML
    private void veljaButtonHandler(ActionEvent event) throws Exception {
        // Opnar rétt xml skjal
        if (virkurIndex != -1) {

            DeckReviewController deckReviewController = new DeckReviewController();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeckReview.fxml"));
            fxmlLoader.setController(deckReviewController);
            Parent root1 = (Parent) fxmlLoader.load();

            deckReviewController.deckLidurBirta(deckList.getItems().get(virkurIndex));

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    /**
     * Opnar Alert og eyðir virkum index ef samþykkt
     * @param event 
     */
    @FXML
    private void EydaButtonHandler(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Deck?");
        alert.setHeaderText("Are you sure you wish to delete this deck?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if (virkurIndex != -1) {
                ObservableList<Deck> o = deckList.getItems();
                // Hér er ekki nóg að eyða úr ListView þar 
                // sem hann gæti haft afmarkaðan lista 
                Deck r = o.get(virkurIndex);
                o.remove(virkurIndex);

                // Finna hlutinn í sjónvarpsdagskránni óafmarkaðri 
                int indexDeck = minnDeck.getDeckLidir().indexOf(r);
                // og eyða í sjónvarpsdagskrá ef það er ekki 
                // þegar búið að eyða honum 
                if (indexDeck != -1) {
                    minnDeck.eydaDeck(indexDeck);
                }             
            }
        }
    }
}
