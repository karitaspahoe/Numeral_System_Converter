package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        //boolean isValidInput;
        int fromNumberInt = 0, fromRadix = 10, toRadix = 10;
        String[] fromNumberStr = null;

        if (isValidRadix(input)) {
            fromRadix = Integer.parseInt(input);
        } else {
            System.out.println("error");
            return;
        }

        input = scanner.next().toLowerCase();
        if (isValidDouble(input, fromRadix)) {
            fromNumberStr = input.split("\\.");
        } else {
            System.out.println("error");
            return;
        }

        input = scanner.next().toLowerCase();
        if (isValidRadix(input)) {
            toRadix = Integer.parseInt(input);
        } else {
            System.out.println("error");
            return;
        }

        if (fromRadix < Character.MIN_RADIX) {
            for (char c : fromNumberStr[0].toCharArray()) {
                fromNumberInt += Integer.parseInt("" + c);
            }
        } else {
            fromNumberInt = Integer.parseInt(fromNumberStr[0], fromRadix);
        }

        if (toRadix < Character.MIN_RADIX) {
            for (int i = 0; i < fromNumberInt; i++) {
                System.out.print("1");
            }

        } else {
            System.out.print(Integer.toString(fromNumberInt, toRadix));
        }

        if (fromNumberStr.length == 2 && (fromRadix !=1 || toRadix !=1)) {
            double num = convertFractionFromRadix(fromNumberStr[1], fromRadix);
            System.out.print("." + convertFractionToRadix(num, toRadix));
        }
        System.out.println();
    }

    public static double convertFractionFromRadix(String numStr, int radix) {
        double numerator;
        double denominator;
        double total = 0;

        for (int i = 0; i < numStr.length(); i++) {
            if (Character.isDigit(numStr.charAt(i))) {
                numerator = Double.parseDouble("" + numStr.charAt(i));
            } else {
                numerator = ((int)numStr.charAt(i) - 87);
            }

            denominator = Math.pow(radix, i+1);
            total += (numerator / denominator);
        }

        return total;
    }

    public static String convertFractionToRadix(double fraction, int radix) {
        double fractionToRadix;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            fractionToRadix = fraction * radix;
            sb.append(Integer.toString((int)fractionToRadix, radix));
            fraction = fractionToRadix - (int) fractionToRadix;
        }
        return sb.toString();
    }

    public static boolean isValidRadix(String input) {
        for (int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int j = Integer.valueOf(input);

        if (j < 1 || j > 36) {
            return false;
        }

        return true;
    }

    public static boolean isValidDouble(String input, int radix) {
        String[] inputStr = input.split("\\.");
        if (inputStr.length > 2) {
            return false;
        }

        for (int i = 0; i < inputStr.length; i++) {
            for (int j = 0; j < inputStr[i].length(); j++) {
                char c = inputStr[i].charAt(j);
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                }

                if (Character.isLetter(c)) {
                    if (((int)c - 87 + 1) > radix) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
