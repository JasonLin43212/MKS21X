public class Driver {
  public static void main(String[] args) {
    //Barcode e = new Barcode("12sa1"); //Should throw an error, sa not valid nums
    // Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
    // Barcode.toCode("131"); //Should throw an error, too little nums
    // Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
    // Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
    // Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
    // Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
    // Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found
  }
}
