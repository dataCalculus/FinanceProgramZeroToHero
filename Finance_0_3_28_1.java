
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;
import java.util.Scanner;

// Program Purpose : Abstract Implementation of Real Time Currency and ATM Program
// Main Purpose to Implement RealTime Abstract Finance Program

// Author : EmirhanG --> DataCalculus
// Version : 0.3.28.1

// New feature list comes with 0.3.28.1
// ++ Kesinlik yes/no 1/0 implement edildi.
// ++ Time eklendi
// ++ Kur değişimi random int ve double type casting ile eklendi.









// Possible and anticipated upgrade list ...
/*  version 0.3.28.2 ile gelecek özellikler
More User Friendly Menu
Bakiye currency bugları
Borsa kapanış açılış saati (check işlemleri ve kur değişimi sabitlenişi)
Inter_* methodlarında zamana göre string basmak iyi_gunler iyi_aksamlar
Atm kuyruğu ilk başlarda sırada bekleniyor console mesajı (random int ile implement et şimdilik)
        Belki döviz bastırılabilir bekleme aşamasında şube simülasyonu gibi...tabii şube kuyruğu da olabilir.
Fiş basmak Ayrı method

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
        CurrentTime();
        System.out.println("Merhaba, Finans/ATM programina hos geldiniz...");
    }


    public static void Inter_Leave()
    {
        CurrentTime();
        System.out.println("Tesekkur eder, iyi gunler dileriz...");
    }






    public static void Menu()
    {

        System.out.println("Menu yukleniyor...");
        // timing olabilir
        CurrentTime();
        System.out.println("1. Mevcut kur bilgisine erismek icin...");
        System.out.println("2. Bakiye goruntuleme...");
        System.out.println("3. Doviz al");
        System.out.println("4. Doviz sat");
        System.out.println("5. Menuyu goruntulemek icin...");
        System.out.println("0. Cikis ");


    }


    public static void  CurrentTime()
    {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
    }


    public static double CurrencyFluctuation()
    {
        Random randomNum = new Random();
        double temp = randomNum.nextInt(3);
        if (randomNum.nextInt(1) == 0)
        {
            return(temp);
        }

        else
        {
            return(temp*-1);
        }

    }



    // Kesinlik methodunda secim ekraninda kit sayida karakter oldugu varsayildi dokunmaktik ornedgindeki gibi...
    public static int Certainity()
    {
        CurrentTime();
        System.out.println("Proc un tamamlanması icin onaylama tusuna basiniz...");
        Scanner scan = new Scanner(System.in);
        int temp_ok = scan.nextInt();
        if (temp_ok == 1)
        {
            System.out.println("Islem onaylandi...");
            return 1;
        }
        else  {
        System.out.println("Islem iptal ediliyor.\n Ana secim ekranina yonlendiriliyorsunuz...");
        return 0;

    }

    }






    public static void main(String[] args) {





        boolean logicContinuity = true;


        double Fluctuating = CurrencyFluctuation();
        double Currency_Euro_Alim  = 20.10 + Fluctuating ;
        double Currency_Euro_Satim = 19.10 + Fluctuating ;
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
               CurrentTime();
               System.out.println("itibariyle");
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
               if (Certainity() == 0)
               {
                   continue;
               }
               else {
                   Capital_Euro = Currency_Euro_Alim * temp_doviz;
                   Capital_TRY = Capital_TRY - (temp_doviz * Currency_Euro_Alim);
                   CurrentTime();
                   System.out.println("itibariyle");
               }
           }

           else if (selection==4)
           {
               System.out.println("Lutfen ne kadar doviz satmak istediginizi yaziniz...");
                double temp_doviz_sat = input.nextDouble();
               if (Certainity() == 0)
               {
                   continue;
               }
               else {
                   Capital_Euro = Currency_Euro_Satim * temp_doviz_sat;
                   Capital_TRY = Capital_TRY + (temp_doviz_sat * Currency_Euro_Satim);
                   CurrentTime();
                   System.out.println("itibariyle");
               }
           }
           else if (selection==5)
           {
               CurrentTime();
              Menu();

           }



           else if (selection==0)
           {
               CurrentTime();
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