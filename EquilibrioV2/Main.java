import java.util.ArrayList;

/**
 * Classe main

 * @author Daniela Pereira Rigoli
 * @version 1.03
 * @note
 * Algoritmos e Estrutura de Dados     | 138 |
 * Professor: João Batista
 */

public class Main {
    static Equilibrium blob = new Equilibrium();

    public static void main(String[] args) {
        leituraArquivo();
    }

    public static void leituraArquivo() {

        Equilibrium tree = new Equilibrium();

        
        for(int i = 4; i < 14; i++){
            tree.construct("../casos/teste"+ i + ".txt");
            //System.out.print("\nPara o teste "+ i + " foram achadas "+tree.getNumEquilibrado() +" maquinas em equilibrio");

        } 

        
        //tree.construct("../casos/teste6.txt");
        //ArrayList<String> test = tree.calcEquilibrio();

        //System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \nLISTA EM EQUILIBRIO\n");
        

        //for(int i = 0; i < test.size(); i++) {   
        //    System.out.print(test.get(i));
        //} 

        //System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n\n");

        //System.out.print("\nPara o teste 6 foram achadas "+tree.getNumEquilibrado() +" maquinas em equilibrio");

        

    }
}