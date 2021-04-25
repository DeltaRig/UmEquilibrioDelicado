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

        Equilibrium blob = new Equilibrium();

        long tempoInicio;
        for(int i = 4; i <= 13; i++){
            tempoInicio = System.currentTimeMillis();
            blob.construct("../casos/teste"+ i + ".txt");
            System.out.print("\nPara o teste "+ i + " foram achadas "+blob.getNumEquilibrado() +" maquinas em equilibrio");

            //System.out.println("\nTempo Total: "+(System.currentTimeMillis()-tempoInicio) + " milisegundos");
        } 

        
        //blob.construct("../casos/teste4.txt");
        //blob.getArrayComplete();
        //System.out.print("Maquinas equilibradas: " + blob.getNumEquilibrado());
        //ArrayList<String> test = blob.calcEquilibrio();

        //System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \nLISTA EM EQUILIBRIO\n");
        

        //for(int i = 0; i < test.size(); i++) {   
        //    System.out.print(test.get(i));
        //} 

        //System.out.print("\n\n -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n\n");

        //System.out.print("\nPara o teste 6 foram achadas "+blob.getNumEquilibrado() +" maquinas em equilibrio");

        

    }
}