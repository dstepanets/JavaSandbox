
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static private ArrayList<String> movies = new ArrayList<>();

    public static void main(String[] args) {

    	try {

			File file = new File("movies.txt");
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) {
				movies.add(reader.nextLine());
			}

			for (String m : movies) {
				System.out.println(m);
			}

		} catch (FileNotFoundException e) {
    		System.out.println("ERROR. " + e + "|| File not found");
		} catch (IOException e) {
			System.out.println("ERROR. " + e + "|| Can't read file 'movies.txt'");
		}




    }
}
