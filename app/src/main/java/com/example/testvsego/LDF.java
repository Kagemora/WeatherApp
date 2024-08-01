package com.example.testvsego;

public class LDF {
    public static void main(String[] args) {
        System.out.println();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        break; // Выйти из цикла, если поток прерван
                    }
                    System.out.print(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Установить флаг прерывания снова
                        break; // Выйти из цикла при перехвате исключения
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
