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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.*;
import static utility.Ordinatore.scambia;
/**
 *
 * @author Studente
 */
public class Classifica {
    private final static int NUM_MAX_TENNISTI=1000;
    private Tennista[] classificaAtp;
    private int nTennistiPresenti=0;
    
    public Classifica()
    {
        classificaAtp=new Tennista[NUM_MAX_TENNISTI];
    }
    
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
                //non fare nulla
            } 
            catch (EccezioneClassificaPiena ex) 
            {
                //non succederà mai
            }
        }
    }
    
    public void setTennista(Tennista t) throws EccezioneClassificaPiena
    {
        if(nTennistiPresenti>=NUM_MAX_TENNISTI)
            throw new EccezioneClassificaPiena();
        
        classificaAtp[nTennistiPresenti]=new Tennista(t);
        classificaAtp=Ordinatore.selectionSortDecrescente(classificaAtp);
        ordinatoreId();
        nTennistiPresenti++;
    }
    
    public Tennista getTennista(int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>nTennistiPresenti-1)
            throw new EccezioneIdNonValido();
        return classificaAtp[id];
        
    }
    
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
    
    public int getNumMaxTennisti()
    {
        return NUM_MAX_TENNISTI;
    }
    
    public int getNTennistiPresenti()
    {
        return nTennistiPresenti;
    }
    
    public void ordinatoreId()
    {
        for(int i=0;i<nTennistiPresenti-1;i++)
        {
                classificaAtp[i].setIDTennista(i);
        }
    }
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
                    nome=datiVolume[1];
                    cognome=datiVolume[2];
                    data=datiVolume[3];
                    dataNascita=LocalDate.parse(data);
                    punti=Integer.parseInt(datiVolume[4]);
                    titoli=Integer.parseInt(datiVolume[5]);
                    t=new Tennista(nome, cognome, dataNascita, punti, titoli);
                    this.setTennista(t);
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
    
    public void serializzazione(String nomeFileBinario) throws FileNotFoundException, IOException
    {
        
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFileBinario));
            writer.writeObject(this);
            writer.flush();
            writer.close();
    }
    
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
    
}
