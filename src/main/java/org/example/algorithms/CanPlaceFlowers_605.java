package org.example.algorithms;

public class CanPlaceFlowers_605 {
    /**
     * Если left и right — это индексы первого и последнего нуля в этом отрезке,
     * то длина нулевого отрезка может быть вычислена как:
     * length = right − left + 1
     */
    public static boolean canPlaceFlowersMyMethod(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0) return true;
        int count;
        int left = 0;
        int zone = 2;
        int completedResource = 0;
        for (int right = 0; right < flowerbed.length; right++) {
            if (left < right && flowerbed[left] == 1) while (flowerbed[left] == 1) left++;
            if (right + 1 < flowerbed.length && flowerbed[right + 1] == 1) {
                count = (right - left + 1);
                if (left == 0) completedResource += count / zone;
                else completedResource += count / zone + (count % zone - 1);
                left = right + 2;
            }
            if (right == flowerbed.length - 1 && flowerbed[right] == 0) {

                count = (right - left + 1);

                if (count == flowerbed.length) return (flowerbed.length + 1) / 2 >= n;

                else completedResource += count / zone;
            }
        }
        return completedResource / n > 0;
    }

    /**
     * метод ИИ , результаты такие же
     */
    public static boolean canPlaceFlowersAI(int[] flowerbed, int n) {
        if (n == 0) return true; // Если не нужно размещать цветы, сразу возвращаем true

        int count = 0; // Счетчик размещенных цветов

        for (int i = 0; i < flowerbed.length; i++) {
            // Проверяем, можно ли разместить цветок
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) && // Сосед слева
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // Сосед справа
                flowerbed[i] = 1; // Размещаем цветок
                count++; // Увеличиваем счетчик
            }
            if (count >= n) return true; // Если размещено достаточно цветов, возвращаем true
        }

        return false; // Если не удалось разместить нужное количество цветов
    }

    /**
     *  Внутри цикла выполняются следующие проверки:
     *      (flowerbed[i] == 1)
     *    - Если текущая ячейка содержит цветок (значение 1), индекс увеличивается на 2, чтобы пропустить
     *      следующую ячейку, так как цветы не могут быть размещены рядом.
     *
     *      (i == len - 1 || flowerbed[i + 1] == 0)
     *    - Если текущая ячейка пустая (значение 0), выполняется дополнительная проверка:
     *      - Если это последняя ячейка массива, цветок может быть размещен здесь, так как нет соседей справа.
     *      - Либо следующая ячейка также пустая, что позволяет разместить цветок в текущей позиции.
     *      В этом случае количество цветов для размещения уменьшается на 1, и индекс увеличивается на 2.
     *
     *      Последний else
     *    - Если ни одно из предыдущих условий не выполнено, это означает, что текущая ячейка пустая,
     *      но следующая ячейка содержит цветок. В этом случае индекс увеличивается на 3, чтобы перейти
     *      к следующей возможной позиции для размещения.
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int i = 0;
        while (i < len && n > 0) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else
                i += 3;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed1 = new int[]{1, 0, 0, 0, 1};
        int[] flowerbed4 = new int[]{1, 0, 0, 0, 0, 1}; //2
        int[] flowerbed5 = new int[]{1, 0, 0, 0, 0, 0, 1}; //2
        int[] flowerbed6 = new int[]{0, 0, 0}; //2
        int[] flowerbed7 = new int[]{0, 0}; //2
        int[] flowerbed8 = new int[]{0, 0, 0, 0}; //2
        int[] flowerbed2 = new int[]{0, 0, 0, 0, 1, 0, 0, 0, 1};
        int[] flowerbed3 = new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed6, 2));
    }
}
