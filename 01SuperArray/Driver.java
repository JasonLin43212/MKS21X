public class Driver {
  public static void main(String [] args){
    SuperArray test = new SuperArray();
    test.add("hi");
    test.add("doIWork?");
    System.out.println(test);   // [hi,doIWork?]
    System.out.println(test.get(1)); //doIWork?
    System.out.println(test.size()); // 2
    System.out.println(test.set(1,"yes")); //doIWork?
    System.out.println(test); //[hi,yes]
    test.clear();
    System.out.println(test); //[]
    System.out.println(test.isEmpty());   //true
  }

}
