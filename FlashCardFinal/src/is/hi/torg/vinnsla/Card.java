/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.torg.vinnsla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Sigríður Ösp sos42@hi.is
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kanji",
    "reading",
    "trans",})

/**
 * Getters og setters fyrir spilin
 */
public class Card {

    @XmlElement(required = true)
    protected String kanji;
    @XmlElement(required = true)
    protected String reading;
    @XmlElement(required = true)
    protected String trans;

    public String getKanji() {
        return this.kanji;
    }

    public void setKanji(String value) {
        this.kanji = value;
    }

    public String getReading() {
        return this.reading;
    }

    public void setReading(String value) {
        this.reading = value;
    }

    public String getTrans() {
        return this.trans;
    }

    public void setTrans(String value) {
        this.trans = value;
    }
}
