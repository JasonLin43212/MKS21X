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


}
