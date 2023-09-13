

public class PrimeTestingApp{

        private static final int HIGHEST_NUMBER_TO_TEST = 2000;

        public static void main(String[] args) {
            var app = new PrimeTestingApp();
            app.startTesting();
        }

        private void startTesting() {
            var numberUnderTest = new NumberUnderTest();

            var tester1 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
            var tester2 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
            var tester3 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
            var tester4 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
            Thread thread1 = new Thread(tester1);
            Thread thread2= new Thread(tester2);
            Thread thread3 = new Thread(tester3);
            Thread thread4 = new Thread(tester4);

//
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();


        }
}
