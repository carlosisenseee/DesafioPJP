public class Main {
    static Mapa mapa  = new Mapa();
    public static void main(String[] args) {
        mapa.preencherMapa();

        mapa.mostrarMapa();

        mapa.criaElementos(8, 5);

        mapa.mostrarMapaOculto();
    }
}