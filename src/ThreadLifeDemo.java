class TestThread1 implements Runnable{
    private boolean flag = true;
    public void stopMe(){
        flag = false;
    }
    public void run(){
        while(flag){
            System.out.println(Thread.currentThread().getName()+"线程在运行");
        }
    }
}

class ThreadLifeDemo {
    public static void main(String[] args){
        TestThread1 t = new TestThread1();
        new Thread(t).start();
        for(int i = 0; i < 20; ++i){
            if(i == 5)
                t.stopMe();
            System.out.println("main线程在运行"+i);
        }
    }
}
