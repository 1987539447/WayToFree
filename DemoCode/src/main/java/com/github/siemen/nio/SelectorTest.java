package com.github.siemen.nio;
/**
 * Created by Zhan on 2017-06-26.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * nio selector
 */
public class SelectorTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel channel = new ServerSocket().getChannel();
        channel.configureBlocking(false);
        SelectionKey key = channel.register(selector,SelectionKey.OP_READ);
    }
}
