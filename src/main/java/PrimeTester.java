import org.apache.commons.math3.primes.Primes;

public class PrimeTester extends Thread {

    NumberUnderTest numberUnderTest;
    int highestNumberToTest;


    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    public void startTesting() {

        while (true) {

            var number = numberUnderTest.getNumber();

            if (number > highestNumberToTest) {
                break;
            }

            boolean isPrime = Primes.isPrime(number);

            if (isPrime) {
                System.out.println(Thread.currentThread().getId() + " found a prime number: " + number);
            }
        }
    }

    @Override
    public synchronized void run() {
        startTesting();
    }
}
