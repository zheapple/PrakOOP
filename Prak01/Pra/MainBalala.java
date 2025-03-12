import java.util.Scanner;
public class MainBalala {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        // Membaca input untuk 5 kartu
        Kartu[] kartu = new Kartu[5];
        for (int i = 0; i < 5; i++) {
            String suit = scanner.nextLine();
            String rank = scanner.nextLine();
            int multiplier = Integer.parseInt(scanner.nextLine());
            kartu[i] = new Kartu(suit, rank, multiplier);
        }

        // Membaca input jokerType dan targetValue
        int jokerType = Integer.parseInt(scanner.nextLine());
        int targetValue = Integer.parseInt(scanner.nextLine());

        // Membuat objek Blind
        Blind blind = new Blind(kartu[0], kartu[1], kartu[2], kartu[3], kartu[4], jokerType, targetValue);

        // Menampilkan informasi kartu
        String[] urutan = {"pertama", "kedua", "ketiga", "keempat", "kelima"};
        for (int i = 0; i < 5; i++) {
            System.out.println("Kartu " + urutan[i] + " punya suit " + kartu[i].getSuit() + " dengan rank " + kartu[i].getRank() + " dan multiplier " + kartu[i].getMultiplier());
        }

        // Menghitung dan menampilkan skor akhir
        int totalScore = blind.calculateTotalScore();
        System.out.println("Skor akhir : " + totalScore);

        // Menentukan kemenangan
        if (blind.isWin()) {
            System.out.println("MENANG!");
        } else {
            System.out.println("KALAH!");
        }

        scanner.close();
    }
}
