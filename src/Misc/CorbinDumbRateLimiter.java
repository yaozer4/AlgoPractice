package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorbinDumbRateLimiter {
    public static void main(String[] args) {
        Limiter limiter = new Limiter();
        System.out.println(limiter.allowRequest(2, 1));
        System.out.println(limiter.allowRequest(2, 2));
        System.out.println(limiter.allowRequest(2, 3));
        System.out.println(limiter.allowRequest(2, 4));
        System.out.println(limiter.allowRequest(2, 5));
        System.out.println(limiter.allowRequest(2, 6));
        System.out.println(limiter.allowRequest(2, 7));
        System.out.println(limiter.allowRequest(2, 8));
        System.out.println(limiter.allowRequest(2, 9));
        System.out.println(limiter.allowRequest(2, 12));
        System.out.println(limiter.allowRequest(2, 13));
        System.out.println(limiter.allowRequest(2, 23));
        System.out.println(limiter.allowRequest(2, 43));
    }

    static class Limiter {
        Map<Integer, List<Integer>> idToTime = new HashMap<>();
        int TIME_LIMIT = 10;
        int NUM_TIMES = 2;

        boolean allowRequest(int id, int timestamp) {
            List<Integer> lastTimes = idToTime.getOrDefault(id, new ArrayList<>());
            if (lastTimes.size() < NUM_TIMES) {
                lastTimes.add(timestamp);
                idToTime.put(id, lastTimes);
                return true;
            } else {
                boolean allow = false;
                for (int time: lastTimes) {
                    allow = timestamp - time >= TIME_LIMIT;
                }
                if (allow) {
                    lastTimes.remove(0);
                    lastTimes.add(timestamp);
                    idToTime.put(id, lastTimes);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
