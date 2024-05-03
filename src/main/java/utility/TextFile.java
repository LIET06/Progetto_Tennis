/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Rappresenta un file di testo.
 * Consente di scrivere una stringa sul file di testo o di leggere una stringa dal file di testo
 * Quando viene istanziato, il file di testo può essere aperto:
 *  -in scrittura in append
 *  -in scrittura non in append
 *  -in lettura.
 * Consente di chiudere il file
 * @author Studente
 */
public class TextFile {
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
     * Costruttore non in append
     * @param fileName pathname del file fisico da leggere/scrivere
     * @param mode madalità di apertura del file, può assumere i seguenti valori:
     *  -W o w per aprire il file in scrittura
     *  -qualsiasi altra lettera per aprire il file in lettura
     * @throws FileNotFoundException Viene sollevata se il file da leggere 
     * non viene trovato. Se il file aperto in scrittura non viene trovato,
     * esso viene creato.
     * @throws IOException Viene sollevata se non è possibile accedere al file. 
     */
    public TextFile(String fileName, char mode) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W'||mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(fileName));
        else
            writer=new BufferedWriter(new FileWriter(fileName));
    }
    
    /**
     * Costruttore con append
     * @param fileName pathname del file fisico da leggere/scrivere
     * @param mode madalità di apertura del file, può assumere i seguenti valori:
     *  -W o w per aprire il file in scrittura
     *  -qualsiasi altra lettera per aprire il file in lettura
     * @param append se vale true il file aperto in scrittura è aperto in append,
     * altrimenti viene aperto non in append
     * @throws FileNotFoundException Viene sollevata se il file da leggere 
     * non viene trovato. Se il file aperto in scrittura non viene trovato,
     * esso viene creato.
     * @throws IOException Viene sollevata se non è possibile accedere al file. 
     */
     public TextFile(String fileName, char mode, boolean append) throws FileNotFoundException, IOException
    {
        this.mode='R';
        if(mode=='W'||mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(fileName));
        else
            writer=new BufferedWriter(new FileWriter(fileName,append));       
    }
    
     /**
      * Scrive una stringa su file
      * @param line
      * @throws FileException Viene sollevata se il file è aperto in lettura anzichè in scrittura
      * @throws IOException Viene sollevata se non è possibile accedere al file.
      */
    public void toFile(String line) throws FileException, IOException
    {
        if(mode=='R')
            throw new FileException("Errore! File aperto in lettura!");
        
        writer.write(line);
        writer.newLine();
    }
    
    /**
     * Legge dal file e restituisce la stringa letta
     * la prima volta che viene invocato questo metodo viene
     * letta la prima riga del file, in seguito, ogni volta che viene invocato
     * questo metodo la stringa letta è la successiva.
     * quando viene raggiunta la fine del file il metodo solleva un'eccezione FileException.
     * @return La stringa letta
     * @throws FileException Viene sollevata in due casi:
     *  -se il file è aperto in scrittura anzichè in lettura
     *  -se viene raggiunta la fine del file
     * @throws IOException Viene sollevata se non è possibile accedere al file.
     */
    public String fromFile() throws FileException, IOException
    {
        String s;
        if(mode=='W')
            throw new FileException("Errore! File aperto in scrittura!");
        
        s=reader.readLine();
        if(s==null)
            throw new FileException("Fine del file!");
        return s;
    }
    
    /**
     * 
     * @throws IOException Viene sollevata se non è possibile accedere al file.
     */
    public void closeFile() throws IOException
    {
        if(mode=='R')
            reader.close();
        else
            writer.close();
        
    }
    
    
}
