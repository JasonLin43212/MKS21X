public class Driver{
  public static void main(String[]args){
    int[] a = {1,2,34,4,54,9,34,992,44};
    for (int i=0;i<a.length;i++){
      System.out.println(a[i]);
    }
    Sorts.selectionSort(a);
    System.out.println("-----Sorted-----");
    for (int i=0;i<a.length;i++){
      System.out.println(a[i]);
    }
  }
}
