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
import java.util.Observable;
import java.util.Observer;
public class Antena extends Observable implements Observer{
	private String mensagem;
	private boolean operacional;
	private int canal=1;
	
	public void transmiteOndasRadio(String mensagem){
		int i;
                //System.out.println(mensagem);
		StringBuilder x=new StringBuilder();
		for(i=0;i<mensagem.length();i++){
			x.append(Integer.toBinaryString(mensagem.charAt(i)));
			x.append(' ');
		}
		String s=x.toString();
		/*for(i=0;i<mensagem.length();i++){
			s+=(Integer.toBinaryString(mensagem.charAt(i)));
			s+=" ";
		}*/
		this.mensagem=s;
                EspacoSideral.getInstancia().setSinal(canal, s);
		//System.out.println(s);
                //mandar para o espaco
	}
	public void recebeOndasRadio(){
		String h=EspacoSideral.getInstancia().getSinal(canal);
                String x[];
		StringBuilder c= new StringBuilder();
		x=h.split(" ");
		for(int i=0;i<x.length;i++){
			c.append((char)Integer.parseInt(x[i],2));
		}
		//System.out.println(c);
                String a=c.toString();
                setMensagem(a);
                //mandar para o modulocomunicacao
	}
	public String getMensagem(){
		return mensagem;
	} 
	public void setMensagem(String mensagem){
		if(mensagem!=null){
                    this.mensagem=mensagem;
                    notifica();
                }
	}
        public void setCanal(int canal){
            if(canal>0){
                this.canal=canal;
            }
        }
        public int getCanal(){
            return canal;
        }
	public Antena(){
		EspacoSideral.getInstancia().addObserver(this);
	}
	@Override
	public void update(Observable o,Object arg){
            if(o==EspacoSideral.getInstancia()){
		this.recebeOndasRadio();
            }
	}
	public void notifica(){
		setChanged();
		notifyObservers();
	}
}


// Observer é quem observa
// Observable é quem é observado