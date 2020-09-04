/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.UrunYukle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UrunKutusu extends JPanel {    //bu sınıfın amacı marketPanel'e her bir ürünü yeni bir JPanel içerisinde düzenli bir şekilde tutarak eklemektir

    private JPanel panel;
    private JLabel image;
    private JLabel urunAd;
    private JLabel urunFiyat;
    private JButton sepeteEkleButton;
    private static SessionFactory sessionFactoryObj;
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
    
    public UrunKutusu(String imageName, String urunAd, float urunFiyat, int urunId, JPanel urunSepet) { //marketPanel'e eklenen ürünler için kullanılan constructor
        panel = new JPanel();
        setBorder(BorderFactory.createLineBorder(Color.black, 3, true));    //panele çerçeve ekle
        panel.setLayout(new GridLayout(4, 0));  //panelin layoutunu GridLayout olarak set et
        ImageIcon imageIcon = new ImageIcon("images/" + imageName); //panele yüklenecek image'lar için ImageIcon oluştur ve path'ini ürün oluşturulduğunda veri tabanından al
        Image imageResize = imageIcon.getImage();   //image'ın size'ını ayarlayabilmek için
        Image newImg = imageResize.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH);    //yeni bir Image nesnesinde önceden oluşturduğumuz Image nesnesini scale et
        image = new JLabel(new ImageIcon(newImg));  //boyutu ayarlanan Image'ı yeni bir ImageIcon olarak image JLabel'ine ekle
        this.urunAd = new JLabel(urunAd);   //gelen ürün adını urunAd JLabel'ine ekle
        this.urunFiyat = new JLabel("Fiyat: " + String.valueOf(urunFiyat) + "TL");  //gelen ürün fiyatını urunFiyat JLabel'ine ekle
        sepeteEkleButton = new JButton("Sepete Ekle");  //sepete ekle butonu ekle
        sepeteEkleButton.addActionListener(new ActionListener() {   //sepeteEkleButton için bir action listener oluştur ki hangi butona basıldığını anlayıp urunSepet paneline UrunKutusu ekleyebilelim
            @Override
            public void actionPerformed(ActionEvent e) {
                int secilenUrunId;
                UrunYukle urunYukle = new UrunYukle();
                secilenUrunId = Integer.parseInt(e.getActionCommand());
                urunYukle.sepeteEkle(urunSepet, secilenUrunId, buildSessionFactory());  //UrunYukle sınıfının sepeteEkle metoduna urunSepet(JPanel), secilenUrunId(butonu tıklanan ürünün id'si ve SessionFactory objesi(veri tabanına bağlanmak için) gönder
                
            }
        });
        sepeteEkleButton.setActionCommand(String.valueOf(urunId));  //ürünü sepete eklemek için butona tıklandığında, ürünü tanımlayabilmek için butonun ActionCommand'ini ürünün id'si olarak set ediyoruz
        panel.add(image);   //panele componentleri ekle
        panel.add(this.urunAd);
        panel.add(this.urunFiyat);
        panel.add(sepeteEkleButton);
        this.add(panel);    //paneli yeni bir JPanel nesnesinden oluştur(panel referansına yeni bir obje atandı)
    }

    public UrunKutusu(String urunAd, float urunFiyat) { //urunSepet'e eklenen ürünler için kullanılan constructor
        panel = new JPanel();
        setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));    //çerçeve ekle
        setLayout(new BorderLayout(5, 5));  //layoutu BorderLayout olarak set et
        this.urunAd = new JLabel(urunAd);
        this.urunFiyat = new JLabel(String.valueOf(urunFiyat) + "TL");
        panel.add(this.urunAd); //componentleri panele ekle
        panel.add(this.urunFiyat);
        this.add(panel);    //paneli yeni bir JPanel nesnesinden oluştur(panel referansına yeni bir obje atandı)
    }
}
