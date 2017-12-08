import java.util.*;

public class Driver{
  public static void main(String[]args){
    //Change this part with any test case you like by
    //commenting and uncommenting

    //int[] a = {64, 25, 12, 22, 11};
    //int[] a = {34, 25, 12, 22, 12};
    //int[] a = {6, 25, -12, 22, 1, 32, 22};
    //int[] a = {-5, -25, -12, -15, 1};
    //int[] a = {1, 1, 0, 1, 0, 0};
    //int[] a = {1932, -25, 12, 12, 3};
    int[] a = {4, 23, -12, 0, 11, 1, 4, 99, 32, 14, 19, 23};

    String input = "[";
    for (int i=0;i<a.length;i++){
      input += a[i];
      if (i!=a.length-1){
        input += ",";
      }
    }
    input += "]";
    System.out.println(input);
    //Sorts.selectionSort(a);
    Sorts.insertionSort(a);
    //Arrays.sort(a);
    System.out.println("-----Sorted Below----");
    String output = "[";
    for (int i=0;i<a.length;i++){
      output += a[i];
      if (i!=a.length-1){
        output += ",";
      }
    }
    output += "]";
    System.out.println(output);
  }
}
