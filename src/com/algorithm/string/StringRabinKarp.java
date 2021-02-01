package com.algorithm.string;

public class StringRabinKarp {
    final int PRIME = 101;

    private int hashing(String pattern) {
        int code = 0;
        for (int i = 0; i < pattern.length(); i++)
            code += pattern.charAt(i) * Math.pow(PRIME, i);
        return code;
    }

    public boolean RabinKarp(String text, String pattern) {
        if (text.length() < pattern.length())
            return false;

        int patternCode = hashing(pattern);
        int textCode = hashing(text.substring(0, pattern.length())); // Initial hash code from text

        // Rolling hash
        for (int i = pattern.length(); i < text.length() + 1; i++) {
            if (patternCode == textCode)
                return true;
            textCode = (int) ((textCode - text.charAt(i - pattern.length())) / PRIME + (text.charAt(i) * Math.pow(PRIME, pattern.length() - 1)));
        }
        return false;
    }

    public static void main(String[] args) {
        StringRabinKarp s = new StringRabinKarp();
        boolean patternExist = s.RabinKarp("abedabc", "abc");
        System.out.println("Exist: " + patternExist);
    }
}
