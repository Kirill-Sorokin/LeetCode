func countTriplets(arr []int) int {
    n := len(arr)
    count := 0
    prefixXor := make([]int, n+1)
    
    for i := 0; i < n; i++ {
        prefixXor[i+1] = prefixXor[i] ^ arr[i]
    }
    
    for i := 0; i < n; i++ {
        for j := i + 1; j < n; j++ {
            if prefixXor[i] == prefixXor[j+1] {
                count += (j - i)
            }
        }
    }
    
    return count
}
