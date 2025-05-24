/**
 * BumbuCommand.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223105 Zheannetta Apple
 */

public class BumbuCommand implements ICommandAction {
    private Bumbu bumbu;
    
    /**
     * Konstruktor untuk membuat command baru dengan objek Bumbu tertentu
     * 
     * @param bumbu Objek Bumbu yang akan dikontrol oleh command ini
     */
    public BumbuCommand(Bumbu bumbu) {
        this.bumbu = bumbu;
    }
    
    /**
     * Mengeksekusi perintah dengan memanggil metode grindSpice() dan saute()
     * secara berturut-turut pada objek Bumbu
     */
    @Override
    public void execute() {
        bumbu.grindSpice();
        bumbu.saute();
    }
    
    /**
     * Membatalkan perintah dengan memanggil metode stopSaute() pada
     * objek Bumbu
     */
    @Override
    public void undo() {
        bumbu.stopSaute();
    }
}