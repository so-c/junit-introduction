package chapter19.practice1;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    /**
     * 指定された数までのFizzBuzzのリストを返す.
     * @param num FizzBuzzの数
     * @return 指定された数までのFizzBuzzのリスト
     */
    public static List<String> createFizzBuzzList(int num) {
        List<String> result = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            result.add(getFizzBuzz(i));
        }
        return result;
    }

    private static String getFizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        
        if (i % 3 == 0) {
            return "Fizz";
        }
        
        if (i % 5 == 0) {
            return "Buzz";
        }
        
        return Integer.toString(i);
    }

}
