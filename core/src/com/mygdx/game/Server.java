package com.mygdx.game;

import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;

/**
 * Server class
 */
/*
public class Server {
    private int port;
    private boolean running = false;
    private Selector selector;
    private ServerSocket serverSocket;
    private ByteBuffer buffer;

    public Server(int port, int bufferSize){
        this.port = port;
        this.buffer = ByteBuffer.allocate(bufferSize);
    }

    public void start(){
        /new Thread(this).start();
    }

    @Override
    public void run() {
        running = true;
    }
}
*/