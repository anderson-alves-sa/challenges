package org.devtrace.challenges;

public class QalifiyAlgos {

    private static final int minimumLength = 6;
    private static final int maskStartLimit = 1;
    private static final int maskEndLimit = 4;
    private static final char ascii_0 = 48;
    private static final char ascii_9 = 57;
    private static final char mask = '#';


    private static final String multiplication = "*";
    private static final String division = "/";
    private static final String sum = "+";
    private static final String subtraction = "-";
    private static final int ansi_0 = 48;
    private static final int ansi_9 = 57;

    public static double evaluateReversePolishNotation(final String expr) {

        final String[] elements = expr.split(" ");

        double[] results = new double[elements.length];

        int idxOp = 0;
        int idxRes = 0;

        while (idxOp < elements.length) {

            if (elements[idxOp].charAt(0) < ansi_0 || elements[idxOp].charAt(0) > ansi_9) {
                results[idxRes - 2] =
                        runExpression(elements[idxOp],
                                results[idxRes - 2],
                                results[idxRes - 1]);
                idxRes = idxRes - 2;
            } else {
                results[idxRes] = Double.parseDouble(elements[idxOp]);
            }

            idxRes++;
            idxOp++;
        }

        return results[--idxRes];
    }

    public static double runExpression(final String operator, final double operand1, final double operand2) {
        switch(operator) {
            case multiplication:
                return operand1 * operand2;
            case division:
                return operand1 / operand2;
            case sum:
                return operand1 + operand2;
            default:
                return operand1 - operand2;
        }
    }

    public static String maskify(final String creditCardNumber) {

        if(creditCardNumber.length() < minimumLength) {
            return creditCardNumber;
        }

        final char[] creditCardNumberArray = creditCardNumber.toCharArray();

        for (int idx = maskStartLimit; idx < creditCardNumberArray.length - maskEndLimit; idx++) {
            if (creditCardNumberArray[idx] >= ascii_0 && creditCardNumberArray[idx] <= ascii_9) {
                creditCardNumberArray[idx] = mask;
            }
        }

        return new String(creditCardNumberArray);
    }


    public static String numberToOrdinal(final Integer number ) {

        if (number == 0) {
            return "0";
        }

        final char[] numberAsChar = String.valueOf(number).toCharArray();
        final int numberLength = numberAsChar.length;

        final int lastNumber = Character.getNumericValue(numberAsChar[numberLength -1]);

        if (numberLength > 1) {
            final int secondLastNumber = Character.getNumericValue(numberAsChar[numberLength -2]);
            if (secondLastNumber == 1 && (lastNumber == 1 || lastNumber == 2 || lastNumber ==3)) {
                return String.valueOf(number).concat("th");
            }
        }

        if (lastNumber == 1) {
            return String.valueOf(number).concat("st");
        }

        if (lastNumber == 2) {
            return String.valueOf(number).concat("nd");
        }

        if (lastNumber == 3) {
            return String.valueOf(number).concat("rd");
        }

        return String.valueOf(number).concat("th");
    }

}
