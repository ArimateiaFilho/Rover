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
public class DepositoAmostras{
	private Amostra amostras[];
	private int totalAmostras=0;
	private int finalFila=0;
	private int proxAmostra=0;
	
	public Amostra getAmostra(){
		Amostra y=null;
		if(totalAmostras>0){
			y=amostras[proxAmostra];
			amostras[proxAmostra]=null;
			proxAmostra++;
			proxAmostra=proxAmostra%amostras.length;
			totalAmostras--;
		}
		return y;
	}
	public void setAmostra(Amostra amostra){
		if(totalAmostras<amostras.length&&amostra!=null){
			amostras[finalFila]=amostra;
                        finalFila++;
			finalFila=finalFila%amostras.length;
			totalAmostras++;
                       // System.out.println("amostra setada");
		}
	}
        public DepositoAmostras(){
            amostras=new Amostra[5];
        }
        public DepositoAmostras(int tam){
            if(tam>0){
                amostras=new Amostra[tam];
            }else{
                amostras=new Amostra[5];
            }
        }
}
