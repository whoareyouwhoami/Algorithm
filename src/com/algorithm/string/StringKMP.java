package com.algorithm.string;

public class StringKMP {
    private int[] KMPFailure(String pattern) {
        int i = 1;
        int j = 0;
        int[] failure = new int[pattern.length()];

        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                failure[i] = j + 1;
                i++;
                j++;
            } else {
                if(j == 0) {
                    failure[i] = 0;
                    i++;
                } else {
                    j = failure[j - 1];
                }
            }
        }

        System.out.print("Failure function: ");
        for(int x: failure) {
            System.out.print(x + " ");
        }
        System.out.println();
        return failure;
    }

    private boolean KMP(String text, String pattern) {
        int i = 0;
        int j = 0;
        int[] failure = KMPFailure(pattern);

        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if(j == pattern.length())
                    return true;
            } else {
                if(j == 0)
                    i++;
                else
                    j = failure[j - 1];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringKMP kmp = new StringKMP();

        String s = "babcbabcabcaabcabcabcacabc";
        String p = "abcabcacab";

        boolean patternExist = kmp.KMP(s, p);
        System.out.println("Pattern exist: " + patternExist);
    }
}
