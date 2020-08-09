package leetcode;

/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FooBar {
  private int n;

  private Object lock = new Object();
  private int count = 0;

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printFoo.run() outputs "foo". Do not change or remove this line.
      synchronized (lock) {
        if (count % 2 == 1) {
          lock.wait();
        }
        printFoo.run();
        count++;
        lock.notifyAll();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printBar.run() outputs "bar". Do not change or remove this line.
      synchronized (lock) {
        if (count % 2 == 0) {
          lock.wait();
        }
        printBar.run();
        count++;
        lock.notifyAll();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Runnable r1 = ()->System.out.println("foo");
    Runnable r2 = ()->System.out.println("bar");
    final FooBar fooBar = new FooBar(2);
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
