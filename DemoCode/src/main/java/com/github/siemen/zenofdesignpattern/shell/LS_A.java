package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * ls -a 命令
 */
public class LS_A extends AbstractLS {
    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_a(vo.formatData());
    }

    @Override
    protected String getOperateParam() {
        return super.A_PARAM;
    }
}
