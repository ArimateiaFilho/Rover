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

public class Planeta{
	private String nome;
	private int diametro;
	private ArrayList[][] objetos;
	private int gravidade;
	public Planeta(){
            objetos=new ArrayList[15][15];
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    objetos[i][j]=new ArrayList();
                }
            }
            natureza(15);
        }
	public Planeta(int tam){
            if(tam>0){
                objetos=new ArrayList[tam][tam];
                for (int i = 0; i < tam; i++) {
                    for (int j = 0; j < tam; j++) {
                        objetos[i][j]=new ArrayList();
                    }
                }
                natureza(tam);
            }else{
                objetos=new ArrayList[15][15];
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        objetos[i][j]=new ArrayList();
                    }
                }
                natureza(15);
            }
        }
        public Planeta(String nome,int tam){
            this(tam);
            setNome(nome);
        }
        public Planeta(String nome,int tam,int gra){
            this(nome,tam);
            setGravidade(gra);
        }
        public void setGravidade(int gra){
            if(gra>0){
                gravidade=gra;
            }else{
                gravidade=2;
            }
        }
        public int getGravidade(){
            return gravidade;
        }
        public String getNome(){
            return nome;
        }
	public Coordenada getObjeto(Object objeto){
            return locali(objeto);
        }
	public ArrayList getObjetos(Object objeto){
            ArrayList x=localizar(objeto);
            return x;
	}
	public void moverObjetos(Object objeto,int direcao){
            for (int i = 0; i <objetos.length ; i++) {
                for (int j = 0; j < objetos[i].length; j++) {
                    for (int k = 0; k < objetos[i][j].size(); k++) {
                        if(objetos[i][j].get(k)==objeto){
                            objetos[i][j].remove(k);
                            if(direcao==0){
                                if(i==0){
                                    objetos[objetos.length-1][j].add(objeto);
                                }else{
                                    objetos[i-1][j].add(objeto);
                                }
                            }
                            if(direcao==1){
                                if(j==objetos[i].length-1){
                                    objetos[i][0].add(objeto);
                                }else{
                                    objetos[i][j+1].add(objeto);
                                }
                            }
                            if(direcao==2){
                                if(i==objetos.length-1){
                                    objetos[0][j].add(objeto);
                                }else{
                                    objetos[i+1][j].add(objeto);
                                }
                            }
                            if(direcao==3){
                                if(j==0){
                                    objetos[i][objetos[0].length-1].add(objeto);
                                }else{
                                    objetos[i][j-1].add(objeto);
                                }
                            }
                        }
                    }
                }
            }
	}
	public void adicionaObjeto(Object objeto){
            if(objetos!=null){
                Random ra=new Random();
                objetos[ra.nextInt(objetos.length)][ra.nextInt(objetos.length)].add(objeto);
            }
	}
	public Object removeObjeto(Object objeto,int posicao){
            ArrayList y=null;
            Object x=null;
            if(objeto instanceof Rover){    
            }else{
                y=localizar(objeto);
                x=y.get(posicao-1);
                y.remove(posicao-1);

            }
            return x;
	}
        private Coordenada locali(Object objeto){
            Coordenada h=new Coordenada();
            for (int i = 0; i < objetos.length; i++) {
                for (int j = 0; j < objetos[0].length; j++) {
                    for (int k = 0; k < objetos[i][j].size(); k++){
                        if(objetos[i][j].get(k)==objeto){
                            h.x=i;
                            h.y=j;
                        }
                    }
                }
            }
            return h;
        }
	private ArrayList localizar(Object objeto){
            ArrayList x=null;
            for (int i = 0; i < objetos.length; i++) {
                for (int j = 0; j < objetos[0].length; j++) {
                    for (int k = 0; k < objetos[i][j].size(); k++){
                        if(objetos[i][j].get(k)==objeto){
                            x=objetos[i][j];
                        }
                    }
                }
            }
            return x;
        }
        private void natureza(int tam){
            for (int i = 0; i < tam*2; i++) {
                for (int j = 0; j < tam*2; j++) {
                    adicionaObjeto(new Rocha());
                    adicionaObjeto(new Bateria());
                }
                //adicionaObjeto(new Bateria());
            }
            
        }
        private void diametroPlaneta(){
            Random x= new Random();
            diametro=2*(objetos.length/6);
        }
        public int getTamanho(){
            return objetos.length;
        }
        public void setNome(String nome){
            if(nome!=null){
                this.nome=nome;
            }else{
                this.nome="kripton";
            }
        }
}