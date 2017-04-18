package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * ls命令实现
 */
public class LS extends AbstractLS {
    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }

    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }
}
