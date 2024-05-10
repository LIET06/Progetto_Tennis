/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import eccezioni.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.*;
import static utility.Ordinatore.scambia;
/**
 * Rappresenta una classifica composta da tennisti di classe Tennista
 * @author LL
 */
public class Classifica implements Serializable{
    private final static int NUM_MAX_TENNISTI=1000;
    private Tennista[] classificaAtp;
    private int nTennistiPresenti=0;
    
    /**
     * Costruttore della classifica
     */
    public Classifica()
    {
        classificaAtp=new Tennista[NUM_MAX_TENNISTI];
    }
    
    /**
     * Costruttore di copia
     * @param c classifica da copiare
     */
    public Classifica(Classifica c)
    {
        classificaAtp=new Tennista[NUM_MAX_TENNISTI];
        Tennista t;
        for(int i=0;i<NUM_MAX_TENNISTI;i++)
        {
            try 
            {
                t=c.getTennista(i);
                setTennista(t);
            } 
            catch (EccezioneIdNonValido ex) 
            {
                classificaAtp[i]=null;
            } 
            catch (EccezioneClassificaPiena ex) 
            {
                //non succederà mai ma in caso
                break;
            }
        }
    }
    
    /**
     * Inserisce il tennista all'interno della classifica 
     * posizionandolo in base ai punti
     * @param t tennista da aggiungere
     * @throws EccezioneClassificaPiena se la classifica ha raggiunto il numero massimo di tennisti che può contenere
     */
    public void setTennista(Tennista t) throws EccezioneClassificaPiena
    {
        if(nTennistiPresenti>=NUM_MAX_TENNISTI)
            throw new EccezioneClassificaPiena();
        
        classificaAtp[nTennistiPresenti]=new Tennista(t);
        classificaAtp=Ordinatore.selectionSortDecrescente(classificaAtp);
        ordinatoreId();
        nTennistiPresenti++;
    }
    
    /**
     * Restituisce il tennista in posizione "id"
     * @param id posizione del tennista
     * @return il tennista
     * @throws EccezioneIdNonValido se la posizione passata 
     *         dall'utente non corrisponde a nessun tennista, ovvero se 
     *         è minore di 0 o maggiore del numero di tennisti presenti
     */
    public Tennista getTennista(int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>nTennistiPresenti-1)
            throw new EccezioneIdNonValido();
        return classificaAtp[id];
        
    }
    
    /**
     * Rimuove il tennista in posizione "id"
     * @param id posizione del tennista
     * @throws EccezioneIdNonValido se la posizione passata 
     *         dall'utente non corrisponde a nessun tennista, ovvero se 
     *         è minore di 0 o maggiore del numero di tennisti presenti
     */
    public void eliminaTennista(int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>nTennistiPresenti-1)
            throw new EccezioneIdNonValido();
        
        for(int i=id;i<nTennistiPresenti;i++)
        {
            classificaAtp[i]=classificaAtp[i+1];
        }
        nTennistiPresenti--;
        ordinatoreId();
    }
    
    /**
     * Restituisce il numero massimo di tennisti inseribili nella classifica
     * @return NUM_MAX_TENNISTI
     */
    public int getNumMaxTennisti()
    {
        return NUM_MAX_TENNISTI;
    }
    
    /**
     * Restituisce il numero di tennisti presenti nella classifica
     * @return nTennistiPresenti
     */
    public int getNTennistiPresenti()
    {
        return nTennistiPresenti;
    }
    
    /**
     * Assegna gli ID in ordine in base alla classifica:
     *              posizione 1--> ID=1
     *              posizione 2--> ID=2
     *              posizione 3--> ID=3
     *              ...
     */
    public void ordinatoreId()
    {
        for(int i=0;i<nTennistiPresenti-1;i++)
        {
                classificaAtp[i].setIDTennista(i);
        }
    }
    
    /**
     * Aggiungi dei punti ad un tennista
     * @param punti punti da aggiungere
     * @param id posizione del tennista
     * @throws eccezioni.EccezioneIdNonValido se la posizione passata 
     *         dall'utente non corrisponde a nessun tennista, ovvero se 
     *         è minore di 0 o maggiore del numero di tennisti presenti
     */
    public void aggiungiPuntiTennista(int punti, int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>nTennistiPresenti-1)
            throw new EccezioneIdNonValido();
        classificaAtp[id].setPunti((classificaAtp[id].getPunti()+punti));
    }
    
    /**
     * Aggiungi dei titoli vinti ad un tennista
     * @param titoli numero titoli da aggiungere
     * @param id posizione del tennista
     * @throws eccezioni.EccezioneIdNonValido se la posizione passata 
     *         dall'utente non corrisponde a nessun tennista, ovvero se 
     *         è minore di 0 o maggiore del numero di tennisti presenti
     */
    public void aggiungiTitoliTennista(int titoli, int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>nTennistiPresenti-1)
            throw new EccezioneIdNonValido();
        classificaAtp[id].setTitoliVinti((classificaAtp[id].getTitoliVinti()+titoli));
    }
    
    /**
     * Esporta i tennisti presenti nella classifica in un file di testo in formato CSV.
     * Per ogni tennista vengono esportate le seguenti informazioni:
     * id;nome;cognome;dataNascita;punti;titoliVinti.
     * Prima di esportare i tennisti, cancello dal file CSV tutti i dati presenti
     * @param nomeFileCSV
     * @throws IOException Se non è possibile accedere al file
     */
    public void esportaCSV(String nomeFileCSV) throws IOException
    {
        TextFile f1;
        Tennista t;
        f1= new TextFile(nomeFileCSV,'W'); //Apro il file in scrittura
        String datiVolume;

        for(int i=0;i<NUM_MAX_TENNISTI;i++)
        {
            try 
            {
                t=this.getTennista(i);
                datiVolume=i+";"+t.getNome()+";"+t.getCognome()+";"+t.getDataNascita()+";"+t.getPunti()+";"+t.getTitoliVinti();
                f1.toFile(datiVolume);
            } 
            catch (FileException ex) 
            {
                //non succederà mai
            } 
            catch (EccezioneIdNonValido ex) 
            {
                //non fare nulla
            }
        }

        f1.closeFile();  //Tutti i volumi sono statoi scritti
        System.out.println("Esportazione avvenuta correttamente.");
    } 
    
    /**
     * Legge i tennisti presenti in un file di testo CSV e li aggiunge alla classifica.
     * @param nomeFileCSV
     * @throws IOException Se non è possibile accedere al file
     */
    public void importaCSV(String nomeFileCSV) throws IOException
    {
        String nome, cognome, data;
        int punti, titoli;
        LocalDate dataNascita;
        String rigaLetta;
        String[] datiVolume;
        TextFile f1; 
        Tennista t;
            //Importa da file CSV
            f1=new TextFile(nomeFileCSV,'R');
            do
            {
                try
                {
                    rigaLetta=f1.fromFile();
                    datiVolume=rigaLetta.split(";");
                    if(datiVolume.length>1)
                    {
                        nome=datiVolume[1];
                        cognome=datiVolume[2];
                        data=datiVolume[3];
                        dataNascita=LocalDate.parse(data);
                        punti=Integer.parseInt(datiVolume[4]);
                        titoli=Integer.parseInt(datiVolume[5]);
                        t=new Tennista(nome, cognome, dataNascita, punti, titoli);
                        this.setTennista(t);
                    }
                }
                catch (FileException ex) 
                {
                    //fine del file
                    f1.closeFile();
                    System.out.println("Fine operazione di caricamento");
                    break;
                } 
                catch (EccezioneClassificaPiena ex) 
                {
                    //non succederà mai
                }
            }while(true);                
    } 
    
    /**
     * Salva l'oggetto Classifica this (e tutti gli oggetti in esso contenuti) su un file binario
     * @param nomeFileBinario Nome del file
     * @throws FileNotFoundException Se il file non viene trovato in fase di chiusura
     * @throws IOException Se non è possibile accedere al file
     */
    public void serializzazione(String nomeFileBinario) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBinario));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    /**
     * Restituisce un oggetto Classifica (e tutti gli oggetti in esso contenuti)
     * precedentemente memorizzato in un file binario
     * @param nomeFileBinario Pathname del file binario
     * @return c1
     * @throws FileNotFoundException Se il file non viene trovato in fase di chiusura
     * @throws IOException      Se non è possibile accedere al file
     * @throws ClassNotFoundException Se la struttura dati memorizzata nel file non corrisponde allo scaffale
     */
    public Classifica deserializzazione(String nomeFileBinario) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Classifica c1;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
        c1=(Classifica)reader.readObject();
        reader.close();
        return c1;
    }
    
    @Override
    public String toString()
    {
        String s="";
        for(int i=0;i<classificaAtp.length;i++)
        {
            if (classificaAtp[i]==null)
                break;
            else
                s+=(i+1)+"-->\t"+classificaAtp[i].toString()+"\n";
        }
        
        return s;
    }
    
    /**
     * Permette di confrontare correttamente i tennisti di diverse classifiche
     * @param c
     * @return true o false
     */
    @Override
    public boolean equals(Object c)
    {
        Classifica c1;
        c1=(Classifica)c;
        c1.ordinatoreId();
        if(c1.getNTennistiPresenti()==nTennistiPresenti)
        {
            for(int i=0;i<nTennistiPresenti;i++)
            {
                try 
                {
                    if(!(c1.getTennista(i)).equals(getTennista(i)))
                    {
                        return false;
                    }
                } 
                catch (EccezioneIdNonValido ex) 
                {
                    //non succederà mai
                }
            }
            return true;
        }
        else
            return false;
    }
    
}
