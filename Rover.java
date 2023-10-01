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
import java.util.Random;
import java.util.Observable;
import java.util.Observer;
import java.util.*;
public class Rover implements Observer,Runnable{
	private Bateria bateria;
        private ModuloComunicacao moduloComunicacao=new ModuloComunicacao();
	private Coordenada eixo=new Coordenada();
	private int direcao=0;
	private String nome;
        private DepositoAmostras deposito;
	private ModuloAnalises analise;
	private Planeta planeta;
	private BracoMecanico braco;
	private char mapa[][];//adicionar 'A' se achar agua
        //adicionar 'B' se achar bateira
        //se tiver os 2 coloca 'X'
        private boolean ld=false;
	Thread thread=new Thread(this);
	private int inicio=0;
	
	//metodos
        public void ligaRover(){
            //thread
            ld=true;
            if(inicio==0){
                inicio++;
                thread.start();
            }
        }
        public void desligaRover(){
            //desligar thread
            ld=false;
        }
        
        public void executaComando(){
            String re=moduloComunicacao.getMensagem();
            String rer[]=re.split(":");
            if(rer[0].equals("go")){
                ld=false;
                int x,y;
                x=Integer.parseInt(rer[1], 10);
                y=Integer.parseInt(rer[2], 10);
                if(eixo.x<x){
                    direcao=1;
                    while(eixo.x<x){
                        moveFrente();
                        analisaArea();
                    }
                }
                if(eixo.x>x){
                    direcao=3;
                    while(eixo.x>x){
                        moveFrente();
                        analisaArea();
                    }
                }
                if(eixo.y>y){
                    direcao=2;
                    while(eixo.y>y){
                        moveFrente();
                        analisaArea();
                    }
                }
                if(eixo.y<y){
                    direcao=0;
                    while(eixo.y<y){
                        moveFrente();
                        analisaArea();
                    }
                }
                ld=true;
            }
        }
        
        public void transmiteMensagem(String mensagem){
            this.moduloComunicacao.transmiteMensagem(mensagem);
        }
        private void carregarBateria(int valor){
            bateria.carregarBateria(valor);
        }
        public void analisaArea(){
            //procura bateira
            //quero pegar rocha?
            //quero analizar?
            Random ra=new Random();
            if(bateria.getCargaAtual()>0){
                int x=ra.nextInt(5);
                ArrayList ara=planeta.getObjetos(this);
                for (int i = 0; i < ara.size(); i++) {
                    if(ara.get(i) instanceof Bateria){
                        mapa[eixo.x][eixo.y]='B';
                       // System.out.println(eixo.x+" "+eixo.y);
                    }
                }
                int h=0;
                Rocha ro=null;
                //System.out.println(x);
                if(x==0||x==1||x==2){
                    for (int i = 0; i < ara.size(); i++) {
                        if(ara.get(i) instanceof Rocha){
                            ro=braco.pegaRocha(i);
                            break;
                        }
                    }
                    guardaAmostra(constroiAmostra(ro));
                }
                if(x==1||x==2){
                    boolean re=analise.analisaAmostra();
                    if(re){
                        moduloComunicacao.transmiteMensagem("Achei água na posiçao ("+eixo.x+","+eixo.y+")");
                       // System.out.println("asdasdads");
                        if(mapa[eixo.x][eixo.y]=='B'){
                            mapa[eixo.x][eixo.y]='X';
                        }else{
                            mapa[eixo.x][eixo.y]='A';
                        }
                    }
                }
            }
        }
        public Rocha pegaRocha(int posicao){ 
            if(bateria.getCargaAtual()>0){
                return braco.pegaRocha(posicao);
            }else{
                return null;
            }
            
        }
        public Amostra constroiAmostra(Rocha r){
            Amostra x;
            if(r!=null){
                x= new Amostra(eixo,r);
            }else{
                x=null;
            }
            return x;
        }
        public void guardaAmostra(Amostra a){
            if(a!=null){
                deposito.setAmostra(a);
            }
        }
        public Object pegaItem(int pos){
            //pega a bateria
            Bateria y=null;
            if(pos!=-1){
                ArrayList x=planeta.getObjetos(this);
                y=(Bateria)x.remove(pos);
            }
            return y;
        }
	public String getDirecao(){
            String x="Norte";
            if(direcao==0){
		x="Norte";	
            }
            if(direcao==1){
                x="Leste";
            }
            if(direcao==2){
                x="Sul";
            }
            if(direcao==3){
                x="Oeste";
            }
            return x;
	}
	public int getEixoX(){
		return eixo.x;
	}
	public int getEixoY(){
		return eixo.y;
	}
        public Coordenada getEixo(){
            return eixo;
        }
	public void setNome(String nome){
		if(nome!=null){
			this.nome=nome;
		}else{
                    this.nome="kuririm";
                }
	}
	public String getNome(){
		return nome;
	}
	public String getCoordenada(){
		return (eixo.x+" em x e "+eixo.y+" em y ");
	}
	public int getNivelBateria(){
		return bateria.getCargaAtual();
	}
	public void dobraDireita(){
		direcao++;
		direcao=direcao%4;
	}
	public void dobraEsquerda(){
		if(direcao==0){
			direcao=3;
		}else{
			direcao--;
		}
	}
	public void moveFrente(){
            int valor=1;
            switch(direcao){
                    case 0:
                            if(valor>bateria.getCargaAtual()){
                                    valor=bateria.getCargaAtual();
                            }
                            bateria.descarregaBateria(valor);
                            for(int i=0;i<valor;i++){
                                planeta.moverObjetos(this, direcao);
                                eixo.y++;
                                if(eixo.y==planeta.getTamanho()){
                                    eixo.y=0;
                                }
                            }
                    break;
                    case 1:
                            if(valor>bateria.getCargaAtual()){
                                    valor=bateria.getCargaAtual();
                            }
                            bateria.descarregaBateria(valor);
                            for(int i=0;i<valor;i++){
                                planeta.moverObjetos(this, direcao);
                                eixo.x++;
                                if(eixo.x==planeta.getTamanho()){
                                    eixo.x=0;
                                }
                            }
                    break;
                    case 2:
                            if(valor>bateria.getCargaAtual()){
                                    valor=bateria.getCargaAtual();
                            }
                            bateria.descarregaBateria(valor);
                            for(int i=0;i<valor;i++){
                                planeta.moverObjetos(this, direcao);
                                eixo.y--;
                                if(eixo.y<0){
                                    eixo.y=planeta.getTamanho()-1;
                                }
                            }
                    break;
                    case 3:
                            if(valor>bateria.getCargaAtual()){
                                    valor=bateria.getCargaAtual();
                            }
                            bateria.descarregaBateria(valor);                
                            for(int i=0;i<valor;i++){
                                planeta.moverObjetos(this, direcao);
                                eixo.x--;
                                if(eixo.x<0){
                                    eixo.x=planeta.getTamanho()-1;
                                }
                            }
                    break;
            }
                //analiza area();   SEMPRE
	}
        //Construir Rover
	public Rover(){
            moduloComunicacao.addObserver(this);
	}
        public Rover(Planeta planeta){
            this();
            if(planeta!=null){
                mapa=new char[planeta.getTamanho()][planeta.getTamanho()];
                this.planeta=planeta;
                this.planeta.adicionaObjeto(this);
                Coordenada h=planeta.getObjeto(this);
                eixo.x=h.x;
                eixo.y=h.y;
            }
        }
        public Rover(Planeta planeta,String nome,int bateria,int deposito,int peso,int abertura){
            this(planeta);
            setNome(nome);
            this.bateria=new Bateria(bateria);
            this.deposito=new DepositoAmostras(deposito);
            this.braco=new BracoMecanico(peso,abertura,this);
            analise=new ModuloAnalises(this.deposito);
        }
        @Override
        public void update(Observable o, Object arg) {
            if(o==moduloComunicacao){
                executaComando();
            }
        }

        @Override
        public void run(){
            do{
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    
                }
                if(bateria.getCargaAtual()>10){
                    Random ra=new Random();
                    int x=ra.nextInt(4);
                    if(x==0){
                        moveFrente();
                        analisaArea();
                    }
                    if(x==1){
                        moveFrente();
                        analisaArea();
                    }
                    if(x==2){
                        dobraDireita();
                    }
                    if(x==3){
                        dobraEsquerda();
                    }
                }else if(bateria.getCargaAtual()<=10&&bateria.getCargaAtual()>0){
                    int x=eixo.x,y=eixo.y;
                    int mex=52000,mey=52000;
                    int vx=0,vy=0;
                    for (int i = 0; i < mapa.length; i++) {
                        for (int j = 0; j < mapa[0].length; j++) {
                            if(mapa[i][j]=='B'||mapa[i][j]=='X'){
                                int a=x-i,b=y-j;
                                a=(int)Math.sqrt(Math.pow(a, 2));
                                b=(int)Math.sqrt(Math.pow(b, 2));
                                if(a<=mex||b<=mey){
                                    mex=a;
                                    mey=b;
                                    vx=i;
                                    vy=j;
                                }
                                if(mapa[i][j]=='B'){
                                    mapa[i][j]=' ';
                                }else{
                                    mapa[i][j]='A';
                                }
                            }
                        }
                    }
                    mex=vx-x;
                    mey=vy-y;
                    while(mex<0){
                        direcao=3;
                        mex++;
                        moveFrente();
                    }
                    while(mex>0){
                        direcao=1;
                        mex--;
                        moveFrente();
                    }
                    while(mey<0){
                        direcao=0;
                        mey++;
                        moveFrente();
                    }
                    while(mey>0){
                        direcao=2;
                        mey--;
                        moveFrente();
                    }
                    ArrayList arra=planeta.getObjetos(this);
                    int num=-1;
                    for (int i = 0; i < arra.size(); i++) {
                        if(arra.get(i) instanceof Bateria){
                            num=i;
                            break;
                        }
                    }
                    Bateria bat=(Bateria)pegaItem(num);
                    if(bat!=null){
                        moduloComunicacao.transmiteMensagem("Troca de bateria posição ("+eixo.x+","+eixo.y+")");
                        bateria=bat;// System.out.println("trocando bateria");
                    }   
                }
                if(bateria.getCargaAtual()==0){
                    ld=false;
                }
            }while(ld);
            thread.stop();
        }
        public Planeta getPlaneta(){
            return planeta;
        }
}