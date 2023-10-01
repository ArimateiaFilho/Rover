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

import java.util.Observer;
import java.util.Observable;
public class ModuloComunicacao extends Observable implements Observer{
	private String mensagemRecebida;
	private int gastoEnergetico=5;
	private Antena antena=new Antena();
	private String mensagemTransmitida;
       
	public String codificaMensagem(String mensagem){
		String mensagemcrip="";
                //System.out.println(mensagem);
		for(int i=0;i<mensagem.length();i++){
			int crip=mensagem.charAt(i);
			crip+=3;
			char letra=(char)crip;
			mensagemcrip+=letra;
		}
               // System.out.println(mensagemcrip);
		return mensagemcrip;
	}
	public String decodificaMensagem(String mensagem){
		String mensagemdescrip="";
		for(int i=0;i<mensagem.length();i++){
			int crip=mensagem.charAt(i);
			crip-=3;
			char letra=(char)crip;
			mensagemdescrip+=letra;
		}
               // System.out.println(mensagemdescrip);
		return mensagemdescrip;
	}
	public void transmiteMensagem(String mensagem){
		if(mensagem!=null){
			antena.transmiteOndasRadio(codificaMensagem(mensagem));
		}
	}
	public void recebeMensagem(){
		mensagemRecebida=decodificaMensagem(antena.getMensagem());
                if(mensagemRecebida.equals(mensagemTransmitida)){
                    //faz nada
                }else{
                    notifica();
                }
	}
       /* public ModuloComunicacao(Antena antena){
            if(antena!=null){
                this.antena=antena;
                antena.addObserver(this);
            }
        }*/
        public ModuloComunicacao(){
            antena.addObserver(this);
        }
	public int getGastoEnergetico(){
		return gastoEnergetico;
	}
        public void notifica(){
            //faltando
            setChanged();
            notifyObservers();
        }
        public int getCanal(){
            return antena.getCanal();
        }
        public void setCanal(int canal){
            if(canal>=0){
                antena.setCanal(canal);
            }
        }
        public void setMensagem(String mensagem){
        //    if(mensagem!=null){
     ///           this.mensagem=mensagem;
          //  }
        }
        public String getMensagem(){
            return mensagemRecebida;
        }
        @Override
	public void update(Observable o,Object arg){
		if(o==antena){
			this.recebeMensagem();
		}
	}
}