package day2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (c),2016-2019,北京金地安华有限公司成都分公司
 * ClassName   :  Test2
 * Author      : MaMingze
 * Date        : 2019/3/5 16:51
 * Description : TODO
 * Version 1.0
 **/
/*1. 缓冲队列BlockingQueue简介：

  BlockingQueue是双缓冲队列。BlockingQueue内部使用两条队列，允许两个线程同时向队列一个存储，一个取出操作。在保证并发安全的同时，提高了队列的存取效率。

2. 常用的几种BlockingQueue：

ArrayBlockingQueue（int i）:规定大小的BlockingQueue，其构造必须指定大小。其所含的对象是FIFO顺序排序的。

LinkedBlockingQueue（）或者（int i）:大小不固定的BlockingQueue，若其构造时指定大小，生成的BlockingQueue有大小限制，不指定大小，其大小有Integer.MAX_VALUE来决定。其所含的对象是FIFO顺序排序的。

PriorityBlockingQueue（）或者（int i）:类似于LinkedBlockingQueue，但是其所含对象的排序不是FIFO，而是依据对象的自然顺序或者构造函数的Comparator决定。

SynchronizedQueue（）:特殊的BlockingQueue，对其的操作必须是放和取交替完成。

3. 自定义线程池（ThreadPoolExecutor和BlockingQueue连用）：

     自定义线程池，可以用ThreadPoolExecutor类创建，它有多个构造方法来创建线程池。

    常见的构造函数：ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)*/
public class Test2 implements Runnable {
    @Override
    public void run() {
        //打印正在执行的缓存线程信息
        System.out.println(Thread.currentThread().getName() + "正在执行");
        //sleep一秒保证3个任务在3个线程执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    class TertThreadPoolExecutor{
        public static void main(String[] args){
      //创建数组型缓冲等待队列
            ArrayBlockingQueue<Runnable> bq=new ArrayBlockingQueue<Runnable>(10);
      //ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, bq);

           //创建三个任务
            Runnable t1=new Test2();
            Runnable t2=new Test2();
            Runnable t3=new Test2();


            //这个三个任务分别在三个不同的线程上面执行
            tpe.execute(t1);
            tpe.execute(t2);
            tpe.execute(t3);

            //关闭自定义线程池
            tpe.shutdown();
        }
   }

