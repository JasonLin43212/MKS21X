public class CirculatingBook extends LibraryBook {
  private String currentHolder;
  private String dueDate;

  public CirculatingBook (String author, String title, String ISBN, String callNumber) {
    super(author,title,ISBN,callNumber);
    currentHolder = null;
    dueDate = null;
  }

  public String getCurrentHolder(){
    return currentHolder;
  }

  public String getDueDate(){
    return dueDate;
  }

  public void setCurrentHolder(String currentHolder){
    this.currentHolder = currentHolder;
  }

  public void setDueDate(String dueDate){
    this.dueDate = dueDate;
  }

  public void checkout(String holder, String dueDate){
    this.currentHolder = holder;
    this.dueDate = dueDate;
  }

  public void returned(){
    currentHolder = null;
    dueDate = null;
  }

  public String circulationStatus(){
    if (currentHolder != null){
      return currentHolder + ", " + dueDate;
    }
    return "book available on shelves";
  }

  public String toString(){
    if (currentHolder != null){
       return super.toString() + ", " + circulationStatus();
     }
     return super.toString();
  }
}
