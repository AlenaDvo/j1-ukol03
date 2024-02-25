package cz.czechitas.ukol3;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    private Disk druhyDisk;

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    @Override
    public String toString() {
        if (this.jeZapnuty) {
            return "Pocitac ma: " + cpu + ", " + ram + ", " + pevnyDisk + ", druhy " + druhyDisk + " a je zapnuty.";
        } else {
            return "Pocitac ma: " + cpu + ", " + ram + ", " + pevnyDisk + ", druhy " + druhyDisk + " a neni zapnuty.";
        }
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (cpu == null) {
            System.err.println("Pocitac nelze zapnout, nema zadny procesor.");
            return;
        } else if (ram == null) {
            System.err.println("Pocitac nelze zapnout, nema zadnou pamet.");
            return;
        } else if (pevnyDisk == null) {
            System.err.println("Pocitac nelze zapnout, nema zadny disk.");
            return;
        } else if (jeZapnuty) {
            System.err.println("Pocitac uz je zapnuty, nelze jej zapnout znovu.");
            return;
        } else {
            jeZapnuty = true;
            System.out.println("Pocitac byl zapnut.");
        }
    }

    public void vypniSe() {
        if (!jeZapnuty()) {
            return;
        } else {
            jeZapnuty = false;
            System.out.println("Pocitac byl vypnut.");
        }
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty()) {
            System.err.println("Pocitac neni zapnuty, nelze na nej zapisovat.");
        } else {
            // je misto na prvnim disku
            if (pevnyDisk.getVolneMisto() > velikost) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
                pevnyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " zapsan na pevny " + pevnyDisk + ".");
            // je misto na druhem disku
            } else if (druhyDisk.getVolneMisto() > velikost) {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() + velikost);
                druhyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " zapsan na druhy " + druhyDisk + ".");
            // neni misto nikde
            } else {
                System.err.println("Nemohu zapsat soubor o velikosti " + velikost + ", protoze na ani jednom disku pro nej neni misto.");
            }
        }
    }


    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty()) {
            System.err.println("Pocitac neni zapnuty, nelze z nej mazat.");
        } else {
            // smazeme z prvniho disku
            if (pevnyDisk.getVyuziteMisto() > velikost) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
                pevnyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " smazan z pevneho disku: " + pevnyDisk +".");
            // smazeme z druheho disku
            } else if (druhyDisk.getVyuziteMisto() > velikost) {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
                druhyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " smazan z druheho disku: " + druhyDisk + ".");
            // nelze smazat odnikud
            } else {
                System.err.println("Nelze smazat soubor vetsi, nez je vyuzite misto ani na jednom disku.");
            }
        }
    }
}