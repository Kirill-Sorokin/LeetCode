import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        int left = 0, right = tokens.length - 1;
        
        while (left <= right) {
            if (power >= tokens[left]) { // Play the smallest token face-up.
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) { // Play the largest token face-down.
                power += tokens[right--];
                score--;
            } else { // Can't play any token.
                break;
            }
        }
        
        return maxScore;
    }
}
