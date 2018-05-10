package com.zx.concurrent;

import com.zx.concurrent.annoations.NotThreadSafe;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * author:ZhengXing
 * datetime:2018-05-10 20:43
 * 并发测试
 */
@NotThreadSafe
@Slf4j
public class ConcurrentTest {

    // 请求总数
    private static int clientTotal = 5000;

    // 同时并发数
    private static int threadTotal = 200;

    // 计数器
    private static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 让主线程等待所有线程执行完毕，再输出结果
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        // 执行请求总数次的请求
        for (int i = 0; i < clientTotal; i++) {
            // 执行请求，每次都调用信号量，控制并发在一定数量内
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("error:",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }

    /**
     * 递增
     */
    private static void add() {
        count++;
    }

}
