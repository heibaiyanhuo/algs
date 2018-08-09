package leetcode.problems;

public class A258_Add_Digits {

    public int addDigits(int num) {
//        if (num == 0) {
//            return 0;
//        }
//        int res = num % 9;
//        return res == 0 ? 9 : res;
        return (num - 1) % 9 + 1;
    }
}
