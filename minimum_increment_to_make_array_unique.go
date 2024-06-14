func minIncrementForUnique(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    
    sort.Ints(nums)
    
    moves := 0
    for i := 1; i < len(nums); i++ {
        if nums[i] <= nums[i-1] {
            increment := nums[i-1] - nums[i] + 1
            nums[i] += increment
            moves += increment
        }
    }
    
    return moves
}
