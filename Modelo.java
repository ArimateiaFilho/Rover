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
public class Modelo implements Observer1,Observer{
    private Planeta planeta;
    private Rover rover;
    private ArrayList<Observer1> observers = new ArrayList<>();
    private ModuloComunicacao modulo=new ModuloComunicacao();
    private ArrayList relatorio=new ArrayList();
    @Override
    public void update(Observable o,Object arg){
        setMensagem(modulo.getMensagem());
    }
    public void setMensagem(String mensagem){
        relatorio.add(mensagem);
    }
    public ArrayList getMensagem(){
        return relatorio;
    }
    public void registraObserver(Observer1 observer) {
		observers.add(observer);
    }
    public void notificaObservers() {
		for(Observer1 observer : observers) {
			observer.updatee();
		}
    }
    @Override
    public void updatee(){
        
    }
    public void setRover(String nome,int bateria,int deposito,int peso,int abertura){
        rover=new Rover(planeta,nome,bateria,deposito,peso,abertura);
        //System.out.println(rover);
    }
    public void setPlaneta(String nome,int tam,int gra){
        planeta=new Planeta(nome,tam,gra);
        //System.out.println(planeta);
    }
    public void ligaRover(){
        rover.ligaRover();
    }
    public void desligaRover(){
        rover.desligaRover();
    }
    public String getNome(){
        return rover.getNome();
    }
    public int getBateria(){
        return rover.getNivelBateria();
    }
    public String getNomePlaneta(){
        return rover.getPlaneta().getNome();
    }
    public Modelo(){
        modulo.addObserver(this);
    }
    public String getCoordenada(){
        return rover.getCoordenada();
    }
    public void execultaComando(String mensagem){
        String x[]=mensagem.split(":");
        if(x[0].equals("go")){
            modulo.transmiteMensagem(mensagem);
        }else{
            setMensagem("Comando invalido");
        }
    }
}
