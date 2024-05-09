/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_tennis;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luca
 */
public class TennistaTest {
    
    public TennistaTest() {
    }

    /**
     * Test of Tennista method, of class Tennista.
     */
    @Test
    public void testCostruttorePuntiNegativi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), -1, 2);
        assertEquals(0, t.getPunti());
    }
    
    /**
     * Test of Tennista method, of class Tennista.
     */
    @Test
    public void testCostruttoreTitoliNegativi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,-1);
        assertEquals(0, t.getTitoliVinti());
    }
    
    /**
     * Test of Tennista method, of class Tennista.
     */
    @Test
    public void testCostruttoreCopia() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        Tennista t1=new Tennista(t);
        assertEquals(t, t1);
    }
    
    /**
     * Test of Tennista method, of class Tennista.
     */
    @Test
    public void testCostruttoreCopiaIndipensenza() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        Tennista t1=new Tennista(t);
        t.setPunti(1);
        t.setTitoliVinti(100);
        assertEquals(200,t1.getPunti());
        assertEquals(2,t1.getTitoliVinti());
    }

    /**
     * Test of setIDTennista and getIdTennista method, of class Tennista.
     */
    @Test
    public void testSetIDTennista() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setIDTennista(7);
        assertEquals(7, t.getIdTennista());
    }

    /**
     * Test of getNome method, of class Tennista.
     */
    @Test
    public void testGetNome() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals("Luca", t.getNome());
    }

    /**
     * Test of setNome method, of class Tennista.
     */
    @Test
    public void testSetNome() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setNome("Omar");
        assertEquals("Omar", t.getNome());
    }

    /**
     * Test of getCognome method, of class Tennista.
     */
    @Test
    public void testGetCognome() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals("Lieto", t.getCognome());
    }

    /**
     * Test of setCognome method, of class Tennista.
     */
    @Test
    public void testSetCognome() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setCognome("Sorteni");
        assertEquals("Sorteni", t.getCognome());
    }

    /**
     * Test of getDataNascita method, of class Tennista.
     */
    @Test
    public void testGetDataNascita() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals(LocalDate.of(2006, 12, 13), t.getDataNascita());
    }

    /**
     * Test of setDataNascita method, of class Tennista.
     */
    @Test
    public void testSetDataNascita() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setDataNascita(LocalDate.of(2006, 1, 11));
        assertEquals(LocalDate.of(2006, 1, 11), t.getDataNascita());
    }

    /**
     * Test of getPunti method, of class Tennista.
     */
    @Test
    public void testGetPunti() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals(200,t.getPunti());
    }

    /**
     * Test of setPunti method, of class Tennista.
     */
    @Test
    public void testSetPuntiPositivi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setPunti(1000);
        assertEquals(1000,t.getPunti());
    }

    /**
     * Test of setPunti method, of class Tennista.
     */
    @Test
    public void testSetPuntiNegativi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setPunti(-1);
        assertEquals(0,t.getPunti());
    }
    
    /**
     * Test of getTitoliVinti method, of class Tennista.
     */
    @Test
    public void testGetTitoliVinti() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals(2,t.getTitoliVinti());
    }

    /**
     * Test of setTitoliVinti method, of class Tennista.
     */
    @Test
    public void testSetTitoliVintiPositivi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setTitoliVinti(50);
        assertEquals(50,t.getTitoliVinti());
    }
    
    /**
     * Test of setTitoliVinti method, of class Tennista.
     */
    @Test
    public void testSetTitoliVintiNegativi() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        t.setTitoliVinti(-1);
        assertEquals(0,t.getTitoliVinti());
    }

    /**
     * Test of toString method, of class Tennista.
     */
    @Test
    public void testToString() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        String StringaAttesa="Luca;Lieto;2006-12-13; Punti: 200; Titoli: 2";
        assertEquals(StringaAttesa,t.toString());
    }

    /**
     * Test of equals method, of class Tennista.
     */
    @Test
    public void testEquals() {
        Tennista t=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        Tennista t1=new Tennista("Luca", "Lieto", LocalDate.of(2006, 12, 13), 200,2);
        assertEquals(t,t1);
    }
    
}
