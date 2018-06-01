package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {


  public static void main (String [] args) {
    String []langs = {"HTML","Java", "PHP","Ruby" };

    //for (int i = 0; i< langs.length; i++) {
    //System.out.println("Я хочу выучить " + langs [i]);

    //List <String> languages = new ArrayList <String> ();
    //languages.add("java");
   //languages.add("PHP");
    //languages.add("Ruby");
    //languages.add("HTML"); Либо так,


    List <String> languages = Arrays.asList("HTML","Java", "PHP","Ruby");
    //for (int i = 0; i< languages.size(); i++) {
   //System.out.println("Я хочу выучить " + languages.get(i));

    for (String l:languages) { //  особая конструкция цикла, которая пренназаначениа для перебора элементов в коллекции
    System.out.println("Я хочу выучить " + l);



    }


  }
}