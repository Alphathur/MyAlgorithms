package leetcode;

public class FooBarII {
  private int n;

  private Object lock = new Object();
  private boolean flag = false;

  public FooBarII(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printFoo.run() outputs "foo". Do not change or remove this line.
      synchronized (lock) {
        if (flag) {
          lock.wait();
        }
        printFoo.run();
        flag=true;
        lock.notifyAll();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printBar.run() outputs "bar". Do not change or remove this line.
      synchronized (lock) {
        if (!flag) {
          lock.wait();
        }
        printBar.run();
        flag=false;
        lock.notifyAll();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Runnable r1 = ()->System.out.println("foo");
    Runnable r2 = ()->System.out.println("bar");
    final FooBarII fooBar = new FooBarII(1000);
    new Thread(()->{
      try {
        fooBar.foo(r1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(()->{
      try {
        fooBar.bar(r2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }
}

