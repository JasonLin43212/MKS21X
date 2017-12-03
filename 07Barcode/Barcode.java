public class Barcode{
  private String zip;

  public Barcode(String zip){
    this.zip = zip;
  }

  public String getZip(){
    return zip;
  }

  private int getCheckSum(){
    int sum = 0;
    for (int i=0; i<zip.length(); i++){
      sum += Integer.parseInt(zip.substring(i,i+1));
    }
    return sum % 10;
  }

  public String toString(){
    return getCode() + " (" + getZip() + ")";
  }

  public int compareTo(Barcode other){
    return zip.compareTo(other.getZip());
  }

  public boolean equals(Barcode other){
    return zip.equals(other.getZip());
  }
}
