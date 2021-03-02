class Producer implements Runnable{
    Pdata p = null;
    public Producer(Pdata p){
        this.p = p;
    }
    public void run(){
        int i = 0;
        while(true){
            // 往数据库里存放数据
            if(i == 0)
            {
                p.set("张三", "男");
            }
            else
            {
                p.set("李四", "女");
            }
            i = (i+1)%2;
        }
    }
}

class Consumer implements Runnable{
    Pdata p = null;
    public Consumer(Pdata p){
        this.p = p;
    }
    public void run(){
        while(true){
            // 从数据库里读取数据
            p.get();
        }
    }
}
class Pdata{
    String name;
    String sex;
    boolean bFull = false;
    public synchronized void set(String name, String sex){
        if(bFull){
            try{
                wait(); // 写满了，后来写的线程要等待
            }
            catch (InterruptedException e)
            {}
        }
        notify(); // 可以写了，唤醒最先到达的线程
        this.name = name;
        this.sex = sex;
        this.bFull = true;
        try {
            Thread.sleep(1000);//让控制台输出慢一点
        }
        catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
    public synchronized void get(){
        if(!bFull){
            try{
                wait();//还没写满，需要读取？等着
            }
            catch (InterruptedException e)
            {}
        }
        notify(); // 写满了，可以读取了，唤醒最先到达的线程
        System.out.println("消费者读取数据："+this.name+"-->"+this.sex);
        this.bFull = false;
    }
}

class test9{
    public static void main(String[] args){
        Pdata p = new Pdata();
        new Thread(new Producer(p)).start();
        new Thread(new Consumer(p)).start();
    }
}