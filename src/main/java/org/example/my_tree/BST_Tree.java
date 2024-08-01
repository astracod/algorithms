package org.example.my_tree;

public class BST_Tree {
    static class TreeNode {
        TreeNode parent;
        Integer key;
        TreeNode left, right;

        TreeNode(int value) {
            key = value;
            parent = null;
            left = null;
            right = null;
        }
    }

    TreeNode root;
    int size = 0;

    BST_Tree() {
        root = null;
    }

    public void add(Integer key) {
        TreeNode y = root;
        TreeNode x = new TreeNode(key);
        if (root == null) root = x;
        else {
            TreeNode tmp = y;
            if (x.key > y.key) {
                while (tmp.right != null)
                    tmp = tmp.right;
                tmp.right = x;
            } else {
                while (tmp.left != null)
                    tmp = tmp.left;
                tmp.left = x;
            }
            x.parent = tmp;
        }
        size++;
    }

    public void remove(int value) {
        TreeNode tmp = root;
        if (tmp.key == value && tmp.parent == null) {
            tmp.right.parent = null;
            root = tmp.right;
        }
        if (tmp.key < value) {
            while (tmp.right != null) {
                if (tmp.key == value && tmp.parent != null) {
                    tmp.right.parent = tmp.parent;
                    tmp.parent.right = tmp.right;
                }
                tmp = tmp.right;
            }
        }
        if (tmp.key == value && tmp.right == null) {
            tmp = tmp.parent;
            tmp.right = null;
        }
        size--;
    }

    public void print() throws InterruptedException {
        TreeNode tmp = root;
        while (tmp != null) {
            System.out.print(tmp.key + " ");
            tmp = tmp.right;
        }
        System.out.println();
    }

}

class Solutions {
    public static void main(String[] args) throws InterruptedException {
        BST_Tree tree = new BST_Tree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.print();
        tree.remove(3);
        tree.print();
        tree.remove(1);
        tree.print();
    }
}