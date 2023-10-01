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
public class Substancia{
	private String nome;
	private String formula;
	private int massa;
	public int getMassa(){
		return massa;
	}
	public String getNome(){
		return nome;
	}
	public String getFormula(){
		return formula;
	}
	public Substancia(){
                Random gerar = new Random();
		int x=gerar.nextInt(20)+1;
		switch (x){
			case 1:
				this.nome="Agua";
				this.formula="H2O";
				break;
			case 2:
				this.nome="Acido sulfurico";
				this.formula="H2SO4";
				break;
			case 3:
				this.nome="Peroxido de hidrogenio";
				this.formula="H2O2";
				break;
			case 4:
				this.nome="Dioxido de nitrogenio";
				this.formula="NO2";
				break;
			case 5:
				this.nome="Acucar";
				this.formula="C12H22O11";
				break;
			case 6:
				this.nome="Bicarbonato de sodio";
				this.formula="NaHCO3";
				break;
			case 7:
				this.nome="Acido cloridrico";
				this.formula="HCl";
				break;
			case 8:
				this.nome="Sulfeto de hidrogenio";
				this.formula="H2S";
				break;
			case 9:
				this.nome="Hidroxido de sodio";
				this.formula="NaOH";
				break;
			case 10:
				this.nome="Oxido de ferro";
				this.formula="Fe2O3";
				break;
                        case 11:
				this.nome="Agua";
				this.formula="H2O";
				break;
                        case 12:
				this.nome="Agua";
				this.formula="H2O";
				break;
			default:
				this.nome="Calcario";
				this.formula="CaCO";//amostra para qualquer caso;
				break;
		}
		x=gerar.nextInt(47)+1;
		if(x+5*13<=1000){
                    massa=(x+5)*13;
                }else{
                    massa=1000;
                }
                
	}
}