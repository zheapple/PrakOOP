import java.util.ArrayList;
import java.util.List;

public class ComputerManager {
    private List<Computer> list = new ArrayList<Computer>();

    /**
     * Menambahkan komputer ke array
     * 
     * @param computer objek Computer
     */
    public void addComputer(Computer computer) {
        // Tambahkan komputer ke list
        list.add(computer);
    }

    /**
     * Menyalakan monitor semua komputer yang mempunyai monitor 
     * dengan metode turnOnMonitor
     */
    public void turnOnAllMonitors() {
        for (Computer c : list) {
            if (c instanceof Monitor) {
                Monitor m = (Monitor) c; m.turnOnMonitor();
            }
        }
    }

    /**
     * Mematikan monitor semua komputer yang mempunyai monitor 
     * dengan metode turnOffMonitor
     */
    public void turnOffAllMonitors() {
        for (Computer c : list) {
            if (c instanceof Monitor) {
                Monitor m = (Monitor) c; m.turnOffMonitor();;
            }
        }
    }

    /**
     * Mencetak spesifikasi semua komputer
     * dengan metode printSpecification
     */
    public void printAllSpecifications() {
        for (Computer c : list) {
            c.printSpecification();
        }
    }

    /**
     * Memindahkan semua komputer yang portable
     * dengan metode move
     */
    public void moveAllPortableComputers() {
        for (Computer c : list) {
            if (c instanceof Portable) {
                Portable m = (Portable) c; m.move();
            }
        }
    }

    /**
     * Menggunakan keyboard semua komputer yang memiliki keyboard
     * dengan metode useKeyboard
     */
    public void useAllKeyboards() {
        for (Computer c : list) {
            if (c instanceof Keyboard) {
                Keyboard m = (Keyboard) c; m.useKeyboard();
            }
        }
    }

}
