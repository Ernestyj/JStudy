package onlinealgo;

/**
 * Created by eugene on 16/8/2.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] sizes = new int[n];
        LinkedList<Guest> guests = new LinkedList<>();
        for(int i=0; i<n; i++) sizes[i] = sc.nextInt();
        for(int i=0; i<m; i++) {
            guests.add(new Guest(sc.nextInt(), sc.nextInt()));
        }
        long res = 0;
        System.out.println(res);
    }
    static class Guest{
        int spend, people;
        public Guest(int people, int spend) {
            this.spend = spend;
            this.people = people;
        }
    }
    public static long maxIncome(int n, int m, int[] sizes, LinkedList<Guest> guests){
        if (n==0 || m==0) return 0;
        Collections.sort(guests, new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                return Integer.compare(o2.spend, o1.spend);//降序
            }
        });
        Arrays.sort(sizes);//升序
        long res = 0;
        ListIterator<Guest> iterator = null;
        Guest guest = null;
        for (int size: sizes){
            iterator = guests.listIterator();
            while (iterator.hasNext()) {
                guest = iterator.next();
                if (guest.people<=size) {
                    res += guest.spend;
                    iterator.remove();
                    break;
                }
            }
        }
        return res;
    }

}
