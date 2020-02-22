package com.liqiang.algorithm;

import java.util.*;

/**
 * <p>Description: [找到字符串中所有字母异位词]</p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class FindAllAnagramsInString {

    /**
     * 暴力解法
     * 时间复杂度O(N^2)
     * 空间复杂度O(N^2)
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int each = s.length() - p.length();//循环次数
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.get(c) == null ? 1 : pMap.get(c) + 1);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= each; i++) {
            int match = 0;
            Map<Character, Integer> sMap = new HashMap<>();
            for (int j = 0; j < p.length(); j++) {//每次循环p个长度
                char c = s.charAt(j + i);
                if (pMap.containsKey(c)) {
                    sMap.put(c, sMap.get(c) == null ? 1 : sMap.get(c) + 1);
                    if (sMap.get(c).equals(pMap.get(c))) {//一个字符出现次数匹配
                        match++;
                    }
                } else {
                    break;
                }
            }
            if (match == pMap.size()) {//一次循环匹配字符数和pMap的个数相同为一次异位词
                resultList.add(i);
            }
        }
        return resultList;
    }

    /**
     * 先排序再比较
     * 时间复杂度:O(N^2)
     * 空间复杂度:O(N^2)
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> resultList = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        p = String.valueOf(pArray);
        int eachCount = s.length() - p.length();
        for (int i = 0; i <= eachCount; i++) {
            char[] sArray = s.substring(i, p.length() + i).toCharArray();
            Arrays.sort(sArray);
            if (String.valueOf(sArray).equals(p)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    /**
     * 滑动窗口(Map实现)
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams3(String s, String p) {
        ArrayList resultList = new ArrayList();
        //存储p的所有字符出现的次数
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.get(c) == null ? 1 : pMap.get(c) + 1);
        }
        //定义s的字符Map来获取
        Map<Character, Integer> sMap = new HashMap<>();
        //定义左右两个指针实现窗口滑动，右指针向右滑动，判断左右两个指针的长度等于p长度后，判断字符是否收集成功。
        int left = 0, right = 0;
        int matcher = 0;//定义matcher来统计匹配字符个数
        while (right < s.length()) {
            char c = s.charAt(right);
            //收集s的字符出现次数
            if (pMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) == null ? 1 : sMap.get(c) + 1);
                if (pMap.get(c).equals(sMap.get(c))) {
                    matcher++;
                }
            }
            right++;
            //当窗口和p的长度一致时
            if ((right - left) == p.length()) {

                if (matcher == pMap.size()) {
                    resultList.add(left);
                }
                //左下标向右移，并清除原下标sMap统计次数
                char l = s.charAt(left);
                if (pMap.containsKey(l)) {
                    //如果字符匹配matcher--
                    if (pMap.get(l).equals(sMap.get(l))) {
                        matcher--;
                    }
                    //字符统计数-1
                    sMap.put(l, sMap.get(l) - 1);
                }

                left++;
                while (left < right && !pMap.containsKey(s.charAt(left))) {
                    left++;
                }
            }
        }
        return resultList;
    }

    /**
     * 滑动窗口(数组实现)
     * 时间复杂度:ON
     * 空间复杂度:ON
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams4(String s, String p) {
        ArrayList resultList = new ArrayList();
        //存储p的所有字符出现的次数
        int[] pArray = new int[26];
        int total = 0;
        for (char c : p.toCharArray()) {
            if (pArray[c - 'a'] == 0) {
                total++;
                pArray[c - 'a'] = 1;
            } else {
                pArray[c - 'a'] = pArray[c - 'a'] + 1;
            }
        }
        //定义s的字符Map来获取
        int[] sArray = new int[26];
        //定义左右两个指针实现窗口滑动，右指针向右滑动，判断左右两个指针的长度等于p长度后，判断字符是否收集成功。
        int left = 0, right = 0;
        int matcher = 0;//定义matcher来统计匹配字符个数
        while (right < s.length()) {
            char c = s.charAt(right);
            //收集s的字符出现次数
            if (pArray[c - 'a'] > 0) {
                sArray[c - 'a'] = sArray[c - 'a'] == 0 ? 1 : sArray[c - 'a'] + 1;
                if (pArray[c - 'a'] == sArray[c - 'a']) {
                    matcher++;
                }
            }
            right++;
            //当窗口和p的长度一致时
            if ((right - left) == p.length()) {

                if (matcher == total) {
                    resultList.add(left);
                }
                //左下标向右移，并清除原下标sMap统计次数
                char l = s.charAt(left);
                if (pArray[l - 'a'] > 0) {
                    //如果字符匹配matcher--
                    if (pArray[l - 'a'] == sArray[l - 'a']) {
                        matcher--;
                    }
                    //字符统计数-1
                    sArray[l - 'a'] = sArray[l - 'a'] - 1;
                }

                left++;
                while (left < right && pArray[s.charAt(left) - 'a'] == 0) {
                    left++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        String s = "ababababab";
        String p = "aab";

        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
        System.out.println(Arrays.toString(findAllAnagramsInString.findAnagrams4(s, p).toArray()));
    }
}
