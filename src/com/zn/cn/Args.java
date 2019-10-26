package com.zn.cn;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zn.cn.Command;
import sun.awt.image.ImageWatched;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @FilePath TDD com.zn.cn Args
 * @Description TODO
 * @Author zn
 * @Date 2019/10/21 10:36
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class Args {
    Map initMap = new LinkedHashMap();
    Map runMap = new LinkedHashMap();
    public Args() {
        initCommand();
    }
    public String parseCommandName(String commandLine) {
        String[] commands = commandLine.split(" ");
        String names = "";
        for (String command : commands) {
            command = command.replace("-", "");
            names = names + command + ",";
        }
        return names.substring(0, names.length() - 1);
    }

    public String parseCommandNameAndValue(String commandLine) throws Exception {
        // "-l -p8080 -chttp://www.baidu.com -d"
        String[] commands = commandLine.split(" ");
        for (String command : commands) {
            command = command.replace("-", "");
            if (command.length() < 1) {
                throw new Exception("参数格式错误，请检查是否是-命令，如：-d. 错误参数:" + command);
            }
            if (command.length() == 1) {
                Object value = "";
                if (initMap.containsKey(command)) {
                    Command command1 = (Command) initMap.get(command);
                    if (command1.getType() == Integer.class) {
                        value = 0;
                    } else if (command1.getType() == Boolean.class) {
                        value = true;
                    } else {
                        value = "";
                    }
                }
                runMap.put(command, value);
            } else {
                String key = command.substring(0, 1);
                String value1 = command.substring(1);
                runMap.put(key, value1);
            }
        }
        String str = "";
        Iterator iterator = this.runMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            str = str + key + ":" + this.runMap.get(key) + ",";
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

    private void initCommand() {
        Command command = new Command();
        command.setName("l");
        command.setValue("");
        command.setType(Boolean.class);
        initMap.put("l", command);

        command = new Command();
        command.setName("p");
        command.setValue(0);
        command.setType(Integer.class);
        initMap.put("p", command);

        command = new Command();
        command.setName("d");
        command.setValue(0);
        command.setType(Integer.class);
        initMap.put("d", command);

        command = new Command();
        command.setName("c");
        command.setValue(0);
        command.setType(String.class);
        initMap.put("c", command);
    }
}
