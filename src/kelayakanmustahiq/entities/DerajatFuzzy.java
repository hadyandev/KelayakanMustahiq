package kelayakanmustahiq.entities;
// Generated Feb 24, 2017 6:41:49 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * DerajatFuzzy generated by hbm2java
 */
@Entity
@Table(name = "derajat_fuzzy",
         catalog = "kelayakanmustahiq"
)
public class DerajatFuzzy implements java.io.Serializable {

    private int idDerajat;
    private String namaMustahiq;
    private Float tanggunganSedikit;
    private Float tanggunganBanyak;
    private Float tempattinggalBuruk;
    private Float tempattinggalBaik;
    private Float pendapatanKurang;
    private Float pendapatanCukup;
    private Float attitudeKurangbaik;
    private Float attitudeBaik;

    public DerajatFuzzy() {
    }

    public DerajatFuzzy(int idDerajat) {
        this.idDerajat = idDerajat;
    }

    public DerajatFuzzy(int idDerajat, String namaMustahiq, Float tanggunganSedikit, Float tanggunganBanyak, Float tempattinggalBuruk, Float tempattinggalBaik, Float pendapatanKurang, Float pendapatanCukup, Float attitudeKurangbaik, Float attitudeBaik) {
        this.idDerajat = idDerajat;
        this.namaMustahiq = namaMustahiq;
        this.tanggunganSedikit = tanggunganSedikit;
        this.tanggunganBanyak = tanggunganBanyak;
        this.tempattinggalBuruk = tempattinggalBuruk;
        this.tempattinggalBaik = tempattinggalBaik;
        this.pendapatanKurang = pendapatanKurang;
        this.pendapatanCukup = pendapatanCukup;
        this.attitudeKurangbaik = attitudeKurangbaik;
        this.attitudeBaik = attitudeBaik;
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")

    @Column(name = "id_derajat", unique = true, nullable = false)
    public int getIdDerajat() {
        return this.idDerajat;
    }

    public void setIdDerajat(int idDerajat) {
        this.idDerajat = idDerajat;
    }

    @Column(name = "nama_mustahiq", length = 50)
    public String getNamaMustahiq() {
        return this.namaMustahiq;
    }

    public void setNamaMustahiq(String namaMustahiq) {
        this.namaMustahiq = namaMustahiq;
    }

    @Column(name = "tanggungan_sedikit", precision = 12, scale = 0)
    public Float getTanggunganSedikit() {
        return this.tanggunganSedikit;
    }

    public void setTanggunganSedikit(Float tanggunganSedikit) {
        this.tanggunganSedikit = tanggunganSedikit;
    }

    @Column(name = "tanggungan_banyak", precision = 12, scale = 0)
    public Float getTanggunganBanyak() {
        return this.tanggunganBanyak;
    }

    public void setTanggunganBanyak(Float tanggunganBanyak) {
        this.tanggunganBanyak = tanggunganBanyak;
    }

    @Column(name = "tempattinggal_buruk", precision = 12, scale = 0)
    public Float getTempattinggalBuruk() {
        return this.tempattinggalBuruk;
    }

    public void setTempattinggalBuruk(Float tempattinggalBuruk) {
        this.tempattinggalBuruk = tempattinggalBuruk;
    }

    @Column(name = "tempattinggal_baik", precision = 12, scale = 0)
    public Float getTempattinggalBaik() {
        return this.tempattinggalBaik;
    }

    public void setTempattinggalBaik(Float tempattinggalBaik) {
        this.tempattinggalBaik = tempattinggalBaik;
    }

    @Column(name = "pendapatan_kurang", precision = 12, scale = 0)
    public Float getPendapatanKurang() {
        return this.pendapatanKurang;
    }

    public void setPendapatanKurang(Float pendapatanKurang) {
        this.pendapatanKurang = pendapatanKurang;
    }

    @Column(name = "pendapatan_cukup", precision = 12, scale = 0)
    public Float getPendapatanCukup() {
        return this.pendapatanCukup;
    }

    public void setPendapatanCukup(Float pendapatanCukup) {
        this.pendapatanCukup = pendapatanCukup;
    }

    @Column(name = "attitude_kurangbaik", precision = 12, scale = 0)
    public Float getAttitudeKurangbaik() {
        return this.attitudeKurangbaik;
    }

    public void setAttitudeKurangbaik(Float attitudeKurangbaik) {
        this.attitudeKurangbaik = attitudeKurangbaik;
    }

    @Column(name = "attitude_baik", precision = 12, scale = 0)
    public Float getAttitudeBaik() {
        return this.attitudeBaik;
    }

    public void setAttitudeBaik(Float attitudeBaik) {
        this.attitudeBaik = attitudeBaik;
    }

}
