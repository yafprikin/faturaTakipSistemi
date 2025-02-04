package com.mycompany.faturatakipsistemi;
import java.util.Scanner;

//1--Kullanici sınıfı, kullanıcı bilgilerini tutar: ad, soyad, telefon numarası ve Adres bilgisi.
//2--Adres iç içe sınıfı, kullanıcının adres bilgisini tutar: il, ilçe, mahalle.
//3--Kullanici sınıfının yapılandırıcısı, adres bilgilerini de alır ve Adres iç içe sınıfını başlatır.
//4--adresBilgisi() metodu, adresin tamamını döndürür (il, ilçe, mahalle).
 
        
public class Kullanici {
    private String adSoyad;
    private String telefon;
    private Adres adres;  //içiçe
    private int gun;
    private int ay;
    private int yil;
    private int tutar;
    
    Scanner scanner = new Scanner(System.in);
    
    public Kullanici(String adSoyad ,String telefon,String il,String ilce,String mahalle){
        this.adSoyad = adSoyad;
        this.telefon = telefon;
        this.adres = new Adres(il, ilce,mahalle);
        
    }
    public void setToplama() throws HatalıTutarException {
        setAdSoyad();
        setTelefon();
        setAdresBilgileri();
        setTarih();
        setTutar();   
    }
    
    public String getAdSoyad(){
        return adSoyad;
    }
    
    public void setAdSoyad(){
        System.out.println("Lutfen adi giriniz \t:");
        this.adSoyad = scanner.nextLine();
    }
    
    public String getTelefon(){
        return telefon;
    }
    
    public void setTelefon(){
        System.out.println("Lutfen telefonu giriniz \t:");
        this.telefon = scanner.nextLine();
    }
    
    public Adres getAdres(){
        return adres;
    }
    
    public void setAdres(Adres adres){
        this.adres=adres;
    }
    public void setAdresBilgileri() {
        System.out.println("o---Lutfen adres bilgilerini gitin---o");
        this.adres.setIl();
        this.adres.setIlce();
        this.adres.setMahalle();
        this.setAdres(adres);
    }
    public String getAdresBilgileri() {
        return (this.adres.adresBilgisi());
    }
    
    public void setTarih() {
        System.out.println("Lutfen gun giriniz \t:");
        this.gun = scanner.nextInt();
        System.out.println("Lutfen ay giriniz \t:");
        this.ay = scanner.nextInt();
        System.out.println("Lutfen yil giriniz \t:");
        this.yil = scanner.nextInt();
    }
    
    public String getTarih() {
        return yil +"/"+ ay +"/"+ gun;
    }
    public int getGun() {
        return gun;
    }
    public int getAy() {
        return ay;
    }
    public int getYil() {
        return yil;
    }
    
    public void setTutar() throws HatalıTutarException{
        System.out.println("Lutfen tutar giriniz : ");
        this.tutar = scanner.nextInt();
        
        if (this.tutar < 0) {
        throw new HatalıTutarException("Tutar negatif olamaz!");
    }
    }
    
    public int getTutar() {
        return tutar;
    }
    
    
    
    public static class Adres {
        private String il, ilce ,mahalle;
        Scanner scanner = new Scanner(System.in);


        public Adres(String il,String ilce,String mahalle){
            this.il = il ;
            this.ilce = ilce;
            this.mahalle = mahalle ;
        }
        
        public String getIl(){
            return il;
        }
        
        public void setIl(){
            System.out.println("Lutfen il giriniz \t:");
            this.il= scanner.nextLine();
        }
        public String getIlce(){
            return ilce;
        }
        
        public void setIlce(){
            System.out.println("Lutfen ilce giriniz \t:");
            this.ilce=scanner.nextLine();
        }
        public String getMahalle(){
            return mahalle;
        }
        
        public void setMahalle(){
            System.out.println("Lutfen Mahalle giriniz \t:");
            this.mahalle=scanner.nextLine();
        }
        
        public String adresBilgisi(){
            return il+", "+ilce+", "+mahalle;
        }
        
        
}
}



//Adres sınıfı, Kullanici sınıfının içinde iç içe (nested) bir sınıf olarak yer alır.
//Adres bilgilerini almak için, kullanıcı nesnesinin getAdres() metodunu kullanırız.
//adresBilgisi() metodu, tam adres bilgisini döndürür.