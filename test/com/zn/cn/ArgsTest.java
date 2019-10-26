package com.zn.cn;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by zn on 2019/10/20.
 */
public class ArgsTest extends TestCase {
    Args args = new Args();
    @Test
    public void test_parse_command_name(){
        assertEquals("l,p,c",args.parseCommandName("-l -p -c"));
    }

    @Test
    public void test_parse_command_value() {
        try {
            String result = args.parseCommandNameAndValue("-l -p8080 -chttp://www.baidu.com -d");
            String expected = "l:true,p:8080,c:http://www.baidu.com,d:0";
            assertEquals(expected,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_parse_command_value_and_multi_format() {
        try {
            String result = args.parseCommandNameAndValue("-l -p 8080 -c http://www.baidu.com -d ");
            String expected = "l:true,p:8080,c:http://www.baidu.com,d:0";
            assertEquals(expected,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
