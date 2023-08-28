package stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/submissions/1034101079/
 */
public class LeetCode_225_ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
            for(int i = 0 ; i < queue.size() - 1 ; i ++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
