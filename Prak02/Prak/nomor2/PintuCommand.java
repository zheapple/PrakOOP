public class PintuCommand implements ICommand {
    private Pintu pintu;
    private int state;

    /**
     * Constructor untuk membuat PintuCommand,
     * Terdapat 3 state untuk pintu:
     * - State 0: pintu tertutup
     * - State 1: pintu terbuka
     * 
     * State awal pintu adalah tertutup
     * 
     * @param pintu      Objek pintu yang digunakan
     */
    public PintuCommand(Pintu pintu) {
        this.pintu = pintu;
        this.state = 0; // State awal adalah tertutup
    }
    
    /**
     * Mengeksekusi aktivitas untuk pintu sesuai dengan state
     * - Bila state sekarang = 0, maka pintu akan dibuka
     */
    public void execute() {
        if (state == 0) {
            pintu.open();
            state = 1; // Ubah state menjadi terbuka
        } else if (state == 1) {
            pintu.close();
            state = 0; // Ubah state menjadi tertutup
        }
    }

    /**
     * Mengembalikan pintu ke state semula
     * - Bila state sekarang selain 0, maka pintu akan ditutup
     */
    public void undo() {
        if (state != 0) {
            pintu.close();
            state = 0; // Ubah state menjadi tertutup
        // } else {
        //     System.out.println("Pintu sudah dalam keadaan tertutup.");
        }
    }
}
