/**
 * KualiCommand.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223105 Zheannetta Apple
 */

public class KualiCommand implements ICommandAction {
    private Kuali kuali;
    
    /**
     * Konstruktor untuk membuat command baru dengan objek Kuali tertentu
     * 
     * @param kuali Objek Kuali yang akan dikontrol oleh command ini
     */
    public KualiCommand(Kuali kuali) {
        this.kuali = kuali;
    }
    
    /**
     * Mengeksekusi perintah dengan memanggil metode heat() dan cook() secara
     * berturut-turut pada objek Kuali
     */
    @Override
    public void execute() {
        kuali.heat();
        kuali.cook();
    }
    
    /**
     * Membatalkan perintah dengan memanggil metode turnOff() pada objek Kuali
     */
    @Override
    public void undo() {
        kuali.turnOff();
    }
}