/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.mycompany.progetto_tennis.Tennista;

/**
 * Classe che contiene metodi statici per ordinare dei vettori
 * @author Studente
 */
public class Ordinatore {
    
    /**
     * Scambia fra di loro gli elementi in
     * posizione pos1 e in posizione pos2 di un array v di interi
     * @param v l'array che contiene gli elementi da scambiare
     * @param pos1 la posizione del primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(int [] v, int pos1, int pos2)
    {
        if(v==null)
            return;
        if(v.length==0)
            return;
        if(pos1<0||pos2<0||pos1>=v.length||pos2>=v.length)
            return;
        int sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    /**
     * Scambia fra di loro gli elementi in
     * posizione pos1 e in posizione pos2 di un array v di stringhe
     * @param v l'array che contiene gli elementi da scambiare
     * @param pos1 la posizione del primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(String [] v, int pos1, int pos2)
    {
        String sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    public static void scambia(Tennista [] v, int pos1, int pos2)
    {
        Tennista sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente
     * di un array v di interi utilizzando l'algoritmo selection sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]<vOrdinato[i])
                    scambia(vOrdinato, i, j);
            }
        }
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente
     * di un array v di interi utilizzando l'algoritmo selection sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]>vOrdinato[i])
                    scambia(vOrdinato, i, j);
            }
        }
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente
     * di un array v di stringhe utilizzando l'algoritmo selection sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine alfabetico crescente
     */
    public static String[] selectionSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j].compareToIgnoreCase(vOrdinato[i])<0)
                    scambia(vOrdinato, i, j);
            }
        }
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente
     * di un array v di stringhe utilizzando l'algoritmo selection sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine alfabetico decrescente
     */
    public static String[] selectionSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j].compareToIgnoreCase(vOrdinato[i])>0)
                    scambia(vOrdinato, i, j);
            }
        }
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente
     * di un array v di interi utilizzando l'algoritmo bubble sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine crescente
     */
    public static int[] bubbleSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        boolean scambi=true;
        do{
            scambi=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(vOrdinato[i]>vOrdinato[i+1])
                {
                    scambia(vOrdinato, i, i+1);
                    scambi=true;
                }
            }
        }while(scambi);
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente
     * di un array v di interi utilizzando l'algoritmo bubble sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static int[] bubbleSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        boolean scambi=true;
        do{
            scambi=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(vOrdinato[i]<vOrdinato[i+1])
                {
                    scambia(vOrdinato, i, i+1);
                    scambi=true;
                }
            }
        }while(scambi);
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente
     * di un array v di stringhe utilizzando l'algoritmo bubble sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine crescente
     */
    public static String[] bubbleSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        boolean scambi=true;
        do{
            scambi=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(vOrdinato[i+1].compareToIgnoreCase(vOrdinato[i])<0)
                {
                    scambia(vOrdinato, i, i+1);
                    scambi=true;
                }
            }
        }while(scambi);
        
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente
     * di un array v di stringhe utilizzando l'algoritmo bubble sort
     * @param v array da ordinare
     * @return copia dell'array ordinato in ordine decrescente
     */
    public static String[] bubbleSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        boolean scambi=true;
        do{
            scambi=false;
            for(int i=0;i<lunghezza-1;i++)
            {
                if(vOrdinato[i+1].compareToIgnoreCase(vOrdinato[i])>0)
                {
                    scambia(vOrdinato, i, i+1);
                    scambi=true;
                }
            }
        }while(scambi);
        
        return vOrdinato;
    }
    
    public static Tennista[] selectionSortDecrescente(Tennista[] classifica)
    {
        int lunghezza=classifica.length;
        //Creo una copia di v e lo chiamo vOrdinato
        Tennista[] vOrdinato=new Tennista[lunghezza];
        
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=classifica[i];

        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[i]!=null&&vOrdinato[j]!=null)
                {
                    if(vOrdinato[i].getPunti()<vOrdinato[j].getPunti())
                        scambia(vOrdinato, i, j);
                }
            }
        }
        return vOrdinato;
    }
}
