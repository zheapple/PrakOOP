/**
 * Huawoi.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author [NIM] [Nama]
 */

public class Huawoi extends Handphone {
	private Boolean isKW;

	public Huawoi(Boolean isKW) {
		// Sesuai dengan Soal
        super(
            isKW ? "Huawoi KW" : "Huawoi",
            isKW ? 2000000 : 5000000,
            isKW ? 2 : 4
        );
        this.isKW = isKW;
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
		if (this.getHarga() - hargaTawaran <= 1000000) {
			this.setHarga(hargaTawaran);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printSpeciality() {
		// Bila isKW = true, Print (tanpa tanda kutip, diakhiri newline) "HPnya murah
		// bos"
		// Bila isKW = false, Print (tanpa tanda kutip, diakhiri newline) "Speknya
		// kenceng bos"
        if (this.isKW) {
            System.out.println("HPnya murah bos");
        } else {
            System.out.println("Speknya kenceng bos");
        }
	}
}