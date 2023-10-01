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
public class Rocha{
        private int diametro;
	private Substancia substancias[];
	public int getMassaTotal(){
		int t=0;
		for(int i=0;i<substancias.length;i++){
			t+=substancias[i].getMassa();
		}
		return t;
	}
	public Substancia[] getSubistancia(){
		return substancias;
	}
        public int getDiametro(){
            return diametro;
        }
	public Rocha(){
		Random gerar = new Random();
                int x=gerar.nextInt(10)+1;
		substancias=new Substancia[x];
		for(int i=0;i<substancias.length;i++){
			substancias[i]=new Substancia();
		}
                diametro=gerar.nextInt(100)+1;
	}
	//metodo pra testes
	public void printRocha(){
		for(int i=0;i<substancias.length;i++){
			System.out.println(substancias[i].getNome());
		}
	}
}