/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rover;

import java.util.Observable;
import java.util.HashMap;
public class EspacoSideral extends Observable{
	private static HashMap <Integer,String> sinais=new HashMap<>();
	private static EspacoSideral instancia= new EspacoSideral();
	
        public void setSinal(int canal,String sinal){
		sinais.put(canal,sinal);
                notifica();
	}
	public static EspacoSideral getInstancia(){
		return instancia;
	}
	public void notifica(){
            setChanged();
            notifyObservers();
	}
	public String getSinal(int canal){
            //sinais na posicao canal e retorna aquela String
            String x=sinais.get(canal);
            return x;
	}
	private EspacoSideral(){
		
	}
}



