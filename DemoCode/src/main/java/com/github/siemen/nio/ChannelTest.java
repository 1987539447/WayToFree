package com.github.siemen.nio;
/**
 * Created by Zhan on 2017-06-27.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java nio channel
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {

        transfer();
    }

    public static void channelRead() throws IOException {
        RandomAccessFile file = new RandomAccessFile("test.txt","rw");
        FileChannel channel = file.getChannel();//从文件或者流获取到channel
        ByteBuffer buffer = ByteBuffer.allocate(10);//构建缓存并读取
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1){
            System.out.println("Read--bytes-"+bytesRead);
            buffer.putChar('X');
            buffer.putChar('X');
            buffer.flip();//buffer变为读模式，修改数据指针
            buffer.mark();
            System.out.print((char)buffer.get());
            buffer.reset();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            channel.write(buffer);
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        file.close();
    }

    public static void transfer() throws IOException {
        FileChannel fromChannel = new RandomAccessFile("from.txt","rw").getChannel();//从文件或者流获取到channel
        FileChannel toChannel = new RandomAccessFile("to.txt","rw").getChannel();//从文件或者流获取到channel
        toChannel.transferFrom(fromChannel,0,fromChannel.size());
        fromChannel.transferTo(0,fromChannel.size(),toChannel);
    }
}
