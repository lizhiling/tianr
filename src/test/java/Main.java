import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        Long input;

        System.out.print(minDiff("ccaccjp",
                "fwosarcwge"));
    }

    public static int minDiff(String a, String b) {
        int m = a.length();
        int n = b.length();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        if (m == 0 || n == 0) {
            int sum = 0;
            for (char aC : aArray) {
                sum += aC;
            }
            for (char bC : bArray) {
                sum += bC;
            }
            return sum;
        }

        int[][] mem = new int[m][n];

        // init
        mem[0][0] = aArray[0] == bArray[0] ? 0 : aArray[0] + bArray[0];
        int[] tempA = new int[m];
        tempA[0] = aArray[0];
        for (int i = 1; i < m; i++) {
            tempA[i] = tempA[i - 1] + aArray[i];
            if (bArray[0] != aArray[i]) {
                mem[i][0] = mem[i - 1][0] + aArray[i];
            } else {
                mem[i][0] = tempA[i - 1];
            }
        }
        int[] tempB = new int[n];
        tempB[0] = bArray[0];
        for (int i = 1; i < n; i++) {
            tempB[i] = tempB[i - 1] + bArray[i];
            if (bArray[i] != aArray[0]) {
                mem[0][i] = mem[0][i - 1] + bArray[i];
            } else {
                mem[0][i] = tempB[i - 1];
            }
        }

        // start
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int temp = aArray[i] == bArray[j] ? mem[i - 1][j - 1] : mem[i - 1][j - 1] + aArray[i] + bArray[j];
                mem[i][j] = Math.min(temp, Math.min(mem[i - 1][j] + aArray[i], mem[i][j - 1] + bArray[j]));
            }
        }

        return mem[m - 1][n - 1];
    }
}
