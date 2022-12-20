package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] modules = directory.listFiles();
			if (modules != null) {
				for (File m : modules) {
					// System.out.println(f.getAbsolutePath());
					File[] files = m.listFiles();
					for (File f : files) {
						if (f.getAbsolutePath().contains(".java")) {
							System.out.println(f.getAbsolutePath());
							try {
								FileWriter fw = new FileWriter(f.getAbsolutePath(), true);

								/*
								 * NOTE: To append to a file that already exists, add true as a second parameter
								 * when calling the FileWriter constructor. (e.g. FileWriter fw = new
								 * FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
								 */
							
								fw.write("\n" + "//Copyright © 2022 Alfred Sherlock");
								

								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
	}
}

//Copyright © 2022 Alfred Sherlock