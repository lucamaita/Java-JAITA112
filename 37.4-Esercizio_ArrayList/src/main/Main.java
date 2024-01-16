package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		String path = "src/res/Dati.txt";
		Scanner file = new Scanner(new File(path));
		
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(";");
			
			for(String s : infoRiga)
			{
				numeri.add(Integer.parseInt(s));
			}
		}
		
// NUMERO MAGGIORE -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		int max = Integer.MIN_VALUE;
		String numMax = "";
		
		for(Integer n : numeri) 
		{
			if(n > max)
			{
				max = n;
				numMax = n + ", ";
			}
			else if(n == max)
				numMax += n + ", ";
		}
		
		System.out.println("Numero massimo: " + numMax.substring(0, numMax.length()-2));
		
// MEDIA TOTALE -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		double media = 0;
		double somma = 0;
		
		for(Integer n : numeri)
		{
			somma += n;
		}
		
		media = somma/numeri.size();
		
		System.out.println("Media: " + media);
// MEDIA MULTIPLI 5 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		media = 0;
		somma = 0;
		int conta = 0;
		
		for(Integer n : numeri)
		{
			if(n%5==0)
			{
				conta++;
				somma += n;
			}
		}
		
		media = somma/conta;
		
		System.out.println("Media multipli 5: " + media);
		
// NUMERO MINORE TRA I MULTIPLI DI 3 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		int min = Integer.MAX_VALUE;
		String numMin = "";
		
		for(Integer n : numeri)
		{
			if((n%3 == 0) && (n < min))
			{
				min = n;
				numMin = n + ", ";
			}
			else if ((n%3 == 0)&&(n == min))
			{
				numMin += n + ", ";
			}
		}
		
		System.out.println("Numero minore tra i multipli di 3: " + numMin.substring(0, numMin.length()-2));
		
// MODIFICARE TUTTI I MULTIPLI DI 7 IN 10 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		for(int i = 0; i < numeri.size(); i++)
		{
			if (numeri.get(i) % 7 == 0)
			{
				numeri.set(i, 10);
			}
		}
		
		System.out.println(numeri);
		
// CANCELLARE NUMERI TRA 10 E 25 -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		for(int i = 0; i < numeri.size(); i++)
		{
			if(numeri.get(i) > 9 && numeri.get(i) < 26)
			{
				numeri.remove(i);
			}
		}
		
		System.out.println(numeri);
		
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		numeri.sort(null);
		
		System.out.println(numeri);
		
		
	}

}
