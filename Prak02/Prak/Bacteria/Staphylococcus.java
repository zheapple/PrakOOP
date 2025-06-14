/*
    Nama                    : Zheannetta Apple
    NIM                     : 18223105
    Hari dan tanggal        : Sabtu, 14 Juni 2025
    Deskripsi Program       :
*/

/**
 * Staphylococcus.java
 * 
 * Implementasi spesifik untuk bakteri Staphylococcus.
 * Staphylococcus dapat resisten terhadap Kanamycin.
 */
public class Staphylococcus extends Bacteria implements AdaptiveResponse {
    /**
     * Constructor untuk Staphylococcus.
     * Name diisi dengan "Staphylococcus"
     * @param growthRate Laju reproduksi
     * @param currentPopulation Populasi bakteri saat ini
     * @param hasKanR true jika resisten terhadap Kanamycin, false jika tidak.
     */
        public Staphylococcus(double growthRate, int currentPopulation, boolean hasKanR) {
            super("Staphylococcus", currentPopulation, growthRate, hasKanR);
        }

    /**
     * Implementasi respon adaptif untuk Staphylococcus.
     * Staphylococcus akan melakukan respon adaptif dengan cara "menelan" plasmid berisi gen resistensi Kanamycin
     * dari bakteri lain sehingga menjadi resisten terhadap Kanamycin (punya gen kanR).
     */
    @Override
    public void doAdaptiveResponse() {
        setKanR(true);
    }

    /** 
     * Mengembalikan representasi detail informasi dari Staphylococcus.
     */
    public String toString() {
        return super.toString();
    }
        
}
