package com.company.stringOperation;

import com.company.CustomException.BlankException;
import com.company.Model.LongestWord;

import java.util.ArrayList;
import java.util.List;

public class CustomisedString {

    public int countOfParticularChar(String str, char ch) {
        int count = 0;
        ch = Character.toLowerCase(ch);
        char[] chArr = str.toLowerCase().toCharArray();
        int i = 0;
        while (i < chArr.length - 1) {
            if (chArr[i] == ch) {
                ++count;
            }
            i++;
        }
        return count;
    }

    public boolean checkPalindromeItr(String str) {
        boolean isPalindrome = true;
        int len = str.length() - 1;
        char[] ch = str.toLowerCase().toCharArray();
        for (int i = 0; i <= (str.length() - 1) / 2; i++) {
            if (ch[i] != ch[len--]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public String conCatString(String st1, String st2) {
        int lenSt1 = st1.length();
        int lenSt2 = st2.length();
        int totLen = lenSt1 + lenSt2;
        char[] ch = new char[totLen];
        char[] ch1 = st1.toCharArray();
        char[] ch2 = st2.toCharArray();

        for (int i = 0; i < lenSt1; i++) {
            ch[i] = ch1[i];
        }

        int k = 0;
        for (int j = lenSt1; j < totLen; j++) {
            ch[j] = ch2[k++];
        }
        String st = new String(ch);
        return st;
    }


    public LongestWord longestWord(String str) throws BlankException {
        if (str == null || str == "" || str == " ") {
            throw new BlankException("Input String can not be null or blank");
        }
        List<String> list = new ArrayList<>();
        char[] ch = str.trim().toCharArray();
        int totLength = this.lengthOfString(str);
        int i = 0;
        StringBuffer maxWord = new StringBuffer();
        StringBuffer curWord = new StringBuffer();

        while (i < totLength && ch[i] != ' ') {
            maxWord.append(ch[i++]);
        }
        int maxWordLength = maxWord.length();
        i++;

        while (i < totLength) {
            if (curWord.length() != 0) {
                curWord = new StringBuffer();
            }
            while (i < totLength && ch[i] != ' ') {
                curWord.append(ch[i++]);
            }
            if (curWord.length() >= maxWordLength) {
                list.add(curWord.toString());
                maxWordLength = curWord.length();

            }
            ++i;
        }

        List<String> finalList = new ArrayList<>();
        for(String st: list){
            if(this.lengthOfString(st) == maxWordLength){
                finalList.add(st);
            }
        }
        LongestWord longWord = new LongestWord();
        longWord.setWordLength(maxWordLength);
        longWord.setLongestWords(finalList);

        return longWord;
    }

    public int lengthOfString(String st) {
        int length = 0;
        char[] ch = st.trim().toCharArray();
        for (int i = 0; i < ch.length; i++)
            ++length;

        return length;
    }
}
