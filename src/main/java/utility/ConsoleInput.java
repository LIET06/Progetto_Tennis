/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe che rappresenta una console di input (tastiera)
 * Un oggetto istanza della classe ConsoleInput espone dei metodi
 * che consentono di acquisire dalla tastiera variabili di ciascun
 * tipo di dato nativo e oggetti di tipo String
 * Gli attributi sono due istanzie di classi InputStreamReader
 * e BufferedReader che consentono di creare uno stream 
 * di byte di input dalla tastiera
 * @author Studente
 */
public class ConsoleInput 
{
    private InputStreamReader input;
    private BufferedReader tastiera;

    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        input=new InputStreamReader(System.in);
        tastiera=new BufferedReader(input);
    }
    
    /**
     * Metodo per la lettura di un dato di tipo String
     * @return la stringa letta
     * @throws IOException Errore di lettura
     */
    public String readString() throws IOException
    {
        return tastiera.readLine();
    }
    
    /**
     * Metodo per la lettura di un dato di tipo int
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public int readInt() throws IOException, NumberFormatException
    {
        return Integer.parseInt(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo short
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo long
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo float
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo double
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo boolean
     * @return true se il numero inserito è una stringa "true",
     *         altrimenti false
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo byte
     * @return il numero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un dato di tipo char
     * @return il primo carattere di una stringa inserita
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Input non conforme
     */
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
}
