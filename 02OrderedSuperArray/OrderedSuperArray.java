public class OrderedSuperArray extends SuperArray{

  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(int startingCapacity){
    super(startingCapacity);
  }

  public OrderedSuperArray(String[] ary) {
    super(ary.length);
    for (int i=0;i<ary.length;i++){
      add(ary[i]);
    }
  };

  /*call the proper add.*/
  public void add(int index, String value){
    add(value);
  }

  public boolean add(String value){
    int index = findIndexBinary(value);
    super.add(index,value);
    return true;

  }
  //regualr method
  private int findIndex(String value){
    for (int i=0;i<size();i++){
      if (value.compareTo(get(i))<=0){
        return i;
      }
    }
    return size();
  }

  public String set(int index, String element){
    throw new UnsupportedOperationException();
  }

  private int findIndexBinary(String value){
    if (size() == 0){
      return size();
    }
    int start = 0;
    int end = size()-1;
    while (start != end) {
      int middle = (start + end)/2;
      if (value.compareTo(get(middle))>0){
        start = middle + 1;
      }
      else if (value.compareTo(get(middle))<0){
        end = middle;
      }
      else {
        return middle;
      }
    }
    if (value.compareTo(get(start))>0) {
      return start + 1;
    }
    return start;
  }

  public int indexOfBinary(String target){
    if (size()==0){
      return 0;
    }
    int start = 0;
    int end = size()-1;
    int index = -1;
    while (start != end) {
      int middle = (start + end)/2;
      if (target.compareTo(get(middle))>0){
        start = middle + 1;
      }
      else if (target.compareTo(get(middle))<0){
        end = middle;
      }
      else {
        index = middle;
        end = middle;
      }
    }
    if (get(start).equals(target)){
      return start;
    }
    return index;
  }

  public int lastIndexOfBinary(String target){
    if (size()==0){
      return 0;
    }
    int start = 0;
    int end = size()-1;
    int index = -1;
    while (start != end) {
      int middle = (start + end)/2;
      if (target.compareTo(get(middle))>0){
        start = middle + 1;
      }
      else if (target.compareTo(get(middle))<0){
        end = middle;
      }
      else {
        index = middle;
        start = middle + 1;
      }
    }
    if (get(end).equals(target)){
      return end;
    }
    return index;
  }
}
