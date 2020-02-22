package com.liqiang.algorithm.bfsordfs;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [N皇后]</p>
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-queens/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class NQueens {
    int[] lie;
    int[] pie;
    int[] na;
    int n;
    int[] result;
    List<List<String>> resultList = new ArrayList<>();

    public void addListString() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (result[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        resultList.add(list);
    }

    /**
     * 需要遍历每行每一列的各种情况
     * 非递归实现用stack来实现，但是性能很低
     * @param n
     * @return
     */
//    public List<List<String>> solveNQueens2(int n) {
//        lie = new int[n];
//        pie = new int[n];
//        na = new int[n];
//        result = new int[n];
//        this.n = n;
//        int row = 0;
//        int col = 0;
//        int colRecord = 0;
//        boolean flag = true;
//        boolean loop = true;
//        while (loop) {
//            label:
//            for (int i = row; i < n; i++) {
//                for (int j = col; j < n; j++) {
//                    System.out.println("i： " + i + " j: " + j);
//                    //如果不存在列撇那
//                    if (valid(i, j)) {
//                        System.out.println("valid  i： " + i + " j: " + j);
//                        result[i] = j;
//                        //更新列撇那
//                        lie[i] = j + 1;
//                        pie[i] = i + j + 1;
//                        na[i] = i - j + n;
//                        if (i == n - 1) {
//                            addListString();
//                            flag = true;//如果找到一次结果后
//                            if (colRecord < n - 1 && row < n - 1) {
//                                col = colRecord + 1;
//                            }
//                            break label;
//                        }
//                        if (flag && j < n - 1) {//记录第一次位置
//                            row = i;
//                            colRecord = j;
//                            flag = false;
//                        }
//                        col = 0;
//                        break;
//                    }
//                    if (j == n - 1) {
//                        if (flag) {//没有匹配，重新循环
//                            row = row + 1;
//                        } else {//有匹配，按匹配继续循环
//                            col = colRecord + 1;
//                            flag = true;
//                        }
//                        break label;
//                    }
//                }
//            }
//            if (row == n - 1) {
//                loop = false;
//            }
//            //按照row,col清除
//            for (int x = row; x < n; x++) {
//                lie[x] = 0;
//                pie[x] = 0;
//                na[x] = 0;
//            }
//        }
//        return resultList;
//    }

    public List<List<String>> solveNQueens(int n) {
        lie = new int[n];
        pie = new int[n];
        na = new int[n];
        result = new int[n];
        this.n = n;

        dfsQueens(0);
        return resultList;
    }

    /**
     * DFS
     *
     * @param row
     */
    public void dfsQueens(int row) {
        if (row == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(row, i)) {
                lie[row] = i + 1;
                pie[row] = i + row + 1;
                na[row] = row - i + n;
                result[row] = i;
                if (row == n - 1) {
                    addListString();
                }
                dfsQueens(row + 1);
                //归去来兮 否则会产生下次循环将读取上一次的值
                lie[row] = 0;
                pie[row] = 0;
                na[row] = 0;
                result[row] = 0;
            }
        }
    }

    //验证列撇捺
    public boolean valid(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (lie[i] == y + 1) {
                return false;
            }
            if (pie[i] == x + y + 1) {
                return false;
            }
            if (na[i] == x - y + n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(5);
        for (int i = 0; i < lists.size(); i++) {
            List<String> strings = lists.get(i);
            for (int j = 0; j < strings.size(); j++) {
                System.out.println(strings.get(j));
            }
            System.out.println("----------------------------------");
        }
    }
}
