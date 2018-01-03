public class SuperArray{

  private String[] data;
  private int size;

  public SuperArray(){
    this(10);
  }

  public SuperArray(int startingCapacity){
    data = new String[startingCapacity];
    size = 0;
  }

  public void clear(){
    data = new String[data.length];
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size()==0;
  }

  public boolean add(String element){
    add(size(),element);
    return true;
  }

  public String toString(){
    String str = "[";
    for (int i=0;i<size();i++){
      str += data[i];
      if (i!=size()-1){
        str+=", ";
      }
    }
    str+="]";
    return str;
  }

  public String get(int index){
    if (index>=size() || index<0){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public String set(int index, String element){
    if (index>=size() || index<0){
      throw new IndexOutOfBoundsException();
    }
    String oldElement = data[index];
    data[index] = element;
    return oldElement;
  }
  //Phase 2
  private void resize(){
    String[] newData = new String[2*size()+1];
    for (int i=0;i<data.length;i++){
      newData[i] = data[i];
    }
    data = newData;
  }

  //Phase 3
  public boolean contains(String target){
    for (int i=0;i<size();i++){
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target){
    for (int i=0;i<size();i++){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    for (int i=size()-1;i>-1;i--){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public void add(int index, String element){
    if (index>size() || index<0){
      throw new IndexOutOfBoundsException();
    }
    if (size() == data.length){
      resize();
    }

    for (int i=size();i>index;i--){
      data[i]=data[i-1];
    }
    data[index] = element;
    size++;
  }

  public String remove(int index){
    if (index>=size() || index<0){
      throw new IndexOutOfBoundsException();
    }
    String oldElement = data[index];
    String[] newData = new String[data.length];
    for (int i=0;i<size();i++){
      if (i<index){
        newData[i]=data[i];
      }
      if (i>=index){
        newData[i]=data[i+1];
      }
    }
    data = newData;
    size--;
    return oldElement;
  }

  public boolean remove(String element){
    if (contains(element)){
      remove(indexOf(element));
      return true;
    }
    return false;
  }
}
