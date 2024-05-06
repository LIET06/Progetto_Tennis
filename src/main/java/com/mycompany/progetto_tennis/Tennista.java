/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Rappresenta un Tennista
 * @author LL
 */
public class Tennista implements Serializable{
    private static int nextID=1;
    private int idTennista;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int punti;
    private int titoliVinti;

    /**
     * Costruttore
     * @param nome nome del tennista
     * @param cognome cognome del tennista
     * @param dataNascita data di nascita del tennista
     * @param punti punti guadagnati con i tornei
     * @param titoliVinti numero dei titoli(tornei) vinti
     */
    public Tennista(String nome, String cognome, LocalDate dataNascita, int punti, int titoliVinti) {
        this.idTennista=nextID;
        nextID++;
        setNome(nome);
        setCognome(cognome);
        setDataNascita(dataNascita);
        setPunti(punti);
        setTitoliVinti(titoliVinti);
    }
    
    /**
     * Costruttore di copia
     * @param t tennista da copiare
     */
    public Tennista(Tennista t) {
        setIDTennista(t.getIdTennista());
        setNome(t.getNome());
        setCognome(t.getCognome());
        setDataNascita(t.getDataNascita());
        setPunti(t.getPunti());
        setTitoliVinti(t.getTitoliVinti());
    }
    
    /**
     * Restituisce il numero identificativo di un tennista
     * @return idTennista
     */
    public int getIdTennista()
    {
        return idTennista;
    }
    
    /**
     * Imposta il numero identificativo ad un tennista
     * @param id 
     */
    public void setIDTennista(int id)
    {
        this.idTennista=id;
    }
    
    /**
     * Restitusce il nome di un tennista
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Assegna il nome ad un tennista
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * Restitusce il cognome di un tennista
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Assegna il cognome ad un tennista
     * @param cognome 
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    /**
     * Restitusce la data di nascita di un tennista
     * @return dataNascita
     */
    public LocalDate getDataNascita() 
    {
        return dataNascita;
    }

    /**
     * Assegna la data di nascita ad un tennista
     * @param dataNascita 
     */
    public void setDataNascita(LocalDate dataNascita) 
    {
        this.dataNascita = dataNascita;
    }

    /**
     * Restitusce i punti di un tennista
     * @return punti
     */
    public int getPunti() 
    {
        return punti;
    }

    /**
     * Assegna i punti ad un tennista
     * @param punti 
     */
    public void setPunti(int punti) 
    {
        this.punti = punti;
    }

    /**
     * Restitusce i titoli vinti da un tennista
     * @return titoliVinti
     */
    public int getTitoliVinti() 
    {
        return titoliVinti;
    }

    /**
     * Assegna i titoli vinti ad un tennista
     * @param titoliVinti 
     */
    public void setTitoliVinti(int titoliVinti) 
    {
        this.titoliVinti = titoliVinti;
    }
    
    /**
     * Restituisce una stringa che contiene i dati di un tennista
     * @return s
     */
    public String toString()
    {
        String s;
        s=getNome()+";"+getCognome()+";"+getDataNascita()+"; Punti: "+getPunti()+"; Titoli: "+getTitoliVinti();
        return s;
    }
    
    /**
     * Permette di confrontare correttamente i dati di diversi tennisti
     * @param t 
     * @return true o false
     */
    public boolean equals(Object t)
    {
        Tennista ten;
        ten=(Tennista)t;
        if(ten.getNome()==getNome()&&ten.getCognome()==getCognome()&&ten.getDataNascita()
                ==getDataNascita()&&ten.getPunti()==getPunti()&&ten.getTitoliVinti()==getTitoliVinti())
            return true;
        else
            return false;
        
    }
}
