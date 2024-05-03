/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_tennis;

import eccezioni.*;
import utility.*;
import static utility.Ordinatore.scambia;
/**
 *
 * @author Studente
 */
public class Classifica {
    private Tennista[] classificaAtp;
    
    public Classifica()
    {
        classificaAtp=new Tennista[1000];
    }
    
    public Classifica(Classifica c)
    {
        
    }
    
    public void setTennista(Tennista t)
    {
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
        for(int i=0;i<classificaAtp.length;i++)
        {
            if(classificaAtp[i].getIdTennista()==id)
                return classificaAtp[i];
        }
        throw new EccezioneIdNonValido();
    }
    
    public void eliminaTennista(int id)
    {
        for(int i=0;i<classificaAtp.length;i++)
            if(classificaAtp[i].getIdTennista()==id)
            {
                while(i<classificaAtp.length)
                {
                    classificaAtp[i]=classificaAtp[i+1];
                    i++;
                }
            }
    }
    
    public void ordinatoreId()
    {
        for(int i=0;i<classificaAtp.length;i++)
        {
            if(classificaAtp[i]!=null)
                classificaAtp[i].setIDTennista(i);
        }
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
