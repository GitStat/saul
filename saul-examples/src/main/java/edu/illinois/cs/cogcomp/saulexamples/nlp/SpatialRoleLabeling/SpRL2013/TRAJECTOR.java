/** This software is released under the University of Illinois/Research and Academic Use License. See
  * the LICENSE file in the root folder for details. Copyright (c) 2016
  *
  * Developed by: The Cognitive Computations Group, University of Illinois at Urbana-Champaign
  * http://cogcomp.cs.illinois.edu/
  */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.30 at 10:59:22 AM CET 
//


package edu.illinois.cs.cogcomp.saulexamples.nlp.SpatialRoleLabeling.SpRL2013;

import edu.illinois.cs.cogcomp.saulexamples.nlp.SpatialRoleLabeling.SpRLAnnotation;

import java.math.BigInteger;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TRAJECTOR")
public class TRAJECTOR implements SpRLAnnotation {

    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "start", required = true)
    protected BigInteger start;
    @XmlAttribute(name = "end", required = true)
    protected BigInteger end;
    @XmlAttribute(name = "text", required = true)
    protected String text;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the start property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setStart(BigInteger value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setEnd(BigInteger value) {
        this.end = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }
}
