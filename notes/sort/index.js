a = [2,4,3,6,3,0,7,4,8,9,2,5]
// a = [3, 2, 1]

const swap = (numbers, i , j) => {
    let temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
}

const insertSort = (numbers) => {
    for (let i = 1; i < numbers.length; i++) {
        for (let j = i; j > 0 && numbers[j] < numbers[j - 1]; j--) {
            swap(numbers, j, j - 1);
        }
    }
    return numbers;
}


const shellSort = (numbers) => {

}


console.log(insertSort(a));
