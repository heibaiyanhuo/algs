package leetcode.problems;

public class A012_Integer_to_Roman {



    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        String[] thousandInRoman = new String[]{"", "M", "MM", "MMM"};
        String[] hundredInRoman = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tenInRoman = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] oneInRoman = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousand = num / 1000;
        result.append(thousandInRoman[thousand]);

        num %= 1000;
        int hundred = num / 100;
        result.append(hundredInRoman[hundred]);

        num %= 100;
        int ten = num / 10;
        result.append(tenInRoman[ten]);

        num %= 10;
        int one = num;
        result.append(oneInRoman[one]);

        return result.toString();
    }

    public static void main(String[] args) {
        A012_Integer_to_Roman solution = new A012_Integer_to_Roman();
        System.out.println(solution.intToRoman(1994));
    }
}
