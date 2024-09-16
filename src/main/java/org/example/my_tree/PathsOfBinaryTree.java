package org.example.my_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathsOfBinaryTree {

    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<StringBuilder> pathStack = new Stack<>(); // Стек для хранения StringBuilder для каждого пути

        stack.push(root);
        pathStack.push(new StringBuilder().append(root.val)); // Начинаем с корня

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            StringBuilder path = pathStack.pop();

            if (node.left == null && node.right == null) {
                answer.add(path.toString()); // Если достигли листа, добавляем путь в результат
                continue; // Пропускаем остальную часть цикла, идем на следующую итерацию
            }

            if (node.right != null) {
                stack.push(node.right);
                pathStack.push(new StringBuilder(path).append("->").append(node.right.val));
            }

            if (node.left != null) {
                stack.push(node.left);
                pathStack.push(new StringBuilder(path).append("->").append(node.left.val));
            }
        }

        return answer;
    }


}

class Solution {
    public static void main(String[] args) {
        PathsOfBinaryTree paths = new PathsOfBinaryTree();
//        paths.root = new PathsOfBinaryTree.TreeNode(1, new PathsOfBinaryTree.TreeNode(2), new PathsOfBinaryTree.TreeNode(3));
//        PathsOfBinaryTree.TreeNode tmp = paths.root;
//        tmp.left.left = new PathsOfBinaryTree.TreeNode(5);
//        tmp.left.right = new PathsOfBinaryTree.TreeNode(6);

        paths.root = new PathsOfBinaryTree.TreeNode(1, new PathsOfBinaryTree.TreeNode(), new PathsOfBinaryTree.TreeNode(4));
        PathsOfBinaryTree.TreeNode tmp = paths.root;
        tmp.right.left = new PathsOfBinaryTree.TreeNode(3);
        tmp.right.left.left= new PathsOfBinaryTree.TreeNode(2);
        tmp.right.right = new PathsOfBinaryTree.TreeNode(5);
        tmp.right.right.right=new PathsOfBinaryTree.TreeNode(6);

        List<String> res = paths.binaryTreePaths(paths.root);
        for (String re : res) {
            System.out.println(re);
        }
    }

}