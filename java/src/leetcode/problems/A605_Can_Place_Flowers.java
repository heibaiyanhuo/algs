package leetcode.problems;

public class A605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        boolean prev0 = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (prev0) {
                    if (i == flowerbed.length - 1) {
                        return --n <= 0;
                    }
                    if (flowerbed[i + 1] == 0) {
                        n--;
                        if (n == 0) return true;
                    } else {
                        i++;
                    }
                    prev0 = false;
                } else {
                    prev0 = true;
                }
            } else {
                prev0 = false;
            }
        }
        return false;
    }
}
