import java.util.*;

public class Driver{
  public static void main(String[]args){
    int[] a = new int[20000];
    for (int i=0;i<a.length;i++){
      //a[i] = i;
      a[i] = (int) (Math.random()*100000);
    }

    int[] b = new int[a.length];
    for (int i=0; i<b.length;i++){
      b[i] = a[i];
    }

    Arrays.sort(b);

    double start = System.currentTimeMillis();
    //Sorts.selectionSort(a);
    //Sorts.insertionSort(a);
    Sorts.bubbleSort(a);
    double end = System.currentTimeMillis();

    if (equals(a,b)){
      //System.out.println(Arrays.toString(a));
      System.out.println(end-start+"msec");
    }
    else {
      System.out.println("Not sorted correctly");
    }
  }

  public static boolean equals(int[] a, int[] b){
    if (a.length != b.length){
      return false;
    }
    for (int i=0; i<a.length;i++){
      if (a[i] != b[i]){
        return false;
      }
    }
    return true;
  }
}
