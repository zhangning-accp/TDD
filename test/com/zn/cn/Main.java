package com.zn.cn;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;

import java.util.HashMap;
import java.util.Map;

/**
 * @FilePath TDD com.zn.cn Main
 * @Description TODO
 * @Author zn
 * @Date 2019/10/30 16:23
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class Main {
    public static void main(String ... args) {
        String questionString = "{\"keyword\":\"PushUpsNumber\",\"orderNumber\":1,\"title\":\"记录下俯卧撑个数\",\"questionnaireId\":1186596190507245568,\"optionRange\":\"{\\\"max\\\":80,\\\"min\\\":0,\\\"step\\\":1}\",\"id\":1186596192587620352,\"style\":\"autoIncrementWheel\",\"description\":\"(如果不能完成，请滚动到最后选择不能完成)\",\"type\":1}";
        int index = questionString.indexOf("optionRange");
        index += "optionRange".length();
        String before = questionString.substring(0,index + 2);
        String after = questionString.substring(index + 2);
        String center = "";
//        Snowflake snowflake = new Snowflake(2,2);
//        for(int i = 0; i < 1000; i ++) {
//            long id = snowflake.nextId();
//        }
    }
}
