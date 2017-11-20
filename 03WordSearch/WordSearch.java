import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;
  private int seed;
  private String fileName;
  private int row;
  private int col;


  public static void main(String[]args){
    String basicError= "\nHello User! Welcome to my Word Search."+
      "\n\nPlease choose one of the following formats with all the arguments filled in:"+
      "\n\njava WordSearch <rows> <cols> <filename>"+
      "\n\njava WordSearch <rows> <cols> <filename> <randomSeed>"+
      "\n\njava WordSearch <rows> <cols> <filename> <randomSeed> <answer>";
    int row = 0;
    int column = 0;
    String filename = "";
    int randomSeed = 0;
    String answer = "";
    if (args.length < 3) {
      System.out.println(basicError);
    }
    else {

      //checking rows format
      try{
        row = Integer.parseInt(args[0]);
      }catch (NumberFormatException e){
        System.out.println("\nYour argument for <rows> is formatted incorrectly. Fix it! (Positive Integer)");
        System.exit(1);
      }

      //checking cols format
      try{
        column = Integer.parseInt(args[1]);
      }catch (NumberFormatException e){
        System.out.println("\nYour argument for <cols> is formatted incorrectly. Fix it! (Positive Integer)");
        System.exit(1);
      }

      //checking that the file can be read
      try{
        filename = args[2];
        Scanner in = new Scanner(new File(args[2]));
      }catch (FileNotFoundException e){
        System.out.println("\nA file named \""+ filename +"\" can not be found. Check that:\n (1) Your argument for <filename> contains the file extension\n (2) A file with such a name exists in the same directory as WordSearch.java");
        System.exit(1);
      }

      //For 3 arguments
      if (args.length == 3) {
        WordSearch a = new WordSearch(row, column, filename);
        a.fillIn();
        System.out.println(a);
      }
      else {
        //checking randomSeed format
        try{
          randomSeed = Integer.parseInt(args[3]);
        }catch (NumberFormatException e) {
          System.out.println("\nYour argument for <randomSeed> is formatted incorrectly. Fix it! (Integer)");
          System.exit(1);
        }
        //checking if they want solution
        if (args.length > 4 && args[4].equals("key")) {
          WordSearch a = new WordSearch(row, column, filename, randomSeed);
          System.out.println(a);
        }
        //No, they don't want solution so just give them a puzzle with seed
        else {
          WordSearch a = new WordSearch(row, column, filename, randomSeed);
          a.fillIn();
          System.out.println(a);
        }
      }
    }
  }

  public WordSearch(int rows, int cols, String fileName) {
    this(rows, cols, fileName, (new Random()).nextInt());
  }

  public WordSearch( int rows, int cols, String fileName, int randSeed){
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    this.row = rows;
    this.col = cols;
    this.fileName = fileName;

    this.seed = randSeed;
    randgen = new Random(randSeed);

    data = new char[rows][cols];
    for (int i=0; i<rows;i++){
      for(int j=0; j<cols;j++){
        data[i][j] = '_';
      }
    }

    try{
      Scanner in = new Scanner(new File(fileName));

      while (in.hasNext()){
        wordsToAdd.add(in.nextLine().toUpperCase());
      }

    } catch(FileNotFoundException e) {
      System.out.println("File Not Found: " + fileName);
      System.exit(1);
    }

    if (row > 0 && col > 0) {
      addAllWords();
    }
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    for (int i=0; i<data.length;i++){
      for(int j=0; j<data[i].length;j++){
        data[i][j] = '_';
      }
    }
  }

  /**The proper formatting for a WordGrid is created in the toString.
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
  public String toString(){
    String str = "\nRows: " + row +" Columns: " + col + " Seed: " + seed + " FileName: " + fileName + "\n\n";
    for (int i=0; i<row; i++){
      for(int j=0; j<col ;j++){
        str += data[i][j] + " ";
      }
      str += "\n";
    }

    if (wordsAdded.size() == 0) {
      str += "\nNone of the words from the file fit into this puzzle.\nCheck that:\n(1)Your words are not too long\n(2)Your puzzle is not too small\n(3)Your file has text in it";
    }
    else {
      str += "\nFind the following words:\n";
    }
    for (int i=0; i<wordsAdded.size(); i++){
      if (i % 3 == 0) {
        str += "\n";
      }
      str += wordsAdded.get(i) + "          ";
    }
    return str + "\n";
  }

  private boolean isNotInRange (int num, boolean isRow){
    if (num < 0) {
      return true;
    }
    if (isRow) {
      return num >= row;
    }
    return num >= col;
  }

  private boolean addAllWords(){
    int numOfWords = wordsToAdd.size();
    for (int i=0; i<numOfWords; i++){
      int j = 0;
      while (j < 100000){
        if (addWord(randgen.nextInt(row),
                    randgen.nextInt(col),
                    wordsToAdd.get(randgen.nextInt(wordsToAdd.size())),
                    randgen.nextInt(3) - 1,
                    randgen.nextInt(3) - 1)){
          j += 100000;
        }
        j++;
      }
    }
    return true;
  }

  private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement) {
    if (rowIncrement == 0 && colIncrement == 0){
      return false;
    }

    //checks if the word search can contain the word
    if (isNotInRange(r,true) || isNotInRange(r+rowIncrement*(word.length()-1),true) ||
        isNotInRange(c,false) || isNotInRange(c+colIncrement*(word.length()-1),false)) {
      return false;
    }

    //checks if there are any overlap
    int row = r;
    int column = c;
    for ( int i=0; i<word.length(); i++){
      if (data[row][column] != '_' && data[row][column] != word.charAt(i)){
        return false;
      }
      row += rowIncrement;
      column += colIncrement;
    }

    //adds in the word
    for ( int i=0; i<word.length(); i++){
      data[r][c] = word.charAt(i);
      r += rowIncrement;
      c += colIncrement;
    }

    wordsToAdd.remove(word);
    wordsAdded.add(word);

    return true;
  }

  public void fillIn(){
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++){
        if (data[i][j] == '_') {
          data[i][j] = letters.charAt(randgen.nextInt(26));
        }
      }
    }
  }

  public int getSeed(){
    return seed;
  }

  public ArrayList getAddedWords(){
    return wordsAdded;
  }
}
