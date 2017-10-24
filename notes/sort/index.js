// 定义数组
a1 = [2,4,3,6,3,0,7,4,8,9,2,5,2,3,4,4,6,2,4,0,2,3,4,5,6,7,8,8,2,2]

a2 = ((n) => {
    let result = [];
    for (let i = 0; i < n; i++) {
        result[i] = Math.floor(Math.random()*1000);
    }
    return result;
})(1000000);

a3 = [5,6,7,8,9,2,3,4,5,6,7,8]

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
            // for (let j = i; j >= h && numbers[j] < numbers[j - h]; j -= h) {
            //     swap(numbers, j, j - h);
            // }
            let toBeInserted = numbers[i], j = i;
            while (j >= h && toBeInserted < numbers[j - h]) {
                numbers[j] = numbers[j - h];
                j -= h;
            }
            numbers[j] = toBeInserted;
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

const MergeSort = class {

    constructor(nums) {
        this.nums = nums;
    }
    
    // 自顶向下
    sort1() {
        this.aux = new Array(this.nums.length);
        this._sort(this.nums, 0, this.nums.length - 1);
    }

    _sort(a, lo, hi) {
        if (hi <= lo) return;
        let mid = Math.floor((lo + hi)/2);
        this._sort(a, lo, mid);
        this._sort(a, mid + 1, hi);
        this._merge(a, lo, mid, hi);
    }

    // 自底向上
    sort2() {
        let N = this.nums.length;
        this.aux = new Array(N);
        for (let sz = 1; sz < N; sz = sz + sz) {
            for (let lo = 0; lo < N - sz; lo += sz + sz) {
                this._merge(this.nums, lo, lo + sz - 1, Math.min(N - 1, lo + sz + sz - 1))
            }
        }
    }

    _merge(a, lo, mid, hi) {
        let i = lo, j = mid + 1;

        for (let k = lo; k <= hi; k++) {
            this.aux[k] = a[k];
        }

        for (let k = lo; k <= hi; k++) {
            if (i > mid) a[k] = this.aux[j++];
            else if (j > hi) a[k] = this.aux[i++];
            else if (this.aux[j] < this.aux[i]) a[k] = this.aux[j++];
            else a[k] = this.aux[i++]
        }
    }
}


// =====================================================================================

// 测试

// selectSort(a1);
// insertSort(a1);
// shellSort(a1);
// getRuntime(insertSort1, a1);
// getRuntime(insertSort1, a2);
// getRuntime(shellSort, a2);
new MergeSort(a1).sort2();
console.log(a1);
