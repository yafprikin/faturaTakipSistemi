package com.mycompany.faturatakipsistemi;

import java.time.LocalDate;
import java.util.Scanner;

public class FaturaTakipSistemi {
   public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int secim;
            Kullanici optional = new Kullanici("DEFAULT", "00000000000", "DEFAULT", "DEFAULT", "DEFAULT");
            
            
            System.out.println("o---Seciminizi yapin---o");
            System.out.println("1:Elektrik\n2:Su\n3:Internet\n4:Dogalgaz\n5:Ornekler\n");
            secim = scanner.nextInt();
            if ( secim==1 | secim==2 | secim==3 | secim==4 | secim==5) {
                System.out.println("Manuel secim yaptiniz, bazi bilgiler girmeniz gerekmekte.");
                optional.setToplama();
                double toplamTutar = optional.getTutar();
                
                
                
                if (secim==1) {
                    ElektrikFaturasi optionalElektrik = new ElektrikFaturasi(optional.getAdSoyad(), optional.getTutar(), LocalDate.of(optional.getYil(), optional.getAy(), optional.getGun()));
                    optionalElektrik.faturaDetaylariGoster();
                    optionalElektrik.gecikmeZammiHesapla();
                }
                else if (secim==2) {
                    SuFaturasi optionalSu = new SuFaturasi(optional.getAdSoyad(), optional.getTutar(), LocalDate.of(optional.getYil(), optional.getAy(), optional.getGun()));
                    optionalSu.faturaDetaylariGoster();
                    optionalSu.gecikmeZammiHesapla();
                }
                else if (secim==3) {
                    InternetFaturasi optionalInternet = new InternetFaturasi(optional.getAdSoyad(), optional.getTutar(), LocalDate.of(optional.getYil(), optional.getAy(), optional.getGun()));
                    optionalInternet.faturaDetaylariGoster();
                    optionalInternet.gecikmeZammiHesapla();
                }
                else if (secim==4) {
                    DogalgazFaturasi optionalDogalgaz = new DogalgazFaturasi(optional.getAdSoyad(), optional.getTutar(), LocalDate.of(optional.getYil(), optional.getAy(), optional.getGun()));
                    optionalDogalgaz.faturaDetaylariGoster();
                    optionalDogalgaz.gecikmeZammiHesapla();
                    
                }
                else if (secim==5) {
                    System.out.println("Örneklere geçiliyor...");
                }
                else {
                    System.out.println("Beklenmedik bir hata. Kim bilir ne oldu.");
                }
            }
            else {
                    System.out.println("Hatali secim yaptiniz, otomatik olarak örneklere geçiliyor.");
                }
            
            System.out.println("Ornekleri goruntulemek icin rastgele bir sayi girin");
            secim = scanner.nextInt();
            
            // Fatura örnekleri oluştur
            ElektrikFaturasi elektrikFaturasi = new ElektrikFaturasi("Emre Nesne", 250.0, LocalDate.of(2024, 12, 10));
            SuFaturasi suFaturasi = new SuFaturasi("Burak Yapilan", 75.0, LocalDate.of(2024, 11, 25));
            InternetFaturasi internetFaturasi = new InternetFaturasi("Yusuf Program", 100.0, LocalDate.of(2024, 11, 20));
            DogalgazFaturasi dogalgazFaturasi = new DogalgazFaturasi("Yagiz Lama", 100.0, LocalDate.of(2025, 11, 20));

            // Fatura detaylarını göster
            elektrikFaturasi.faturaDetaylariGoster();
            Kullanici kullanici1 = new Kullanici("Emre Nesne", "05553332211", "Manisa", "Turgutlu", "Yeni");
            System.out.println("Adres \t:" + kullanici1.getAdres().adresBilgisi());
            elektrikFaturasi.gecikmeZammiHesapla();
            System.out.println("\n\n");
            
            
            suFaturasi.faturaDetaylariGoster("Su Faturasi Detaylari");
            Kullanici kullanici2 = new Kullanici("Burak Yapilan", "0555444444", "Manisa", "Turgutlu", "Alazlar");
            System.out.println("Adres \t:" + kullanici2.getAdres().adresBilgisi());
            suFaturasi.gecikmeZammiHesapla();
            System.out.println("\n\n");
            
            
            internetFaturasi.faturaDetaylariGoster("Internet Faturasi Detaylari", "TL");
            Kullanici kullanici3 = new Kullanici("Yusuf Program", "05553330011", "Manisa", "Turgutlu", "Acarlar");
            System.out.println("Adres \t:" + kullanici3.getAdres().adresBilgisi());
            internetFaturasi.gecikmeZammiHesapla();
            System.out.println("\n\n");
            
            
            dogalgazFaturasi.faturaDetaylariGoster();
            Kullanici kullanici4 = new Kullanici("Yusuf Program", "05553330011", "Manisa", "Turgutlu", "Acarlar");
            System.out.println("Adres \t:" + kullanici4.getAdres().adresBilgisi());
            dogalgazFaturasi.gecikmeZammiHesapla();
            System.out.println("\n\n");

            // Gecikme zammı hesaplama testleri
            // suFaturasi.gecikmeZammiHesapla();
            // internetFaturasi.gecikmeZammiHesapla();
            // elektrikFaturasi.gecikmeZammiHesapla();
            // dogalgazFaturasi.gecikmeZammiHesapla();

        } catch (HatalıTutarException e) {
            System.out.println("Hatali Tutar Hatasi \t: " + e.getMessage());
        } catch (GecikmeZammiException e) {
            System.out.println("Gecikme Hatasi \t: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Beklenmeyen bir hata olustu \t: " + e.getMessage());
        }
        
        
        
        
    }
   
}





