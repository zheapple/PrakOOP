/**
 * Main.java
 * 
 * @author [NIM] [Nama]
 */

import java.util.*;

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        if (cekPaketSama(cards)) {
            if (adaAngka(cards,'T') && adaAngka(cards,'J') && adaAngka(cards,'Q') && adaAngka(cards,'K') && adaAngka(cards,'A')) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        int[] kartuCount = {hitungAngka(cards,'2'),
                            hitungAngka(cards,'3'),
                            hitungAngka(cards,'4'),
                            hitungAngka(cards,'5'),
                            hitungAngka(cards,'6'),
                            hitungAngka(cards,'7'),
                            hitungAngka(cards,'8'),
                            hitungAngka(cards,'9'),
                            hitungAngka(cards,'T'),
                            hitungAngka(cards,'J'),
                            hitungAngka(cards,'Q'),
                            hitungAngka(cards,'K'),
                            hitungAngka(cards,'A')};

        boolean adaThrees = false;
        boolean adaPair = false;
        for (int i = 0; i < 13; i++) {
            if (kartuCount[i] == 3) {
                adaThrees = true;
            }
        }
        for (int i = 0; i < 13; i++) {
            if (kartuCount[i] == 2) {
                adaPair = true;
            }
        }
        return (adaThrees && adaPair);
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        return cekPaketSama(cards);
    }

    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        if (isRoyal(cards)) {
            return 3;
        } else if (isFullHouse(cards)) {
            return 2;
        } else if (isFlush(cards)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static char getPaket(String kartu) {
        return kartu.charAt(0);
    }

    public static char getAngka(String kartu) {
        return kartu.charAt(1);
    }

    public static boolean adaAngka(String[] cards, char angka) {
        for (int i = 0; i < 5; i++) {
            if (getAngka(cards[i]) == angka) {
                return true;
            }
        }
        return false;
    }

    public static boolean cekPaketSama(String[] cards) {
        if (getPaket(cards[0]) == getPaket(cards[1]) && getPaket(cards[1]) == getPaket(cards[2]) && getPaket(cards[2]) == getPaket(cards[3])&& getPaket(cards[3]) == getPaket(cards[4])&& getPaket(cards[4]) == getPaket(cards[1])) {
            return true;
        } else {
            return false;
        }
    }

    public static int hitungAngka(String[] cards, char angka) {
        int jumlah = 0;
        for (int i = 0; i < 5; i++) {
            if (getAngka(cards[i]) == angka) {
                jumlah++;
            }
        }
        return jumlah;
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];
        Scanner sc = new Scanner(System.in);
        /* YOUR CODE HERE */
        for (int i = 0; i < 5; i++) {
            cardsTuanBil[i] = sc.next();
        }
        for (int i = 0; i < 5; i++) {
            cardsTuanMask[i] = sc.next();
        }
        
        if (getSetRanking(cardsTuanBil) > getSetRanking(cardsTuanMask)) {
            System.out.println("Tuan Bil");
            System.out.println(getSetRanking(cardsTuanBil));
        } else if (getSetRanking(cardsTuanMask) > getSetRanking(cardsTuanBil)) {
            System.out.println("Tuan Mask");
            System.out.println(getSetRanking(cardsTuanMask));
        } else {
            System.out.println("Seri");
            System.out.println(getSetRanking(cardsTuanBil));
        }
    }
}