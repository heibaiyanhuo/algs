/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */




const largestRectangleArea = (heights) => {
    // Different from LC11. Container with most water
    let maxArea = 0;
    let monoStack = [];
    for (let i = 0; i < heights.length; i++) {
        while (monoStack.length > 0 && heights[i] < heights[monoStack[monoStack.length - 1]]) {
            let idx = monoStack.pop();
            let left = monoStack.length > 0 ? monoStack[monoStack.length - 1] : -1; 
            maxArea = Math.max(maxArea, (i - left - 1) * heights[idx]);
        }
        monoStack.push(i);
    }
    return maxArea;
}

console.log(largestRectangleArea([2,1,5,6,2,3]))