package Leetcode.zap.todo.sandbox;

import java.util.ArrayList;
import java.util.List;

public class CharStringExample {

    public static void main(String[] args) {
        new CharStringExample().selfDividingNumbers(1, 22).forEach(k-> System.out.println(k));
    }
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> results = new ArrayList<>();


        for(int i = left; i<=right;i++){
            if(isSelfDividing(i)){
                results.add(i);
            }
        }


        return results;
    }

    public boolean isSelfDividing(int num ){

        for(char c : String.valueOf(num).toCharArray()){
            if(c == '0' || num % (c-'0') > 0 ){
                return false;
            }
        }

        return true;
    }
}
