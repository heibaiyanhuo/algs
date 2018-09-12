package leetcode.problems;



import leetcode.datastructures.NestedInteger;

import java.util.List;

public class A339_Nested_List_Weight_Sum {

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> lst, int depth) {
        int sum = 0;
        for (NestedInteger ni: lst) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
