package stack;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/submissions/996678559/
 */

public class LeetCode_445_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> st1 = new ArrayDeque<>();
        ArrayDeque<Integer> st2 = new ArrayDeque<>();

        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
            int v1 = (!st1.isEmpty()) ? st1.pop() : 0;
            int v2 = (!st2.isEmpty()) ? st2.pop() : 0;

            int sum = v1 + v2 + carry;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;

            carry = sum / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }
}
