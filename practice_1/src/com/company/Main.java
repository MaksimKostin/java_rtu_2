package com.company;

class PingPongPrint{
    private int count = 0;

    public synchronized void ping(){
        System.out.print("Ping ");
        count++;
        notify();
        if(count < 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pong(){
        System.out.print("Pong ");
        count++;
        notify();
        if(count < 6){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Ping implements Runnable{
    PingPongPrint pingPongPrint;

    public Ping(PingPongPrint pingPongPrint) {
        this.pingPongPrint = pingPongPrint;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            pingPongPrint.ping();
        }
    }
}

class Pong implements Runnable{
    PingPongPrint pingPongPrint;

    public Pong(PingPongPrint pingPongPrint) {
        this.pingPongPrint = pingPongPrint;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            pingPongPrint.pong();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        PingPongPrint pingPongPrint = new PingPongPrint();
        new Thread(new Ping(pingPongPrint)).start();
        new Thread(new Pong(pingPongPrint)).start();
    }
}


