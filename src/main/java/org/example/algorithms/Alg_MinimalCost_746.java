package org.example.algorithms;

public class Alg_MinimalCost_746 {
    /**
     * алгоритм опирается на локальные решения (минимальные затраты на текущем шаге),
     * которые гарантируют глобальную оптимальность (минимальная стоимость всего пути).
     * Используется динамическое программирование:
     * 1. Массив `dp` хранит минимальную стоимость достижения каждой ступени.
     * 2. Рекуррентное соотношение:
     *    dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2])
     *    - Минимальная стоимость текущей ступени — это её стоимость плюс
     *      минимальная стоимость двух предыдущих ступеней.
     * 3. Начальные условия:
     *    dp[0] = cost[0], dp[1] = cost[1]
     * 4. Ответ: Math.min(dp[cost.length-1], dp[cost.length-2])
     *    - Можно завершить подъём с последней или предпоследней ступени.
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        int[] cost2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
