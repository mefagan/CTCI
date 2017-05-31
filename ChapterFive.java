package crackingCodingInterview;

public class ChapterFive {

  public static int insertion(int N, int M, int i, int j) {
    int allones = ~0;
    int left = allones << (j + 1);
    int right = (1 << i) - 1;
    int mask = left | right;
    int n_cleared = N & mask;
    int m_shifted = M << i;
    return n_cleared | m_shifted;
  }
  
  public static String binaryRepOfNumber(int n) {
    StringBuilder answer = new StringBuilder();
    if (n>1) {
      binaryRepOfNumber(n/2);
    } 
    answer.append(String.valueOf(n%2));
    return answer.toString();
  }
  
  public static String binaryToString(double num) {
    StringBuilder answer = new StringBuilder();
    answer.append(".");
    while (num > 0) {
      double r = num * 2;
      if (r >= 1) {
        num = r -1;
        answer.append(1);
      } else {
        answer.append(0);
        num = r;
      }
    }
    return answer.toString();
  }
  
  public static int flipBitToWin(int num) {
    int bit = -1;
    int count;
    int lastBit;
    int max = 1;
    int previousCount = 0;
    int currentCount = 0;
    boolean addOne = false;
    for (int i = 1; i <= num; i<<=1) {
      lastBit = bit;
      bit = num&i;
      if (bit == 0 && lastBit == 1) {
        addOne = false;
        previousCount = currentCount;
        currentCount = 0;
      } 
      if (bit == 0 && lastBit < 1) {
        previousCount = 0;
        currentCount = 0;
      }
      if (bit == 1) {
        if (lastBit == 0) {
          addOne = true;;
        } 
        currentCount++;
        count = previousCount + currentCount;
        if (count > max) {
          max = count;
        }
      }
    }
    return max;
  }
  
  public static void main(String[] args) {    
    System.out.println(insertion((byte)1000000000, (byte)10011, 2, 6));
    System.out.println(binaryToString(.625));
  }
  
}
