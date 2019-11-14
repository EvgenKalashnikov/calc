package Util;

import java.math.BigInteger;

public class SimpleIntegerMultiplier {

    public static String multiplyAlgFirst(String firstNumber, String secondNumber) {
        return new BigInteger(firstNumber).multiply(new BigInteger(secondNumber)).toString();
    }

    public static String multiplyAlgSecond(String firstNumber, String secondNumber) {
        checkCorrectOrThrow(firstNumber, secondNumber);
        String result = null;
        boolean positive = isPositive(firstNumber, secondNumber);

        char[] chars1 = firstNumber.replaceFirst("([-0])*", "").toCharArray();
        char[] chars2 = secondNumber.replaceFirst("([-0])*", "").toCharArray();
        String[] reversedSingleMultiplications = new String[firstNumber.length()];
        StringBuilder stringBuilder = new StringBuilder();
        int singleMultiplicationMaxLength = 0;


        int c = 0;

        for (int i = chars1.length - 1; i >= 0; i--) {
            int rememberedDigit = 0;
            int digitFromFirstNum = Character.digit(chars1[i], 10);
            String repeat = "0".repeat(c++);
            stringBuilder.append(repeat);

            for (int j = chars2.length - 1; j >= 0; j--) {

                int digitFromSecondNum = Character.digit(chars2[j], 10);
                int digitMultiplication = digitFromFirstNum * digitFromSecondNum;
                int currentDigitsValue = digitMultiplication + rememberedDigit;
                if (currentDigitsValue < 10) {
                    stringBuilder.append(currentDigitsValue);
                    rememberedDigit = 0;
                } else {
                    stringBuilder.append(currentDigitsValue % 10);
                    rememberedDigit = currentDigitsValue / 10;
                }

            }
            if (rememberedDigit > 0) {
                stringBuilder.append(rememberedDigit);
            }
            reversedSingleMultiplications[i] = stringBuilder.toString();
            int currentDigitsValueLength = stringBuilder.length();
            singleMultiplicationMaxLength = Math.max(currentDigitsValueLength, singleMultiplicationMaxLength);
            stringBuilder.delete(0, currentDigitsValueLength);

        }
        if (positive){
            return sumReversedNumbers(reversedSingleMultiplications, singleMultiplicationMaxLength);
        }
        return "-".concat(sumReversedNumbers(reversedSingleMultiplications, singleMultiplicationMaxLength));



    }

    private static boolean isPositive(String firstNumber, String secondNumber) {
        if (firstNumber.startsWith("-") ^ secondNumber.startsWith("-")) {
            return false;
        }
        return true;
    }

    private static String sumReversedNumbers(String[] reversedSingleMultiplications, int singleMultiplicationMaxLength) {
        int rememberedSumOfDigits = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < singleMultiplicationMaxLength; i++) {
            int counter = 0;

            for (String singleMultiplication : reversedSingleMultiplications) {
                if (singleMultiplication.length() > i) {
                    counter += Character.digit(singleMultiplication.charAt(i), 10);
                }
            }
            counter += rememberedSumOfDigits;
            if (counter < 10) {
                stringBuilder.append(counter);
                rememberedSumOfDigits = 0;
            } else {
                stringBuilder.append(counter % 10);
                rememberedSumOfDigits = counter / 10;
            }


        }
        String result = stringBuilder.reverse().toString();
        stringBuilder.delete(0, stringBuilder.length());
        return result;
    }

    private static void checkCorrectOrThrow(String firstNumber, String secondNumber) {
        if (!firstNumber.matches("-?(\\d)*")) {
            throw new NumberFormatException("not a Integer : " + firstNumber);
        }
        if ( !secondNumber.matches("-?(\\d)*")) {
            throw new NumberFormatException("not a Integer : " + secondNumber);
        }
        if (firstNumber.isEmpty() | secondNumber.isEmpty()){
            throw new NumberFormatException("input string has zero size");
        }
    }
}
