public class Driver {
  public static void main(String[] args) {
  Barcode y = new Barcode("11133");
  Barcode x = new Barcode("11111");
  Barcode z = new Barcode("11133");
  System.out.println(y);
  System.out.println(y.getZip());
  System.out.println(y.getCode());
  System.out.println(x.equals(y));
   System.out.println(y.equals(z));
  System.out.println(y.compareTo(x));
  }
}
