package com.liqiang.algorithm;

import java.util.*;

/**
 * <p>Description: [对异或词分组]</p>
 * https://leetcode-cn.com/problems/group-anagrams/
 * Created on 2019/7/11 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class GroupAnagrams {


    /**
     * 时间复杂度:O(NKlogK),其中N是strs的长度，而K是strs中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为O(N)。然后，我们在O(KlogK)的时间内对每个字符串排序。
     * 空间复杂度:O(NK),排序存储在map中的全部信息内容。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (sortMap.containsKey(String.valueOf(chars))) {
                List<String> stringList = sortMap.get(String.valueOf(chars));
                stringList.add(strs[i]);
                sortMap.put(String.valueOf(chars), stringList);
            } else {
                List<String> groupList = new ArrayList<>();
                groupList.add(strs[i]);
                sortMap.put(String.valueOf(chars), groupList);
            }
        }
        return new ArrayList<>(sortMap.values());
    }

    /**
     * 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
     *
     * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List> groupMap = new HashMap<>();
        int[] nums = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(nums, 0);
            for (char c : strs[i].toCharArray()) {
                nums[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(nums[j]);
                sb.append('#');
            }
            String key = sb.toString();
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList());
            }
            groupMap.get(key).add(strs[i]);

        }
        return new ArrayList(groupMap.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        groupAnagrams(s);
        List<List<String>> lists = groupAnagrams2(s);
        for (int i = 0; i < lists.size(); i++) {
            List<String> strings = lists.get(i);
            for (int j = 0; j < strings.size(); j++) {
                System.out.println(strings.get(j));
            }
        }
    }
}
