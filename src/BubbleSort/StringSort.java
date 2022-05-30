package BubbleSort;

import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //输入字符串
        System.out.println("请输入要排序的字符串：");
        String input = sc.next();

        //将字符串拆分成单个字符，再转换成ASCII码串的数组
        int length = input.length();
        char[] inputSep = input.toCharArray();
        int[] stringToAsc = new int[length];
        for (int i = 0; i < length; i++) {
            stringToAsc[i] = inputSep[i];
        }

        //排序
        int max = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(stringToAsc[i]<stringToAsc[j]){
                    temp = stringToAsc[i];
                    stringToAsc[i] = stringToAsc[j];
                    stringToAsc[j] = temp;
                }
            }
        }

        //将结果输出
        System.out.print("有序字符串：");
        for (int i = 0; i < inputSep.length; i++) {
            char s = (char)stringToAsc[i];
            System.out.print(s);
        }
        System.out.println();
        System.out.print("ASCII码: [");
        for (int i = 0; i < stringToAsc.length-1; i++) {
            System.out.print(stringToAsc[i]+",");
        }
        System.out.print(stringToAsc[stringToAsc.length-1]+"]");
    }
}