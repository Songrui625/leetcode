package 递归.lc94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    List<Integer> list = new ArrayList<>();
    //递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

    //迭代写法
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return list;
//        }
//        TreeNode p = root;
//        int[] stack = new int[100];
//        int top = 0;
//        stack[top++] = p.val;
//        while (stack[top] != 0) {
//            while (p.left != null) {
//                stack[top++] = p.val;
//                p = p.left;
//            }
//        }
//    }
}
