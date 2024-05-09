/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_tennis;

import java.io.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Studente
 */
public class ClassificaTest {
    
    public ClassificaTest() {
        
    }
    
    /**
     * Test of Classifica method, of class Classifica.
     */
    @Test
    public void TestCostruttore() {
        Classifica c1=new Classifica();
        assertEquals(0,c1.getNTennistiPresenti());
    }
    
    /**
     * Test of Classifica method, of class Classifica.
     */
    @Test
    public void TestCostruttoreCopiaUguale() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c1.setTennista(t1);
        Classifica c2=new Classifica(c1);
        assertEquals(c1,c2);
    }
    
    /**
     * Test of Classifica method, of class Classifica.
     */
    @Test
    public void TestCostruttoreCopiaDiversa() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c1.setTennista(t1);
        Classifica c2=new Classifica(c1);
        c2.eliminaTennista(0);
        assertEquals(false,c1.equals(c2));
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
    public void testSetTennistaClassificaPiena() throws Exception
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
    public void testOrdinatoreId() throws Exception{
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c1.setTennista(t1);
        assertEquals(t, c1.getTennista(1));
        assertEquals(t1, c1.getTennista(0));
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
     * Test of aggiungiPuntiTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiPuntiTennistaPosizioneNegativa() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiPuntiTennista(300, -1));
    }
    
    /**
     * Test of aggiungiPuntiTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiPuntiTennistaPosizioneMaggioreNMaxTennisti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        for(int i=0;i<c1.getNumMaxTennisti();i++)
        {
            c1.setTennista(t);
        }
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiPuntiTennista(300, 1100));
    }
    
    /**
     * Test of aggiungiPuntiTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiPuntiTennistaPosizioneMaggioreTPresenti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiPuntiTennista(300, 5));
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
     * Test of aggiungiTitoliTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiTitoliTennistaPosizioneNegativa() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiTitoliTennista(3, -1));

    }
    
    /**
     * Test of aggiungiTitoliTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiTitoliTennistaPosizioneMaggioreNMaxTennisti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        for(int i=0;i<c1.getNumMaxTennisti();i++)
        {
            c1.setTennista(t);
        }
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiTitoliTennista(3, 1100));

    }
    
    /**
     * Test of aggiungiTitoliTennista method, of class Classifica.
     */
    @Test
    public void testAggiungiTitoliTennistaPosizioneMaggioreTPresenti() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        eccezioni.EccezioneIdNonValido eccezione = assertThrows(eccezioni.EccezioneIdNonValido.class, () ->
        c1.aggiungiTitoliTennista(3, 5));

    }

    /**
     * Test of esportaCSV and importaCSV method, of class Classifica.
     */
    /*@Test
    public void testEsportaImportaCSVConEquals() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c1.setTennista(t1);
        Classifica c2=new Classifica(c1);
        c2.eliminaTennista(0);
        c1.esportaCSV("tennisti.csv");
        c2=new Classifica();
        c2.importaCSV("tennisti.csv");
        assertEquals(c1, c2);
    }
    
    /**
     * Test of esportaCSV method, of class Classifica.
     */
    @Test
    public void testEsportaCSV() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        IOException eccezione = assertThrows(IOException.class, () ->
        c1.esportaCSV("z:\\tennisti.csv"));
        
    }

    /**
     * Test of importaCSV method, of class Classifica.
     */
    @Test
    public void testImportaCSV() throws Exception {
        Classifica c1=new Classifica();
        IOException eccezione = assertThrows(IOException.class, () ->
        c1.importaCSV("FileCheNonEsiste.csv"));
    }
    
    /**
     * Test of importaCSV method, of class Classifica.
     */
    @Test
    public void testImportaCSVVuoto() throws Exception {
        Classifica c1=new Classifica();
        c1.importaCSV("FileVuoto.csv");
        assertEquals(0, c1.getNTennistiPresenti());
    }
    
    /**
     * Test of importaCSV method, of class Classifica.
     */
    @Test
    public void testImportaCSVNonCorretto() throws Exception {
        Classifica c1=new Classifica();
        NumberFormatException eccezione = assertThrows(NumberFormatException.class, () ->
        c1.importaCSV("FileNonCorretto.csv"));
    }

    /**
     * Test of serializzazione and deserializzazione method, of class Classifica.
     */
    @Test
    public void testSerializzazioneDeserializzazione() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.serializzazione("classifica.bin");
        Classifica c2=new Classifica();
        c2.deserializzazione("classifica.bin");
        assertEquals(c1, c2);
    }
    
    /**
     * Test of serializzazione method, of class Classifica.
     */
    @Test
    public void testSerializzazioneFileInsesistente() throws Exception {
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        IOException eccezione = assertThrows(IOException.class, () ->
        c1.serializzazione("Z:\\classifica.bin"));
    }

    /**
     * Test of deserializzazione method, of class Classifica.
     */
    @Test
    public void testDeserializzazioneFileInsesistente() throws Exception {
        Classifica c1=new Classifica();
        FileNotFoundException eccezione = assertThrows(FileNotFoundException.class, () ->
        c1.deserializzazione("Z:\\classifica.bin"));
    }
    
    /**
     * Test of deserializzazione method, of class Classifica.
     */
    @Test
    public void testDeserializzazioneFileVuoto() throws Exception {
        Classifica c1=new Classifica();
        c1.serializzazione("classifica.bin");
        Classifica c2=new Classifica();
        c2.deserializzazione("classifica.bin");
        assertEquals(0, c1.getNTennistiPresenti());
    }
    
    /**
     * Test of deserializzazione method, of class Classifica.
     */
    @Test
    public void testDeserializzazioneFileNonCorretto() throws Exception {
        Classifica c1=new Classifica();
        IOException eccezione = assertThrows(IOException.class, () ->
        c1.deserializzazione("ClassificaCorrotta.bin"));
    }

    /**
     * Test of toString method, of class Classifica.
     */
    @Test
    public void testToString() throws Exception{
        Classifica c1=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        c1.setTennista(t);
        String StringaAttesa="1-->\tLuca;Lieto;2006-12-13; Punti: 200; Titoli: 2\n";
        assertEquals(StringaAttesa, c1.toString());
    }
    
    /**
     * Test of Equals method, of class Classifica.
     */
    @Test
    public void testEqualsTrue() throws Exception{
        Classifica c1=new Classifica();
        Classifica c2=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c1.setTennista(t1);
        c2.setTennista(t1);
        c2.setTennista(t);
        assertEquals(c1, c2);
    }
    
    /**
     * Test of Equals method, of class Classifica.
     */
    @Test
    public void testEqualsFalse() throws Exception{
        Classifica c1=new Classifica();
        Classifica c2=new Classifica();
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200, 2);
        Tennista t1=new Tennista("Omar", "Sorteni", LocalDate.of(2006, 12, 10), 900, 2);
        c1.setTennista(t);
        c2.setTennista(t1);
        assertEquals(false, c2.equals(c1));
    }
    
}
