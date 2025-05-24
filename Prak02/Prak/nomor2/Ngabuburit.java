public class Ngabuburit {
    public static int maxSameActivity = 3;

    public ICommand command;
    public int jenuhCounter;

    /**
     * Constructor untuk melakukan Ngabuburit
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public Ngabuburit(ICommand command) {
        this.command = command;
        this.jenuhCounter = 0; // Inisialisasi counter jenuh
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan
     * Counter jenuh akan kembali ke 0
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public void changeCommand(ICommand command) {
        this.command = command;
        this.jenuhCounter = 0; // Reset counter jenuh
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan dengan argumen string. 
     * Counter jenuh akan kembali ke 0
     * Pilihan command adalah "laptop", "pintu", atau "rumah"
     * 
     * @param command     Aktivitas yang ingin dilakukan dalam string
     */
    public void changeCommandStr(String command) {
        if (command.equals("laptop") || command.equals("pintu") || command.equals("rumah")) {
            switch (command) {
                case "laptop":
                    this.command = new LaptopCommand(new Laptop());
                    break;
                case "pintu":
                    this.command = new PintuCommand(new Pintu());
                    break;
                case "rumah":
                    this.command = new RumahCommand(new Rumah());
                    break;
            }
            this.jenuhCounter = 0; // Reset counter jenuh
        // } else {
        //     System.out.println("Command tidak valid!");
        }
    }

    /**
     * Method untuk melakukan aktivitas pada command. Jika command sudah dijalankan
     * lebih dari maxSameActivity, maka akan mencetak "Sudah jenuh! Lakukan aktivitas lain"
     * ke layar.
     */
    public void doStuff() {
        if (this.jenuhCounter < maxSameActivity) {
            this.command.execute();
            this.jenuhCounter++;
        } else {
            System.out.println("Sudah jenuh! Lakukan aktivitas lain");
        }
    }
}
