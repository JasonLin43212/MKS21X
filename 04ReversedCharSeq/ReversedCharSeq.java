public class ReversedCharSeq implements CharSequence {

  public static void main(String[]args){
    ReversedCharSeq a = new ReversedCharSeq("Hello");
    ReversedCharSeq b = new ReversedCharSeq(a);
    
    System.out.println(a);//olleH
    System.out.println(b);//Hello
    System.out.println(a.charAt(3));//e
    System.out.println(a.length());//5
    System.out.println(a.toString());//olleH
    System.out.println(a.subSequence(2,4));//le
    System.out.println(a.subSequence(0,3));//oll
    System.out.println(a);//olleH
  }

  private String data = "";

  public ReversedCharSeq (String str) {
    for (int i=str.length()-1; i>=0; i--) {
      data += str.substring(i,i+1);
    }
  }

  public ReversedCharSeq (ReversedCharSeq seq) {
    this(seq.toString());
  }

  public char charAt(int index){
    return data.charAt(index);
  }

  public int length(){
    return data.length();
  }

  public String toString(){
    return data;
  }

  public ReversedCharSeq subSequence(int start, int end) {
    String sliced = data.substring(start,end);
    ReversedCharSeq normalSlice = new ReversedCharSeq(sliced);
    return new ReversedCharSeq(normalSlice);
  }
}
