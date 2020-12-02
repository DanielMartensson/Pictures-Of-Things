import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

class GeneratePaths {
	public static void main(String[] args) {
		double procent = readInputArgument(args);
		if (procent == 0.0)
			return;
		ArrayList<File> allPictures = scanAllClassFolders();
		createPaths(allPictures, procent);
	}

	private static ArrayList<File> scanAllClassFolders() {
		// First get names of the folders 0, 1, 2, etc
		File[] folders = new File("Classes").listFiles(File::isDirectory);
		ArrayList<File> allPictures = new ArrayList<File>();
		for (File folder : folders) {
			String className = folder.getName();
			System.out.println("Reading class folder: " + className);
			File[] classPictures = new File("Classes/" + className).listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
			for (File classPicture : classPictures)
				allPictures.add(classPicture);
		}
		Collections.shuffle(allPictures); // Mixing the list
		return allPictures;
	}

	private static double readInputArgument(String[] args) {
		double procent = Double.parseDouble(args[0]);
		if (procent <= 0 || procent >= 1) {
			System.out.println("Sorry! You need to enter a double value between 0 and 1");
			return 0;
		}
		System.out.println("You selected " + procent + " for training and " + (1.0 - procent) + " for validation");
		return procent;
	}

	private static void createPaths(ArrayList<File> allPictures, double procent) {
		double size = (double) allPictures.size();
		int stopTrain = (int) (size * procent);
		writeFile(allPictures, "TrainPaths.txt", 0, stopTrain);
		writeFile(allPictures, "ValidPaths.txt", stopTrain, (int) size);
	}

	private static void writeFile(ArrayList<File> allPictures, String fileName, int start, int stop) {
		int size = allPictures.size();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Classes/" + fileName)));
			for (int i = start; i < stop; i++)
				if (i < stop - 1)
					bw.write(allPictures.get(i).getAbsolutePath() + "\n");
				else
					bw.write(allPictures.get(i).getAbsolutePath()); // We don't need the last \n
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Writing file " + fileName + " in Classes folder");

	}
}
