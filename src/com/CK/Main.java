package com.CK;

public class Main {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros    ";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];


        for (int j = 0; j <= word2.length(); j++) {
            for (int i = 0; i <= word1.length(); i++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}