/**
 * Hornet.java
 */
public class Hornet extends Boss implements SpecialBosses {
    private int stringAmount;

    /**
     * Constructor untuk membuat boss hornet
     * Hornet memiliki nama "Hornet", maxHealth sebanyak 900 dan attackPower
     * sebanyak 15
     */
    public Hornet(int stringAmount) {
        super("Hornet", 900, 15);
        this.stringAmount = stringAmount;
    }

    /**
     * Mengembalikan battlecry hornet
     * Mengembalikan string "HEGALE!"
     * 
     * @return "HEGALE!"
     */
    @Override
    public String battleCry() {
        return "HEGALE!";
    }

    /**
     * Menambahkan jumlah string sebanyak 100
     *
     */
    public void chargeString() {
        stringAmount += 100;
    }

    /**
     * Special attack hanya bisa dilakukan apabila jumlah string di atas 10
     * Apabila jumlah string kurang, maka program akan print "[String insufficient]"
     * INGAT : tuliskan juga bracketnya ya!!
     * Apabila jumlah string memenuhi maka program akan :
     * 1. print "ADINO!"
     * 2. mengurangi HP knight sebanyak attack power + total string
     * 3. special attack pasti menggunakan semua string, string akan habis
     * 
     * @param knight target
     */
    @Override
    public void specialAttack(Knight knight) {
        if (stringAmount <= 10){
            System.out.println("[String insufficient]");
        }
        else{
            System.out.println("ADINO!");
            int damage = getAttackPower() + stringAmount;
            stringAmount = 0;
            knight.setHealth(knight.getHealth() - damage);
        }
    }

    /**
     * Representasi string dari Hornet
     * 
     * @return String yang merepresentasikan Hornet
     */
    @Override
    public String toString() {
        return String.format(super.toString() + "[Hornet] %d string", stringAmount);
    }
}