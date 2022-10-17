//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.17 a las 03:48:10 PM CDT 
//


package com.cine.salaService.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Sala complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Sala"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSala"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cantFilas"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minExclusive value="0"/&gt;
 *               &lt;maxInclusive value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="cantColumnas"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minExclusive value="0"/&gt;
 *               &lt;maxInclusive value="10"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="estado"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Disponible"/&gt;
 *               &lt;enumeration value="Mantenimiento"/&gt;
 *               &lt;enumeration value="Reservada"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sala", propOrder = {
    "idSala",
    "cantFilas",
    "cantColumnas",
    "estado"
})
public class Sala {

    protected int idSala;
    protected int cantFilas;
    protected int cantColumnas;
    @XmlElement(required = true)
    protected String estado;

    /**
     * Obtiene el valor de la propiedad idSala.
     * 
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * Define el valor de la propiedad idSala.
     * 
     */
    public void setIdSala(int value) {
        this.idSala = value;
    }

    /**
     * Obtiene el valor de la propiedad cantFilas.
     * 
     */
    public int getCantFilas() {
        return cantFilas;
    }

    /**
     * Define el valor de la propiedad cantFilas.
     * 
     */
    public void setCantFilas(int value) {
        this.cantFilas = value;
    }

    /**
     * Obtiene el valor de la propiedad cantColumnas.
     * 
     */
    public int getCantColumnas() {
        return cantColumnas;
    }

    /**
     * Define el valor de la propiedad cantColumnas.
     * 
     */
    public void setCantColumnas(int value) {
        this.cantColumnas = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

}
