package com.company.stringOperation;

public class CustomisedString {

    public int countOfParticularChar(String str, char ch) {
        int count = 0;
        ch = Character.toLowerCase(ch);
        char[] chArr = str.toLowerCase().toCharArray();
        int i = 0;
        while (i < chArr.length - 1) {
            if(chArr[i] == ch){
                ++count;
            }
            i++;
        }
        return count;
    }

    public boolean checkPalindromeItr(String str){
        boolean isPalindrome = true;
        int len = str.length() - 1;
        char []ch = str.toLowerCase().toCharArray();
        for(int i = 0; i<=(str.length() - 1)/2; i++){
            if(ch[i]!=ch[len--]){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
