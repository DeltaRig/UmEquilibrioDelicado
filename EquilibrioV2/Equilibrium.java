import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Classe de arvore binaria de maquinas
 * 
 * Algoritmos e Estrutura de Dados      138
 * Professor: João Batista
 * @author Daniela Pereira Rigoli
 * @version 1.0
 * 
 */

public class Equilibrium {

    // Cada nodo representa uma maquina
    private static final class Node {
        public int left; // position
        public int right;
        private Integer work; // E = trabalho a ser executado ou divido

        public Node(Integer work, int left, int right) {
            this.work = work;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return "\nElement: " + work;
        }
    }

    public Equilibrium() {
        numEquilibrado = null;
    }

    // Atributos
    private Node[] nodos;
    private Integer numEquilibrado;

    public int getNumEquilibrado(){
        calcEquilibrio(0);
        return numEquilibrado;
    }

    public void getArrayComplete(){
        for(int i = 0; i < nodos.length; i++ ){

            System.out.println("Posição "+ i);
            if(nodos[i] != null){
                System.out.println(" filhoEsc " + nodos[i].left + " filhoDir " + nodos[i].right);
                System.out.println(" work " + nodos[i].work);
            }
        }
    }
    

    public void construct(String file){
        this.numEquilibrado = 0;
        File fileF = new File(file);
        Path filePath = Paths.get(file);
        
        // Pegar a quantidade de linhas para criar o array
        // Ler o arquivo
        try (LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(file))) {
            linhaLeitura.skip(fileF.length());
            int qtdLinha = linhaLeitura.getLineNumber();

            nodos = new Node[qtdLinha + 1];

            BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset());
            String line;
            String[] temporary;

            while ( true ) {

                line = reader.readLine();
                if ( line == null ) break;

                temporary = line.split(" ");

                int position = Integer.valueOf(temporary[0].substring(1));

                if(temporary[1].charAt(0) == 'X'){
                    int left = Integer.parseInt(temporary[1].substring(1));
                    int right = Integer.parseInt(temporary[2].substring(1));
                    
                    nodos[position] = new Node(null, left, right);
                } else {
                    int left = Integer.parseInt(temporary[1]);
                    int right = Integer.parseInt(temporary[2]);
                    if(left == right){
                        numEquilibrado++; // aqui começa a contagem das maquinas equilibradas
                    }
                    nodos[position] = new Node((left + right), -1, -1);
                }
            }
        

        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }


    /**
     * Usado para calcular o equilibrio
     * Cada nodo encontrado em equilibro armazena uma string no vetor
    */

    private int calcEquilibrio(int position) {
        if(nodos[position].left == -1){
            //if(nodos[position].right == -1){ // verificação separada para aceitar o teste x2
                return nodos[position].work;
            //}
        }

        if(nodos[position].work == null){
            int leftWork = calcEquilibrio(nodos[position].left);
            int rightWork = calcEquilibrio(nodos[position].right);
            nodos[position].work = leftWork + rightWork;

            //System.out.print("Na posição "+ position + " encontrei " + nodos[position].work + ", vindo de " leftWork + " e "+ rightWork);
            if(leftWork == rightWork){
                this.numEquilibrado++;
            }

        }
        return nodos[position].work;
    }

    /****
            if(n.work == null){
                n.left.work = calcEquilibrioAux(n.left, res, n.work);
                n.right.work = calcEquilibrioAux(n.right, res, n.work);

                n.work = n.left.work + n.right.work;
                if(n.left.work == n.right.work){
                    res.add("\nMaquina equilibrado: " + n.name + ", tem trabalho = " + n.work);
                }
                return n.work;
            }
        }
        return work;
    }
     */
}
