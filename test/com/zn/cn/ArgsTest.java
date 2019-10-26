package com.zn.cn;

import cn.hutool.core.collection.CollUtil;
import com.zn.cn.args.Args;
import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @FilePath TDD com.zn.cn ArgsTest
 * @Description TODO
 * @Author zn
 * @Date 2019/10/26 15:35
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class ArgsTest extends TestCase {
    String commandLine = "-ltrue,false,true -p9809,89,0, -h http://www.baidu.com,/usr/home/root,root.n -d0,1,2,3,4";
    Args args = new Args();
//    public void test_command_name(){
//        List commandNames = new ArrayList();
//        commandNames.add("lfalse");
//        commandNames.add("p9809");
//        commandNames.add("h http://www.baidu.com");
//        commandNames.add("d");
//        commandNames.add("s");
//        assertEquals(commandNames,args.parserCommandName(commandLine));
//    }

//    public void test_command_name_and_value() {
//        Map map = new LinkedHashMap();
//        map.put("l","");
//        map.put("p","9809");
//        map.put("h","http://www.baidu.com");
//        map.put("d","");
//        map.put("s","");
//        assertEquals(map,args.parserCommandNameAndValue(commandLine));
//    }

    public void test_command_name_and_value_data_type() {
//        Map map = new LinkedHashMap();
//        map.put("l",true);
//        map.put("p",);
//        map.put("h","http://www.baidu.com,/usr/root/home,abc");
//        map.put("d",0);
//        map.put("s","/usr/root/home");
       Map map = args.parserCommandNameAndValueDataType(commandLine);
       System.out.println(map);
    }
}
