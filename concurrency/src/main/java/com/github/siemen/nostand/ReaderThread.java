package com.github.siemen.nostand;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 非标准取消
 * 不响应中断：网络IO
 * 重写Interupte，关闭底层连接
 */
public class ReaderThread extends Thread {

    private static final int BUF_SIZE = 10 * 1024;
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void interrupt() {
        try{
            socket.close();
        } catch (IOException e) {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[BUF_SIZE];
            while (true) {
                int count = in.read(buf);
                if(count < 0){
                    break;
                }else{
                    processBuf(buf);
                }
            }
        } catch (IOException e) {//线程直接退出
            e.printStackTrace();
        }
    }

    private void processBuf(byte[] buf) {

    }
}
