package nl.han.meron.oose.dea.primetester;

import nl.han.meron.oose.dea.primetester.exception.OuchIFoundThirtySevenAndHenceMustDieException;
import org.apache.commons.math3.primes.Primes;

public class PrimeTester implements Runnable {

    private NumberUnderTest numberUnderTest;
    private int highestNumberToTest;

    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    public void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {

        while (true) {

            var number = numberUnderTest.getNumber();

            if (number > highestNumberToTest) {
                break;
            }

            if (number == 37) {
                throw new OuchIFoundThirtySevenAndHenceMustDieException();
            }
            var isPrime = Primes.isPrime(number);

            if (isPrime) {
                System.out.println(Thread.currentThread().getId() + " found a prime number: " + number);
            }
        }
    }

    public void run(){
        try {
            startTesting();
        } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
            System.out.println(Thread.currentThread().getId() +  " found Thirty Seven and must die.");
        }
    }
}
