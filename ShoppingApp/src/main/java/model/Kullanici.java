package model;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
                                //veri tabanındaki tabloları oluşturmak için tablomuzu ve özelliklerini belirlediğimiz sınıflardan biri
@Entity
@Table(name = "kullanici_table")    //veri tabanındaki tablomuzun adını belirliyoruz
public class Kullanici implements Serializable {

    public Kullanici() {
    }
    public Kullanici(int id,String kullaniciAdi, String parola, float cuzdan) { //kullanıcının giriş yaptığında program çalıştığı sürece bilgilerinin tutulduğu ya da yok edildiği durumlar için kullanılan constructor
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.cuzdan = cuzdan;
    }
    //kullanıcı nesnemizi oluşturduğumuzda bilgilerin objemize yüklenmesini sağlamak için constructora alınması gereken bilgileri parametre olarak alıyoruz
    public Kullanici(String kullaniciAdi, String parola, String rol, String mail) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.rol = rol;
        this.mail = mail;
    }
    //diğer bir constructorumuzda da admin rolündeki kullanıcı oluşturmak için gereken parametreleri alıyoruz
    public Kullanici(String kullaniciAdi, String parola, String rol) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
        this.rol = rol;
    }
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "kullanici_id")
    private int id;

    @Column(name = "kullanici_k_adi", unique = true)
    private String kullaniciAdi;
    
    @Column(name = "kullanici_parola",nullable=false)
    private String parola;
    
    @Column(name = "kullanici_ad")
    private String ad;
 
    @Column(name = "kullanici_soyad")
    private String soyad;
 
    @Column(name = "kullanici_rol")
    private String rol;
    
    @Column(name = "kullanici_cuzdan")
    private float cuzdan;
    
    @Column(name = "kullanici_tel")
    private String telefon;
    
    @Column(name = "kullanici_adres")
    private String adres;
    
    @Column(name = "kullanici_email")
    private String mail;

    //getter ver setter metodları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getKullaniciAdi() {
    return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public float getCuzdan() {
        return cuzdan;
    }

    public void setCuzdan(float cuzdan) {
        this.cuzdan = cuzdan;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String geteMail() {
        return mail;
    }

    public void seteMail(String mail) {
        this.mail = mail;
    }  
}
