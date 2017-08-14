/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

var maxArea = function(height) {
    let from = 0, to = height.length - 1;
    let area = 0;
    while (from < to) {
        area = Math.max(area, (to - from) * Math.min(height[from], height[to]));
        if (height[from] > height[to]) {
            to--;
        } else {
            from++;
        }
    }
    return area;
};