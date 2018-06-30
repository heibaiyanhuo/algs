package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A095_Unique_Binary_Search_Trees_II {

    private List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> lst = new ArrayList<>();

        if (start > end) {
            lst.add(null);
            return lst;
        }
        if (start == end) {
            lst.add(new TreeNode(start));
            return lst;
        }

        List<TreeNode> leftLst;
        List<TreeNode> rightLst;

        for (int i = start; i <= end; i++) {
            leftLst = helper(start, i - 1);
            rightLst = helper(i + 1, end);

            for (TreeNode lNode: leftLst) {
                for (TreeNode rNode: rightLst) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    lst.add(root);
                }
            }

        }

        return lst;
    }


}
