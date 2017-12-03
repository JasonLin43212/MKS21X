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

  public String getCode(){
    String num = zip + getCheckSum();
    String output = "|";
    for (int i=0; i<num.length();i++){
      output += convert(num.substring(i,i+1));
    }
    output += "|";
    return output;
  }

  private String convert(String str){
    String[] conversion = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    return conversion[Integer.parseInt(str)];
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
