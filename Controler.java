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
public class Controler {
    private Modelo modelo;
    private View view;
    
    public Controler(Modelo m,View v){
        modelo=m;
        view=v;
    }
    public void funcaoPlaneta(String nome,int tam,int gravidade){
        modelo.setPlaneta(nome, tam, tam);
        view.criarRover();
    }
    /*public void funcaoPlaneta(int num){
        Scanner sc=new Scanner(System.in);
        String nome=null;
        int tam=15,re=0,r=0,gra=1,rr=0;
        switch(num){
            case 1:
                view.select(num);
                nome=sc.nextLine();
                re=1;
            break;
            case 2:
                view.select(num);
                tam=sc.nextInt();
                if(tam>=15&&tam<=200){
                    
                }else{
                    tam=15;
                }
                r=2;
            break;
            case 3:
                view.select(num);
                gra=sc.nextInt();
                if(gra<0){
                    gra=1;
                }
                rr=3;
            default :
                view.erro();
            break;
        }
        if(re==1&&r==2&&rr==3){
            modelo.setPlaneta(nome,tam,gra);
            view.criarRover();
        }else{
            view.incompleto();
        }
        
    }*/
    /*public void funcaoRover(int num){
        Scanner sc=new Scanner(System.in);
        String nome=null;
        int r[]=new int[5];
        int bateria=0,peso=0,abertura=0,deposito=0;
        switch(num){
            case 1:
                view.select(num+2);
                nome=sc.nextLine();
                r[0]=1;
            break;
            case 2:
                view.select(num+2);
                bateria=sc.nextInt();
                r[1]=1;
            break;
            case 3:
                view.select(num+2);
                deposito=sc.nextInt();
                r[2]=1;
            break;
            case 4:
                view.select(num+2);
                peso=sc.nextInt();
                r[3]=1;
            break;
            case 5:
                view.select(num+2);
                abertura=sc.nextInt();
                r[4]=1;
            break;
            default:
                view.erro();
            break;
        }
        int re=0;
        for (int i = 0; i < r.length; i++) {
            if(r[i]==1){
                re++;
            }
        }
        if(re==5){
            if(bateria<100||bateria>1000){
                bateria=100;
            }
            if(deposito<3||deposito>10){
                deposito=5;
            }
            if(peso<300||peso>99999){
                peso=1000;
            }
            if(abertura<20||abertura>300){
                abertura=60;
            }
            modelo.setRover(nome, bateria, deposito, peso, abertura);
        }else{
            view.incompleto();
        }
    }*/
    public void funcaoRover(String nome,int bateria,int deposito,int peso,int abertura){
        modelo.setRover(nome, bateria, deposito, peso, abertura);
        view.exe();
    }
    public void exe(int num){
        Scanner sc=new Scanner(System.in);
        switch(num){
            case 1:
                modelo.ligaRover();
            break;
            case 2:
                modelo.desligaRover();
            break;
            case 3:
                view.updatee();
            break;
            case 4:
                view.dados();
            break;
            case 5:
                view.exeComando();
                modelo.execultaComando(sc.nextLine());
            break;
        }
    }
}
