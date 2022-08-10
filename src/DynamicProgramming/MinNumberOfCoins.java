package DynamicProgramming;

import java.util.Arrays;

public class MinNumberOfCoins {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(135, new int[]{39,45,130,40,4,1,60,75}));
    }

    private static int ways = 0;

    public static int recNumWays(int n, int[] denoms) {
        if (n == 0) {
            return 1;
        }
        for (int i = denoms.length-1; i >= 0; i--) {
            if (n >= denoms[i]) {
                int rem = n - denoms[i];
                if (rem == 0) {
                    return 1;
                } else {
                    return 1 + recNumWays(rem, denoms);
                }
            }
        }
        return 0;
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        Arrays.sort(denoms);
        return recNumWays(n, denoms);
    }

//    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
//        // Write your code here.
//        Arrays.sort(denoms);
//        Map<Integer, Integer> prevResults = new HashMap<>();
//        for (int i=denoms.length-1; i>=0; i--) {
//            int remainder = n - denoms[i];
//            if (remainder == 0) {
//                return 1;
//            } else if (remainder < 0) {
//                continue;
//            } else {
//                Integer result = prevResults.getOrDefault(remainder, 0);
//                prevResults.put(result, )
//            }
//        }
//        return -1;
//    }
}