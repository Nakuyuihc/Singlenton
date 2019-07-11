public class ReverseNum {
    public int reverseNum(int paraNum){
        int revNum = 0;
        // 关键也就是这三行的代码
        while(paraNum != 0){
            revNum =  paraNum % 10 + revNum * 10;
            paraNum /= 10;
        }
        return revNum;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseNum().reverseNum(19870));
    }
}
