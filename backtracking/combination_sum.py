class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []  # Stores all unique combinations

        def backtrack(curr_list=[], remaining=target, start=0):
            # Base case: if remaining sum is 0, add current combination
            if remaining == 0:
                results.append(curr_list.copy())
                return

            # Iterate through candidates starting from 'start'
            for i in range(start, len(candidates)):
                # Skip duplicate elements if the current candidate is the same as the previous one (except for the first occurrence)
                if i > start and candidates[i] == candidates[i-1]:
                    continue

                # If candidate is greater than remaining sum, stop iterating
                if candidates[i] > remaining:
                    break

                # Add candidate to current list and recurse with updated remaining sum
                curr_list.append(candidates[i])
                backtrack(curr_list, remaining - candidates[i], i)

                # Backtrack: remove last element from current list
                curr_list.pop()

        candidates.sort()  # Sort candidates to group duplicates together
        backtrack()  # Start backtracking from index 0
        return results
