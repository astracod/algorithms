package org.example.my_tree;

import java.util.*;

public class BST_Tree {
    public static class TreeNode {
        TreeNode parent;
        Integer key;
        TreeNode left, right;

        TreeNode(int value) {
            key = value;
            parent = null;
            left = null;
            right = null;
        }

        public TreeNode() {
        }

        TreeNode(int key, TreeNode left, TreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

    }

    TreeNode root;
    int size = 0;

    BST_Tree() {
        root = null;
    }

    public void add(Integer key) {
        TreeNode x = root;
        TreeNode y = null;
        TreeNode tmp = new TreeNode(key);
        while (x != null) {
            y = x;
            if (tmp.key > x.key) x = x.right;
            else if (tmp.key < x.key) x = x.left;
            else return;
        }
        tmp.parent = y;
        if (root == null) root = tmp;
        else {
            if (tmp.key > y.key) y.right = tmp;
            else y.left = tmp;
        }
        size++;
    }

    public TreeNode search(int key) {
        TreeNode tmp = root;
        while (tmp != null && tmp.key != key) {
            if (tmp.key > key) tmp = tmp.left;
            else tmp = tmp.right;
        }
        return tmp;
    }

    public TreeNode findMin() {
        TreeNode tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    void transplant(TreeNode u, TreeNode v) {
        if (v != null) v.parent = u.parent;
        if (u.parent == null) root = v;
        else {
            if (u.parent.right == u) u.parent.right = v;
            else u.parent.left = v;
        }
    }

    public void remove(int value) {
        TreeNode z = search(value);
        if (z == null) return;
        if (z.left == null) transplant(z, z.right);
        else if (z.right == null) transplant(z, z.left);
        else {
            TreeNode y = findMin(z.right);
            if (y.parent != z) {
                transplant(y, y.right);
                y.right = z.right;
                z.right.parent = y;
            }
            y.left = z.left;
            z.left.parent = y;
            transplant(z, y);
        }
        size--;
    }

    public void write() {
        print(this.root);
        System.out.println();
    }

    public void print(TreeNode x) {
        if (x != null) {
            print(x.left);
            System.out.print(x.key + " ");
            print(x.right);
        }
    }

    public void loopPrint() {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = this.root;
        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }
        System.out.println();
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left > right) return left + 1;
        else return right + 1;
    }

    public int height() {
        TreeNode tmp = root;
        return getHeight(tmp);
    }

    public void showLeaves() {
        Stack<TreeNode> s = new Stack<>();
        Set<Integer> answer = new HashSet<>();
        TreeNode current = this.root;
        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                if (current.left == null && current.right == null) answer.add(current.key);
                current = current.left;
            }
            current = s.pop();
            if (current.left == null && current.right == null) answer.add(current.key);
            current = current.right;
        }
        System.out.println(answer);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e)
            return null;
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, s, mid - 1);
        node.right = helper(nums, mid + 1, e);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        return helper(nums, 0, n - 1);
    }

}

class Solutions {
    // -10, -3, 0, 5, 9 -- 0,-3,9,-10,null,5 -- 0,-10,5,null,-3,null,9
    public static void main(String[] args) {
        BST_Tree tree = new BST_Tree();

        int[] nums = new int[]{-10, -3, 0, 5, 9};
        BST_Tree.TreeNode node = tree.sortedArrayToBST(nums);
        tree.root = new BST_Tree.TreeNode(1);
        BST_Tree.TreeNode tmp = tree.root;
        tmp.right = new BST_Tree.TreeNode(2);
        tmp.left = new BST_Tree.TreeNode();
        tmp.right.right = new BST_Tree.TreeNode(3);
        tmp.left.left = new BST_Tree.TreeNode();
        tmp.right.right.right = new BST_Tree.TreeNode(4);
        tmp.left.left.left = new BST_Tree.TreeNode();
        tree.loopPrint();


    }
}