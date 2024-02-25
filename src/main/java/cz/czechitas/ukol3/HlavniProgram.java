package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.

        System.out.println("Program spuštěn.");

        // vytvoreni procesoru
        Procesor procesor1 = new Procesor();
        procesor1.setRychlost(2_800_000_000L);
        procesor1.setVyrobce("Intel");
        // test toString procesoru
        System.out.println(procesor1);

        // vytvoreni disku
        Disk disk1 = new Disk();
        disk1.setKapacita(475_000_000_000L);
        disk1.setVyuziteMisto(400_000_000_000L);
        // test toString disku
        System.out.println(disk1);

        // vytvoreni pameti
        Pamet pamet1 = new Pamet();
        pamet1.setKapacita(16_000_000_000L);
        // test toString pameti
        System.out.println(pamet1);

        // vytvoreni pocitace
        Pocitac pocitac1 = new Pocitac();
        // test zapnuti pocitace bez jednotlivych soucasti
        pocitac1.zapniSe();

        pocitac1.setCpu(procesor1);
        pocitac1.setRam(pamet1);
        pocitac1.setPevnyDisk(disk1);
        // test toString pocitace
        System.out.println(pocitac1);

        // zapnuti pocitace
        pocitac1.zapniSe();
        // test druheho zapnuti pocitace
        pocitac1.zapniSe();
        // vypnuti pocitace
        pocitac1.vypniSe();
        // test druheho vypnuti pocitace
        pocitac1.vypniSe();
    }
}