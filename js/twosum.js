
const twosum = (nums, target) => {
    nums.sort()
    let left = 0
    let right = nums.length - 1
    while (left < right) {
        let sum = nums[left] + nums[right]
        if(sum > target) {
            --right
        }else if (sum < target) {
            ++left
        }else {
            return [nums[left], nums[right]]
        }
    }
    return []
}

console.log(twosum([1,2,3,4], 5))