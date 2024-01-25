package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Negozio {
	
	private ArrayList<Articolo> articoli;
	
	public Negozio(String path) throws FileNotFoundException {
		
		articoli = new ArrayList<Articolo>();
		
		Scanner file = new Scanner(new File(path));
		
		Entity e;
		
		while(file.hasNextLine()) {
			
			String[] info = file.nextLine().split(",");
			
			e = null;
			
			if(info[0].equalsIgnoreCase("p")) {
				
				e = new Pc(Integer.parseInt(info[1]),
							info[2],
							Integer.parseInt(info[3]),
							info[4],
							Integer.parseInt(info[5]),
							info[6],
							Integer.parseInt(info[7]),
							info[8]);
			}
			
		}
		
	}
	
}
