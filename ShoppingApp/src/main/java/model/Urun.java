package model;
 
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "urun_table")
public class Urun implements Serializable {

    public Urun(){ //hibernate sorgulama dilinde default constructor hatasından kaçınmak için default constructor oluştuldu
        
    }
    public Urun(String ad, String marka, String kategori, Date sonKTarih, String imagePath, float ucret) {
        this.ad = ad;
        this.marka = marka;
        this.kategori = kategori;
        this.sonKTarih = sonKTarih;
        this.imagePath = imagePath;
        this.ucret = ucret;
    }
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "urun_id")
    private int id;
     
    @Column(name = "urun_ad")
    private String ad;
 
    @Column(name = "urun_marka")
    private String marka;
 
    @Column(name = "urun_kategori")
    private String kategori;
    
    @Column(name = "urun_sk_tarih")
    private Date sonKTarih;

    @Column(name = "urun_resim_yolu")
    private String imagePath;
    
    @Column(name = "urun_ucret")
    private float ucret;
    
    //getter ver setter metodları
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Date getSKTarih() {
        return sonKTarih;
    }

    public void setSKTarih(Date sonKTarih) {
        this.sonKTarih = sonKTarih;
    }

    public Date getSonKTarih() {
        return sonKTarih;
    }

    public void setSonKTarih(Date sonKTarih) {
        this.sonKTarih = sonKTarih;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getUcret() {
        return ucret;
    }

    public void setUcret(float ucret) {
        this.ucret = ucret;
    }
    

}
