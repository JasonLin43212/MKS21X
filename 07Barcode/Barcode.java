import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode>{
  private String zip;
  private static String[] conversion = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

  public Barcode(String zip){
    if (zip.length() == 5){
      for (int i=0; i<zip.length();i++){
        if (!Character.isDigit(zip.charAt(i))){
          throw new IllegalArgumentException();
        }
      }
      this.zip = zip;
    }
    else {
      throw new IllegalArgumentException();
    }
  }

  public String getZip(){
    return zip;
  }

  private static int getCheckSum(String zip){
    int sum = 0;
    for (int i=0; i<zip.length(); i++){
      sum += Integer.parseInt(zip.substring(i,i+1));
    }
    return sum % 10;
  }

  public String getCode(){
    String num = zip + getCheckSum(zip);
    String output = "|";
    for (int i=0; i<num.length();i++){
      output += convert(num.substring(i,i+1));
    }
    output += "|";
    return output;
  }

  private static String convert(String str){
    return conversion[Integer.parseInt(str)];
  }

  public String toString(){
    return getCode() + " (" + getZip() + ")";
  }

  public int compareTo(Barcode other){
    return zip.compareTo(other.getZip());
  }

  public boolean equals(Barcode other){
    return zip.equals(other.getZip());
  }

  public static String toCode(String zip){
     if (zip.length() == 5){
      for (int i=0; i<zip.length();i++){
        if (!Character.isDigit(zip.charAt(i))){
          throw new IllegalArgumentException();
        }
      }
    }
    else {
      throw new IllegalArgumentException();
    }
    String num = zip + getCheckSum(zip);
    String output = "|";
    for (int i=0; i<num.length();i++){
      output += convert(num.substring(i,i+1));
    }
    output += "|";
    return output;
  }

  public static String codeToNumber(String code){
    for (int i=0;i<conversion.length;i++){
      if (code.equals(conversion[i])){
        return i+"";
      }
    }
    throw new IllegalArgumentException();
  }

  public static String toZip(String code){
    if (code.length() != 32){
      throw new IllegalArgumentException();
    }
    if (!(code.charAt(0)=='|' && code.charAt(31)=='|')){
      throw new IllegalArgumentException();
    }
    String number = "";
    for (int i=1;i<27;i+=5){
      number += codeToNumber(code.substring(i,i+5));
    }
    int sum = 0;
    for (int i=0;i<5;i++){
      sum += Integer.parseInt(number.substring(i,i+1));
    }
    if (sum % 10 == Integer.parseInt(number.substring(5,6))){
      return number.substring(0,5);
    }
    throw new IllegalArgumentException();
  }
}
