package com.githubjuc.juc.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.线程 操作资源
 * 2.高内聚 低耦合
 * synchronized lock
 */

class Ticket{
    private int number=30;
    private Lock lock=new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"正在买第"+(number--)+"张票,\t还剩下"+(number)+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ticketTest{
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{ for (int i = 1; i <=40 ; i++) ticket.sale();},"A").start();
        new Thread(()->{ for (int i = 1; i <=40 ; i++) ticket.sale();},"B").start();
        new Thread(()->{ for (int i = 1; i <=40 ; i++) ticket.sale();},"C").start();
    }

}

