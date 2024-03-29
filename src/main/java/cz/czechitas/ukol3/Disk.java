package cz.czechitas.ukol3;

public class Disk {
    private long kapacita;
    private long vyuziteMisto;

    private long volneMisto;

    public long getVolneMisto() {
        return volneMisto;
    }

    public void setVolneMisto() {
        this.volneMisto = kapacita - vyuziteMisto;
    }

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    @Override
    public String toString() {
        return "Disk s kapacitou " + kapacita + " bajtu a vyuzitym mistem " + vyuziteMisto + " bajtu";
    }
}
