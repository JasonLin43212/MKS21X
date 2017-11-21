public class SuperArray{

  public String[] data;
  private int size;

  public SuperArray(){
      data = new String[10];
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
    if (data.length == size()){
      resize();
      data[size()]= element;
    }
    else {
      data[size()] = element;
    }
    size++;
    return true;
   }

  public String toString(){
    String str = "[";
    for (int i=0;i<size();i++){
      str += data[i];
      if (i!=size()-1){
        str+=",";
      }
    }
    str+="]";
    return str;
  }

  public String get(int index){
    if (index>=size() || index<0){
      System.out.println("Error: Index out of range." +
                         "(Index Range: 0-"+
                         (size()-1) +
                         ", Requested Index:"+ index+ ")");
      return null;
    }
    return data[index];
  }

  public String set(int index, String element){
    if (index>=size() || index<0){
      System.out.println("Error: Index out of range." +
                         "(Index Range: 0-"+
                         (size()-1) +
                         ", Requested Index:"+ index+ ")");
      return null;
    }
    String oldElement = data[index];
    data[index] = element;
    return oldElement;
  }
  //Phase 2
  private void resize(){
    String[] newData = new String[2*size()];
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
    if (index>=size() || index<0){
      System.out.println("Error: Index out of range." +
                         "(Index Range: 0-"+
                         (size()-1) +
                         ", Requested Index:"+ index+ ")");
    }
    if (size() == data.length){
      resize();
    }
    String[] newData = new String[data.length];
    for (int i=0;i<size();i++){
      if (i<index){
        newData[i] = data[i];
      }
      else if (i == index){
        newData[i] = element;
        size++;
      }
      else {
        newData[i] = data[i-1];
      }
    }
    data = newData;
  }

  public String remove(int index){
    if (index>=size() || index<0){
      System.out.println("Error: Index out of range." +
                         "(Index Range: 0-"+
                         (size()-1) +
                         ", Requested Index:"+ index+ ")");
      return null;
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
