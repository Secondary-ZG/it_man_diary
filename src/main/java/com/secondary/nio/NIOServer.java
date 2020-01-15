package com.secondary.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/3 10:39
 * Description: NIO服务端
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        //创建一个在本地窗口进行监听的服务Socket通道，并设置为非阻塞
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //必须配置为非阻塞才能往selector上注册，否则会报错，selector模式本身就是非阻塞模式
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));

        //创建一个选择器selector
        Selector selector = Selector.open();

        //将ServerSocketChannel注册到selector上，并且selector对客户端accept连接操作感兴趣
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            System.out.println("等待事件发生");
            //轮询监听channel里的key，selector是阻塞的，accept()也是阻塞的
            selector.select();

            System.out.println("有事件发生了");
            //有客户端请求，被轮询听到 遍历selector中的keys
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //删除本次已处理的key，防止下次select重复处理
                iterator.remove();
                handle(key);
            }
        }
    }

    private static void handle(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            System.out.println("有客户端连接事件发生了");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            //NIO非阻塞体现：此处accept方法是阻塞的，但是这里因为发生了连接事件，所以这个方法马上会执行完，不会阻塞
            //处理完连接请求不会继续等待客户端的数据发送
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            //通过Selector监听Channel时对读事件感兴趣
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            System.out.println("有客户端数据可读事件发生了");
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //NIO非阻塞体现：首先read方法不会阻塞，其次这种事件响应模型，当调用到read方法时肯定是发生了客户端发送数据的事件
            int len = socketChannel.read(byteBuffer);
            if (len != -1) {
                System.out.println("读取到客户端发送的数据：" + new String(byteBuffer.array(), 0, len));
            }
            ByteBuffer byteBufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
            socketChannel.write(byteBufferToWrite);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (key.isWritable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            System.out.println("write事件");
            //NIO事件触发时水平触发
            //使用Java的NIO编程的时候，在没有数据可以往外写的时候要取消事件
            key.interestOps(SelectionKey.OP_READ);
            socketChannel.close();
        }
    }
}
