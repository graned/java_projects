/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatgram.nettytest.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * IMPLEMENTATION OF A DESCARD PROTOCOL
 * 
 * THIS CODE HANDLES THE SERVER-SIDE CHANNEL
 * 
 * -NOTES
 * DiscardServerHandler extends ChannelInboundHandlerAdapter, which is an implementation of ChannelInboundHandler. ChannelInboundHandler provides various event handler methods that you can override. For now, it is just enough to extend ChannelInboundHandlerAdapter rather than to implement the handler interface by yourself.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

    /**
     * CLOSES CONNECTION WHENEVER AN EXCEPTION OCCURS
     * @param ctx
     * @param cause
     * @throws Exception 
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * THIS OVERRIDE METHOD WILL DISCARD THE RECIEVED DATA SILENTLY
     * -NOTES
     * We override the channelRead() event handler method here. This method is called with the received message, whenever new data is received from a client. In this example, the type of the received message is ByteBuf.
     * @param ctx
     * @param msg
     * @throws Exception 
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf in = (ByteBuf)msg;
        try {
            while(in.isReadable()){
                System.out.println((char)in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
        */
        //ECHO SERVER IMPLEMENTATION
        ctx.write(msg);
        ctx.flush();
    }
    
}
