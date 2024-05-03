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
                t=c.gettennista(i);
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
        if(Tennista.getNumerotennistiPresenti()>=NUM_MAX_TENNISTI)
            throw new EccezioneClassificaPiena();
        for(int i=0;i<classificaAtp.length;i++)
        {
            if(classificaAtp[i]==null)
                classificaAtp[i]=new Tennista(t);
        }
        classificaAtp=Ordinatore.selectionSortDecrescente(classificaAtp);
        ordinatoreId();
    }
    
    public Tennista gettennista(int id) throws EccezioneIdNonValido
    {
        if (id<0 ||id>Tennista.getNumerotennistiPresenti())
            throw new EccezioneIdNonValido();
        return classificaAtp[id];
        
    }
    
    public void eliminaTennista(int id)
    {
        for(int i=id;i<Tennista.getNumerotennistiPresenti();i++)
        {
            classificaAtp[i]=classificaAtp[i+1];
        }
        Tennista.diminuisciTennistiPresenti();
        ordinatoreId();
    }
    
    public void ordinatoreId()
    {
        for(int i=0;i<Tennista.getNumerotennistiPresenti();i++)
        {
                classificaAtp[i].setIDTennista(i);
        }
    }
    
    public int getNumMaxTennisti()
    {
        return NUM_MAX_TENNISTI;
    }
    
    public void esposrtaCSV(String nomeFileCSV) throws IOException
    {
        TextFile f1;
        Tennista t;
        f1= new TextFile(nomeFileCSV,'W'); //Apro il file in scrittura
        String datiVolume;

        for(int i=0;i<NUM_MAX_TENNISTI);i++)
        {
            try 
            {
                t=this.gettennista(i);
                datiVolume=i+";"+getNome()+";"+getCognome()+";"+getDataNascita()+";"+getPunti()+";"+getTitoliVinti();
                f1.toFile(datiVolume);
            } 
            catch (FileException ex) 
            {
                //non succederà mai
            }
        }

        f1.closeFile();  //Tutti i volumi sono statoi scritti
        System.out.println("Esportazione avvenuta correttamente.");
    } 
    
    public void importaCSV(String nomeFileCSV) throws IOException
    {
        String titolo,autore;
        int numeroPagine,ripiano, posizione;
        String rigaLetta;
        String[] datiVolume;
        TextFile f1; 
        Libro lib;
            //Importa da file CSV
            f1=new TextFile(nomeFileCSV,'R');
            do
            {
                try
                {
                    rigaLetta=f1.fromFile();
                    datiVolume=rigaLetta.split(";");
                    ripiano=Integer.parseInt(datiVolume[0]);
                    posizione=Integer.parseInt(datiVolume[1]);
                    titolo=datiVolume[2];
                    autore=datiVolume[3];
                    numeroPagine=Integer.parseInt(datiVolume[4]);
                    lib=new Libro(titolo,autore,numeroPagine);
                    try 
                    {
                        this.setLibro(lib, ripiano, posizione);
                    } 
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Errore: ripiano "+ripiano+ " non corretto per il volume "+titolo);
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                         System.out.println("Errore: posizione "+posizione+ " non corretta per il volume "+titolo);
                    }
                    catch (EccezionePosizioneOccupata ex) 
                    {
                         System.out.println("Nel ripiano  "+ripiano+ " e posizione "+posizione+" è già presente un volume. Il volume "+titolo+ " non sarà posizionato nello scaffale.");
                    }
                }
                catch (FileException ex) 
                {
                    //fine del file
                    f1.closeFile();
                    System.out.println("Fine operazione di caricamento");
                    break;
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
    
    public Scaffale deserializzazione(String nomeFileBinario) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Scaffale s1;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
        s1=(Scaffale)reader.readObject();
        reader.close();
        return s1;
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
                s+=i+"-->\t"+classificaAtp[i].toString()+"\n";
        }
        
        return s;
    }
    
}
