package com.atlwj.protocol.dubbo;

import com.atlwj.framework.Invocation;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.concurrent.*;

public class NettyClient<T> {

    public NettyClientHandler client = null;

    //private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static final int corePoolSize = 10;

    private static final int maxinumPoolSize = 100;

    private static final long keepAliveTime = 1;

    private static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);

    private static ThreadPoolExecutor executorService;

    static {
        executorService = new ThreadPoolExecutor(corePoolSize,maxinumPoolSize,keepAliveTime, TimeUnit.SECONDS,workQueue,
                new ThreadFactoryBuilder().setNameFormat("XX-task-5d").build());
    }

    public void start(String hostName, Integer port) {
        client = new NettyClientHandler();

        Bootstrap b = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("decoder", new ObjectDecoder(ClassResolvers
                                .weakCachingConcurrentResolver(this.getClass()
                                        .getClassLoader())));
                        pipeline.addLast("encoder", new ObjectEncoder());
                        pipeline.addLast("handler", client);
                    }
                });

        try {
            b.connect(hostName, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String send(String hostName, Integer port, Invocation invocation) {
        if (client == null) {
            start(hostName, port);
        }

        client.setInvocation(invocation);
        try {
            return (String) executorService.submit(client).get();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (ExecutionException e) {
//            e.printStackTrace();
        }
        return null;
    }


}
