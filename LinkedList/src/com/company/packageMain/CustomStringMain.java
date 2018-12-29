package com.company.packageMain;

import com.company.CustomException.BlankException;
import com.company.Model.LongestWord;
import com.company.stringOperation.CustomisedString;

public class CustomStringMain {
    public static void main(String[] args) {
//        System.out.println("Count: "+
//        new CustomisedString()
//                .countOfParticularChar("misSissipy",'S'));

//        System.out.println("isPalindrome: "+new CustomisedString()
//                .checkPalindromeItr("1222231"));
//        System.out.println("Con Cat: " + new CustomisedString()
//                .conCatString("Hello77", "World"));

        try {
            String str = "Small things makess perfectiony but perfection1 is no small thing invincible";
            LongestWord lw = new CustomisedString().longestWord(str);
            System.out.println("Length of the Longest Word: " + lw.getWordLength());

            System.out.println("Longest Words: ");
            if (lw.getLongestWords().size() > 0) {
                for (String words : lw.getLongestWords()) {
                    System.out.println(words);
                }
            }
        } catch (BlankException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
