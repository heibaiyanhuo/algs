const a = (length, points) => {
    let result = [];
    let path = {
        sequence: [],
        length: 0
    }
    backtrack(result, path, points, length);
    let max = result[0].length;
    for (let i = 1; i < result.length; i++) {
        if (result[i].length > max) max = result[i].length;
    }
    // console.log(result.reverse())
    return max;
}

const backtrack = (result, path, points, length) => {
    if ((path.length > 0 && path.length <= length) && path.sequence.length > 0 ) {
        let lastIdx = path.sequence[path.sequence.length - 1];
        let temp = pathLength(points[path.sequence[0]][0], points[path.sequence[0]][1], points[lastIdx][0], points[lastIdx][1]);
        if (temp + path.length <= length) {
            console.log(path)
            let t = path.sequence.slice();
            result.push(t);
        } else {
            return;
        }
    }
    for (let i = 0; i < points.length; i++) {
        if (!path.sequence.includes(i)) {
            if (path.sequence.length === 0) {
                path.sequence.push(i);
                backtrack(result, path, points, length);
                path.sequence.pop();
            } else {
                let lastIdx = path.sequence[path.sequence.length - 1];
                let temp = pathLength(points[lastIdx][0], points[lastIdx][1], points[i][0], points[i][1]);
                path.length += temp;
                path.sequence.push(i);
                backtrack(result, path, points, length);
                path.sequence.pop();
                path.length -= temp;
            }
        }
    }
}

const pathLength = (x1, y1, x2, y2) => {
    return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
}

console.log(a(20, [[0, 0], [0, 3], [3, 3], [2, 4], [9,2], [3,5], [2,8]]));