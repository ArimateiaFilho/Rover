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

public class Bateria{
	private String nome;
	private int cargaMaxima, cargaAtual;
	public void descarregaBateria(int carga){
		if(carga >= 0 && carga <= cargaAtual){
			cargaAtual-=carga;
		}	
	}
	public void carregarBateria(int carga){
		if(carga>=0&&carga<=cargaMaxima-cargaAtual){
			cargaAtual+=carga;
		}else if(carga>cargaMaxima-cargaAtual){
			cargaAtual=cargaMaxima;
		}
	}
	public Bateria(){
		cargaMaxima = 100;
		cargaAtual = cargaMaxima;
	}
	public Bateria(int cargaMaxima){
		if(cargaMaxima>0){
			this.cargaMaxima=cargaMaxima;
			cargaAtual=this.cargaMaxima;
		}else{
                    this.cargaMaxima=100;
                    cargaAtual=this.cargaMaxima;
                }
	}
	public Bateria(String nome){
		this();
		if(nome!=null){
			this.nome = nome;
		}
	}
	public int getCargaAtual(){
		return cargaAtual;
	}
}