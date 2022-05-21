package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 ArrayList<String> ciudades = new ArrayList<>();
	     Grafo grafo = new Grafo(100);
	     Scanner sc = new Scanner(System.in);
	     
	     try {
	            File spanishTxt = new File ("guategrafo.txt");
	            FileReader fr = new FileReader(spanishTxt);
	            BufferedReader br1 = new BufferedReader(fr);
	            String linea = "";
	            Scanner scanner = new Scanner(fr);

	            while (scanner.hasNextLine()) {
	                linea = scanner.nextLine();
	                grafo.addEdge(linea.split(" ")[0],linea.split(" ")[1], Integer.parseInt(linea.split(" ")[2]));
	                if (!ciudades.contains(linea.split(" ")[0])) ciudades.add(linea.split(" ")[0]);
	            }
	            fr.close();
	            br1.close();

	        } catch (Exception e) {
	            System.out.println("Error");
	        }

	        grafo.verifyVertices();
	        grafo.GenerateMatrix();
	}

}
