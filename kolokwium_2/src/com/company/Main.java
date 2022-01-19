package com.company;

import java.util.*;
import java.lang.*;


public class Main {

    public static void main(String[] args) {

        Kandydat nr1 = new Kandydat("Michał", 33, "licencjat", 3);
        Kandydat nr2 = new Kandydat("Maciek", 23, "licencjat", 1);
        Kandydat nr3 = new Kandydat("Kamil", 33, "mistrzowie", 5);
        Kandydat nr4 = new Kandydat("Roman", 37, "mistrzowie", 8);
        Kandydat nr5 = new Kandydat("Jan", 24, "licencjat", 2);
        Kandydat nr6 = new Kandydat("Jan", 24, "licencjat", 4);

        ArrayList<Kandydat> lista=new ArrayList<Kandydat>();

        lista.add(nr1);
        lista.add(nr2);
        lista.add(nr3);
        lista.add(nr4);
        lista.add(nr5);

        Rekrutacja grupa=new Rekrutacja(3, lista);

        System.out.println( grupa.Qualified(nr2));
        System.out.println( grupa.Qualified(nr3));

        System.out.println(nr1.compareTo(nr2));

        grupa.pokaz(lista);





    }
}



class Kandydat extends ArrayList<Kandydat> implements Comparable, Cloneable{

    private String nazwa;
    private int wiek;
    private String wyksztalcony;
    private int lata_doswiadczenia;

    public Kandydat(String nazwa, int wiek, String wyksztalcony, int lata_doswiadczenia){

        this.nazwa=nazwa;
        this.wiek=wiek;
        this.wyksztalcony=wyksztalcony;
        this.lata_doswiadczenia=lata_doswiadczenia;
    }

    public String getNazwa(){
        return nazwa;
    }

    public int getWiek(){
        return wiek;
    }

    public String getWyksztalcony(){
        return wyksztalcony;
    }
    public int getLata_doswiadczenia(){
        return lata_doswiadczenia;
    }


    @Override
    public int compareTo(Object o) {
        if(this!=o){
            if(this.size()>o.toString().length()){
                return 1;
            }
            else{
                return -1;
            }
        }
        return 0;
    }


}


class Rekrutacja{

    public static int doswiadczenie;
    private ArrayList<Kandydat> lista_kandytatow;

    public Rekrutacja(int doswiadczenie, ArrayList<Kandydat> lista){
        this.doswiadczenie=doswiadczenie;
        this.lista_kandytatow=lista;
    }


    public void set(){
        doswiadczenie=2;
    }

    public boolean Qualified(Kandydat k){
        if(doswiadczenie<=k.getLata_doswiadczenia()){
            return true;
        }
    return false;
    }

    public void pokaz(ArrayList<Kandydat> lista){
        ArrayList<Kandydat> tmp_list=new ArrayList<Kandydat>();
        for(int i=0;i<lista.size();i++){
            tmp_list.add(lista.get(i));
        }
        System.out.println(tmp_list);
    }

}

