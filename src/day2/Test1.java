package day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (c),2016-2019,北京金地安华有限公司成都分公司
 * ClassName   :  Test1
 * Author      : MaMingze
 * Date        : 2019/3/5 14:50
 * Description : TODO
 * Version 1.0
 **/
/*这个练习主要是针对线程池的
* 线程池就是首先创建一些线程，
* 它们的集合称为线程池。
* 使用线程池可以很好地提高性能，线程池在系统启动时即创建大量空闲的线程，
* 程序将一个任务传给线程池，线程池就会启动一条线程来执行这个任务，执行结束以后，
* 该线程并不会死亡，而是再次返回线程池中成为空闲状态
* ，等待执行下一个任务。**/
/*2. 线程池的工作机制

         2.1 在线程池的编程模式下，任务是提交给整个线程池，而不是直接提交给某个线程，线程池在拿到任务后，就在内部寻找是否有空闲的线程，如果有，则将任务交给某个空闲的线程。

         2.1 一个线程同时只能执行一个任务，但可以同时向一个线程池提交多个任务。

3. 使用线程池的原因：
        多线程运行时间，系统不断的启动和关闭新线程，成本非常高，会过渡消耗系统资源，以及过渡切换线程的危险，从而可能导致系统资源的崩溃。
        这时，线程池就是最好的选择了。*/
public class Test1 {
    /*1. 线程池的返回值ExecutorService简介：
         ExecutorService是Java提供的用于管理线程池的类。该类的两个作用：控制线程数量和重用线程*/

    public static void main(String[] args){
        Test1 t=new Test1();
        //这第一方法是将线程不断的复用，通过线程休息的办法，不用新建线程
        //t.ThreadPoolExecutorTest1();

        //Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
         //t.ThreadPoolExecutorTest2(3);


        //Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
        //t.ThreadPoolExecutorTest3(5);

        //Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
      //  t.ThreadPoolExecutorTest4(5);

        //Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
        t.ThreadPoolExecutorTest5();
    }

    /* Executors.newCacheThreadPool()：
    可缓存线程池，先查看池中有没有以前建立的线程，如果有，就直接使用。如果没有，就建一个新的线程加入池中，
    缓存型池子通常用于执行一些生存期很短的异步型任务*/
    private void ThreadPoolExecutorTest1() {
        //创建一个可以缓存的线程池
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            //这边利用sleep是为了可以明显的看到使用的线程池里面的线程，没有创建线程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            //打印所显示的信息
                                            System.out.println(Thread.currentThread().getName()+"正在被执行");
                                        }
                                    }

            );

        }
    }

    /* Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
 */ private void ThreadPoolExecutorTest2(int num) {
        //创建一个可重用固定个数的线程池
                 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(num);
                 for (int i = 0; i < 10; i++) {
                         fixedThreadPool.execute(new Runnable() {
                public void run() {
                                        try {
                                            //打印正在执行的缓存线程信息
                                                System.out.println(Thread.currentThread().getName()+"正在被执行");
                                               Thread.sleep(2000);
                                             } catch (InterruptedException e) {
                                                e.printStackTrace();
                                             }
                                     }
             });
                     }
             }



    /* Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
     */ private void ThreadPoolExecutorTest3(int num) {
        //创建一个可重用固定个数的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
               scheduledThreadPool.schedule(new Runnable() {
             public void run() {
                                 System.out.println("延迟1秒执行");
                            }
         }, 1, TimeUnit.SECONDS);
}


    /* Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
     */ private void ThreadPoolExecutorTest4(int num) {
        //创建一个可重用固定个数的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        } ,1, 3, TimeUnit.SECONDS);
    }


    /* Executors.newFixedThreadPool(int n)：创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
     */ private void ThreadPoolExecutorTest5() {
        //创建一个单线程化的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
                        final int index = i;
                       singleThreadExecutor.execute(new Runnable() {
                public void run() {
                                        try {
                                               //结果依次输出，相当于顺序执行各个任务
                                              System.out.println(Thread.currentThread().getName()+"正在被执行,打印的值是:"+index);
                                               Thread.sleep(1000);
                                           } catch (InterruptedException e) {
                                               e.printStackTrace();
                                           }
                                    }
            });
                   }
             }
    }













