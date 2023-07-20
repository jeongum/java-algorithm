package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/asteroid-collision/submissions/999333697/
 */

public class LeetCode_735_AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (st.isEmpty() || asteroid > 0) {
                st.push(asteroid);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && Math.abs(asteroid) > st.peek()) {       // 스택 원소 제거
                    st.pop();
                }

                if (!st.isEmpty() && Math.abs(asteroid) == st.peek()) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                }
            }
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) result[i] = st.pop();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }
}
