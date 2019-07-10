public class TestSingleton {

    private enum Singleton{
        INTANCE;
        private TestSingleton singleton;
        private Singleton(){
            singleton = new TestSingleton();
            System.out.println("单例对象初始化");
        }
        private TestSingleton getSingleton(){
            return singleton;
        }
    }

    public static TestSingleton getIntance(){
        return Singleton.INTANCE.getSingleton();
    }
}
