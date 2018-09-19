package leetcode.problems;

import leetcode.datastructures.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class A341_Flatten_Nested_List_Iterator {

    Deque<NestedInteger> stack = new ArrayDeque<>();

    public A341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        return stack.pop().getInteger();
    }
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
