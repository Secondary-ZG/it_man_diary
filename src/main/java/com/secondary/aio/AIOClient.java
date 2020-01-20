package com.secondary.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/15 14:44
 * Description: AIO服务端
 */
public class AIOClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000)).get();
        socketChannel.write(ByteBuffer.wrap("Hello Sever".getBytes()));
    }

}
