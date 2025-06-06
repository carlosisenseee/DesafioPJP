import java.util.Random;

public class Mapa {
    private int linhas = 8;
    private int colunas = 8;
    String[][] mapa = new String[linhas][colunas];
    String[][] mapaOculto = new String[linhas][colunas];
    Random gerador = new Random();

    public void criaElementos(int tesouros, int bombas) {
        for (int i = 0; i < tesouros; i++) {
            int[] tesourosLinhas = new int[tesouros];
            int[] tesourosColunas = new int[tesouros];
            int linha = gerador.nextInt(tesouros);
            int coluna = gerador.nextInt(tesouros);
            tesourosLinhas[i] = linha;
            tesourosColunas[i] = coluna;
            System.out.println(linha + " " + coluna);

            for (int j = 0; j < i; j++) {
                if (tesourosLinhas[j] == linha) {
                    if (tesourosColunas[j] == coluna) {
                        System.out.println("Ja apareceu");
                    }
                }
            }

            mapaOculto[linha][coluna] = " T ";
        }
        for (int i = 0; i < bombas; i++) {
            System.out.println("NAAAAAAAAAAAA");
        }
    }

    public void preencherMapa() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (mapa[i][j] == null) {
                    mapa[i][j] = " ~ ";
                }
            }
        }
    }

    public void mostrarMapa() {
        System.out.print("   0  1  2  3  4  5  6  7\n");
        for (int i = 0; i < linhas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }

    public void mostrarMapaOculto() {
        System.out.print("   0  1  2  3  4  5  6  7\n");
        for (int i = 0; i < linhas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(mapaOculto[i][j]);
            }
            System.out.println();
        }
    }
}
