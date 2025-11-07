import java.util.Scanner;

public class Fibonacci {

    static int COUNT = 0;

    static int recurFibo(int n) {
        COUNT++;
        if (n <= 1) {
            return n;
        } else {
            return recurFibo(n - 1) + recurFibo(n - 2);
        }
    }

    public static void iterativeFibo(int n) {
        int a = 0, b = 1;
        System.out.print("Iterative Fibonacci sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int nterms = sc.nextInt();

        if (nterms <= 0) {
            System.out.println("Please enter a positive integer");
        } else {
            System.out.println("Recursive Fibonacci sequence:");
            for (int i = 0; i < nterms; i++) {
                System.out.print(recurFibo(i) + " ");
            }
            System.out.println("\nSteps required using Counter: " + COUNT);
            iterativeFibo(nterms);
        }
        sc.close();
    }
}
