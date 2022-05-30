package Example;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        //创建Scanner来读取用户的键盘输入
        Scanner in = new Scanner(System.in);

        //游戏设置
        int rangeStart = 10;
        int rangeEnd = 90;
        int maxCount = 5;

        //游戏统计
        int totalGameCount = 0;
        int correctGuessCount = 0;
        //是否结束游戏
        boolean gameEnd = false;
        while(!gameEnd) {
            int mod = rangeEnd - rangeStart;
            if (rangeStart < 0 || rangeEnd < 0) {
                System.out.println("开始和结束必须是正的");
            }
            if (mod <= 1) {
                System.out.println("非法的数字范围：(" + rangeStart + "," + rangeEnd + ")");
            }
            int bigRandom = (int) (Math.random() * rangeEnd * 100);
            int numberToGuess = (bigRandom % mod) + rangeStart;
            if (numberToGuess < rangeStart) {
                numberToGuess = rangeStart + 1;
            } else if (numberToGuess > rangeEnd) {
                numberToGuess = rangeEnd - 1;
            }


        //剩余的猜测次数
            int leftToGuess = maxCount;

            boolean currentGameCounted = false;
            boolean correctGuess = false;

            System.out.println("请输入猜测的数字，范围在("+rangeStart+","+rangeEnd+")。 输入-1代表结束游戏");
            while (leftToGuess > 0) {
                System.out.println("剩余猜测次数"+leftToGuess+"。请输入本次猜测的数字：");

                int guess = in.nextInt();
                if(guess<0){
                    gameEnd=true;
                    System.out.println("用户选择结束游戏");
                    break;
                }
                if(!currentGameCounted){
                    totalGameCount++;
                    currentGameCounted = true;
                }
                leftToGuess--;
                if (guess > numberToGuess){
                    System.out.println("输入的数字比正确数字大");
                } else if (guess < numberToGuess){
                    System.out.println("输入的数字比正确数字小");
                } else{
                    correctGuessCount++;
                    correctGuess = true;
                    System.out.println("输入的数字正确");
                    break;
                }
            }
            if(!correctGuess){
                System.out.println("本次的正确数字是："+numberToGuess);
            }
            System.out.println("共进行了"+totalGameCount+"次游戏，其中猜中的次数为"+correctGuessCount);
        }
    }
}
