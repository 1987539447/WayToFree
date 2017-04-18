package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * ls -l 命令
 */
public class LS_L extends AbstractLS {
    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_l(vo.formatData());
    }

    @Override
    protected String getOperateParam() {
        return super.L_PARAM;
    }
}
