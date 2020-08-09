package leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {

  private CountDownLatch c2;
  private CountDownLatch c3;
  public Foo() {
    c2 = new CountDownLatch(1);
    c3 = new CountDownLatch(1);
  }

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    c2.countDown();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    c2.await();
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    c3.countDown();
  }

  public void third(Runnable printThird) throws InterruptedException {
    c3.await();
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }

  public static void main(String[] args) throws InterruptedException {
    final Foo foo = new Foo();
    new Thread(()->{
      try {
        foo.third(() -> System.out.print("third"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(()->{
      try {
        foo.second(() -> System.out.print("second"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    new Thread(()->{
      try {
        foo.first(() -> System.out.print("first"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }


}
