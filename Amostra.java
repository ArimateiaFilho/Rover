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
import java.time.LocalTime;
public class Amostra{
	private Rocha rocha;
	private Coordenada coordenada;
	private LocalTime horaLocal;
	
	public Amostra(Coordenada coordenada,Rocha rocha){
            this();	
            if(coordenada!=null&&rocha!=null){
                this.rocha=rocha;
                //System.out.println(this.rocha);
                this.coordenada=coordenada;        
            }
	}
	public Rocha getRocha(){
		return rocha;
	}
	public Coordenada getCoordenada(){
		return coordenada;
	}
	public LocalTime getHoraLocal(){
		return horaLocal;
	}
	private Amostra(){
		horaLocal=LocalTime.now();
	}
}
