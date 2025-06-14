/**
 * Knight.java
 */

public class Knight {
    private int currentSoul;
    private final int maxSoul = 100;
    private int currentHealth;
    private int maxHealth;
    private int attackPower;

    /**
     * Constructor untuk membuat Knight baru
     * Ingat bahwa Knight akan memiliki current health maksimal ketika dibuat
     * 
     * @param maxSoul     Jumlah soul maksimum
     * @param maxHealth   Jumlah health maksimum
     * @param attackPower Kekuatan serangan dasar Knight
     */
    public Knight(int maxHealth, int attackPower) {
        this.maxHealth = maxHealth;
        this.currentSoul = maxSoul;
        this.currentHealth = maxHealth;
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan jumlah soul knight
     * 
     * @return jumlah soul
     */
    public int getSoul() {
        return currentSoul;
    }

    /**
     * Menambahkan jumlah soul sebanyak 30 poin
     * 
     */
    public void focus() {
        currentSoul += 30;
        if (currentSoul > maxSoul){
            currentSoul = maxSoul;
        }
    }

    /**
     * Mendapatkan jumlah health knight
     * 
     * @return jumlah health
     */
    public int getHealth() {
        return currentHealth;
    }

    /**
     * Mengatur health knight
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        currentHealth = health;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
        else if (currentHealth < 0) currentHealth = 0;
    }

    /**
     * Menambahkan jumlah health sebanyak 30 poin apabila soul mencukupi
     * Akan mengurangi soul sebanyak 30 dan menambahkan health sebanyak 30
     * mengembalikan true apabila healing berhasil dilakukan
     * mengembalikan false apabila soul tidak mencukupi
     * 
     * @return true atau false, sesuai keadaan
     */
    public boolean heal() {
       if (currentSoul >= 30){
        currentHealth += 30;
        if (currentHealth > maxHealth){
            currentHealth = maxHealth;
        }
        currentSoul -= 30;
        return true;
       }
       else{
        return false;
       }
    }

    /**
     * Mendapatkan jumlah attack power knight
     * 
     * @return jumlah attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Menyerang boss
     * 
     * @param boss target
     */
    public void attackBoss(Boss boss) {
        boss.setHealth(boss.getHealth() - attackPower);
        if (boss.getHealth() < 0){
            boss.setHealth(0);
        }
    }

    /**
     * Fungsi ini menyerang semua boss dalam pantheon
     * 1. print "== ATTACKING PANTHEON =="
     * 2. Menyerang semua boss dalam pantheon
     * 3. print boss tersebut setelah boss tersebut diserang
     * 3. print "== PANTHEON ENDS =="
     * 
     * @param knight target
     */
    public void attackPantheon() {
        System.out.println("== ATTACKING PANTHEON ==");
        for (int i = 0; i <  Boss.getPantheonSize(); i++){
            attackBoss(Boss.getPantheon()[i]);            
            System.out.println(Boss.getPantheon()[i].toString());
        }
        System.out.println("== PANTHEON ENDS ==");
    }

    /**
     * Representasi string dari Boss
     * 
     * @return String yang merepresentasikan Boss
     */
    @Override
    public String toString() {
        return String.format("Knight [Soul: %d, Health : %d, Attack : %d]", currentSoul, currentHealth, attackPower);
    }
}