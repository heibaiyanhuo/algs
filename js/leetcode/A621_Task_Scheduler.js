/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.
 */

const leastInterval = (tasks, n) => {
    let map = new Array(26).fill(0);
    for (let task of tasks) {
        map[task.charCodeAt() - 65]++;
    }

    let count = 0;
    for (let i = 0; i < 26; i++) {
        count = Math.max(count, map[i]);
    }
    let ans = (n + 1) * (count - 1);
    for (let i = 0; i < 26; i++) {
        if (map[i] === count) ans++;
    }
    return Math.max(tasks.length, ans);
}