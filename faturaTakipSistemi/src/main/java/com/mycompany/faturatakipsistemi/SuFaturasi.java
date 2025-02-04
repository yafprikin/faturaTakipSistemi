package com.mycompany.faturatakipsistemi;

import java.time.LocalDate;

public class SuFaturasi extends Fatura {
    boolean gecikmeVarMi;
    public SuFaturasi(String musteriAdi, double faturaTutari, LocalDate sonOdemeTarihi) {
        super(musteriAdi, faturaTutari, sonOdemeTarihi);
    }

    @Override
    public void gecikmeZammiHesapla() throws Exception {
        if (gecikmedeMi()) {
            double gecikmeZammi = faturaTutari * 0.03; // %3 gecikme zammı
            faturaTutari += gecikmeZammi;
            System.out.println("Su Faturasina Gecikme Zammi Uygulandi : " + gecikmeZammi);
            gecikmeVarMi = true;
            indirimHesapla();
            
            if (gecikmeZammi > 100) { // Gecikme zammı çok büyükse örnek hata durumu
            throw new GecikmeZammiException("Gecikme Zammi cok yuksek!" + gecikmeZammi + " TL");
        }
        } else {
            System.out.println("Su Faturasina Gecikme Zammi Uygulanmadı.");
            gecikmeVarMi = false;
            indirimHesapla();
        }
    }
    
    public void indirimHesapla() {
        
        if (faturaTutari>50 && gecikmeVarMi==false) {
            indirimliFaturaTutari=faturaTutari*0.95;
            System.out.println("Gecikme yok ve 30TL'den yuksek fatura.\nIndirimli Fatura Tutari : \t" + indirimliFaturaTutari + "\n");
        }
        else if (faturaTutari>50 && gecikmeVarMi==true){
            System.out.println("Gecikme oldugundan indirim faturaya yansimadi.\n");
            indirimliFaturaTutari=faturaTutari;
        }
        else if (faturaTutari<50 && gecikmeVarMi==false) {
            System.out.println("Gecikme yok fakat fatura tutari 30 dan kucuk oldugundan indirim faturaya yansimadi.\n");
            indirimliFaturaTutari=faturaTutari;
        }
        else if (faturaTutari<50 && gecikmeVarMi==true) {
            System.out.println("Gecikme var ve fatura tutari 30 dan kucuk oldugundan indirim faturaya yansimadi.\n");
        }
        else {
            System.out.println("Karsilastirmalarda bir hata ile karsilasildi. Hicbir seye dokunulmadan devam ediliyor.\n");
            indirimliFaturaTutari=faturaTutari;
        }
    }
}




//SuFaturasi:
//
//Tüketim: Kullanıcı ne kadar su tüketmişse, toplam tutar buna göre hesaplanır.
//İndirim: 50 TL'yi aşan faturalar için %5 indirim uygulanır.
//Gecikme Zammı: Ödeme tarihi geçmiş faturalar için %10 gecikme zammı eklenir.