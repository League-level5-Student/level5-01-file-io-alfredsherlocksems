package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main (String [] args) {
		String message = JOptionPane.showInputDialog("Type a message.");
		String key = JOptionPane.showInputDialog("Type a key");
		int num = Integer.parseInt(key);
		char[] list = new char[message.length()];
		for (int i = 0; i < list.length; i++) {
			list[i] = message.charAt(i);
			list[i] += num;
		}
		String s = "";
		for (int i = 0; i < list.length; i++) {
			s = s + list[i];
		}
		System.out.println(s);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/test.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write(s);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileDecryptor d = new FileDecryptor();
		d.setKey(num);
		d.bob(num);
	}
}
