import java.util.Arrays;

public class binary_search {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        System.out.println("first index = 0 and last index = " + hi);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("middle index = " + mid);
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        System.out.print("user entered array readed from file in sorted form");
        for (int i = 0; i < whitelist.length; i++) {
            System.out.println(whitelist[i]);
        }
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1) {
                StdOut.println(key + " Not Found!");
                System.out.println("-----------------------------");
            } else if (rank(key, whitelist) != -1)
                StdOut.println("Found it : " + key);
        }
    }
}