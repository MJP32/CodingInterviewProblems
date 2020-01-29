package Pramp;

/*

   A   B   C  D  E  F  G
A  C  -C  -C -C -C -C  -C
B  -C  C  -C -C -C -C  -C
D
F
F
G
H



*/

/*
base case Recussion
== shrink both src and tgt

src == '' tgt="ABC"
solution
out = "+A+B+C"

src == 'ABC' tgt=""
solution
out = "-A-B-C"

==
 shrink both src and tgt
!=
 -C from src
 +C from tgt

*/

import java.io.*;
import java.util.*;

class DiffBetweenTwoStrings {
    public static void main(String[] args) {

        System.out.println( diffBetweenTwoStrings("ABCDEFG", "ABDFFGH" ));



    }
    static String diffBetweenTwoStrings(String source, String target) {


        String result="";
        helper(source, target, result);


        return result;


    }


    static void  helper(String source, String target, String result){

        if(source.length() == 0){
            result += addChars(target);
            return;
        }

        if(target.length() == 0){
            result += addChars(source);
            return;
        }


        int i =0;
        int j=0;

        if(source.charAt(i)  == target.charAt(j)){
            result += source.charAt(i);

            helper( source, target, result);

        }
        else{
            result += "+"+target.charAt(i);
            String s = source.substring(1, source.length());
            String t = target.substring(1, target.length());

            helper(s, t,  result);

        }


    }

    private static String addChars(String target) {
        return target;
    }
}




