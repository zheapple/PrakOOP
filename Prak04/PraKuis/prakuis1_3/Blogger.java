public class Blogger implements Poster {
    private String blogName;
    private int maxBlogs = 100;
    private Blog blogs[];
    private int blogCount = 0;

    private int maxSubscribers = 100;
    private Subscriber[] subscribers;
    private int subscriberCount = 0;

    /** 
     * KONSTRUKTOR - Menciptakan objek Blogger baru dengan subscribers kosong.
     * 
     * @param name: Nama dari Blogger
     */
    public Blogger(String name) {
        this.blogName = name;
        this.blogs = new Blog[maxBlogs];
        this.subscribers = new Subscriber[maxSubscribers];
    }

    /** Metode yang akan mengembalikan list subscriber */
    public Subscriber[] getSubscribers() {
        Subscriber[] result = new Subscriber[subscriberCount];
        for (int i = 0; i < subscriberCount; i++) {
            result[i] = subscribers[i];
        }
        return result;
    }

    /** Metode yang akan mengembalikan jumlah subscriber. */
    public int getSubscriberCount() {
        return subscriberCount;
    }

    /** Metode yang akan mengembalikan list blog milik blogger. */
    public Blog[] getBlogs() {
        Blog[] result = new Blog[blogCount];
        for (int i = 0; i < blogCount; i++) {
            result[i] = blogs[i];
        }
        return result;
    }

    /** 
     * Metode untuk menambahkan konten baru ke akun dan menotifikasi seluruh subscriber. Jika blog sudah mencapai maksimum
     * maka tidak akan menambah apa-apa.
     * 
     * Notifikasi ke subscriber akan diberikan dalam format berikut:
     * "Blog {blogName} telah mengunggah blog baru dengan judul {blog.getTitle()}"
     * 
     * @param content: Konten yang akan di-post harus berupa Blog.
     */
    public void post(Content blog) {
        if (blogCount < maxBlogs && blog instanceof Blog) {
            blogs[blogCount] = (Blog) blog;
            blogCount++;
            for (int i = 0; i < subscriberCount; i++) {
                subscribers[i].addNotification("Blog " + blogName + " telah mengunggah blog baru dengan judul " + ((Blog) blog).getTitle());
            }
        }
    }

    /** 
     * Metode untuk mengubah Blog yang pernah dibuat dan menotifikasi seluruh subscriber. Jika
     * Blog yang diberikan tidak ada di dalam list blogs, maka jangan lakukan apapun.
     * 
     * Notifikasi ke subscriber akan diberikan dalam format berikut:
     * "Blog {blogName} telah mengubah blog {oldBlog.getTitle()} menjadi {newBlog.getTitle()}"
     * 
     * @param oldBlog: Blog lama yang mungkin ada atau tidak ada di list Blog.
     * @param newBlog: Blog yang akan menggantikan Blog lama
     */
    public void changePost(Content oldBlog, Content newBlog) {
        if (oldBlog instanceof Blog && newBlog instanceof Blog) {
            for (int i = 0; i < blogCount; i++) {
                if (blogs[i].isSame(oldBlog)) {
                    blogs[i] = (Blog) newBlog;
                    for (int j = 0; j < subscriberCount; j++) {
                        subscribers[j].addNotification("Blog " + blogName + " telah mengubah blog " + ((Blog) oldBlog).getTitle() + " menjadi " + ((Blog) newBlog).getTitle());
                    }
                    break;
                }
            }
        }
    }

    /** 
     * Metode yang memungkinkan berlangganan ke Poster ini dengan menambahkan ke list Subscriber
     * 
     * @param subscriber: Akun yang ingin berlangganan.
     */
    public void subscribe(Subscriber s) {
        if (subscriberCount < maxSubscribers) {
            subscribers[subscriberCount] = s;
            subscriberCount++;
        }
    }
}
