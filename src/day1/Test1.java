package day1;

/**
 * Copyright (c),2016-2019,北京金地安华有限公司成都分公司
 * ClassName   :  Test1
 * Author      : MaMingze
 * Date        : 2019/2/27 10:22
 * Description : TODO
 * Version 1.0
 **/

/**  * Q 26 左旋转字符串
 * 题目：定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。
 * 如把字符串abcdef左旋转2位得到字符串cdefab。
 * 请实现字符串左旋转的函数。要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)*/

public class Test1 {
    /*
     * abcdef->ab.cdef->ba.fedc->cdefab
     */
    public static String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (n <= 0 || n >= str.length()) {
            return str;
        }
        int begin = 0;
        int end = str.length() - 1;
        char[] letters = str.toCharArray();
        reverseString(letters, begin, n - 1);
        reverseString(letters, n, end);
        reverseString(letters, begin, end);
        return new String(letters);

    }

    // public static String reverseString(String str,int begin,int end){
    public static String reverseString(char[] letters, int begin, int end) {
        /*
         * of course we can do it like this: StringBuilder sb=new
         * StringBuilder(str); sb.reverse().toString(); but we are learning
         * algorithm so let's 'reinvent the wheel'.
         */
        if (begin >= end) {
            return null;
        }
        for (int i = begin, j = end; i < j; i++, j--) {
            char tmp = letters[i];
            letters[i] = letters[j];
            letters[j] = tmp;
        }
        return new String(letters);
    }
}

