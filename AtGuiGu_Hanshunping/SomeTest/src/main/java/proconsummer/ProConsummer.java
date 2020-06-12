package proconsummer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProConsummer {
    private volatile boolean flag = true;
    private BlockingQueue<Integer> blockingQueue;

    public ProConsummer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue=blockingQueue;
    }

    public void Pro(){
        Random random = new Random();
        boolean returnResult;
        while (flag){
            int i = random.nextInt();
            returnResult = blockingQueue.offer(i);
            if(returnResult){
                System.out.println("插入成功"+i);
            }else{
                System.out.println("插入失败");
            }
        }
    }

    public void Cons(){
        Integer result =null;
        while (flag){
            result = blockingQueue.poll();
            if(result==null){
                flag=false;
                return;
            }
            System.out.println("消费结果"+result);
        }
    }

    public void stop(){
        flag=false;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(1);
        ProConsummer proConsummer = new ProConsummer(blockingQueue);
        new Thread(() -> {
            proConsummer.Pro();
        }, "pro").start();
        Thread.sleep(2);
        new Thread(() -> {
            proConsummer.Cons();
        }, "com").start();

        Thread.sleep(2);
    }
}
