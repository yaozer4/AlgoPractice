package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class NumWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(7, new int[]{2,3,4,7}));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        Map<Integer, Integer> compliments = new HashMap<>();
        compliments.put(0, 1);

        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    int rem = amount - denom;
                    Integer remainderWays = compliments.getOrDefault(rem, 0);
                    Integer amountWays = compliments.getOrDefault(amount, 0);
                    compliments.put(amount, remainderWays + amountWays);
                }
            }
        }

        return compliments.get(n);
    }
}