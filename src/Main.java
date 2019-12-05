import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(123454321/10);
        System.out.println(123454321/100);
        System.out.println(123454321/1000);
        System.out.println(123454321/10000);
        System.out.println(123454321/100000);
        System.out.println(123454321/1000000);
        System.out.println(123454321/10000000);
        System.out.println(123454321/100000000);
        System.out.println("============");
        System.out.println(123454321%10); //1
        System.out.println(123454321%100); //21
        System.out.println(123454321%1000); //321
        System.out.println(123454321%10000);
        System.out.println(123454321%100000);
        System.out.println(123454321%1000000);
        System.out.println(123454321%10000000);
        System.out.println(123454321%100000000);
        System.out.println(123454321%1000000000);

        System.out.println(1/1);
        System.out.println(21/10);
        System.out.println(321/100);
        System.out.println(4321/1000);

        System.out.println("=======test======");
        int x = 1000000001;
        long start = 1;
        long s = 0;
        int count = 0;
        List<Long> list = new ArrayList<>();
        while (s != x) {
            start = start * 10;
            s = x % start;
            long m = s/(start/10);
            list.add(m);
            System.out.println("-------");
            System.out.println(s);
            System.out.println(m);
            count++;
        }

        System.out.println("===================");

        for (int i = 0; i < list.size() / 2; i++) {
            System.out.println(list.get(i));
            if (list.get(i).intValue() != list.get(list.size()-1 - i).intValue()) {
                System.out.println("not rome");
            }
        }
        System.out.println(count);
    }
}
