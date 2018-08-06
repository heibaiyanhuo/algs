package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A450_Delete_Node_in_a_BST {

    private TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode target = root;
        TreeNode parent = dummy;
        boolean fromLeft = true;
        while (target != null) {
            if (target.val == key) {
                break;
            }
            parent = target;
            if (target.val > key) {
                target = target.left;
                fromLeft = true;
            } else {
                target = target.right;
                fromLeft = false;
            }
        }
        if (target != null) {
            deleteNode(target, parent, fromLeft);
        }

        return dummy.left;
    }

    private void deleteNode(TreeNode target, TreeNode parent, boolean fromLeft) {
        if (target.left != null) {
            TreeNode node = target.left;
            if (node.right == null) {
                target.val = node.val;
                deleteNode(node, target, true);
            } else {
                while (node.right != null) {
                    parent = node;
                    node = node.right;
                }
                target.val = node.val;
                deleteNode(node, parent, false);
            }
        } else if (target.right != null) {
            TreeNode node = target.right;
            if (node.left == null) {
                target.val = node.val;
                deleteNode(node, target, false);
            } else {
                while (node.left != null) {
                    parent = node;
                    node = node.left;
                }
                target.val = node.val;
                deleteNode(node, parent, true);
            }

        } else {
            if (fromLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

    }


    private TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null ) {
                return root.left;
            }

            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            root.val = node.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
}
