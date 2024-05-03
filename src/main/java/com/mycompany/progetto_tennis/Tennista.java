/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import java.time.LocalDate;

/**
 *
 * @author Studente
 */
public class Tennista {
    private static int nextId=1;
    private int idTennista;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int punti;
    private int titoliVinti;

    public Tennista(String nome, String cognome, LocalDate dataDiNascita, int punti, int titoliVinti) {
        this.idTennista=nextId;
        nextId++;
        setNome(nome);
        setCognome(cognome);
        setDataNascita(dataNascita);
        setPunti(punti);
        setTitoliVinti(titoliVinti);
    }
    
    public Tennista(Tennista t) {
        setIDTennista(t.getIdTennista());
        setNome(t.getNome());
        setCognome(t.getCognome());
        setDataNascita(t.getDataNascita());
        setPunti(t.getPunti());
        setTitoliVinti(t.getTitoliVinti());
    }

    
    public int getIdTennista()
    {
        return idTennista;
    }
    
    public void setIDTennista(int id)
    {
        this.idTennista=id;
    }
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() 
    {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) 
    {
        this.dataNascita = dataNascita;
    }

    public int getPunti() 
    {
        return punti;
    }

    public void setPunti(int punti) 
    {
        this.punti = punti;
    }

    public int getTitoliVinti() 
    {
        return titoliVinti;
    }

    public void setTitoliVinti(int titoliVinti) 
    {
        this.titoliVinti = titoliVinti;
    }
    
    public String toString()
    {
        String s;
        s=getNome()+";"+getCognome()+";"+getDataNascita()+";"+getPunti()+";"+getTitoliVinti();
        return s;
    }
    
}
