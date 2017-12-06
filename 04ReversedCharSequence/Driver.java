
public class Driver{
  public static void main(String[] args){
    ReversedCharSequence a = new ReversedCharSequence("Hello");
    ReversedCharSequence b = new ReversedCharSequence(a);

    System.out.println(a);//olleH
    System.out.println(b);//Hello
    System.out.println(a.charAt(3));//e
    System.out.println(a.length());//5
    System.out.println(a.toString());//olleH
    System.out.println(a.subSequence(2,4));//le
    System.out.println(a.subSequence(0,3));//oll
    System.out.println(a);//olleH
  }
}
