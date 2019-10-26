package com.zn.cn;

import com.zn.cn.fizzbuzz.FizzBuzz;
import junit.framework.TestCase;
import org.junit.Test;

public class FizzBuzzTest extends TestCase {
    @Test
    public void testPrintNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1",fizzBuzz.printNumber(1));
        assertEquals("fizz",fizzBuzz.printNumber(3));
        assertEquals("buzz",fizzBuzz.printNumber(5));
        assertEquals("fizzbuzz",fizzBuzz.printNumber(35));
        assertEquals("fizzbuzz",fizzBuzz.printNumber(53));
        assertEquals("fizz",fizzBuzz.printNumber(13));
        assertEquals("buzz",fizzBuzz.printNumber(55));
    }
}