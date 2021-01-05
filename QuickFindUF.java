
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class QuickFindUF {
    int[] id; // id[i] = component identifier of i
    private int count; // number of connect components

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    @Deprecated
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    public void join(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p]; // needed for correctness
        int qID = id[q]; // to reduce the number of array accesses
        String s1 = String.format("In join pID = %d", pID);
        System.out.println(s1);
        String s2 = String.format("In join qID = %d", qID);
        System.out.println(s2);
        // p and q are already in the same component

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) {
                System.out.println("After condition met in join");
                id[i] = qID;
                String s3 = String.format("qID = %d", qID);
                System.out.println(s3);
                String s4 = String.format("id[i]= qID so the value of id[i] is %d", id[i]);
                System.out.println(s4);
            }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        Scanner value = new Scanner(System.in);
        System.out.print("Enter the itration value: ");
        int a = value.nextInt();
        while (a != -1) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a = a - 1;
            if (uf.find(p) == uf.find(q))
                continue;
            System.out.println("=============== before join ===============");
            uf.join(p, q);
            System.out.println("=============== After join ===============");
            for (int i = 0; i < uf.id.length; i++) {
                System.out.println("value in array: " + uf.id[i]);
            }
            StdOut.println(p + " " + q);

        }
        StdOut.println(uf.count() + " components");
        for (int i = 0; i < uf.id.length; i++) {
            System.out.println(uf.id[i]);
        }
    }

}
