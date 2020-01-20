package com.secondary.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/16 15:50
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    public void ChannelRead(ChannelHandlerContext channelHandlerContext, Object message) throws Exception {
        ByteBuf byteBuf = (ByteBuf) message;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);

        String body = new String(req, "UTF-8");
        System.out.println("the time server receive order :" + body);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis())
                .toString() : "BAD ORDER";

        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        channelHandlerContext.write(resp);
    }

}
