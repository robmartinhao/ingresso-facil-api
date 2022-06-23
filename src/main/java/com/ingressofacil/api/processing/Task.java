package com.ingressofacil.api.processing;

public class Task extends Thread {

    private final long initialValue;
    private final long finalValue;
    private long total = 0;

    public Task(int initialValue, int finalValue) {
        this.initialValue = initialValue;
        this.finalValue = finalValue;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public void run() {
        for (long i = initialValue; i <= finalValue; i++) {
            for (long j = 0; j <= 500; j++) {
                total += j;
            }
            total += i;
        }
    }
}
