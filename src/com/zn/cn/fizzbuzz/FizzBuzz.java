package com.zn.cn.fizzbuzz;

/**
 * Created by zn on 2019/10/20.
 */
public class FizzBuzz {
    public String printNumber(int number) {
        String numberStr = number + "";
        if((isDelivery(number,3) && isDelivery(number,5)) || (contains(numberStr,"3") && contains(numberStr,"5"))) {
            return "fizzbuzz";

        }
        if(isDelivery(number,3) || contains(numberStr,"3")) {
            return "fizz";
        }
        if(isDelivery(number,5) || contains(numberStr,"5")) {
            return "buzz";
        }
        return numberStr;
    }
    public boolean isDelivery(int n1, int n2){
        return n1 % n2 == 0;
    }
    public boolean contains(String str1, String containStr) {
        return str1.contains(containStr);
    }
}
