package leetcode.problems;

import leetcode.datastructures.Point;

import java.util.HashMap;
import java.util.Map;

public class A149_Max_Points_on_a_Line {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int result = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            int max = 0;
            int overlap = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int offsetX = points[j].x - points[i].x;
                int offsetY = points[j].y - points[i].y;
                if (offsetX == 0 && offsetY == 0) {
                    overlap++;
                    continue;
                }
                int d = gcd(offsetX, offsetY);
                offsetX /= d;
                offsetY /= d;
                String key = offsetX + "," + offsetY;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
