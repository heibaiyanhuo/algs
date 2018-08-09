package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A114_Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftLast = null;
        if (root.left != null) {
            flatten(root.left);
            leftLast = root.left;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
        }
        if (root.right != null) {
            flatten(root.right);
        }
        if (leftLast != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            leftLast.right = tmp;
        }
    }


}
