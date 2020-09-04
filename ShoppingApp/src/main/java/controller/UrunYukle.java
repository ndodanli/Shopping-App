/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.LoginData;
import model.UrunKutusu;
import model.Urun;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import view.Main;

public class UrunYukle {    //bu sınıftaki metodların amacı market paneline geçildiğinde ürünleri market paneline doldurmak ve herhangi bir ürün sepete eklendiğinde urunSepet paneline ürünleri eklemektir

    private Urun urun = new Urun();
    private static Session sessionObj;
    private static List<Urun> sepettekiUrunler;

    public void doldur(JPanel urunPanel, JPanel urunSepet, JLabel cuzdanBilgi, SessionFactory sessionFactoryObj) {  //marketPanel'e geçildiğinde marketPanel'e veri tabanından alınan ürünleri ekle
        try {
            sessionObj = sessionFactoryObj.openSession(); //yeni bir session aç
            sessionObj.beginTransaction();  //işlemi başlat
            String hql = "from Urun";   //bütün ürünleri çek
            Query query = sessionObj.createQuery(hql);
            List results = query.list();
            for (Object iter : results) {
                urun = (Urun) iter; //çekilen ürünleri atadığımız listedeki her objeyi Urun nesnesine cast edip UrunKutusu objelerinin constustor'ındaki parametreler için gönderiyoruz ve marketPanel için yeni UrunKutuları oluşturuyoruz
                urunPanel.add(new UrunKutusu(urun.getImagePath(), urun.getAd(), urun.getUcret(), urun.getId(), urunSepet));
            }
            cuzdanBilgi.setText(String.valueOf(LoginData.getKullaniciBilgi().getCuzdan())); //cüzdan bilgimizi güncelliyoruz
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }

    }

    public void sepeteEkle(JPanel urunSepet, int id, SessionFactory sessionFactoryObj) {    //marketPanel'deki ürünlerden sepete eklenenleri urunSepet paneline eklemek için kullandığımız metod
        try {
            sepettekiUrunler = Main.getSepettekiUrunler();  //sepetteki urunları Main sınıfındaki static bir ArrayList içerisinde tutuyoruz çünkü program çalıştığı müddetçe bu listenin içindeki objelere erişim sağlamak istiyoruz
            sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            String hql = "from Urun where id=:urunId";  //Urun tablosundan id'si gelen id'mize eşit olan veriyi getirmek için hql query
            Query query = sessionObj.createQuery(hql); 
            query.setParameter("urunId", id); //hql sorgusunda parametre olarak kullandığımız urunId'ye gelen id'yi parametre olarak veriyoruz
            urun = (Urun) query.uniqueResult(); //tek bir veri alıyoruz
            sepettekiUrunler.add(urun); //ürünümüzü sepete ekliyoruz
            urunSepet.removeAll();  //sepetteki tüm componentleri kaldırıyoruz(yenilerini yükleyip güncellemek için)
            for (Urun iter : sepettekiUrunler) {    //sepettekiUrunler listesinden urunSepet paneline ürünleri ekliyoruz 
                urunSepet.add(new UrunKutusu(iter.getAd(), iter.getUcret()));
            }
            urunSepet.revalidate(); //yeni componentler eklediğimizden layoutmanagere layoutun yeniden hesaplanması gerektiğini bildiriyoruz
            urunSepet.repaint();    //layoutu etkileyecek şekilde değişen componentleri repaint ediyoruz
            //*revalidate ve repainti birlikte kullanarak layout ve ekranın güncel olduğunu garantiliyoruz
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();

            }
        }
    }
}
