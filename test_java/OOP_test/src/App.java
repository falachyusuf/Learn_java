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
