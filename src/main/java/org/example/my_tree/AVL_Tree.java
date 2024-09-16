package org.example.my_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVL_Tree {
    static class TreeNode {
        TreeNode parent;
        Integer key;
        Integer height;
        TreeNode left, right;

        TreeNode(int value) {
            key = value;
            height = 1;
            parent = null;
            left = null;
            right = null;
        }

        public TreeNode() {
        }
    }

    TreeNode root;
    int size = 0;

    AVL_Tree() {
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
        balancing(tmp.parent);
    }

    public TreeNode search(int key) {
        TreeNode tmp = root;
        while (tmp != null && tmp.key != key) {
            if (tmp.key > key) tmp = tmp.left;
            else tmp = tmp.right;
        }
        return tmp;
    }

    public void transplant(TreeNode u, TreeNode v) {
        if (v != null) v.parent = u.parent;
        if (u.parent == null) root = v;
        else {
            if (u.parent.right == u) u.parent.right = v;
            else u.parent.left = v;
        }
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void remove(int key) {
        TreeNode tmp;
        TreeNode z = search(key);
        if (z == null) return;
        if (z.left == null) {
            tmp = z.parent;
            transplant(z, z.right);
        } else if (z.right == null) {
            tmp = z.parent;
            transplant(z, z.left);
        } else {
            TreeNode y = findMin(z.right);
            if (y.parent != z) {
                tmp = y.parent;
                transplant(y, y.right);
                y.right = z.right;
                z.right.parent = y;
            } else
                tmp = y;
            y.left = z.left;
            z.left.parent = y;
            transplant(z, y);
        }
        balancing(tmp);
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (left > right) return left + 1;
        else return right + 1;
    }

    int getBalance(TreeNode tmp) {
        return height(tmp.left) - height(tmp.right);
    }

    public void balancing(TreeNode x) {
        while (x != null) {
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            int balance = getBalance(x);
            if (balance == -2) {
                if (getBalance(x.right) == 1)
                    rightRotate(x.right);
                leftRotate(x);
            } else if (balance == 2) {
                if (getBalance(x.left) == -1)
                    leftRotate(x.left);
                rightRotate(x);
            }
            x = x.parent;
        }
    }

    void rightRotate(TreeNode x) {
        TreeNode y = x.left;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        x.left = y.right;
        if (x.right != null) x.right.parent = x;
        y.right = x;
        x.parent = y;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
    }

    void leftRotate(TreeNode x) {
        TreeNode y = x.right;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        x.right = y.left;
        if (y.right != null) y.right.parent = y;
        y.left = x;
        x.parent = y;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
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

    public void widePassage() {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode x = this.root;
        queue.add(x);
        while (!queue.isEmpty()) {
            TreeNode y = queue.poll();
            if (y != null) {
                System.out.print(y.key + " ");
                queue.add(y.left);
                queue.add(y.right);
            }
        }
    }

}

class AVLSolutions {

    public static void main(String[] args) {
        AVL_Tree avl_tree = new AVL_Tree();
        avl_tree.root = new AVL_Tree.TreeNode(1);
        AVL_Tree.TreeNode tmp = avl_tree.root;
        tmp.right = new AVL_Tree.TreeNode(2);
        tmp.left = new AVL_Tree.TreeNode();
        tmp.right.right = new AVL_Tree.TreeNode(3);
        tmp.left.left = new AVL_Tree.TreeNode();
        tmp.right.right.right = new AVL_Tree.TreeNode(4);
        tmp.left.left.left = new AVL_Tree.TreeNode();
        avl_tree.loopPrint();

    }

}