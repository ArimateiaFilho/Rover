/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rover;

/**
 *
 * @author filho
 */
import java.util.*;
public class View implements Observer1{
    private Modelo modelo;
    private Controler controle;
    public void updatee(){
        ArrayList x=modelo.getMensagem();
        System.out.println("Relatorio {");
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
        System.out.println("}");
    }
    public View(Modelo m){
        modelo=m;
        controle=new Controler(m,this);
        modelo.registraObserver(this);
        criarPlaneta();
    }
    public void criarPlaneta(){
        Scanner sc=new Scanner(System.in);
        int i=0,z=0;
        String nome=null;
        int tam=0,gra=0;
        while(i!=4){
            System.out.println("[1] Nome do planeta");
            System.out.println("[2] Tamanho do planeta");
            System.out.println("[3] Gravidade");
            System.out.println("[4] Terminar");
            z=sc.nextInt();
            if(z==1){
                select(z);
                sc.nextLine();
                nome=sc.nextLine();;
            }
            if(z==2){
                select(z);
                sc.nextLine();
                tam=sc.nextInt();
            }
            if(z==3){
                select(z);
                sc.nextLine();
                gra=sc.nextInt();
            }
            if(z==4){
                i=4;
            }
        }
        controle.funcaoPlaneta(nome, tam, gra);
    }
    
    public void criarRover(){
        Scanner sc=new Scanner(System.in);
        int i=0,z=0;
        String nome=null;
        int nivel=0,tam=0,peso=0,abertura=0;
        while(i!=6){
            System.out.println("[1] Nome do rover");
            System.out.println("[2] Nivel de bateria");
            System.out.println("[3] Tamanho do deposito");
            System.out.println("[4] Peso maximo do braço mecanico");
            System.out.println("[5] Abertura maxima");
            System.out.println("[6] Terminar");
            z=sc.nextInt();
            if(z==1){
                select(z+3);
                sc.nextLine();
                nome=sc.nextLine();;
            }
            if(z==2){
                select(z+3);
                sc.nextLine();
                nivel=sc.nextInt();
            }
            if(z==3){
                select(z+3);
                sc.nextLine();
                tam=sc.nextInt();
            }
            if(z==4){
                select(z+3);
                sc.nextLine();
                peso=sc.nextInt();
            }
            if(z==5){
                select(z+3);
                sc.nextLine();
                abertura=sc.nextInt();
            }
            if(z==6){
                i=6;
            }
        }
        controle.funcaoRover(nome, nivel, tam, peso, abertura);
    }
    public void exibe2(){
        
    }
    public void erro(){
        System.out.println("item invalido");
    }
    public void select(int num){
        switch(num){
            case 1:
                System.out.println("Nome Planeta");
            break;
            case 2:
                System.out.println("Tamanho Planeta");
            break;
            case 3:
                System.out.println("Gravidade");
            break;
            case 4:
                System.out.println("Nome Rover");
            break;
            case 5:
                System.out.println("Nivel bateria");
            break;
            case 6:
                System.out.println("Tamanho deposito");
            break;
            case 7:
                System.out.println("Peso maximo braco");
            break;
            case 8:
                System.out.println("Abertura");
            break;
        }
    }
    public void incompleto(){
        System.out.println("Falta alguma coisa");
    }
    public void exe(){
        int i=234;
        Scanner sc=new Scanner(System.in);
        while(i!=4){
            System.out.println("[1] ligar Rover");
            System.out.println("[2] Desligar Rover");
            System.out.println("[3] Relatorio");
            System.out.println("[4] Dados");
            System.out.println("[5] Mandar Comando");
            System.out.println("[0] Terminar");
            int z=sc.nextInt();
            controle.exe(z);
            if(z==0){
                i=4;
            }
        }
    }
    public void dados(){
        System.out.println("Nome Rover "+modelo.getNome());
        System.out.println("Bateria "+modelo.getBateria()+"%");
        System.out.println("Nome Planeta "+modelo.getNomePlaneta());
        System.out.println(modelo.getCoordenada());
    }
    public void exeComando(){
        System.out.println("Insira o Comando");
    }
}
