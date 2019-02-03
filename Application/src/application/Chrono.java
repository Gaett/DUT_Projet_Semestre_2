package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Chrono implements ActionListener {
	
	public int seconds, minutes, hours;
	private Timer chrono;
	
	private Chrono(){
		this.seconds = 0;
		this.minutes = 0;
		this.hours = 0;
		chrono = new Timer(1000, this);
		chrono.start();
	}
	
	private static Chrono ch = new Chrono();
	
	public static Chrono getInstance(){
		return ch;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.seconds++;
		if(this.seconds == 61){ this.minutes++; this.seconds = this.seconds - 60;}
		if(this.minutes == 61){this.hours++; this.minutes = this.minutes - 60;}
	}
	
	public static void main (String[] args){
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public void stopChrono(){
		this.chrono.stop();
	}
	
	public void resetChrono(){
		this.stopChrono();
		this.seconds = 0;
		this.minutes = 0;
		this.hours = 0;
	}
	
	public void startChrono(){
		this.chrono.start();
	}
}
