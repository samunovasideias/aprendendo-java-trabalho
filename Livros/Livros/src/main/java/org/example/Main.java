package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Service servico=new Service();
        Scanner leia=new Scanner(System.in);
        int opcao=1;
        do{
            System.out.println("bem vindo ao sistema da  livraria voce deseja:\n");
            System.out.println("1.consultar livro por nome \n 2.incluir livro no catalogo \n 3.sair");
             opcao= Integer.parseInt(leia.nextLine());
             switch (opcao){

                 case 1:
                     System.out.println("digite o nome");
                     servico.livro.setNome(leia.nextLine());
                     System.out.println(servico.encontrarNome(servico.livro.getNome()));
                     break;

                 case 2:
                     System.out.println("digite o nome");
                     servico.livro.setNome(leia.nextLine());
                     System.out.println("digite o genero");
                     servico.livro.setGenero(leia.nextLine());
                     System.out.println("digite o autor");
                     servico.livro.setAutor(leia.nextLine());
                     servico.inserir(servico.livro);
                     break;

                 case 3:
                     break;

                 default:
                     System.out.println("opção invalida");
                     break;
             }
        }while(opcao!=3);


    }
}
