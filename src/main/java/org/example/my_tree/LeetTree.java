package org.example.my_tree;


import java.util.*;

class Solutions2 {

    public static class LeetTree {
        public static class TreeNode {
            Integer val;
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

        TreeNode root;

        public void add(int x) {
            TreeNode tmp = new TreeNode(x);
            TreeNode y = root;
            if (root == null) root = tmp;
            else {
                while (y.left != null || y.right != null) {
                    if (tmp.val > y.val) y = y.right;
                    else if (tmp.val < y.val) y = y.left;
                    else return;
                }
                if (tmp.val > y.val) {
                    System.out.println("Right tmp " + tmp.val + " y " + y.val);
                    y.right = tmp;
                } else {
                    System.out.println("Left tmp " + tmp.val + " y " + y.val);
                    y.left = tmp;
                }
            }
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            boolean result = (p.val == q.val);
            if (!result) return false;
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return (left && right);
        }

        private int getHeight(TreeNode node) {
            if (node == null) return 0;
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            if (left > right) return left + 1;
            else return right + 1;
        }

        public int height() {
            LeetTree.TreeNode tmp = root;
            return getHeight(tmp);
        }

        public boolean forS(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            boolean result = (p.val == q.val);
            if (!result) return false;
            boolean left = forS(p.left, q.right);
            boolean right = forS(p.right, q.left);
            return (left && right);
        }

        public boolean isSymmetric(TreeNode root) {
            return forS(root.left, root.right);
        }

        public boolean isBalanced(TreeNode root) {
            if (root != null) {
                int balance = getHeight(root.left) - getHeight(root.right);
                if (balance > 1 || balance < -1) return false;
                return isBalanced(root.left) && isBalanced(root.right);
            }
            return true;
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
                System.out.print(current.val + " ");
                current = current.right;
            }
            System.out.println();
        }

        public void print(TreeNode x) {
            if (x != null) {
                System.out.print(x.val + " ");
                print(x.left);
                print(x.right);
            }
        }

        public List<Integer> recWay(TreeNode x, int count, List<Integer> a) {
            if (x != null) {
                count++;
                if (x.left == null && x.right == null) a.add(count);
                recWay(x.left, count, a);
                recWay(x.right, count, a);
            }
            return a;
        }

        public int maxDepth(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            r = recWay(root, 0, r);
            if (root == null) return 0;
            int max = r.get(0);
            for (int res : r) {
                if (max < res) max = res;
            }
            return max;
        }

        public int minDepth(TreeNode root) {
            List<Integer> r = new ArrayList<>();
            r = recWay(root, 0, r);
            if (root == null) return 0;
            int min = r.get(0);
            for (int res : r) {
                if (min > res) min = res;
            }
            return min;
        }

        public List<Integer> recSum(TreeNode x, int sum, List<Integer> a) {
            if (x != null) {
                sum = sum + x.val;
                if (x.left == null && x.right == null) a.add(sum);
                recSum(x.left, sum, a);
                recSum(x.right, sum, a);
            }
            return a;
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            List<Integer> s = new ArrayList<>();
            s = recSum(root, 0, s);
            for (int a : s) {
                if (a == targetSum) return true;
            }
            return false;
        }

        public void amountThread(TreeNode x, int sum, List<Integer> currentPath, List<List<Integer>> allPaths,
                                 int targetSum) {
            if (x != null) {
                sum = sum + x.val;
                currentPath.add(x.val);
                if (x.left == null && x.right == null) {
                    if (sum == targetSum) allPaths.add(new ArrayList<>(currentPath));
                } else {
                    amountThread(x.left, sum, currentPath, allPaths, targetSum);
                    amountThread(x.right, sum, currentPath, allPaths, targetSum);
                }
                currentPath.remove(currentPath.size() - 1); // удаляем последний элемент-лист, для прохода дальше
            }
        }

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            List<Integer> currentPath = new ArrayList<>();
            amountThread(root, 0, currentPath, allPaths, targetSum);
            return allPaths;
        }

        public void amountNumbers(TreeNode x, StringBuilder currentNumber, List<Integer> allNumbers) {
            int last;
            if (x != null) {
                currentNumber.append(x.val);
                last = String.valueOf(x.val).length();
                if (x.left == null && x.right == null) allNumbers.add(Integer.parseInt(currentNumber.toString()));
                else {
                    amountNumbers(x.left, currentNumber, allNumbers);
                    amountNumbers(x.right, currentNumber, allNumbers);
                }
                currentNumber.delete(currentNumber.length() - last, currentNumber.length());
                // удаляем последний элемент-лист, для прохода дальше
            }
        }

        public int sumNumbers(TreeNode root) {
            List<Integer> allNumbers = new ArrayList<>();
            StringBuilder currentNumber = new StringBuilder();
            amountNumbers(root, currentNumber, allNumbers);
            int sum = 0;
            for (Integer allNumber : allNumbers) {
                sum += allNumber;
            }
            return sum;
        }

        public void flatten(TreeNode root) {
            if (root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            TreeNode tmp = root;
            while (tmp != null || stack.size() > 0) {
                while (tmp != null) {
                    stack.push(tmp);
                    deque.add(tmp);
                    tmp = tmp.left;
                }
                tmp = stack.pop();
                tmp = tmp.right;
            }
            tmp = root;
            while (tmp != null || deque.size() > 0) {
                tmp.right = deque.pollFirst();
                tmp.left = null;
                tmp = tmp.right;
            }
        }

        public int sumR(TreeNode root, int low, int high, int sum) {
            TreeNode tmp = root;
            if (tmp != null) {
                if (tmp.val >= low && tmp.val <= high) sum = sum + tmp.val;
                sum = sumR(tmp.left, low, high, sum);
                sum = sumR(tmp.right, low, high, sum);
            }
            return sum;
        }

        public int rangeSumBST(TreeNode root, int low, int high) {
            return sumR(root, low, high, 0);
        }

        public void widePassage() {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode x = this.root;
            queue.add(x);
            while (!queue.isEmpty()) {
                TreeNode y = queue.poll();
                if (y != null) {
                    System.out.print(y.val + " ");
                    queue.add(y.left);
                    queue.add(y.right);
                }
            }
        }

        public void copyToList(TreeNode x, List<Integer> a) {
            if (x != null) {
                copyToList(x.left, a);
                a.add(x.val);
                copyToList(x.right, a);
            }
        }

        public TreeNode printArr(List<Integer> a, int left, int right) {
            if (left > right) return null;
            int q = left + (right - left) / 2;
            TreeNode node = new TreeNode(a.get(q));
            node.left = printArr(a, left, q - 1);
            node.right = printArr(a, q + 1, right);
            return node;
        }

        public TreeNode balanceBST(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            copyToList(root, res);
            return printArr(res, 0, res.size() - 1);
        }

        public TreeNode search(int key) {
            TreeNode tmp = root;
            while (tmp != null && tmp.val != key) {
                if (tmp.val > key) tmp = tmp.left;
                else tmp = tmp.right;
            }
            return tmp;
        }

        public void copyTreeNodeToList(TreeNode x, List<TreeNode> a) {
            if (x != null) {
                copyTreeNodeToList(x.left, a);
                a.add(x);
                copyTreeNodeToList(x.right, a);
            }
        }

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> way = new ArrayList<>();
            List<TreeNode> answer = new ArrayList<>();
            TreeNode tmp = root;
            TreeNode x = root;
            copyTreeNodeToList(tmp, way);
            boolean dRoot = false;
            for (int iter : to_delete) {
                for (int i = 0; i < way.size(); i++) {
                    if (x.val == iter && way.get(i).val == iter) {
                        TreeNode xRoot = way.get(i);
                        if (xRoot.left != null) answer.add(xRoot.left);
                        if (xRoot.right != null) answer.add(xRoot.right);
                        dRoot = true;
                    }

                    if (way.get(i).left != null && way.get(i).left.val != null && iter == way.get(i).left.val) {
                        TreeNode xRoot = way.get(i);
                        TreeNode target = way.get(i).left;
                        if (!answer.contains(x) && !dRoot) answer.add(x);
                        if (target.left != null) answer.add(target.left);
                        if (target.right != null) answer.add(target.right);
                        answer.remove(target);
                        if (xRoot.left.equals(target)) xRoot.left = null;
                        if (xRoot.right.equals(target)) xRoot.right = null;
                    }
                    if (way.get(i).right != null && way.get(i).right.val != null && iter == way.get(i).right.val) {

                        TreeNode xRoot = way.get(i);
                        TreeNode target = way.get(i).right;
                        if (!answer.contains(x) && !dRoot) answer.add(x);
                        if (target.left != null) answer.add(target.left);
                        if (target.right != null) answer.add(target.right);

                        answer.remove(target);
                        if (xRoot.left != null && xRoot.left.equals(target)) xRoot.left = null;
                        if (xRoot.right.equals(target)) xRoot.right = null;
                    }
                }
                if (x.val == iter) answer.remove(x);
            }
            return answer;
        }

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            copyToList(root, list);
            return list.get(k - 1);
        }

        public TreeNode printNode(TreeNode x, List<TreeNode> answer, Set<Integer> toDelete) {
            if (x == null) return null;
            x.left = printNode(x.left, answer, toDelete);
            x.right = printNode(x.right, answer, toDelete);
            if (toDelete.contains(x.val)) {
                if (x.left != null)
                    answer.add(x.left);
                if (x.right != null)
                    answer.add(x.right);
                return null;
            }
            return x;
        }

        public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
            List<TreeNode> answer = new ArrayList<>();
            Set<Integer> toDelete = new HashSet<>();
            for (int numb : to_delete)
                toDelete.add(numb);
            printNode(root, answer, toDelete);
            if (!toDelete.contains(root.val))
                answer.add(root);
            return answer;
        }

        public int copyToArray(TreeNode x, int[] a, int index) {
            if (x != null) {
                a[index] = x.val;
                index++;
                index = copyToArray(x.left, a, index);
                index = copyToArray(x.right, a, index);
            }
            return index;
        }

    }
    public static void main(String[] args) throws InterruptedException {
        LeetTree leetTree = new LeetTree();

        leetTree.root = new LeetTree.TreeNode(5, new LeetTree.TreeNode(3), new LeetTree.TreeNode(6));
        LeetTree.TreeNode tmp = leetTree.root;
//        tmp.left = new LeetTree.TreeNode(9);
        tmp.left.left = new LeetTree.TreeNode(2);
        tmp.left.right = new LeetTree.TreeNode(4);
        tmp.left.left.left = new LeetTree.TreeNode(1);
//        tmp.left.left.right = new LeetTree.TreeNode(2);
//        tmp.left.right = new LeetTree.TreeNode();
//        tmp.right = new LeetTree.TreeNode(6);
//        tmp.right.left = new LeetTree.TreeNode(6);
//        tmp.right.right = new LeetTree.TreeNode(4);
//        tmp.right.right.right = new LeetTree.TreeNode(4);
//        tmp.right.right.left = new LeetTree.TreeNode(7);
//        System.out.println(leetTree.hasPathSum(tmp, 13));
//        List<List<Integer>> res = leetTree.pathSum(tmp, 22);
//        leetTree.flatten(tmp);
//        leetTree.add(1);
//        leetTree.add(2);
//        leetTree.add(3);
//        leetTree.add(4);
//        leetTree.loopPrint();
        leetTree.widePassage();
        System.out.println();
        int[] a = new int[6];
        leetTree.copyToArray(tmp, a, 0);
        System.out.println(Arrays.toString(a));


    }
}