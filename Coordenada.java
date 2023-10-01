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

public class Coordenada{
	public int x,y;
	
	public int getQuadrante(){
		int h=0;
		if(x>0&&y>0){
			h=1;
		}
		if(x<0&&y>0){
			h=2;
		}
		if(x<0&&y<0){
			h=3;
		}
		if(x>0&&y<0){
			h=4;
		}
		return h;
	}
}
