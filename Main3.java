import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        
        int[] valCard = {0, 0, 0, 0, 0};
        int i;
        int sum = 0;
        int multiplier;
        int booster;

        Scanner input = new Scanner(System.in);
        for (i=0; i<5; i++){
            valCard[i] = input.nextInt();
            sum = sum + valCard[i];
        }

        multiplier = input.nextInt();
        booster = input.nextInt();
        input.close();
        if (booster == 1){
            sum = sum * (multiplier * 2);
        }
        else if (booster == 2) {
            sum = sum * (multiplier * 3);
        }
        else {
            sum = sum * multiplier;
        }

        System.out.println(sum);
    }
}
