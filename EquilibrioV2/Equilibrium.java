import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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
        public Node parent;
        public Node left;
        public Node right;
        private Integer work; // E = trabalho a ser executado ou divido
        private String name; //X0, X1

        public Node(String name, Integer work) {
            parent = null;
            left = null;
            right = null;
            this.name = name;
            this.work = work;
        }

        public String toString(){
            return "Name: " + name + "\nElement: " + work;
        }
    }

    
    // Atributos
    private int count; //contagem do número de nodos
    private Integer numEquilibrado;

    public int getNumEquilibrado(){
        if(numEquilibrado != null){
            return numEquilibrado;
        } else {
            ArrayList<String> aux = calcEquilibrio();
            return aux.size();
        }
    }

    public int getCount(){
        return count;
    }

    
    // Metodos
    public Equilibrium() {
        count = 0;
        numEquilibrado = null;
    }

    public void construct(String file){
        this.numEquilibrado = null;
        this.count = 0;
        File fileF = new File(file);
        Path filePath = Paths.get(file);
        
        // Pegar a quantidade de linhas para criar o array
        // Ler o arquivo
        try (LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(file))) {
            linhaLeitura.skip(fileF.length());
            int qtdLinha = linhaLeitura.getLineNumber();
            System.out.println(qtdLinha);

            BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset());
            String line = reader.readLine();

            

        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }


    /**
     * Usado para calcular o equilibrio
     * Cada nodo encontrado em equilibro armazena uma string no vetor
    */
    public ArrayList<String> calcEquilibrio() {
        ArrayList<String> res = new ArrayList<>();
        return res;
    }
}
