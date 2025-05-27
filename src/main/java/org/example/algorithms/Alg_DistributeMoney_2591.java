package org.example.algorithms;

public class Alg_DistributeMoney_2591 {
    public static int distMoney(int money, int children) {
        if (money < children) return -1;

        int k = (money - children) / 7; // Начальное значение k

        while (k >= 0) {
            int s = children - k;    // Оставшиеся дети
            int r = money - (k * 8) - s; // Оставшиеся деньги, где s равен 1 доллару минимального распределения.

            // Проверка ВСЕХ запрещенных условий
            boolean invalid =
                    (s < 0 || r < 0) ||     // Денег/детей недостаточно
                            (s == 1 && r == 3) ||    // Ребенок получит 4$
                            (s == 0 && r != 0);      // Деньги остались нераспределенными

            if (invalid) {
                k--; // Уменьшаем k и пробуем снова
            } else {
                return k; // Нашли допустимое k
            }
        }

        return -1; // Нет возможных распределений
    }

    public static void main(String[] args) {
        int money = 20;
        int children = 3;
        int money1 = 16;
        int children1 = 2;
        int money2 = 23;
        int children2 = 4;
        System.out.println(distMoney(money, children));
    }
}
