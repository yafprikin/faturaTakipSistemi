
package com.mycompany.faturatakipsistemi;


import java.time.LocalDate;

public abstract class Fatura {
    protected String musteriAdi;
    protected double faturaTutari;
    protected double indirimliFaturaTutari; //Yagiz İndirimli tutarların hazırlanması için abstract class'a fatura eklendi
    protected LocalDate sonOdemeTarihi;
    protected boolean odemeDurumu;

    // Yapılandırıcı
    public Fatura(String musteriAdi, double faturaTutari, LocalDate sonOdemeTarihi) {
        this.musteriAdi = musteriAdi;
        this.faturaTutari = faturaTutari;
        this.sonOdemeTarihi = sonOdemeTarihi;
        this.odemeDurumu = false;  // Varsayılan olarak ödenmemiş
    }

    // Yöntem 1: Fatura detaylarını göster (Parametresiz)
    public void faturaDetaylariGoster() { // Yagiz.1 : Bu fonksiyona \t eklenerek noktalamanin esitlenmesi saglandi
        System.out.println("Musteri Adi \t: " + musteriAdi);
        System.out.println("Fatura Tutari \t: " + faturaTutari);
        System.out.println("Son Odeme Tarihi \t: " + sonOdemeTarihi);
        System.out.println("Odeme Durumu \t: " + (odemeDurumu ? "Odenmis" : "Odenmemis"));
    }

//    // Yöntem 2: Fatura detaylarını mesaj ile göster (Bir parametreli)
    public void faturaDetaylariGoster(String mesaj) {
        System.out.println("Mesaj \t: " + mesaj);
        faturaDetaylariGoster();  // parametresiz olanı çağır
    }

    // Yöntem 3: Fatura detaylarını mesaj ve kur ile göster (İki parametreli)
    public void faturaDetaylariGoster(String mesaj, String paraBirimi) {
        System.out.println("Mesaj \t: " + mesaj);
        System.out.println("Tutar (" + paraBirimi + ")\t: " + faturaTutari);
        faturaDetaylariGoster();  // parametresiz olanı çağır
    }

    // Kalan gün sayısını manuel olarak hesaplama (LocalDate çıkarma)
    public long kalanGunSayisi() {
        return sonOdemeTarihi.getDayOfYear() - LocalDate.now().getDayOfYear();
    }

    public void odemeDurumunuDegistir(boolean durum) {
        this.odemeDurumu = durum;
    }

    public boolean gecikmedeMi() {
        return !odemeDurumu && sonOdemeTarihi.isBefore(LocalDate.now());
    }

    // Alt sınıflarda zorunlu kılmak için bir abstract metodu tanımlıyoruz
    public abstract void gecikmeZammiHesapla() throws Exception;
}






























//public abstract class Fatura {
//    // Alanlar
//    protected String musteriAdi ;
//    protected double tutar;
//    protected LocalDate sonOdemeTarihi;
//    protected boolean odemeDurumu;
//
//    // Yapılandırıcı
//    public Fatura(String musteriAdi, double tutar, LocalDate sonOdemeTarihi) {
//        if (tutar <= 0) {
//            throw new IllegalArgumentException("Tutar sıfır veya negatif olamaz.");
//        }
//        this.musteriAdi = musteriAdi;
//        this.tutar = tutar;
//        this.sonOdemeTarihi = sonOdemeTarihi;
//    }
//
//    // Soyut yöntem
//    public abstract void hesaplaToplamTutar();
//
//    // Ortak yöntem
//    public void faturaDetaylariGoster() {
//        System.out.println("Müşteri Adı: " + musteriAdi);
//        System.out.println("Fatura Tutarı: " + tutar);
//        System.out.println("Son Ödeme Tarihi: " + sonOdemeTarihi);
//    }
//
//    // Getter ve Setter yöntemleri
//    public String getMusteriAdi() {
//        return musteriAdi;
//    }
//
//    public void setMusteriAdi(String musteriAdi) {
//        this.musteriAdi = musteriAdi;
//    }
//
//    public double getTutar() {
//        return tutar;
//    }
//
//    public void setTutar(double tutar) {
//        if (tutar <= 0) {
//            throw new IllegalArgumentException("Tutar sıfır veya negatif olamaz.");
//        }
//        this.tutar = tutar;
//    }
//
//    public LocalDate getSonOdemeTarihi() {
//        return sonOdemeTarihi;
//    }
//
//    public void setSonOdemeTarihi(LocalDate sonOdemeTarihi) {
//        this.sonOdemeTarihi = sonOdemeTarihi;
//    }
//}

