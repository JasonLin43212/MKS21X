public class SuperArrayIterator implements Iterator<String>{
  private SuperArray data;
  private currentIndex;

  public SuperArrayIterator(SuperArray a) {
    data = a;
    currentIndex = 0;
  }

  public boolean hasNext(){
    return currentIndex < data.size();
  }

  public String next(){
    String result = data.get(currentIndex);
    currentIndex++;
    return result;
  }
}
