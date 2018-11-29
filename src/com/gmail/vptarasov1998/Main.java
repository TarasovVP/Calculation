package com.gmail.vptarasov1998;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choise = 0;

        System.out.println("Добро пожаловать в калькулятор. \nKалькулятор выполняет следующие функции:\n" + "1 Операции +,-,*,/; \n" + "2 Извлечение квадратного корня;\n" + "3 Просчет факториала числа;\n" + "4 Просчет длины окружности по радиусу;\n" + "5 Просчет площади круга по радиусу;\n" + "6 Вывод последовательности y при x;");
        System.out.println("Для вычисления необходимо написать номер операции и нажать Enter\n" + "Для выхода введите stop");
        Scanner sc = new Scanner(System.in);
        String enterVal = sc.next();
        while (!enterVal.equalsIgnoreCase("stop")) {
            choise = Integer.parseInt(enterVal);
            doChoise(choise);

        }
    }

    private static BigDecimal mathAction(BigDecimal x, String z, BigDecimal y) {
        MathContext mc = new MathContext(12);
        BigDecimal total = new BigDecimal(0);
        switch (z) {
            case "+":
                total = x.add(y, mc);
                break;
            case "-":
                total = x.subtract(y, mc);
                break;
            case "*":
                total = x.multiply(y, mc);
                break;
            case "/":
                total = x.divide(y, mc);
                break;

        }
        return total;

    }

    private static int factorial(int x) {
        int factorial = 1;
        for (int i = 1; i <= x; i += 1) {
            factorial *= i;
        }
        return factorial;
    }

    private static double circle(double x) {
        double circle = 0.0;
        circle = 2 * (Math.PI * x);
        return circle;
    }

    private static double sqrCircle(double x) {
        double sqrCircle = 0.0;
        sqrCircle = Math.PI * (x * x);
        return sqrCircle;
    }

    private static double[] consistent(double x, double y, double z) {
        int size = (int) ((y - x) / z + 1);
        double[] massive = new double[size];
        int j = 0;
        for (double i = x; i < y; i += z) {
            if (i == 0) {
                massive[j] = i;
                j += 1;
            }
            if (i > 0 && i <= 10 || i == 15) {
                massive[j] = (Math.sqrt(i) / 99);
                j += 1;
            }
            if (i > 10 && i != 15 || i < 0) {
                massive[j] = ((i - 3) * (i - 3)) / 2 * i;
                j += 1;
            }
        }
        return massive;
    }

    private static void doChoise(int choise) {
        Scanner sc = new Scanner(System.in);
        switch (choise) {
            case 1:
                System.out.println("Для вычисления введите через пробел числа, математические действия в формате +, -, *, /  и нажмите Enter");
                Scanner sc1 = new Scanner(System.in);
                String stroka = sc1.nextLine();
                String massive[];
                massive = stroka.split(" ");
                BigDecimal firstNum = new BigDecimal(massive[0]);
                BigDecimal secondNum = new BigDecimal(massive[2]);
                String mathAct = massive[1];
                System.out.println("Ответ: " + mathAction(firstNum, mathAct, secondNum));
                break;
            case 2:
                System.out.println("Для вычисления введите число из которого необходимо извлечь квадратный корень:");
                Double integer = sc.nextDouble();
                System.out.println("Ответ: " + Math.sqrt(integer));
                break;
            case 3:
                System.out.println("Для вычисления введите число из которого необходимо получить факториал:");
                int factorial = sc.nextInt();
                System.out.println("Ответ: " + factorial(factorial));
                break;
            case 4:
                System.out.println("Для вычисления длины окружности задайте радиус:");
                double circle = sc.nextDouble();
                System.out.println("Длина окружности: " + circle(circle));
                break;
            case 5:
                System.out.println("Для вычисления площади круга задайте радиус:");
                double sqrCircle = sc.nextDouble();
                System.out.println("Площадь круга: " + sqrCircle(sqrCircle));
                break;
            case 6:
                System.out.println("Для вывода последовательности введите через пробел начало диапазона, конец диапозона и шаг:");
                Scanner sc2 = new Scanner(System.in);
                String stroka2 = sc2.nextLine();
                String massive2[];
                massive2 = stroka2.split(" ");
                double start = Integer.parseInt(massive2[0]);
                double finish = Integer.parseInt(massive2[1]);
                double step = Integer.parseInt(massive2[2]);
                System.out.println("Последовательность составляет: " + Arrays.toString(consistent(start, finish, step)));
                break;
            default:
                System.out.println("Вы ввели неправильный выбор");
                break;
        }


    }
}
