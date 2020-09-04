package controller;
 
import model.Kullanici;
import model.Urun;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.hibernate.Query;
import org.hibernate.Session;

public class LoadData {
 
    private static Session sessionObj;
    private long control = 0;
    public LoadData(Session sessionObj){
        this.sessionObj = sessionObj;
    }
    
    public void loadAllData(){ //verileri veri tabanına yüklediğimiz metod
        try {
            sessionObj.beginTransaction(); //veritabanına yükleme işlemini başlatıyoruz
            Query query = sessionObj.createQuery("select count(*) from Urun");  //Program her çalıştığında test verilerini tekrar yüklememek için veri tabanında veri olup olmadığını kontrol etmek adına ürün tablosundaki verilerin sayısını alıyoruz
            control = (long)query.uniqueResult();   //tek bir veri alacağımız için uniqueResult() metodu ile sorguyu gerçekleştiriyoruz
            if(control == 0){   //veri tabanında veri olup olmadığını kontrol ediyoruz
                //test için verilerimizi yüklüyoruz
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.save(new Urun("Albeni", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_albeni.jpg", (float) 1.5));
            sessionObj.save(new Urun("Fındıklı Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatfindikli.jpg",(float) 1.25));
            sessionObj.save(new Urun("Muzlu Dokuz Kat", "Ulker", "Gofret", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_dokuzkatmuzlu.jpg",(float) 2));
            sessionObj.save(new Urun("Çikolatalı Gofret", "Ulker", "Çikolata", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_gofret.png",(float) 1.75));
            sessionObj.save(new Urun("Grissini", "Ulker", "Kraker", new GregorianCalendar(2022, Calendar.FEBRUARY, 20).getTime(), "ulker_grissini.jpg",(float) 1.5));
            sessionObj.getTransaction().commit();   //sessionu flush etmek ve çalışmayı sonlandırmak için commit() gerçekleştiriyoruz(bkz. https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/Transaction.html)
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback(); //herhangi bir sql hatasında işlemi geri gönderiyoruz(yeni oluşturular objeler kaldırılır)
            }
            sqlException.printStackTrace(); //bir sqlexception hatasındada sorunun nerede olduğunu anlayabilmek adına
        } finally {
            if(sessionObj != null) {
                sessionObj.close(); //sessionu kapatıyoruz
            }
        }
    }
        
    }

