/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import eccezioni.*;
import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.*;

/**
 *
 * @author LL
 */
public class App implements Serializable{
    public static void main(String[] args) {
        int numeroVociMenu=11;
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
        boolean bisestile;
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
        vociMenu[5]="5 -->\tAggiungi punti a tennista";
        vociMenu[6]="6 -->\tAggiungi titoli a tennista";
        vociMenu[7]="7 -->\tEsporta tennisti in formato CSV";
        vociMenu[8]="8 -->\tImporta tennisti dal file CSV";
        vociMenu[9]="9 -->\tSalva dati Bin";
        vociMenu[10]="10 -->\tCarica dati Bin";
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
                    if(c1.getNTennistiPresenti()==0)
                        System.out.println("Non ci sono tennisti all'interno della classifica");
                    else
                        System.out.println(c1.toString());
                    break;
                    
                case 2://Aggiungi tennista   
                    try{
                        System.out.println("Nome --> ");
                        nome=tastiera.readString();
                        System.out.println("Cognome --> ");
                        cognome=tastiera.readString();
                        System.out.println("Anno di nascita --> ");
                        aa=tastiera.readInt();
                        while(aa<=0||aa>LocalDate.now().getYear())
                        {
                            System.out.println("Inserisci un anno corretto!");
                            System.out.println("Anno di nascita --> ");
                            aa=tastiera.readInt();
                        }
                        
                        if(aa%4==0)
                        {
                            if(aa%100==0)
                            {
                                if(aa%400==0)
                                    bisestile=true;
                                else
                                    bisestile=false;
                            }
                            bisestile=true;
                        }
                        else
                            bisestile=false;
                        
                        System.out.println("Mese di nascita --> ");
                        mm=tastiera.readInt();
                        while(mm<=0||mm>12)
                        {
                            System.out.println("Inserisci un mese corretto(1-12)!");
                            System.out.println("Mese di nascita --> ");
                            mm=tastiera.readInt();
                        }
                        System.out.println("Giorno di nascita --> ");
                        gg=tastiera.readInt();
                        while((mm==2&&bisestile==true)&&(gg<=0||gg>29))
                        {
                            System.out.println("Inserisci un giorno corretto(1-29)!");
                            System.out.println("Giorno di nascita --> ");
                            gg=tastiera.readInt();
                        }
                        while((mm==2&&bisestile==false)&&(gg<=0||gg>28))
                        {
                            System.out.println("Inserisci un giorno corretto(1-28)!");
                            System.out.println("Giorno di nascita --> ");
                            gg=tastiera.readInt();
                        }
                        while((mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)&&(gg<=0||gg>31))
                        {
                            System.out.println("Inserisci un giorno corretto(1-31)!");
                            System.out.println("Giorno di nascita --> ");
                            gg=tastiera.readInt();
                        }
                        while((mm==4|mm==6||mm==9||mm==11)&&(gg<=0||gg>30))
                        {
                            System.out.println("Inserisci un giorno corretto(1-30)!");
                            System.out.println("Giorno di nascita --> ");
                            gg=tastiera.readInt();
                        }
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
                    if(c1.getNTennistiPresenti()==0)
                    {
                        System.out.println("Non ci sono tennisti all'interno della classifica");
                    }
                    else
                    {
                        try 
                        {
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
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
                    }
                    break;
 
                case 4://Rimuovi tennista
                    if(c1.getNTennistiPresenti()==0)
                    {
                        System.out.println("Non ci sono tennisti all'interno della classifica");
                    }
                    else
                    {
                        try
                        {
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
                            posizione--;
                            c1.eliminaTennista(posizione);
                            System.out.println("Tennista eliminato correttamente.");
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
                    }
                    break;
                    
                case 5://aggiungi punti
                    if(c1.getNTennistiPresenti()==0)
                    {
                        System.out.println("Non ci sono tennisti all'interno della classifica");
                    }
                    else
                    {
                        try 
                        {
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
                            posizione--;
                            System.out.println("Punti --> ");
                            punti=tastiera.readInt();
                            while(punti<=0)
                            {
                                System.out.println("Inserisci dei punti validi(>0)!");
                                System.out.println("Punti --> ");
                                punti=tastiera.readInt();
                            }
                            c1.aggiungiPuntiTennista(punti, posizione);
                            System.out.println("Punti inseriti correttamente.");
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
                    }
                    break;
                    
                case 6://aggiungi titoli
                    if(c1.getNTennistiPresenti()==0)
                    {
                        System.out.println("Non ci sono tennisti all'interno della classifica");
                    }
                    else
                    {
                        try 
                        {
                            System.out.println("Inserisci la posizione del tennista--> ");
                            posizione=tastiera.readInt();
                            posizione--;
                            System.out.println("Titoli --> ");
                            titoli=tastiera.readInt();
                            while(titoli<=0)
                            {
                                System.out.println("Inserisci un numero di titoli validi(>0)!");
                                System.out.println("Titoli --> ");
                                titoli=tastiera.readInt();
                            }
                            c1.aggiungiTitoliTennista(titoli, posizione);
                            System.out.println("Titoli inseriti correttamente.");
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
                    }
                    break;
                    
                case 7: //Esporta CSV
                    try
                    {
                        c1.esportaCSV(nomeFileCSV);
                    }
                    catch(IOException ex)
                    {
                        System.out.println("Impossibile ");
                    }
                    break;
                    
                case 8: //Importa CSV
                    try
                    {
                        c1.importaCSV(nomeFileCSV);
                    }
                    catch(IOException ex)
                    {
                        System.out.println("Impossibile accedere al file!");
                    }
                    break;
                    
                case 9: //serializzzione               
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
                    
                case 10: //deserializzzione
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
