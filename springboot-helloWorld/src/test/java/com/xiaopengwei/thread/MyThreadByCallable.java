package com.xiaopengwei.thread;import java.util.concurrent.Callable;/** * <p> * 通过实现 callable * </p> * * @author github.com/xpwi * @since 2019-04-18 */public class MyThreadByCallable implements Callable<Integer> {    private int i = 0;    @Override    public Integer call() throws Exception {        for (;i<10;i++){            System.out.println("第"+i+"个 Thread："+Thread.currentThread().getName());        }        return i;    }}