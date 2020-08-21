package com.lixiande.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore semaphoreH;
    private Semaphore semaphoreO;

        private CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                semaphoreH.release(2);
                semaphoreO.release();
            }
        });
        public H2O() {
            semaphoreH = new Semaphore(2);
            semaphoreO = new Semaphore(1);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            semaphoreH.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            try {
                cyclicBarrier.await();
            }catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            semaphoreO.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            try {
                cyclicBarrier.await();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
        }
    }
}
