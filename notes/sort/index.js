// 定义数组
a = [2,4,3,6,3,0,7,4,8,9,2,5,2,3,4,4,6,2,4,0,2,3,4,5,6,7,8,8,2,2]

b = ((n) => {
    let result = [];
    for (let i = 0; i < n; i++) {
        result[i] = Math.floor(Math.random()*1000);
    }
    return result;
})(80000);

// =====================================================================================

// 通用方法
const swap = (numbers, i , j) => {
    let temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
}

const getRuntime = (func1, ...rest) => {
    console.time('Sort time');
    func1(rest[0]);
    console.timeEnd('Sort time');
}

// =====================================================================================

// 排序算法

// 2.1 初级排序算法
const selectSort = (numbers) => {
    for (let i = 0; i < numbers.length; i++) {
        let minIdx = i;
        for (let j = i + 1; j < numbers.length; j++) {
            if (numbers[j] < numbers[i]) minIdx = j;
        }
        swap(numbers, i, minIdx);
    }
}

const insertSort = (numbers) => {
    for (let i = 1; i < numbers.length; i++) {
        for (let j = i; j > 0 && numbers[j] < numbers[j - 1]; j--) {
            swap(numbers, j, j - 1);
        }
    }
}

const shellSort = (numbers) => {
    let h = 1, N = numbers.length;
    while (h < N/3) h = 3 * h + 1;
    while (h >= 1) {
        for (let i = h; i < N; i++) {
            for (let j = i; j >= h && numbers[j] < numbers[j - h]; j -= h) {
                swap(numbers, j, j - h);
            }
            // let toBeInserted = numbers[i], j = i;
            // while (j >= h && toBeInserted < numbers[j - h]) {
            //     numbers[j] = numbers[j - h];
            //     j -= h;
            // }
            // numbers[j] = toBeInserted;
        }
        h = Math.floor(h/3);
    }
}


// 2.1 练习

// 2.1.25
const insertSort1 = (numbers) => {
    for (let i = 1; i < numbers.length; i++) {
        let toBeInserted = numbers[i], j = i;
        while (j > 0 && toBeInserted < numbers[j - 1]) {
            numbers[j] = numbers[j - 1];
            j--;
        }
        numbers[j] = toBeInserted;
    }
}


// 2.2 归并排序



// =====================================================================================

// 测试

// selectSort(a);
// insertSort(a);
// shellSort(a);
// getRuntime(insertSort1, a);
// getRuntime(insertSort1, b);
getRuntime(shellSort, b);

// console.log(a);
