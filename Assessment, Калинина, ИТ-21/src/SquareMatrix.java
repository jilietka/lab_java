public class SquareMatrix {
    public static void main(String[] args) {
        int n = 10; // Размерность матрицы
        int m = 8;  // Размер квадрата

        int[][] a = new int[n + 1][n + 1];

        // Заполняем матрицу случайными значениями
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = (int) (Math.random() * 10);
            }
        }

        // Матрица для хранения сумм квадратов
        int[][] sumMatrix = new int[n + 1][n + 1];

        // Рассчитываем суммы для каждого горизонтального прямоугольника
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += a[i][j];
            }
            sumMatrix[i][1] = sum;
            for (int j = 2; j <= n - m + 1; j++) {
                sum += (a[i][j + m - 1] - a[i][j - 1]);
                sumMatrix[i][j] = sum;
            }
        }

        // Рассчитываем суммы квадратов
        for (int j = 1; j <= n - m + 1; j++) {
            int sum = 0;
            for (int i = 1; i <= m; i++) {
                sum += sumMatrix[i][j];
            }
            sumMatrix[1][j] = sum;
            for (int i = 2; i <= n - m + 1; i++) {
                sum += (sumMatrix[i + m - 1][j] - sumMatrix[i - 1][j]);
                sumMatrix[i][j] = sum;
            }
        }

        // Выводим матрицу сумм квадратов
        for (int i = 1; i <= n - m + 1; i++) {
            for (int j = 1; j <= n - m + 1; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Подсчитываем общее количество операций
        int totalOperations = (n - m + 1) * (n - m + 1) * (m + m - 1);
        System.out.println("Общее количество операций: " + totalOperations);
    }
}