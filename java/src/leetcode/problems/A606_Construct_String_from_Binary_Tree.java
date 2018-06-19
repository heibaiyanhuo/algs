package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A606_Construct_String_from_Binary_Tree {


    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        preorder(t, res);
        return res.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left != null) {
            sb.append("(");
            preorder(node.left, sb);
            sb.append(")");
        } else if (node.right != null) {
            sb.append("()");
        }
        if (node.right != null) {
            sb.append("(");
            preorder(node.right, sb);
            sb.append(")");
        }
    }
}
