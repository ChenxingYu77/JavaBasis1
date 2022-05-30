package Example;

import java.util.Random;
import java.util.Scanner;

public class ScoresDispose {
    public static void main(String[] args) {
        //声明六个变量，分别代表六门科目的成绩
        int yuWenIndex = 0;
        int shuXueIndex = 1;
        int waiYuIndex = 2;
        int wuLiIndex = 3;
        int huaXueIndex = 4;
        int shengWuIndex = 5;

        //每门课的名字
        String[] names = new String[6];
        names[yuWenIndex] = "语文";
        names[shuXueIndex] = "数学";
        names[waiYuIndex] = "外语";
        names[wuLiIndex] = "物理";
        names[huaXueIndex] = "化学";
        names[shengWuIndex] = "生物";

        Scanner in = new Scanner(System.in);
        System.out.println("请问要保存几年的成绩？");
        int yearCount = in.nextInt();

        double[][] scores = new double[yearCount][names.length];
        Random r = new Random();
        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < names.length; j++) {
                scores[i][j] = r.nextInt(100) ;
            }
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < names.length; j++) {
                System.out.println("第"+(i+1)+"年"+names[j]+"成绩为："+scores[i][j]);
            }

        }

//        System.out.println("请问你要查看第几年的成绩？");
//        int year = in.nextInt() - 1;
//        System.out.println("请输入要查看的课程编号");
//        int scoreIndex = in.nextInt() - 1;
//        System.out.println("第"+(year+1)+"年的"+names[scoreIndex]+"成绩是："+scores[year][scoreIndex]);
        boolean cont = true;
        while (cont) {
            System.out.println("请输入要进行的操作编号：");
            System.out.println("1: 求某年最好成绩\n"+
                    "2: 求某年的平均成绩\n"+
                    "3: 求所有年份最好成绩\n"+
                    "4: 求某门课历年最好成绩");
            int oprtId = in.nextInt();

            int oprtYear = 0;
            switch (oprtId){
                case 1:
                    System.out.println("请输入要求那一年的最好成绩：");
                    oprtYear = in.nextInt() - 1;
                    if(oprtYear<0 || oprtYear>=yearCount){
                        System.out.println("非法的年份");
                        break;
                    }
                    int bestOfYearScoreId = 0;
                    for (int i = 1; i < scores[oprtYear].length; i++) {
                        if (scores[oprtYear][bestOfYearScoreId]<scores[oprtYear][i]) {
                            bestOfYearScoreId = i;
                        }
                    }
                    System.out.println("第"+(oprtYear+1)+"年最好成绩为"+names[bestOfYearScoreId]+":"+scores[oprtYear][bestOfYearScoreId]);
                    break;
                case 2:
                    System.out.println("请输入要求那一年的平均成绩：");
                    oprtYear = in.nextInt() - 1;
                    if(oprtYear<0 || oprtYear>=yearCount){
                        System.out.println("非法的年份");
                        break;
                    }
                    int totalYearScoreId = 0;
                    for (int i = 0; i < scores[oprtYear].length; i++) {
                        totalYearScoreId += scores[oprtYear][i];
                    }
                    double averScore = (double)totalYearScoreId/scores[oprtYear].length;
                    System.out.println("第"+(oprtYear+1)+"年平均成绩为"+":"+averScore);
                    break;
                case 3:
                    int bestOfYearScoreid = 0;
                    oprtYear = 0;
                    for (int i = 0; i < scores.length; i++) {
                        for (int j = 0; j < scores[i].length; j++) {
                            if(scores[oprtYear][bestOfYearScoreid]<scores[i][j]){
                                oprtYear = i;
                                bestOfYearScoreid= j;
                            }
                        }
                    }
                    System.out.println("历年最好成绩为第"+(oprtYear+1)+"年的"+names[bestOfYearScoreid]+"成绩："+scores[oprtYear][bestOfYearScoreid]);
                    break;
                case 4:
                    System.out.println("请问要查询哪门课的历年最好成绩：");
                    int scoreId = in.nextInt();
                    oprtYear = 0;
                    for (int i = 1; i < scores.length; i++) {
                        if(scores[oprtYear][scoreId]<scores[i][scoreId]){
                            oprtYear = i;
                        }
                    }
                    System.out.println(names[scoreId]+"历年最好成绩为第"+(oprtYear+1)+"年，成绩为："+scores[oprtYear][scoreId]);
                    System.out.println(scores.length);
                    break;
                default:
                    System.out.println("程序结束");
                    cont = false;
                    break;
            }

        }
    }
}
