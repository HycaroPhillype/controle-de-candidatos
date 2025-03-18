package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo\n");
        imprimirSelecionados();

    }
    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("IMPRIMINDO A LISTA DE CANDIDATOS INFORMANDO O ÍNDICE DO ELEMENTO\n");

        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° "
            .concat(String.valueOf(indice+1))
            .concat(" é o ")
            .concat(candidatos[indice]));
        }

        System.out.println("\nFORMA ABREVIADA DA INTEREÇÃO FOR EACH\n");

        for(String candidato: candidatos) {
            System.out.println("O CANDIDATO SELECIONADO FOI: ".concat(candidato));
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato(a) "
            .concat(candidato)
            .concat(" Solicitou este valor de salário ")
            .concat(String.valueOf(salarioPretendido)));

            if(salarioBase >= salarioPretendido) {
                System.out.println("O Candidato(a) "
                .concat(candidato)
                .concat(" Foi selecionado(a) para vaga"));

                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO.");
        
        }else if(salarioPretendido == salarioBase){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");

        }
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}