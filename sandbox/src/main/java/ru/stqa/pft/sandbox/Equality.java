package ru.stqa.pft.sandbox;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class Equality {

  public static void main (String [] args) {
    String s1 = "firefox";
    //String s2 = s1;
    String s2 = new String(s1);

    String s3 = "Chrom";
    String s4 = "Chr" + "om";

    String s5 = "firefox 6.0";
    String s6 = "firefox" + Math.sqrt(36.0);

    System.out.println("s1 = " + (s1 == s2));
    System.out.println("s2 = " + (s1.equals(s2)));

    System.out.println("s3 = " + (s3 == s4));
    System.out.println("s4 = " + (s3.equals(s4)));

    System.out.println("s5 = " + (s5 == s6));
    System.out.println("s6 = " + (s5.equals(s6)));
  }
}