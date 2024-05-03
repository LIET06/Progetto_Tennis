/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import eccezioni.EccezioneClassificaPiena;
import eccezioni.EccezioneIdNonValido;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.*;

/**
 *
 * @author Studente
 */
public class App {
    public static void main(String[] args) {
        int numeroVociMenu=9;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Classifica c1=new Classifica();
        ConsoleInput tastiera=new ConsoleInput();
        TextFile f1 = null;
        String nomeFileCSV="tennisti.csv";
        String nomeFileBinario="classifica.bin";
        String nome, cognome;
        int gg,mm,aa,punti,titoli,posizione;
        Tennista t;
        
        
        //Caricamento dati classifica
        try 
        {
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
            c1=(Classifica)reader.readObject();
            reader.close();
            System.out.println("Caricamento effettuato correttamente");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File non trovato");
        } 
        catch (IOException ex) 
        {
             System.out.println("Impossibile accedere al file");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Impossibile leggere il dato memorizzato");
        }
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i tennisti";
        vociMenu[2]="2 -->\tAggiungi tennista";
        vociMenu[3]="3 -->\tVisualizza singolo tennista (posizione)";
        vociMenu[4]="4 -->\tElimina tennista (posizione)";
        vociMenu[5]="5 -->\tEsporta tennisti in formato CSV";
        vociMenu[6]="6 -->\tImporta tennisti dal file CSV";
        vociMenu[7]="7 -->\tSalva dati Bin";
        vociMenu[8]="8 -->\tCarica dati Bin";
        menu=new Menu(vociMenu);
        
        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: //Esci
                    System.out.println("Arrivederci");
                    break;
                case 1://Visualizza tutti
                    System.out.println(c1.toString());
                    break;
                case 2://Aggiungi tennista   
                    try{
                        System.out.println("Nome --> ");
                        nome=tastiera.readString();
                        System.out.println("Cognome --> ");
                        cognome=tastiera.readString();
                        System.out.println("Giorno di nascita --> ");
                        gg=tastiera.readInt();
                        System.out.println("Mese di nascita --> ");
                        mm=tastiera.readInt();
                        System.out.println("Anno di nascita --> ");
                        aa=tastiera.readInt();
                        System.out.println("Numero titoli vinti --> ");
                        titoli=tastiera.readInt();
                        System.out.println("Punti --> ");
                        punti=tastiera.readInt();
                        t=new Tennista(nome, cognome, LocalDate.of(aa, mm, gg), punti, titoli);
                        c1.setTennista(t);
                        System.out.println("Tennista inserito correttamente.");
                    }
                    catch(IOException ex)
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera.");
                    } 
                    catch (EccezioneClassificaPiena ex) 
                    {
                        System.out.println("Impossibile aggiungere il tennista. Classifica piena, eliminiare un tennista prima di aggiungerene un altro");
                    }
                   break;


                case 3: //getTennista
                    try 
                    {
                        do{
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
                            break;
                        }while(true);
                        posizione--;
                        t=c1.getTennista(posizione);
                        System.out.println("Tennista:\n"+t.toString());
                    } 
                    catch (EccezioneIdNonValido ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Formato non corretto");
                    }

                    break;


                    
                case 4://Rimuovi tennista
                        try
                        {
                            do{
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
                            break;
                            }while(true);
                            posizione--;
                            c1.eliminaTennista(posizione);
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Errore. Impossibile leggere da tastiera");
                        } 
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Formato non corretto");
                        } 
                        catch (EccezioneIdNonValido ex) 
                        {
                            System.out.println("Posizione non valida");
                        }
                    break;
                    
                case 5: //Esporta CSV
                    try
                    {
                        c1.esportaCSV(nomeFileCSV);
                    }
                    catch(IOException ex)
                    {
                        System.out.println("Impossibile ");
                    }
                    break;
                case 6: //Importa CSV
                    try
                    {
                        c1.importaCSV(nomeFileCSV);
                    }
                    catch(IOException ex)
                    {
                        System.out.println("Impossibile accedere al file!");
                    }
                    break;
                case 7: //serializzzione               
                    try 
                    {
                        c1.serializzazione(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    }
                    break;
                case 8: //deserializzzione
                    try 
                    {
                        c1.deserializzazione(nomeFileBinario);
                        System.out.println("Caricamento effettuato correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere il dato memorizzato");
                    }
                    break;
            }
        }while(voceMenuScelta!=0);
    }
}
