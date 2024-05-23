public class App {
    public static void main(String[] args) throws Exception {
        Mobil mobil = new Mobil();
        Bus bus = new Bus();

        mobil.setWarna("Kuning");
        mobil.setBanyak_pintu(4);
        mobil.setKecepatan(100);
        bus.setWarna("Biru");
        bus.setBanyak_pintu(5);
        bus.setKecepatan(50);

        bus.Maju();
        mobil.Maju();
    }
}

public interface InterfaceMaju {
    abstract void Maju();
}

public class Roda4 implements InterfaceMaju  {
    private String warna;
    private int banyak_pintu;
    private int kecepatan;

    public Roda4(){
    }

    @Override
    public void Maju() {
        // TODO Auto-generated method stub
        System.out.println("Kendaraan ini memiliki banyak pintu" + getBanyak_pintu() + "dan berwarna "  + getWarna());
        System.out.println("Kendaraan ini sedang berjalan maju dengan kecepatan " + getKecepatan() + " km/jam");
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getBanyak_pintu() {
        return banyak_pintu;
    }

    public void setBanyak_pintu(int banyak_pintu) {
        this.banyak_pintu = banyak_pintu;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }


}

public class Mobil extends Roda4 {

}

public class Bus extends Roda4 {

    
}
