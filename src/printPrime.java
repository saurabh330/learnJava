import java.util.*;

public class printPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        for (int i = low; i <= high; i++) {
            int count = 0;
            for(int div = 2; div * div <=high; div++){
                if (high % div == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Prime");
            } else {
                System.out.println("Not Prime"+ i);
            }
        }
    }
}
