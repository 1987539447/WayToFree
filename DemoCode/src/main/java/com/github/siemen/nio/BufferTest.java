package com.github.siemen.nio;
/**
 * Created by Zhan on 2017-06-30.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio buffer
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        //ByteBuffer,MappedByteBuffer,CharBuffer.....
        ByteBuffer buffer = ByteBuffer.allocate(1024);//分配空间
        buffer.flip();//改变buffer为读取模式--调整指针位置
        buffer.clear();//清空buffer
        buffer.compact();//压缩buffer,移除已读取数据，并把未读取数据移动到buffer起始处
        buffer.capacity();//buffer容量
        buffer.position();//当前指针，读写数据时自动移动，切换为读模式flip()时，position重置为0，从头开始读取
        buffer.limit();//边界指针，写模式下同capacity,读模式下指向数据尾部，表示最大可读取字节

        FileChannel channel = new RandomAccessFile("","rw").getChannel();
        channel.read(buffer);//从channel写数据到buffer
        buffer.put((byte) 'c');//直接向buffer写入数据
        buffer.putChar('c');

        channel.write(buffer);//buffer数据读取到channel写到外部
        buffer.get();//直接读取buffer
        buffer.getChar();

        buffer.rewind();//重置position指针，可以从头重新读取
    }
}
