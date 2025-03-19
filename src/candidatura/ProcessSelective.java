package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.print.DocFlavor.STRING;

public class ProcessSelective {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo\n");

        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for(String candidato: candidates){
            enteringContact(candidato);
        };
    }

    static void enteringContact(String candidate){
        int attemptsCarriedOut = 1;
        boolean keepTryng = true;
        boolean answered = false;

        do {
            answered = call();
            keepTryng = !answered;

            if(keepTryng) {
                attemptsCarriedOut++;
            }else
                System.out.println("\nCONTATO REALIZADO COM SUCESSO\n");

        }while(keepTryng && attemptsCarriedOut < 3); 
            if(answered) {
                System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO "
                .concat(candidate)
                .concat(" NA ")
                .concat(String.valueOf(attemptsCarriedOut))
                .concat(" TENTATIVA"));
            }else
                System.out.println("\nNÃO CONSEGUIMOS CONTATO COM O "
                .concat(candidate)
                .concat(" NÚMERO MAXIMO DE TENTATIVAS ")
                .concat(String.valueOf(attemptsCarriedOut)).concat("\n"));


    }

    static  boolean call() {
        return new Random().nextInt(3)==1;
    }
    
    static void printSelected() {
        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("IMPRIMINDO A LISTA DE CANDIDATOS INFORMANDO O ÍNDICE DO ELEMENTO\n");

        for(int indice=0; indice < candidates.length; indice++) {
            System.out.println("O candidato de n° "
            .concat(String.valueOf(indice+1))
            .concat(" é o ")
            .concat(candidates[indice]));
        };

        // System.out.println("\nFORMA ABREVIADA DA INTEREÇÃO FOR EACH\n");

        for(String candidate: candidates) {
            System.out.println("O CANDIDATO SELECIONADO FOI: ".concat(candidate));
        }
    }

    static void selectCandidates() {
        String [] candidates = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        
        int candidatesSelected = 0;
        int candidateCurrent = 0;
        double wageBase = 2000.0;

        while (candidatesSelected < 5 && candidateCurrent < candidates.length){
            String candidate = candidates[candidateCurrent];
            double wageIntended = valueIntended();

            System.out.println("O candidato(a) "
            .concat(candidate)
            .concat(" Solicitou este valor de salário ")
            .concat(String.valueOf(wageIntended)));

            if(wageBase >= wageIntended) {
                System.out.println("O Candidato(a) "
                .concat(candidate)
                .concat(" Foi selecionado(a) para vaga"));

                candidatesSelected++;
            }
            candidateCurrent++;
        }
    }
    static double valueIntended() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analyzeCandidate(double wageIntended){
        double wageBase = 2000.0;
        if(wageBase > wageIntended) {
            System.out.println("LIGAR PARA O CANDIDATO.");
        
        }else if(wageIntended == wageBase){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");

        }
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}