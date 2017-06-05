package crackingCodingInterview;

public class RecursiveBacktracking {
  
  public static int recurseSansBacktracking(String sample, String remaining, int solutions) {
    if (remaining.length()==0) {
      System.out.println(sample);
      solutions++;
    }
    for (int i = 0; i < remaining.length(); i ++) {
      String rest = remaining.substring(0, i) + remaining.substring(i+1);
      //System.out.println(rest);
      recurseSansBacktracking(sample + remaining.charAt(i), rest, solutions);
    }
    return solutions;
  }
  
  public static void main(String[] args) {
    int solutions = 0;
    String sample = "MAR";
    recurseSansBacktracking("", sample, 0);
  }

}
