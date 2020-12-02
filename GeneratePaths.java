import java.io.*;

class GeneratePaths {
    public static void main(String[] args) {
    	// Get arguments, which is only one argument actully!
    	double procent =  Double.parseDouble(args[0]);
    	if(procent < 0 || procent > 1) {
    		System.out.println("Sorry! You need to enter a double value between 0 and 1");
    		return;
    	}
    	File[] allPictures = scanAllClassFolders();
    }
    
    private static File[] scanAllClassFolders() {
    	// First get names of the folders 0, 1, 2, etc
    	File[] folders = new File("Classes").listFiles(File::isDirectory);
    	for(File folder : folders) {
    		System.out.println(folder.getAbsolutePath());
    	}
    	return null;
    }
}