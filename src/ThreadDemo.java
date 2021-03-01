class TestThread implements Runnable {
    private int tickets = 20;

    public void run() {
        while (true) {
            sale();
        }
    }
    public synchronized void sale(){
        if (tickets > 0) {
            try {
                Thread.sleep(100);
                // 某线程休息了，之前 tickets > 0
                // 别的线程 卖出去票了
                // 休息完回来，可能没有票了，但是线程已经进入了 if 块
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName()
                    + "售出一张票，剩余票数：" + --tickets);
        }
    }
}
class ThreadDemo1 {
    public static void main(String[] args){
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);

        t1.setName("站点1");
        Thread t2 = new Thread(t);
        t2.setName("站点2");
        Thread t3 = new Thread(t);
        t3.setName("站点3");
        Thread t4 = new Thread(t);
        t4.setName("站点4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class A{
    synchronized void funA(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入 funA");
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(name + "调用B类的last()");
        b.last();
    }
    synchronized void last()
    {
        System.out.println("A 类的last()方法");
    }
}

class B{
    synchronized void funB(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name + "进入 funB");
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(name + "调用A类的last()");
        a.last();
    }
    synchronized void last()
    {
        System.out.println("B 类的last()方法");
    }
}

class DeadLockDemo implements Runnable{
    A a = new A();
    B b = new B();
    DeadLockDemo(){ // 构造函数
        Thread.currentThread().setName("Main->>Thread");
        new Thread(this).start();
        a.funA(b);
        System.out.println("main 线程运行结束");
    }
    public void run(){
        Thread.currentThread().setName("Test->>Thread");
        b.funB(a);
        System.out.println("其他线程运行完毕");
    }
    public static void main(String [] args){
        new DeadLockDemo();
    }
}