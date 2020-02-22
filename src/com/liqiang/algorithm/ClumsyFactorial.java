package com.liqiang.algorithm;

/**
 * <p>Description: [笨阶乘]</p>
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * Created on 2019/7/29 14:27
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * <p>
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class ClumsyFactorial {

    boolean first = true;
    int sum;

    /**
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     * @param N
     * @return
     */
    public int clumsy(int N) {
        if (first == true) {
            sum = compute(N);
            first = false;
        } else {
            sum = sum - compute(N);
        }
        if (N - 3 > 0) {
            sum = sum + N - 3;
        }
        if (N - 4 > 0) {
            clumsy(N - 4);
        }

        return sum;
    }

    public int compute(int N) {
        int sum = N;
        if (N - 1 > 0) {
            sum = sum * (N - 1);
        }
        if (N - 2 > 0) {
            sum = sum / (N - 2);
        }
        return sum;
    }

}
