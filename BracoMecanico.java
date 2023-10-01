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
public class BracoMecanico {
    private int pesoMaximo;
    private boolean operacional;
    private int aberturaMaxima;
    private int gravidade;
    private int gastoEnergetico=2;
    private Rover rover;
    public Rocha pegaRocha(int pos){
        ArrayList x=rover.getPlaneta().getObjetos(rover);
        //System.out.println(x);       
        Rocha a=(Rocha)x.get(pos);
       // System.out.println(a);
       int peso=a.getMassaTotal()*gravidade;
       if(a.getDiametro()>aberturaMaxima||peso>pesoMaximo){
           a=null;
       }
        return a;
    }
    public BracoMecanico(){}
    
    public BracoMecanico(int abertura,int peso,Rover rover){
        this.setAberturaMaxima(abertura);
        this.setPesoMaximo(peso);
        this.rover=rover;
    }
    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        if(pesoMaximo>0){
            this.pesoMaximo = pesoMaximo;
        }
    }

    public boolean isOperacional() {
        return operacional;
    }

    public void setOperacional(boolean operacional) {
        this.operacional = operacional;
    }

    public int getAberturaMaxima() {
        return aberturaMaxima;
    }

    public void setAberturaMaxima(int aberturaMaxima) {
        
        if(aberturaMaxima>0){
            this.aberturaMaxima = aberturaMaxima;
        }
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        if(gravidade>0){
            this.gravidade = gravidade;
        }
    }

    public int getGastoEnergetico() {
        return gastoEnergetico;
    }

    public void setGastoEnergetico(int gastoEnergetico) {
        if(gastoEnergetico>0){
            this.gastoEnergetico = gastoEnergetico;
        }
    }
}
