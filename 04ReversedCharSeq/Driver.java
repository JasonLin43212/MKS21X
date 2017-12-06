public class Driver{
  public static void main(String[] args){
    ReversedCharSeq test = new ReversedCharSeq("ABCD");
    System.out.println(test);
    System.out.println(test.charAt(0));
    //System.out.println(test.charAt(-1));
    //System.out.println(test.charAt(4));
    System.out.println(test.length());
    System.out.println(test.subSequence(0,3));
}
}
