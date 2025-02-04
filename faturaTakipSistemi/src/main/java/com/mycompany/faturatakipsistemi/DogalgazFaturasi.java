package com.mycompany.faturatakipsistemi;
import java.time.LocalDate;

public class DogalgazFaturasi extends Fatura {
     boolean gecikmeVarMi;
    public DogalgazFaturasi(String musteriAdi, double faturaTutari, LocalDate sonOdemeTarihi) {
        super(musteriAdi, faturaTutari, sonOdemeTarihi);
    }

    @Override
    public void gecikmeZammiHesapla() throws Exception {
        if (gecikmedeMi()) {
            double gecikmeZammi = faturaTutari * 0.07; // %7 gecikme zammı
            faturaTutari += gecikmeZammi;
            System.out.println("Dogalgaz Faturasina Gecikme Zammi Uygulandi: " + gecikmeZammi);
            gecikmeVarMi = true;
            indirimHesapla();
            if (gecikmeZammi > 100) { // Gecikme zammı çok büyükse örnek hata durumu
            throw new GecikmeZammiException("Gecikme Zammi cok yuksek!" + gecikmeZammi + " TL");
        }

        } else {
            System.out.println("Dogalgaz Faturasina Gecikme Zammi Uygulanmadi.");
            gecikmeVarMi = false;
            indirimHesapla();
        }
    }
    
    public void indirimHesapla() {
        if (faturaTutari>30 && gecikmeVarMi==false) {
            indirimliFaturaTutari=faturaTutari*0.95;
            System.out.println("Gecikme yok ve 30TL'den yuksek fatura.\nIndirimli Fatura Tutari : \t" + indirimliFaturaTutari + "\n");
        }
        else if (faturaTutari>30 && gecikmeVarMi==true){
            System.out.println("Gecikme oldugundan indirim faturaya yansimadi.\n");
            indirimliFaturaTutari=faturaTutari;
        }
        else if (faturaTutari<30 && gecikmeVarMi==false) {
            System.out.println("Gecikme yok fakat fatura tutari 30 dan kucuk oldugundan indirim faturaya yansimadi.\n");
            indirimliFaturaTutari=faturaTutari;
        }
        else if (faturaTutari<30 && gecikmeVarMi==true) {
            System.out.println("Gecikme var ve fatura tutari 30 dan kucuk oldugundan indirim faturaya yansimadi.\n");
            indirimliFaturaTutari=faturaTutari;
        }
        else {
            System.out.println("Karsilastirmalarda bir hata ile karsilasildi. Hicbir seye dokunulmadan devam ediliyor.\n");
        }
        
    } 
}
