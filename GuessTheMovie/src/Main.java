
import java.io.File;
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

			int index = (int)(Math.random() * movies.size());
			System.out.println(index);
			String answer = movies.get(index);
			System.out.println(answer);

			Game game = new Game(answer);

//			for (String m : movies) {
//				System.out.println(m);
//			}


		}  catch (IOException e) {
			System.out.println("ERROR. Can't find or read file 'movies.txt'");
		}
    }

}
