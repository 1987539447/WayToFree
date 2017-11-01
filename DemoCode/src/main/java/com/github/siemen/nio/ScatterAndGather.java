package com.github.siemen.nio;
/**
 * Created by Zhan on 2017-06-30.
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 分散和聚集
 */
public class ScatterAndGather {

    public static void main(String[] args) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        SocketChannel channel = (new ServerSocket()).accept().getChannel();
        ByteBuffer[] bufferArray = new ByteBuffer[]{header,body};
        channel.read(bufferArray);//一个buffer被写满才切换到下一个，要求读取对象必须长度固定
        channel.write(bufferArray);//将buffer中数据依次写入channel
    }
}
