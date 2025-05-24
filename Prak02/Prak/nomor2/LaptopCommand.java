public class LaptopCommand implements ICommand {
    private Laptop laptop;
    private int state;

    /**
     * Constructor untuk membuat LaptopCommand,
     * Terdapat 2 state untuk laptop:
     * - State 0: laptop mati
     * - State 1: laptop hidup dan digunakan
     * 
     * State awal laptop adalah mati
     * 
     * @param laptop      Objek laptop yang digunakan
     */
    public LaptopCommand(Laptop laptop) {
        this.laptop = laptop;
        this.state = 0; // State awal adalah mati
    }
    
    /**
     * Mengeksekusi aktivitas untuk laptop sesuai dengan state
     * - Bila state sekarang = 0, maka laptop akan dinyalakan dan state berubah menjadi menyala
     * - Bila state sekarang = 1, maka laptop akan digunakan
     */
    public void execute() {
        if (state == 0) {
            laptop.turnOn();
            state = 1; // Ubah state menjadi menyala
        } else if (state == 1) {
            laptop.use();
        }
    }

    /**
     * Mengembalikan laptop ke state semula
     * - Bila state sekarang selain 0, maka laptop akan dimatikan
     */
    public void undo() {
        if (state == 1) {
            laptop.turnOff();
            state = 0; // Ubah state menjadi mati
        }
        //  else if (state == 0) {
        //     System.out.println("Laptop sudah dalam keadaan mati.");
        // }
    }
}
