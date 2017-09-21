package mathOperations;

public class MathOperations {

    public static boolean isOperant = false;
    public static int operant;
    public static double[] bufferOfNumbers = {0.0, 0.0, 0.0};
    public static double resultOfOperations;
    public static double finalResult;

    public static void mathOperations(int numberOfOperation) throws ArithmeticException {

        if (numberOfOperation == 1) { // addition
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] + bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 2) { // subtraction
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] - bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 3) { // division
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] / bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        } else if (numberOfOperation == 4) { // increase
            bufferOfNumbers[2] = resultOfOperations;
            bufferOfNumbers[0] = bufferOfNumbers[1] * bufferOfNumbers[2];
            bufferOfNumbers[1] = bufferOfNumbers[0];
            bufferOfNumbers[2] = 0;
        }
    }
}
