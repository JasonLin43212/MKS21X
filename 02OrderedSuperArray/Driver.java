public class Driver {
     public static void main(String args[]){
      OrderedSuperArray ordered = new OrderedSuperArray();
      System.out.println(ordered.add("Happy"));
      System.out.println(ordered.add("Apple"));
      System.out.println(ordered.add("Bable"));
      System.out.println("happy".compareTo("Happy"));
      System.out.println(ordered);
      System.out.println(ordered.add("bable"));

      System.out.println(ordered.add("happy"));
      System.out.println(ordered.add("zappy"));
      System.out.println(ordered.add("Zappy"));

      System.out.println(ordered);

      String[] nextStrings = new String[26];
      int count = 0;
      for (int i = 0; i < 26; i ++){
        if (i % 2 == 0){
          nextStrings[i] = "" + (char)(i + 65);
          nextStrings[i] = nextStrings[i].toLowerCase();
        }
        else{
          nextStrings[i] = "" + (char)(i + 65);
        }
      }

      OrderedSuperArray next = new OrderedSuperArray(nextStrings);
      next.add("B");
      next.add("B");
      next.add("B");

      next.add("H");
      System.out.println(next);
      System.out.println(next.indexOfBinary("B"));//should be 0
      System.out.println(next.indexOfBinary("H"));//should be 4
      System.out.println(next.indexOfBinary("Z"));//should be 12
      System.out.println(next.indexOfBinary("X"));//should be 11
      System.out.println(next.lastIndexOf("H")); // 7
      System.out.println(next.lastIndexOf("B")); // 3
      for (int i = 0; i < next.size(); i ++){
        System.out.println(next.get(i) + "||" + next.findIndex(next.get(i)) + "||" + next.findIndexBinary(next.get(i)) );
      }

      System.out.println(next.findIndexBinary("1")); // should return size();

    }
}
