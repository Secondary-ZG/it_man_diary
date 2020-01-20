package com.secondary.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/16 14:42
 * Description: Netty时间服务
 */
@Slf4j
public class TimeServer {

    public void bind(int port) throws Exception {
        /**
         * 配置服务端的NIO线程组
         * 创建两个的原因是：一个用于服务端接受客户端的连接，
         * 另一个用于进行SocketChannel的网络读写
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture cf = sb.bind(port).sync();

            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("[TimeServer] into [bind] is error:", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {

        int port = 8080;
        if (null != args && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                log.error("Integer.valueOf(args[0]) is error:", e);
            }
        }
        new TimeServer().bind(port);

    }

}
