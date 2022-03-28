package implement;

import java.util.*;
import java.io.*;

public class BOJ_16639_괄호추가하기3 {
    /**
     * Expression 원소들을 저장
     */
    static class Expression{
        boolean number;
        long num;
        char exp;

        public Expression(boolean number, long num) {
            this.number = number;
            this.num = num;
        }

        public Expression(boolean number, char exp) {
            this.number = number;
            this.exp = exp;
        }
    }
    static long result = Long.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        List<Expression> exp = new ArrayList<>();
        for(int i =0 ; i < N ; i++){
            if(0<=str.charAt(i)-'0'&&str.charAt(i)-'0'<10){     // 숫자 저장
                exp.add(new Expression(true, str.charAt(i)-'0'));
            } else{ // 연산자 저장
                exp.add(new Expression(false, str.charAt(i)));
            }
        }

        makeExpression(exp);

        System.out.println(result);
    }

    private static void makeExpression(List<Expression> rem) {
        if(rem.size() == 1){    // 숫자 하나만 남았을 때
            result = Math.max(result, rem.get(0).num);
            return;
        }
        for(int i =0 ; i < rem.size()-2 ; i+=2){
            List<Expression> tmp = new ArrayList<>();
            for(Expression e:rem) tmp.add(e);
            long x = tmp.get(i).num;    // 숫자 1
            char y = tmp.get(i+1).exp;  // 연산자
            long z = tmp.get(i+2).num;  // 숫자 2
            tmp.remove(i+2);    // 리스트에서 없앰
            tmp.remove(i+1);
            tmp.remove(i);
            switch (y){
                case '+':{
                    long n = x+z;
                    tmp.add(i, new Expression(true, n));    // 기존 인덱스에 계산 값 추가
                    break;
                }
                case '-':{
                    long n = x-z;
                    tmp.add(i, new Expression(true, n));     // 기존 인덱스에 계산 값 추가
                    break;
                }
                case '*':{
                    long n = x*z;
                    tmp.add(i, new Expression(true, n));     // 기존 인덱스에 계산 값 추가
                    break;
                }
            }
            makeExpression(tmp);
        }
    }
}
