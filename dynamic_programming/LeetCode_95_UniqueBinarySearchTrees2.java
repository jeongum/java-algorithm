package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/submissions/1012643452/
 */

public class LeetCode_95_UniqueBinarySearchTrees2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class StartEnd {
        int start;
        int end;
        StartEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Map<StartEnd, List<TreeNode>> memo = new HashMap<>();

    public static List<TreeNode> treesStartToEnd(int start, int end) {
        List<TreeNode> tn = new ArrayList<>();
        if (start > end) {
            tn.add(null);
            return tn;
        }
        if (start == end) {
            tn.add(new TreeNode(start));
            return tn;
        }

        if (memo.containsKey(new StartEnd(start, end))) {
            return memo.get(new StartEnd(start, end));
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = treesStartToEnd(start, i - 1);
            List<TreeNode> right = treesStartToEnd(i + 1, end);
            for(TreeNode l: left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    tn.add(root);
                }
            }
        }

        memo.put(new StartEnd(start, end), tn);
        return tn;
    }

    public static List<TreeNode> generateTrees(int n) {
        return treesStartToEnd(1, n);
    }

    public static void main(String[] args) throws Exception {
        List<TreeNode> solution = generateTrees(3);
        System.out.println(solution);
    }
}
