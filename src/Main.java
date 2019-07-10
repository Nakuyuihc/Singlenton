public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        for(int i = 0;i < 3;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    TestSingleton testSingleton = TestSingleton.getIntance();
                    System.out.println(testSingleton.hashCode());
                }
            });
            thread.start();
        }
    }
}
