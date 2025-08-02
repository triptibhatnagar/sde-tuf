import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_PascalTriangle {
    // rows and cols = 0-indexed

    // T:(n+r+n-r = 2n), S: O(1)
    static int fact(int x) {
        int fact = 1;
        for(int i=x; i>=1; i--) {
            fact *= i;
        }
        return fact;
    }
    // T: O(c), S: O(1)
    static int nCr(int n, int r) {
        if(n-r < r) {
            r = n-r;
        }
        int ans = 1;
        for(int i=0; i<r; i++) {
            ans *= n-i;
            ans /= i+1;
        }
        return ans;
    }
    static int typeI(int r, int c) {
        // int fact_n = fact(r);
        // int fact_r = fact(c);
        // int fact_nr = fact(r-c);
        // return fact_n/(fact_r*fact_nr);
        return nCr(r, c);
    }

    // T: O(N*N), S: O(1)
    static int[] typeII_brute(int n) {
        // 0th row = 1 elem ~~~~ nth row = n+1 elem
        int arr[] = new int[n+1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nCr(n, i);
        }
        return arr;
    }
    static List<Integer> typeII_opt(int n) {
        // n=5
        // 5c0 5c1 5c2 5c3 5c4 5c5
        // int arr[] = new int[n+1];
        List<Integer> list = new ArrayList<>();
        // arr[0] = 1;
        list.add(1);
        int ans = 1;
        for(int i=0; i<n; i++) {
            ans *= n-i;
            ans /= i+1;
            // arr[i+1] = ans;
            list.add(ans);
        }
        // return arr;
        return list;
    }

    static List<List<Integer>> typeIII(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            ans.add(typeII_opt(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Elem at row 5 and col 3: "+typeI(5, 3));
        System.out.println(Arrays.toString(typeII_brute(5)));
        System.out.println(typeII_opt(5));
        for(List<Integer> x: typeIII(5)) {
            System.out.println(x);
        }
    }
}
/*
 * Pascal’s Triangle shows all the possible ways of choosing things — and that's exactly what nCr means.
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 */