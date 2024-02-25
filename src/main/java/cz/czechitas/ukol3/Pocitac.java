package cz.czechitas.ukol3;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

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
            return "Pocitac ma: procesor " + cpu + ", pamet " + ram + ", disk " + pevnyDisk + " a je zapnuty.";
        } else {
            return "Pocitac ma: procesor " + cpu + ", pamet " + ram + ", disk " + pevnyDisk + " a neni zapnuty.";
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
            if (pevnyDisk.getVolneMisto() < velikost) {
                System.err.println("Nemohu zapsat soubor o velikosti " + velikost + ", protoze na disku pro nej neni misto.");
            } else {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
                pevnyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " zapsan na disk.");
            }
        }
    }


    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty()) {
            System.err.println("Pocitac neni zapnuty, nelze z nej mazat.");
        } else {
            if (pevnyDisk.getVyuziteMisto() > velikost) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
                pevnyDisk.setVolneMisto();
                System.out.println("Soubor o velikosti " + velikost + " smazan.");
            } else {
                System.err.println("Nelze smazat soubor vetsi, nez je vyuzite misto.");
            }
        }
    }
}