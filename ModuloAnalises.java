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

public class ModuloAnalises{
	private int gastoEnergetico=2;
	private Coordenada coordenadaAgua;
	private int totalAgua=0;
	private StringBuilder relatorio;
	private DepositoAmostras deposito;
	
	public boolean analisaAmostra(){
            boolean res=false;
            int v=0;
            relatorio=new StringBuilder();
            //// teho que guardar o get amostra porque ele da um -- ai fica null
            Amostra teste=deposito.getAmostra();
            if(teste!=null){
                //System.out.println(teste.getRocha());
                Substancia r[]=teste.getRocha().getSubistancia();
                for (int i = 0; i < r.length; i++) {
                    relatorio.append(r[i].getNome());
                    relatorio.append("|");
                    relatorio.append(r[i].getFormula());
                    relatorio.append("|");
                    relatorio.append(r[i].getMassa());
                    relatorio.append("  ");
                    if(r[i].getNome().equals("Agua")){
                        v+=r[i].getMassa();
                    }
                }
            }else{
                //System.out.println("deposito vazio");
            }
            //System.out.println(relatorio);
            totalAgua=v;
            if(v>=500){
                res=true;
                coordenadaAgua=teste.getCoordenada();
            }
            return res;
	}
	public ModuloAnalises(DepositoAmostras deposito){
		if(deposito!=null){
			this.deposito=deposito;
		}
	}
	private ModuloAnalises(){
            deposito=new DepositoAmostras();
        }
        public int getGastoEnergetico(){
            return gastoEnergetico;
        }
}