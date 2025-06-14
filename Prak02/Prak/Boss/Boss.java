/**
 * Boss.java
 */

public abstract class Boss {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private int attackPower;
    private static String difficulty = "Attuned";
    private static Boss[] pantheon ;
    private static int pantheonSize;
    private static final int MAX_PANTHEON_SIZE = 4;


    /**
     * Constructor untuk membuat Boss baru
     * Ingat bahwa Boss akan memiliki current health maksimal ketika dibuat
     * Pantheon Size akan mulai dari 0 (kosong)
     * 
     * @param name        Nama Boss
     * @param maxHealth   Health points Boss
     * @param attackPower Kekuatan serangan dasar Boss
     */
    public Boss(String name, int maxHealth, int attackPower) {
        this.name = name;
        currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        if (pantheon == null){
            pantheon = new Boss[MAX_PANTHEON_SIZE];
            pantheonSize = 0;
        }
    }

    /**
     * Mendapatkan nama Boss
     * 
     * @return nama Boss
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan health Boss
     * 
     * @return health Boss
     */
    public int getHealth() {
        return currentHealth;
    }

    /**
     * Mengatur health boss
     * 
     * @param health nilai health baru
     */
    public void setHealth(int health) {
        currentHealth = health < 0 ? 0 : health > maxHealth ? maxHealth : health;
    }

    /**
     * Mendapatkan attack power Boss
     * 
     * @return attack power Boss
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Mengatur attack power boss
     * 
     * @param health nilai attack power baru
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Mendapatkan kesulitan untuk pantheon
     * 
     * @return difficulty pantheon
     */
    public static String getDifficulty() {
        return difficulty;
    }

    /**
     * Mengatur kesulitan pantheon
     * Pantheon hanya memiliki 3 buah difficulty : "Attuned", "Ascended", dan
     * "Radiant"
     * Apabila difficulty yang diberikan tidak sesuai, maka difficulty tidak akan
     * diatur.
     * 
     * Gunakan method string1.equals(string2) untuk memastikan nilai dua buah string
     * sama
     * 
     * @param difficulty kesulitan pantheon
     */
    public static void setDifficulty(String difficulty) {
        if (difficulty.equals("Attuned")) Boss.difficulty = "Attuned";
        else if (difficulty.equals("Ascended")) Boss.difficulty = "Ascended";
        else if (difficulty.equals("Radiant")) Boss.difficulty = "Radiant";
    }

    /**
     * Menambahkan Boss ke pantheon
     * 
     * @param boss Boss yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika party penuh
     */
    public static boolean addBossToPantheon(Boss boss) {
        if (pantheonSize < MAX_PANTHEON_SIZE){
            pantheon[pantheonSize] = boss;
            pantheonSize++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Mengembalikan pantheon
     * 
     * @return pantheon
     */
    public static Boss[] getPantheon() {
        return pantheon;
    }

    /**
     * Mengembalikan pantheonSize
     * 
     * @return pantheonSize
     */
    public static int getPantheonSize() {
        return pantheonSize;
    }

    /**
     * Fungsi ini menjalankan attack setiap boss dalam pantheon
     * 1. print "== PANTHEON STARTS =="
     * 2. ketika fungsi ini dijalankan, fungsi akan menjalankan special attack untuk
     * setiap pantheon. Tiap difficulty memiliki modifier berbeda :
     * - Apabila difficulty pantheon tersebut "Attuned" maka boss akan menjalankan
     * special attack tanpa modifier apapun
     * - Apabila difficulty pantheon tersebut "Ascended" maka attack power boss akan
     * ditambahkan 20 sebelum menjalankan special attack
     * - Apabila difficulty pantheon tersebut "Radiant" maka attack power boss akan
     * ditambahkan 30 sebelum menjalankan special attack
     * 3. apabila HP knight di atas nol, print "The Knight Survives!"
     * 4. apabila HP knight nol, print "The Knight Dies!"
     * 
     * @param knight target
     */
    public static void playPantheon(Knight knight) {
        System.out.println("== PANTHEON STARTS ==");
        int modifier = 0;
        if (difficulty.equals("Attuned")) modifier = 0;
        else if (difficulty.equals("Ascended")) modifier = 20;
        else if (difficulty.equals("Radiant")) modifier = 30;

        for (int i = 0 ; i < pantheonSize; i++){
            pantheon[i].setAttackPower(pantheon[i].getAttackPower() + modifier);
            if (pantheon[i] instanceof SpecialBosses){
                ((SpecialBosses) pantheon[i]).specialAttack(knight);
            }
        }
        if (knight.getHealth() > 0 ){
            System.out.println("The Knight Survives!");
        }
        else{
            System.out.println("The Knight Dies!");
        }

    }

    /**
     * Representasi string dari Hunter
     * 
     * @return String yang merepresentasikan Boss
     */
    @Override
    public String toString() {
        return String.format("%s [Health : %d, Attack : %d]", name, currentHealth, attackPower);
    }
}