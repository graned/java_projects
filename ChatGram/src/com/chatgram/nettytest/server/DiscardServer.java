/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatgram.nettytest.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import javax.media.CaptureDeviceManager;


/**
 *
 * DISCARDS ANY INCOMING DATA
 */
public class DiscardServer {
 
    private int port;
    public DiscardServer(int port){
        this.port = port;
    }
    
    public void run()throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        public void initChannel(SocketChannel ch) throws Exception{
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);
            
            //BIND AND START TO ACCEPT INCOMING CONNECTIONS
            ChannelFuture f = b.bind(port).sync();
            
            //WAIT UNTIL SERVER SOCKET IS CLOSED 
            //IN THIS EXAMPLE WE DO NOT DO THAT, BUT WE CAN DO IT  GRACEFULLY
            f.channel().closeFuture().sync();
        } finally{
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    
    public static void main(String[] args) throws Exception {
        int port;
        new DiscardServer(8080).run();
    }
}









