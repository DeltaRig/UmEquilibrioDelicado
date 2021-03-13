import java.io.BufferedReader;
import java.io.IOException;
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

public class BinaryTree {

    // Cada nodo representa uma maquina
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        private Integer work; // E = trabalho a ser executado ou divido
        private String name; //X0, X1

        public Node(String name, Integer work) {
            father = null;
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
    private Node root; //referência para o nodo raiz
    private Integer numEquilibrado;

    public int getNumEquilibrado(){
        if(numEquilibrado != null){
            return numEquilibrado;
        } else {
            ArrayList<String> aux = equilibrio();
            return aux.size();
        }
    }

    
    // Metodos
    public BinaryTree() {
        count = 0;
        root = null;
        numEquilibrado = null;
    }

    public void constructTree(String file){

        Path filePath = Paths.get(file);
        //System.out.println(filePath);

        // Ler o arquivo
        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            
             // Adicionar a raiz é diferente
            String[] temporary = line.split(" ");
            addRoot(temporary[0]);
            addLeft(temporary[1], null, root.name);
            addRight(temporary[2], null, root.name);

            line = reader.readLine();        

            while (line != null) {
                temporary = line.split(" ");
                if(temporary[1].charAt(0) == 'X'){
                    addLeft(temporary[1], null, temporary[0]);
                    addRight(temporary[2], null, temporary[0]);
                } else {
                    addLeft(null, Integer.valueOf(temporary[1]), temporary[0]);
                    addRight(null, Integer.valueOf(temporary[2]), temporary[0]);
                }

                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.err.format("Erro na leitura do arquivo: ", e);
            }
    }


    // considerei que sempre tem que começar por uma maquina
    private void addRoot(String name) {
        root = new Node(name, null);
        count++;
    }

    private void addLeft(String name, Integer element, String nomePai) {
        Node aux = searchNodeRefForName(nomePai, root);
        if (aux==null) // se nao encontrou elemPai na arvore
            return;
        if (aux.left != null) // se ja tem filho a esquerda
            return;
        
        // Se encontrou elemPai e ele nao tem filho a esquerda
        // insere element como filho a esquerda de elemPai
        Node n = new Node(name, element);
        n.father = aux;
        aux.left = n;
        count++;
    }

    private void addRight(String name, Integer element, String nomePai) {
        Node aux = searchNodeRefForName(nomePai, root);
        if (aux==null) // se nao encontrou elemPai na arvore
            return;
        if (aux.right != null) // se ja tem filho a direita
            return;
        
        // Se encontrou elemPai e ele nao tem filho a direita
        // insere element como filho a direita de elemPai
        Node n = new Node(name, element);
        n.father = aux;
        aux.right = n;
        count++;
    }


    private Node searchNodeRefForName(String name, Node target) {
        if (target == null)
            return null;
        if (target.name == null){
            return null;
        }
        //Pre: raiz, esq, dir
        if (target.name.equals(name)) { // visita a raiz
            return target;
        }
        Node aux = searchNodeRefForName(name, target.left); // visita esq
        if (aux == null) {
            aux = searchNodeRefForName(name, target.right); // visita dir
        }
        return aux;
    }




    /**
     * Usado para verificar se estava formando a árvore corretamente
     * @return uma lista com todos os elementos da arvore na ordem do 
     * caminhamento pos-fixado.
    */
    public ArrayList<String> positionsPos() {
        ArrayList<String> res = new ArrayList<>();
        positionsPosAux(root, res);
        return res;
    }
    private void positionsPosAux(Node n, ArrayList<String> res) {
        if(n != null){
            positionsPosAux(n.left, res);
            positionsPosAux(n.right, res);
            res.add("Nodo: " + n.name + "\nElemento: " + n.work + 
            "\nPai: " + n.father + "\nFilho da esquerda: " + n.left +
            "\nFilho da direita: " + n.right +
            "\n----------------------------\n\n");
        }
    }
  
    /**
     * Usado para calcular o equilibrio
     * Cada nodo encontrado em equilibro armazena uma string no vetor
    */
    public ArrayList<String> equilibrio() {
        ArrayList<String> res = new ArrayList<>();
        equilibrioAux(root, res, root.work);
        return res;
    }
    private Integer equilibrioAux(Node n, ArrayList<String> res, Integer work) {
        if(n != null){
            if(n.left == null)
                return n.work;
            
            if(n.work == null){
                if(n.left.work == null){
                    n.left.work = equilibrioAux(n.left, res, n.work);
                }
                if(n.right.work == null){
                    n.right.work = equilibrioAux(n.right, res, n.work);
                }

                n.work = n.left.work + n.right.work;
                if(n.left.work == n.right.work){
                    res.add("\nMaquina equilibrado: " + n.name + ", tem trabalho = " + n.work);
                }
                return n.work;
            }

            System.out.print("Nodo: " + n.name + "\nElemento: " + n.work + 
            "\nPai: " + n.father + "\nFilho da esquerda: " + n.left +
            "\nFilho da direita: " + n.right +
            "\n----------------------------\n\n");
        }
        return work;
    }

}
