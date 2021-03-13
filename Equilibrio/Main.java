import java.util.ArrayList;

/**
 * Classe main
 * 
 * Algoritmos e Estrutura de Dados      138
 * Professor: João Batista
 * @author Daniela Pereira Rigoli
 * @version 1.0
 * 
 */

public class Main {
    static BinaryTree tree = new BinaryTree();

    public static void main(String[] args) {
        leituraArquivo();
    }

    public static void leituraArquivo() {

        BinaryTree tree = new BinaryTree();
        tree.constructTree("../casos/teste5.txt");

        /*
        for(int i = 4; i < 14; i++){
            tree.constructTree("../casos/teste"+ i + ".txt");
            System.out.print("\nPara o teste "+ i + " foram achadas "+tree.getNumEquilibrado() +" maquinas em equilibrio");

        }*/ 

        
        ArrayList<String> test = tree.equilibrio();

        System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \nLISTA EM EQUILIBRIO\n");
        

        for(int i = 0; i < test.size(); i++) {   
            System.out.print(test.get(i));
        } 

        System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n\n");

        ArrayList<String> arvoreFinal = tree.positionsPos();

        for(int i = 0; i < arvoreFinal.size(); i++) {   
            System.out.print(arvoreFinal.get(i));
        } 


/**
 * 
caso11 = 97    (talvez)
caso12 = 133  (talvez também)
caso13 = 181  (pode ser mas eu não tenho certeza)
*/
        

    }
}