package exams;

import java.io.FileInputStream;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class Exam_03_MP3_Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String musicName = null;
		
		int menu = Integer.parseInt(sc.nextLine());
		if(menu ==1) {
			musicName = "piano.mp3";
			
		}else if(menu == 2) {
			musicName = "Chill Day.mp3";
		}
		try{
		    FileInputStream fis = new FileInputStream(musicName);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		}
		catch(Exception exc){
		    exc.printStackTrace();
		    System.out.println("Failed to play the file.");
		}
	}

}
