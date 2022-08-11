package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInString {
  public static void main(String[] args) {
    System.out.println(findAnagrams("baa", "aa"));
  }

  public static List<Integer> findAnagrams(String s, String p) {
      List<Integer> anagramIndices = new ArrayList<>();
      if (s.length() < p.length()) {
          return anagramIndices;
      }
      int[] letterCount = new int[26];
      char[] pChars = p.toCharArray();
      char[] firstWindow = s.substring(0, pChars.length - 1).toCharArray();
      for (char c: firstWindow) {
          letterCount[c - 'a']++;
      }
      for (int i=0; (i+p.length())<=s.length(); i++) {
          letterCount[s.charAt(i + p.length() - 1) - 'a']++;
          int[] letterCopy = Arrays.copyOf(letterCount, letterCount.length);
          boolean foundAnagram = true;
          for (char c: pChars) {
              letterCopy[c - 'a']--;
              if (letterCopy[c - 'a'] < 0) {
                  foundAnagram = false;
                  break;
              }
          }
          if (foundAnagram) {
              anagramIndices.add(i);
          }
          letterCount[s.charAt(i) - 'a']--;
      }
      return anagramIndices;
  }
}
