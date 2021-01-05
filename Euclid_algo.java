import java.util.Scanner;

class MyClass {

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int gcd2(int p, int q) {
        while(q != 0){
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        System.out.println("Enter the number of value: ");
        try {
            int va = value.nextInt();
            if (va == 2) {
                System.out.println("Enter the 1st value: ");
                int a = value.nextInt();
                System.out.println("Enter the 2nd value: ");
                int b = value.nextInt();
                value.close();

                int result = gcd(a, b);
                int result1 = gcd2(a, b);
                System.out.println("Answer with recursion = " + result);
                System.out.println("Answer without recursion = " + result1);

            } else if (va == 3) {
                System.out.println("Enter the 1st value: ");
                int a = value.nextInt();
                System.out.println("Enter the 2nd value: ");
                int b = value.nextInt();
                System.out.println("Enter the 3rd value: ");
                int c = value.nextInt();
                value.close();

                //int res = gcd(a, b);
                int result = gcd(c, gcd(a, b));
                //int res1 = gcd2(a, b);
                int result1 = gcd2(c, gcd2(a, b));
                System.out.println("Answer with recursion = " + result);
                System.out.println("Answer without recursion = " + result1);
            }
        } catch (Exception e) {
            System.out.println("Invalide value!");
            System.out.println(e);
            System.exit(1);
        }

    }
}