
import java.util.Scanner;

// Program Purpose : Abstract Implementation of Real Time Currency and ATM Program
// Main Purpose to Implement RealTime Abstract Finance Program

// Author : EmirhanG --> DataCalculus
// Version : 0.3.27




// Possible and anticipated upgrade list ...
/*
Doviz kurunu degistirmek (random lib or additional randomness)
Zaman tabelası eklemek   (formatted string pattern)
Borsa kapanış açılış saati (check işlemleri ve kur değişimi sabitlenişi)
Borsa açılıp kapandığında
Para çekme yatırma durumunda fiş basma
Para çekme/yatırma
Inter_* methodlarında zamana göre string basmak iyi_gunler iyi_aksamlar
Atm kuyruğu ilk başlarda sırada bekleniyor console mesajı (random int ile implement et şimdilik)
        Belki döviz bastırılabilir bekleme aşamasında şube simülasyonu gibi...tabii şube kuyruğu da olabilir.
Errorlar yetersiz bakiye gibi... Sınırlandırılmalı hak ve bu declare edilmeli adil finans sırası atm kur vs için

ADVANCED LEVEL ... >>> Fraud Detection Upgrade ...

UPDATELER ile birlikte Kullancının minimum bilgili olduğu varsayımından ötürü düzenlemeler.



*/


//    ||||||||||||||||||||||||||||||||||              \\
//              Program Scheme                       (laterName architecture if db and other thins be used)
/*
Selamlama giriş,
Infinite loop,
Menu calistirilir

 */


public class Main {

    public static void Inter_Commencement()
    {
        System.out.println("Merhaba, Finans/ATM programina hos geldiniz...");
    }


    public static void Inter_Leave()
    {
        System.out.println("Tesekkur eder, iyi gunler dileriz...");
    }






    public static void Menu()
    {

        System.out.println("Menu yukleniyor...");
        // timing olabilir
        System.out.println("1. Mevcut kur bilgisine erismek icin...");
        System.out.println("2. Bakiye goruntuleme...");
        System.out.println("3. Doviz al");
        System.out.println("4. Doviz sat");
        System.out.println("5. Menuyu goruntulemek icin...");
        System.out.println("0. Cikis ");


    }



    public static void main(String[] args) {

        boolean logicContinuity = true;
        double Currency_Euro_Alim  = 20.10;
        double Currency_Euro_Satim = 19.10;
        double Capital_TRY         = 8500;
        double Capital_Euro        = 0;
        Inter_Commencement();
        Menu();
       while(logicContinuity)
       {

           Scanner input = new Scanner(System.in);
           int selection =  input.nextInt();
           System.out.println("Lutfen bekleyiniz...");
           if (selection==1)
           {
               System.out.println("Euro alim --> "+ Currency_Euro_Alim+" Turk lirasidir");
               System.out.println("Euro satim --> "+ Currency_Euro_Satim+" Turk lirasidir");

           }

           else if (selection==2)
           {
               System.out.println("Hesabinizdaki kalan para "+Capital_TRY +" tutarindadir.");

           }

           else if (selection==3)
           {
               System.out.println("Lutfen ne kadar doviz almak istediginizi yaziniz...");
               double temp_doviz = input.nextDouble();
               Capital_Euro =  Currency_Euro_Alim*temp_doviz;
               Capital_TRY  = Capital_TRY - (temp_doviz*Currency_Euro_Alim) ;
           }

           else if (selection==4)
           {
               System.out.println("Lutfen ne kadar doviz satmak istediginizi yaziniz...");
                double temp_doviz_sat = input.nextDouble();
               Capital_Euro =  Currency_Euro_Satim*temp_doviz_sat;
               Capital_TRY  = Capital_TRY + (temp_doviz_sat*Currency_Euro_Satim) ;

           }
           else if (selection==5)
           {
              Menu();

           }



           else if (selection==0)
           {
               Inter_Leave();
               logicContinuity=false;
               break;
           }


           else
           {
               continue;
           }



       }





    }
}