package com.zn.cn.args;

/**
 * @FilePath TDD com.zn.cn.args CommandConfig
 * @Description TODO
 * @Author zn
 * @Date 2019/10/26 16:12
 * @Version v1.0.0
 * @Location 中国四川省成都市高新区天府大道1700号 环球中心E2 1-3-1708
 **/

public class CommandConfig {
    // 命令名
    String commandName;
    // 命令数据类型
    Class commandDataType;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
    public Class getCommandDataType() {
        return commandDataType;
    }
    public void setCommandDataType(Class commandDataType) {
        this.commandDataType = commandDataType;
    }
}
