package util;


import java.util.*;

public class ArrayUtils {
    private static final Random RND = new Random();


    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toDoubleArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Double> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextDouble());
        }

        // из List<Double> можно получить Double[]
        Double[] arr = list.toArray(new Double[0]);
        // Double[] -> double[]
        return ArrayUtils.toPrimitive(arr);
    }

    /**
     * Конвертация массива строк в двухмерный массив чисел double[][]
     */
    public static double[][] toDoubleArray2(String[] lines) {
        double[][] arr2 = new double[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toDoubleArray(lines[r]);
        }
        return arr2;
    }

    /**
     * Чтение массива строк из консоли, признак окончания - пустая строка
     */
    public static String[] readLinesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line == null || line.trim().length() == 0)
                break;
            lines.add(line);
        }
        return lines.toArray(new String[0]);
    }


    /* Чтение двухмерного массива double[][] с консоли;
     * checkMatrix - задает режим, при котором,
     * если строки содержат разное кол-во элементот, то
     * это считается ошибкой и предлагается повторить ввод
     */
    public static double[][] readDoubleArray2FromConsole(String arrName, boolean checkMatrix) {
        while (true) {
            try {
                if (arrName == null || arrName.length() == 0) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите двумерный массив%s:%n", arrName);
                double[][] arr2 = toDoubleArray2(readLinesFromConsole());
                if (checkMatrix) {
                    for (int i = 1; i < arr2.length; i++)
                        if (arr2[i].length == arr2[0].length) {
                            throw new Exception("Строки с разным кол-вом элементов");
                        }
                }
                return arr2;
            } catch (Exception e) {
                System.out.print("Вы ошиблись, попробуйте еще раз! ");
            }
        }
    }

    /* Чтение двухмерного массива int[][] с консоли;
     * checkMatrix - задает режим, при котором,
     * если строки содержат разное кол-во элементот, то
     * это считается ошибкой и предлагается повторить ввод
     */
    public static double[][] readDoubleArray2FromConsole(boolean checkMatrix) {
        return readDoubleArray2FromConsole(null, checkMatrix);
    }


    /**
     * Cоздание одномерного массива целых чисел, заполненного случайными числами
     *
     * @param length   Кол-во элементов в массиве
     * @param minValue Минимальное значение для случайных чисел (включая)
     * @param maxValue Максимальное значение (не включая)
     * @return Массив int[]
     */
    public static int[] createRandomIntArray(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = minValue + RND.nextInt(maxValue - minValue);
        return arr;
    }

    /**
     * @see #createRandomIntArray(int, int, int)
     */
    public static int[] createRandomIntArray(int length, int maxValue) {
        return createRandomIntArray(length, 0, maxValue);
    }

}

