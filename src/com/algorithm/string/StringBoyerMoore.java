package com.algorithm.string;

import java.util.Arrays;

public class StringBoyerMoore {
    /*
     * Assuming there is only alphabet in the pattern
     */
    private int[] lastOccurenceFunc(String pattern) {
        int[] lastOccurence = new int[26];
        Arrays.fill(lastOccurence, -1);

        for (int idx = 0; idx < pattern.length(); idx++)
            lastOccurence[pattern.charAt(idx) - 'a'] = idx;

        return lastOccurence;
    }

    public boolean BoyerMoore(String text, String pattern) {
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        int[] lastOccurence = lastOccurenceFunc(pattern);

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0)
                    return true;
                i--;
                j--;
            } else {
                int occur = lastOccurence[text.charAt(i) - 'a'];
                i = i + pattern.length() - Math.min(j, occur + 1);
                j = pattern.length() - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringBoyerMoore s = new StringBoyerMoore();
        String text = "abacaabadcabacabaabb";
        String pattern = "abacab";

        boolean patternExist = s.BoyerMoore(text, pattern);
        System.out.println("Pattern exist: " + patternExist);
    }
}
