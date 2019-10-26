package com.zn.cn.args;
import java.util.regex.Matcher;
import	java.util.regex.Pattern;
import org.jboss.arquillian.container.test.spi.command.Command;

import java.util.*;

import java.util.stream.Collectors;

/**
 * @FilePath TDD com.zn.cn.args Args
 * @Description TODO
 * @Author zn
 * @Date 2019/10/26 15:40
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/
public class Args {
    Map<String,CommandConfig> config = new HashMap();

    public Args() {
        initCommandConfig();
    }
    private void initCommandConfig() {

        CommandConfig commandConfig = new CommandConfig();
        commandConfig.setCommandName("l");
        commandConfig.setCommandDataType(Boolean.class);
        config.put(commandConfig.getCommandName(),commandConfig);
        commandConfig = new CommandConfig();
        commandConfig.setCommandName("p");
        commandConfig.setCommandDataType(Integer.class);
        config.put(commandConfig.getCommandName(),commandConfig);

        commandConfig = new CommandConfig();
        commandConfig.setCommandName("h");
        commandConfig.setCommandDataType(String.class);
        config.put(commandConfig.getCommandName(),commandConfig);

        commandConfig = new CommandConfig();
        commandConfig.setCommandName("d");
        commandConfig.setCommandDataType(Integer.class);
        config.put(commandConfig.getCommandName(),commandConfig);

//        commandConfig = new CommandConfig();
//        commandConfig.setCommandName("s");
//        commandConfig.setCommandDataType(String.class);
//        config.put(commandConfig.getCommandName(),commandConfig);

    }
    public List parserCommandName(String commandLine) {
        String [] commands = commandLine.split("-");
        List<String> list  = Arrays.asList(commands);
        list = list.stream().filter(command->{
            return !command.trim().equals("");
        }).map(command-> {
            return command.trim();
        }).collect(Collectors.toList());
        return list;
    }

    public Map parserCommandNameAndValue(String commandLine) {
        Map map = new LinkedHashMap();;
        List<String> command = parserCommandName(commandLine);
        command.stream().forEach(action->{
            String key = action.substring(0,1);
            String value = "";

            if(action.length() > 1) {
                value = action.substring(1).trim();
            }
            if(config.containsKey(key)) {
                CommandConfig commandConfig = config.get(key);
                Class dataType = commandConfig.getCommandDataType();
                builderValueByDataType(map, key, value, dataType);
            } else {
                throw new RuntimeException("未知的命令：" + key);
            }
        });
        return map;
    }

    /**
     * 根据数据类型对value进行处理
     * @param map
     * @param key
     * @param value
     * @param dataType
     */
    private void builderValueByDataType(Map map, String key, String value, Class dataType) {
        if (dataType == Integer.class) {
            builderIntegerValue(map, key, value);
        } else if (dataType == Boolean.class) {
            builderBooleanValue(map, key, value);
        } else {
            builderStringValue(map, key, value);
        }
    }

    private void builderStringValue(Map map, String key, String value) {
        String[] values = value.split(",");
        map.put(key,Arrays.asList(values));
    }

    private void builderBooleanValue(Map map, String key, String value) {
        if(value.trim().equals("")){
            map.put(key,true);
        } else {
            String[] values = value.split(",");
            if(values.length == 1) {
                if (isBoolean(value)) {
                    map.put(key, Boolean.parseBoolean(value));
                } else {
                    throw new RuntimeException("参数" + key + "应该是true or false，现在的值为：" + value);
                }
            } else {
                boolean isBoolean = true;
                for (String s : values) {
                    if (!isBoolean(s)) {
                        throw new RuntimeException("参数" + key + "应该是一个布尔列表，现在的值有非布尔：" + value + "=>" + s);
                    }
                }
                if(isBoolean) {
                    map.put(key,Arrays.asList(values));
                }
            }
        }
    }

    private void builderIntegerValue(Map map, String key, String value) {
        if (value.trim().equals("")) {
            map.put(key, 0);
        } else {
            String[] values = value.split(",");
            if (values.length == 1) {
                if (isNumber(value)) {
                    map.put(key, Integer.parseInt(value));
                } else {
                    throw new RuntimeException("参数" + key + "应该是一个整数值，现在的值为：" + value);
                }
            } else {
                boolean isNumber = true;
                for (String s : values) {
                    if (!isNumber(s)) {
                        throw new RuntimeException("参数" + key + "应该是一个整数列表，现在的值有非整数：" + value + "=>" + s);
                    }
                }
                if(isNumber) {
                    map.put(key,Arrays.asList(values));
                }
            }
        }
    }

    private boolean isNumber(String numberValue) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(numberValue);
        return matcher.matches();
    }
    private boolean isBoolean(String value) {
        Pattern pattern = Pattern.compile("^true|false$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();

    }
    public Map parserCommandNameAndValueDataType(String commandLine) {
        Map map = parserCommandNameAndValue(commandLine);
        return map;
    }
}
