/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_tennis;

import eccezioni.EccezioneClassificaPiena;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Studente
 */
public class ClassificaTest {
    
    public ClassificaTest() {
        Classifica c1=new Classifica();
        assertEquals(0,c1.getNTennistiPresenti());
    }

    /**
     * Test of setTennista method, of class Classifica.
     */
    @Test
    public void testSetTennista() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        Tennista t1=c1.getTennista(0);
        assertEquals(t, t1);
    }

    /**
     * Test of setTennista method, of class Classifica.
     */
    @Test
    public void testExceptionClassificaPiena() throws Exception
    {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        for(int i=0;i<c1.getNumMaxTennisti();i++)
        {
            c1.setTennista(t);
        }
        eccezioni.EccezioneClassificaPiena eccezione = assertThrows(eccezioni.EccezioneClassificaPiena.class, () ->
        c1.setTennista(t));
    }
    
    /**
     * Test of getTennista method, of class Classifica.
     */
    @Test
    public void testGetTennistaPosizioneNegativa() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.getTennista(-1));
    }
    
    /**
     * Test of getTennista method, of class Classifica.
     */
    @Test
    public void testGetTennistaPosizioneMaggrioreNMaxTennisti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        for(int i=0;i<c1.getNumMaxTennisti();i++)
        {
            c1.setTennista(t);
        }
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.getTennista(1100));
    }
    
    /**
     * Test of getTennista method, of class Classifica.
     */
    @Test
    public void testGetTennistaPosizioneMaggrioreTPresenti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.getTennista(500));
    }

    /**
     * Test of eliminaTennista method, of class Classifica.
     */
    @Test
    public void testEliminaTennista() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        c1.eliminaTennista(0);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.getTennista(0));
    }
    
    /**
     * Test of eliminaTennista method, of class Classifica.
     */
    @Test
    public void testEliminaTennistaPosizioneNegativa() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.eliminaTennista(-1));
    }
    
    /**
     * Test of eliminaTennista method, of class Classifica.
     */
    @Test
    public void testEliminaTennistaPosizioneMaggioreNMaxTennisti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        for(int i=0;i<c1.getNumMaxTennisti();i++)
        {
            c1.setTennista(t);
        }
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.eliminaTennista(1100));
    }
    
    /**
     * Test of eliminaTennista method, of class Classifica.
     */
    @Test
    public void testEliminaTennistaPosizioneMaggioreTPresenti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.eliminaTennista(5));
    }

    /**
     * Test of getNumMaxTennisti method, of class Classifica.
     */
    @Test
    public void testGetNumMaxTennisti() {
        Classifica c1=new Classifica();
        assertEquals(1000, c1.getNumMaxTennisti());
    }

    /**
     * Test of getNTennistiPresenti method, of class Classifica.
     */
    @Test
    public void testGetNTennistiPresenti() throws Exception{
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        c1.setTennista(t);
        assertEquals(2, c1.getNTennistiPresenti());
    }

    /**
     * Test of ordinatoreId method, of class Classifica.
     */
    @Test
    public void testOrdinatoreId() {
        
    }

    /**
     * Test of aggiungiPuntiTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiPuntiTennista() throws Exception {
        int puntiIniziali=200;
        int puntiAggiunti=300;
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), puntiIniziali, 2);
        c1.setTennista(t);
        c1.aggiungiPuntiTennista(puntiAggiunti, 0);
        Tennista t1=c1.getTennista(0);
        assertEquals((puntiIniziali+puntiAggiunti), t1.getPunti());
    }

    /**
     * Test of aggiungiTitoliTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiTitoliTennista() throws Exception {
        int titoliIniziali=2;
        int titoliAggiunti=3;
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, titoliIniziali);
        c1.setTennista(t);
        c1.aggiungiTitoliTennista(titoliAggiunti, 0);
        Tennista t1=c1.getTennista(0);
        assertEquals((titoliIniziali+titoliAggiunti), t1.getTitoliVinti());
    }

    /**
     * Test of esportaCSV method, of class Classifica.
     */
    @Test
    public void testEsportaCSV() throws Exception {
    }

    /**
     * Test of importaCSV method, of class Classifica.
     */
    @Test
    public void testImportaCSV() throws Exception {
    }

    /**
     * Test of serializzazione method, of class Classifica.
     */
    @Test
    public void testSerializzazione() throws Exception {
    }

    /**
     * Test of deserializzazione method, of class Classifica.
     */
    @Test
    public void testDeserializzazione() throws Exception {
    }

    /**
     * Test of toString method, of class Classifica.
     */
    @Test
    public void testToString() {
    }
    
}
