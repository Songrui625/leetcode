package 递归.lc589_N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    public Node traverse(Node root) {
        if (root == null) return root;
        else {
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                traverse(root.children.get(i));
            }
        }
        return root;
    }
}
