package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main (String [] args) {
		String bob = JOptionPane.showInputDialog("Type something");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test2.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write("\n" + bob);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

//Copyright © 2022 Alfred Sherlock