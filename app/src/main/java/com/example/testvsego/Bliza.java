package com.example.testvsego;

public class Bliza {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    System.out.print(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 100) {
                thread.interrupt();
            }
            System.out.print("M");
        }
        System.out.print("\nFinish");

    }
}
