//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.17 a las 12:19:07 PM CDT 
//


package com.cine.salaService.dto;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cine.salaService.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cine.salaService.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Asiento }
     * 
     */
    public Asiento createAsiento() {
        return new Asiento();
    }

    /**
     * Create an instance of {@link Sala }
     * 
     */
    public Sala createSala() {
        return new Sala();
    }

    /**
     * Create an instance of {@link Pelicula }
     * 
     */
    public Pelicula createPelicula() {
        return new Pelicula();
    }

    /**
     * Create an instance of {@link Funcion }
     * 
     */
    public Funcion createFuncion() {
        return new Funcion();
    }

    /**
     * Create an instance of {@link Ack }
     * 
     */
    public Ack createAck() {
        return new Ack();
    }

}
