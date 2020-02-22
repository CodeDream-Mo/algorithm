package com.liqiang.algorithm;

import java.util.Arrays;

/**
 * <p>Description: [有效的字母异或词]</p>
 * https://leetcode-cn.com/problems/valid-anagram/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class ValidAnagram {
    /**
     * 方法一：排序后比较
     * 时间复杂度：O(nlogn)，假设 nnn 是 sss 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。
     * 空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1) 辅助空间。
     * 注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：
     * 1.这依赖于语言的细节。
     * 2.这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }

    /**
     * hash表
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
