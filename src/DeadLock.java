public class DeadLock {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    private static class Thread1 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread1 has lock1");
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread1: Waiting for lock 2");

                synchronized (lock2){
                    System.out.println("Thread1: No DeadLock");
                }
            }
        }
    }

    private static class Thread2 extends Thread{
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread2: Has lock2");

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock1");

                synchronized (lock1) {
                    System.out.println("Thread 2: No DeadLock");
                }
            }
        }
    }
    public static void main(String args[]) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();

    }
}
