/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe che rappresenta un menù
 * elencoVoci è un array di stringhe dove ogni stringa rappresenta una voce del menù
 * Ad ogni voce del menù è associato un valore intero. Alla prima voce è associato il valore 0,
 * alla seconda il valore 1 ecc...
 * Ad esempio:
 * 0--> Esci                    valore associato=0
 * 1--> Fai questa cosa         valore associato=1
 * 2--> Fai quest'altra cosa    valore associato=2
 * ...
 * La classe consente di:
 *  -visualizzare le voci del menù
 *  -far scegliere all'utente una voce e restiruire il valore associato alla voce scelta
 * @author Studente
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    /**
     * Costruttore
     * @param elenco (elencoVoci) Rappresenta l'elenco di voci di cui è costituito il menù
     */
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length;
        elencoVoci=new String[numeroVoci];
        
        for(int i=0; i<numeroVoci; i++)
        {
            elencoVoci[i]=elenco[i];
        }
    }
    
    /**
     * Visualizza le voci del menù
     */
    public void visualizzaMenu()
    {
        for(int i=0; i<numeroVoci; i++)
        {
            System.out.println(elencoVoci[i]);
        }
    }
    
    /**
     * Permette all'utente di scegliere la voce del menù
     * I valori interi associati alle voci del menù vanno da 0
     * al numero di voci-1
     * @return Il valore intero associato alla voce scelta
     */
    public int sceltaMenu()
    {
        ConsoleInput tastiera=new ConsoleInput();
        int scelta=0;
        boolean sceltaOK;
        
        do{
            sceltaOK=true;
            visualizzaMenu();
            System.out.println("Scegli --> ");
            try 
            {
                scelta=tastiera.readInt();
                //Verifico che la scelta non sia minore di 0 o non sia maggiore uguale al numero di voci
                if(scelta<0||scelta>=numeroVoci)
                {
                    sceltaOK=false;
                    System.out.println("Scelta non valida. inserire un numero compreso tra 0 e "+(numeroVoci-1));
                }
            } 
            catch (IOException ex) 
            {
                System.out.println("Impossibile leggere da tastiera!");
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Formato input non corretto");
                sceltaOK=false;
            }
        }while(!sceltaOK);
        return scelta;
            
    }
}
