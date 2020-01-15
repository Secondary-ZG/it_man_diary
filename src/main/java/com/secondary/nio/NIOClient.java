package com.secondary.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/3 11:35
 * Description: NIO客户端
 */
public class NIOClient {

    //通道管理器
    private Selector selector;

    public static void main(String[] args) throws IOException {

        NIOClient client = new NIOClient();
        client.initClient("127.0.0.1", 9000);
        client.connect();
    }

    /**
     * 获得一个Socket通道，并对该通道做一些初始化的工作
     *
     * @param ip 连接的服务器的ip
     * @param port 连接的服务器的端口号
     * @throws IOException
     */
    public void initClient(String ip, int port) throws IOException {
        //获得一个Socket通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置通道为非阻塞
        socketChannel.configureBlocking(false);
        //获得一个通道管理器
        this.selector = Selector.open();

        //客户端连接服务器，其实方法执行并没有实现连接，需要在listen()方法种调用
        //用channel.finishConnect()才能完成连接
        socketChannel.connect(new InetSocketAddress(ip, port));
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OPEN_CONNECT事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     * @throws IOException
     */
    public void connect() throws IOException {
        //轮询访问selector
        while (true) {
            selector.select();
            //获得selector种选中的项的迭代器
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                //删除已选中的key， 以防重复处理
                iterator.remove();

                //连接事件发生
                if (selectionKey.isConnectable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    if (socketChannel.isConnectionPending()) {
                        socketChannel.finishConnect();
                    }
                    //设置成非阻塞
                    socketChannel.configureBlocking(false);
                    //在这里可以给客户端发送新
                    ByteBuffer byteBuffer = ByteBuffer.wrap("HelloServer".getBytes());
                    socketChannel.write(byteBuffer);
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限
                    socketChannel.register(this.selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    read(selectionKey);
                }
            }
        }
    }

    /**
     * 处理读取服务端发来的信息的事件
     * @param selectionKey
     * @throws IOException
     */
    public void read(SelectionKey selectionKey) throws IOException {
        //和服务端的read方法一样
        //服务器课读取消息:得到事件发生的Socket通道
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //创建读取的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = socketChannel.read(byteBuffer);
        if (len != -1) {
            System.out.println("客户端收到信息：" + new String(byteBuffer.array(), 0, len));
        }
    }

}
