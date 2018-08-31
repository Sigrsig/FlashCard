/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.torg.vinnsla;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Sigríður Ösp sos42@hi.is
 * Stillir spila listann í Decks.xml
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "cards"
})

/**
 * Getters og setters fyrir title og decks
 */
public class Deck {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "card", required = true)
    protected List<Card> cards;

    /**
     * Gets the value of the title property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTitle(String value) {
        title = value;
    }

    public List<Card> getCards()
    {
        if (cards == null) {
            cards = new ArrayList<Card>();
        }
        return cards;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}