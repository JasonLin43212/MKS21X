public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME
  */
  public static String name(){
    return "10.Lin.Jason";
  }

  /**Selection sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
    for (int i=0;i<data.length;i++){
      int smallestIndex = i;
      for (int j=i;j<data.length;j++){
        if (data[j] < data[smallestIndex]){
          smallestIndex = j;
        }
      }
      int tempStorage = data[i];
      data[i] = data[smallestIndex];
      data[smallestIndex] = tempStorage;
    }
  }

  private static void swap(int[]ary,int a, int b){
    int c =ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
  /*Inefficient version
  public static void insertionSort(int[] data){
    for(int i=1;i<data.length;i++){
      int j = i;
      while (j>0 && data[j] < data[j-1]){
        swap(data,j,j-1);
        j--;
      }
    }
  }
  */

  //More optimized version
  public static void insertionSort(int[] data){
    for (int i=1;i<data.length;i++){
      int currentData = data[i];
      int j = i;
      while (j>0 && currentData < data[j-1]){
        data[j] = data[j-1];
        j--;
      }
      data[j] = currentData;
    }
  }
}
