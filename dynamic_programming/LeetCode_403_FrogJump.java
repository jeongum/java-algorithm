package dynamic_programming;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/frog-jump/submissions/1034072261/
 */
public class LeetCode_403_FrogJump {

    static HashMap<Integer, Integer> m = new HashMap<>();

    static boolean[][] dp;
    static boolean[][] visited;

    static public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] > 1) return false;
        for (int i = 0; i < stones.length; i++) {
            m.put(stones[i], i);
        }
        dp = new boolean[stones.length][stones.length];
        visited = new boolean[stones.length][stones.length];
        return dp(1, 1, stones);
    }

    static private boolean dp(int stone, int jump, int[] stones) {
        if (stone == stones.length - 1) return true;       // 끝까지 왔다면 True
        if (visited[stone][jump]) return dp[stone][jump];   // 들린적이 있다면, 해당 값 그대로 사용

        boolean canGo = false;
        for(int j : new int[]{jump - 1, jump, jump + 1}) {
            if(j > 0 && m.containsKey(stones[stone] + j)) {
                canGo = (canGo || dp(m.get(stones[stone] + j), j, stones));
            }
        }

        visited[stone][jump] = true;
        dp[stone][jump] = canGo;

        return dp[stone][jump];
    }

    public static void main(String[] args) throws Exception {
        boolean result = canCross(new int[]{0,1,3,5,6,8,12,17});
        System.out.println(result);
    }
}

