package leetcode.problems;

import java.util.Map;

public class A273_Integer_to_English_Words {
    final String[] units = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] tens1 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] tens2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final int billion = 1000000000;
    final int million = 1000000;
    final int thousand = 1000;
    final int hundred = 100;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int k;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= billion) {
                k = num / billion;
                res.append(units[k]).append(" Billion ");
                num -= k * billion;
            } else if (num >= million) {
                k = num / million;
                res.append(numberToWords(k)).append(" Million ");
                num -= k * million;
            } else if (num >= thousand) {
                k = num / thousand;
                res.append(numberToWords(k)).append(" Thousand ");
                num -= k * thousand;
            } else if (num >= hundred) {
                k = num / hundred;
                res.append(units[k]).append(" Hundred ");
                num -= k * hundred;
            } else if (num >= 20) {
                k = num / 10;
                res.append(tens2[k]).append(" ");
                num -= k * 10;
            } else if (num >= 10) {
                num -= 10;
                res.append(tens1[num]).append(" ");
                break;
            } else {
                res.append(units[num]).append(" ");
                break;
            }
        }
        if (res.charAt(res.length() - 1) == ' ') res.setLength(res.length() - 1);
        return res.toString();
    }
}
