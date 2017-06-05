package crackingCodingInterview;

public class RecursiveBacktracking {
  
  public static int recurseSansBacktracking(String sample, String remaining, int solutions) {
    if (remaining.length()==0) {
      solutions++;
    }
    for (int i = 0; i < remaining.length(); i ++) {
      String rest = remaining.substring(0, i) + remaining.substring(i+1);
      recurseSansBacktracking(sample, rest, solutions);
    }
    return solutions;
  }
  
  public static void main(String[] args) {
    int solutions = 0;
    String sample = "Mar";
    recurseSansBacktracking(sample, sample, 0);
  }

}
