import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        CimolBojot[] arrCimol = new CimolBojot[3];
        for (int i = 0; i<3; i++){
            String namaMenu = scanner.next();
            int harga = scanner.nextInt();
            int stok = scanner.nextInt();
            arrCimol[i] = new CimolBojot(namaMenu, harga, stok);
        }

        int kasAwal = scanner.nextInt();
        Toko toko = new Toko(kasAwal);

        for (CimolBojot cimol : arrCimol) {
            toko.addCimolBojot(cimol);
        }

        String namaCimol = scanner.next();
        int jumCimol = scanner.nextInt();

        System.out.println(toko.sellCimolBojot(namaCimol, jumCimol));
        System.out.println("Kas kasir sekarang: " + toko.getKas());

        scanner.close();
    }
}
