



/*
 * Ebba Þóra Hvannberg, Háskóli Íslands
 */
package is.hi.torg.vinnsla;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Klasi sem les inn stokkana úr XML skrá og getur birt hana á console 
 * @author Sigríður Ösp sos42@hi.is 
 */
public class DeckKatalogur {
    private Root deck;                     // dagskráin
    private ArrayList<Deck> deckLidir;  // listi af dagskrárliðum - haft hér til 
                                      // þæginda

    // Fastar
     private static final String DECKSXML = "Decks.xml";
     private static final String VILLA_Í_LESTRI_Á_XML_SKRÁ = "Villa í lestri á XML skrá";
     private static final String SKRÁ_MEÐ_XML_GÖGNUM_FANNST_EKKI = "Skrá með XML gögnum fannst ekki";
  
    /**
     * Getters og setters fyrir tilviksbreytur 
     * @return 
     */
    public Root getDecks() {
        return deck;
    }

    public void setDecks(Root deck) {
        this.deck = deck;
    }

    public List<Deck> getDeckLidir() {
        return deckLidir;
    }

    public void setDeckLidir(ArrayList<Deck> deckLidir) {
        this.deckLidir = deckLidir;
    }
    
    /**
     * Smiður sem les inn XML skrána 
     * Birtir villu ef XML skrá fannst ekki 
     */
    public DeckKatalogur() {
        InputStream inputStream = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            inputStream = DeckKatalogur.class.getResourceAsStream(DECKSXML);

            deck = (Root) jaxbUnmarshaller.unmarshal(inputStream);
            deckLidir = (ArrayList<Deck>) deck.getDecks();
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println(VILLA_Í_LESTRI_Á_XML_SKRÁ);
        }

    }
   
    
    /***
     * Eyða deck nr. index
     * @param index vísir í deck liði
     */
    public void eydaDeck(int index) {
        deckLidir.remove(index);
    } 
    
}
