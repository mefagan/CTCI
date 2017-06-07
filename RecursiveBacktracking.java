package crackingCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBacktracking {
  
  public static int recurseSansBacktracking(String sample, String remaining, int solutions) {
    if (remaining.length()==0) {
      System.out.println(sample);
      solutions++;
    }
    for (int i = 0; i < remaining.length(); i ++) {
      String rest = remaining.substring(0, i) + remaining.substring(i+1);
      System.out.println(i);
      recurseSansBacktracking(sample + remaining.charAt(i), rest, solutions);
    }
    return solutions;
  }
  
  public static List<List<Integer>> recursePerm(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums) {
    //base case solution
    if (tempList.size() == nums.length) {
        list.add(new ArrayList<Integer>(tempList));
        tempList = new ArrayList<Integer>();
    } else {
        for (int i = 0; i < nums.length; i ++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            recursePerm(list, tempList, nums);
            tempList.remove((Integer)nums[i]);
        }
    }
    return list;
}
  
  public static int findAllSubsets(String curr, String remaining, int count) {
    if(remaining.length()==0) {
      System.out.println(curr);
      count++;
    } else {
      findAllSubsets(curr + remaining.charAt(0), remaining.substring(1), count);
      findAllSubsets(curr, remaining.substring(1), count);
    }
    return count;
  }
  
  public static void main(String[] args) {
    int solutions = 0;
    String sample = "mar";
    //recurseSansBacktracking("", sample, 0);
    //findAllSubsets("", sample, 0);
    int[] nums = new int[3];
    ArrayList<Integer> numAL = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list = recursePerm(list, new ArrayList<Integer>(), nums);
    for (List<Integer> l : list) {
      System.out.println(l);
    }
  }

}
