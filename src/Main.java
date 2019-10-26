import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.util.Date;

/**
 * @FilePath TDD PACKAGE_NAME Main
 * @Description TODO
 * @Author zn
 * @Date 2019/10/23 15:46
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class Main {
    public static void main(String [] args) {
        Snowflake snowflake = IdUtil.createSnowflake(1,1);
        for(int i = 0; i < 10 ; i ++) {
            System.out.println(snowflake.nextId());
        }
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
