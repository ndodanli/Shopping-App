/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Kullanici;

public class LoginData {    //kullanıcı giriş yaptığında bilgilerini program çalıştığı sürece tutmak için kullanılan sınıf
    private static Kullanici kullaniciBilgi;
    public static Kullanici getKullaniciBilgi() {
        return kullaniciBilgi;
    }

    public static void setKullaniciBilgi(Kullanici kullaniciBilgi) {
        LoginData.kullaniciBilgi = kullaniciBilgi;
    }

}
