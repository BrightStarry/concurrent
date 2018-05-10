### 并发和高并发处理相关学习

* 并发： 如果多个线程在单核CPU上运行，多个线程将交替地执行。也就是说，任何时间，实际上只有某个线程在执行，其他线程则在等待CPU分片时间。


#### CPU多级缓存
* CPU cache： 内存速度无法跟上CPU的执行速度。所以在CPU时钟周期内，CPU常需要等待内存。而且CPU cache就是为了解决这个问题。
    * CPU cache的意义：
        * 时间局部性： 如果某个数据被访问，那么在不久的将来它可能被再次访问。
        * 空间局部性： 如果某个数据被访问，那么和它相邻的数据可能马上被访问。
* CPU多级缓存-缓存一致性（MESI）： 用于保证多级缓存间共享的数据的一致
    * 数据有四种状态，例如缓存被修改，和内存中的数据不一致等。然后可以通过 
        local read/ local write/ remote read/ remote write几种操作修改数据，使其保持一致；
* 乱序执行优化：处理器为提高运算速度执行时打乱代码原有顺序        

#### 并发模拟
* Postman: 模拟Http请求工具，它也可以进行并发测试（最好安装windows版，chrome版少一些功能）
* Apache Bench（AB）： Apache附带的工具，测试网站性能
* JMeter： Apache组织中的压测工具
* 代码：使用Semaphore、CountDownLatch等(查看ConcurrentTest类)

