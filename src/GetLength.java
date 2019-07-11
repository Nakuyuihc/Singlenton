public class GetLength {
    public static void main(String[] args) {
        int i = 22;
        int length = getLength(i);
        System.out.println(length);
    }

    public static int getLength(int i){
        if(i < 10)return 1;
        return getLength(i/10)+1;
    }
}
