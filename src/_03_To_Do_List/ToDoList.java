package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTasks = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();
	
	public static void main (String [] args) {
		ToDoList l = new ToDoList();
		l.setup();
	}
	
	void setup () {
		frame.setVisible(true);
		frame.add(panel);
		String line = "";
		try {

			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do"
			+ "_List/list.txt"));
			
			line = br.readLine();
			
			while(line != null){
				tasks.add(line);
				line = br.readLine();
			}
		

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		addTask.addActionListener((bob) -> {
			String task = JOptionPane.showInputDialog("Add a task.");
			tasks.add(task);
		});
		viewTasks.addActionListener((bob) -> {
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println(tasks.get(i));
			}
		});
		removeTask.addActionListener((bob) -> {
			String num1 = JOptionPane.showInputDialog("What number task do you want to remove?");
			int num = Integer.parseInt(num1);
			tasks.remove(num);
			JOptionPane.showMessageDialog(null, "Removed");
		});
		saveList.addActionListener((bob) -> {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				fw.write(tasks.get(0));
				for (int i = 1; i < tasks.size(); i++) {
					fw.write("\n" + tasks.get(i));
				}
				
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		loadList.addActionListener((bob) -> {
			for (int i = 0; i < tasks.size(); i++) {
				tasks.remove(i);
			}
			String lo = "";
			try {

				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do"
				+ "_List/list.txt"));
				
				lo = br.readLine();
				
				while(lo != null){
					tasks.add(lo);
					lo = br.readLine();
				}
			

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
		
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.pack();
	}
	
}

