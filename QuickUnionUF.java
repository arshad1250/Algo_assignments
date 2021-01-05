import java.util.Scanner;

public class QuickUnionUF {
    int[] parent; // parent[i] = parent of i
    private int count; // number of components

    public QuickUnionUF(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        System.out.println("-------- calling find --------");
        String s1 = String.format("In find p = %d", p);
        System.out.println(s1);
        while (p != parent[p]) {
            p = parent[p];
            String s2 = String.format("In find p = parent[p], so now value of p = %d", p);
            System.out.println(s2);
        }
        System.out.println("-------- loop finished --------");
        String s3 = String.format("In find retuning value of p = %d", p);
        System.out.println(s3);
        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    @Deprecated
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {

        int rootP = find(p);
        int rootQ = find(q);
        String s4 = String.format("rootp = %d", rootP);
        System.out.println(s4);
        String s5 = String.format("rootq = %d", rootQ);
        System.out.println(s5);
        if (rootP == rootQ)
            return;
        String s6 = String.format("parent[rootP] = %d that value change with rootQ ", parent[rootP]);
        parent[rootP] = rootQ;
        System.out.println(s6);

        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        Scanner value = new Scanner(System.in);
        System.out.print("Enter the itration value: ");
        int a = value.nextInt();
        while (a != -1) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a = a - 1;
            if (uf.find(p) == uf.find(q))
                continue;
            System.out.println("=============== before union ===============");
            uf.union(p, q);
            System.out.println("=============== after union ===============");
            for (int i = 0; i < uf.parent.length; i++) {
                System.out.println("value in array: " + uf.parent[i]);
            }
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        for (int i = 0; i < uf.parent.length; i++) {
            System.out.println(uf.parent[i]);
        }
    }

}
