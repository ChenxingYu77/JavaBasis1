package Example;

public class RandomNumber {
    public static void main(String[] args) {
        int rangeStart = 30;
        int rangeEnd = 90;

        // Math.random() 生成随机数，随机数在0到1之间，类型是double
        int mod = rangeEnd - rangeStart;
        if(rangeStart < 0 || rangeEnd < 0){
            System.out.println("开始和结束必须是正的");
        }
        if (mod<=1) {
            System.out.println("非法的数字范围：(" + rangeStart + "," + rangeEnd + ")");
        }
        for (int i = 0; i < 50; i++) {
            int bigRandom = (int)(Math.random() * rangeEnd * 100);
            int numberToGuess = (bigRandom%mod) + rangeStart;
            if (numberToGuess < rangeStart){
                numberToGuess = rangeStart + 1;
            } else if (numberToGuess > rangeEnd) {
                numberToGuess = rangeEnd - 1;
            }
            System.out.println("随机数是："+numberToGuess);
        }
    }
}
