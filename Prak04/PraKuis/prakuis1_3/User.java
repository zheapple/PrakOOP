public class User implements Subscriber {
    private String name;
    private int maxNotification = 100;
    private String[] notifications;
    private int notificationCount = 0;

    /** 
     * KONSTRUKTOR -  Menciptakan objek User baru dengan notification kosong.
     * 
     * @param name: Nama dari user
     */
    public User(String name) {
        this.name = name;
        this.notifications = new String[maxNotification];
    }

    /** Metode yang akan mengembalikan list notification. */
    public String[] getNotifications() {
        String[] result = new String[notificationCount];
        for (int i = 0; i < notificationCount; i++) {
            result[i] = notifications[i];
        }
        return result;
        
    }

    /** Metode yang akan mengembalikan jumlah notifikasi. */
    public int getNotificationCount() {
        return notificationCount;
    }

    /** Metode yang akan mengembalikan nama. */
    public String getName() {
        return name;
    }

    /** 
     * Metode yang akan menambahkan notifikasi baru. Jika notifikasi sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * @return Notifikasi dari Poster langganan.
     */
    public void addNotification(String notification) {
        if (notificationCount < maxNotification) {
            notifications[notificationCount] = notification;
            notificationCount++;
        }
    }

    /**
     * Metode yang akan berlangganan ke Poster
     * 
     * @param poster
     */
    public void subscribeTo(Poster poster) {
        if (poster instanceof Channel) {
            Channel channel = (Channel) poster;
            channel.subscribe(this);
        } else if (poster instanceof Blogger) {
            Blogger blogger = (Blogger) poster;
            blogger.subscribe(this);
        }
    }
}
