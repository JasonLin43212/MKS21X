public class ReversedCharSeq implements CharSequence {

    public static void main(String[]args){
	ReversedCharSeq a = new ReversedCharSeq("Hello");

	System.out.println(a.data);
    }

    public String data;
    
    public ReversedCharSeq (String str) {
	for (int i=str.length()-2; i>=0; i--) {
	    data += str.substring(i,i+1);
	}				
    }

     public ReversedCharSeq (reversedCharSeq str) {
	for (int i=str.length()-2; i>=0; i--) {
	    data += str.substring(i,i+1);
	}				
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

    public CharSequence subSequence(int start, int end) {
	return (CharSequence) data.substring(start,end);
    }
}
