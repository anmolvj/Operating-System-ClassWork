package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Assignment4 {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		int noOfPageFrames;
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Input the total no of permissible page frames: ");
		noOfPageFrames=sc.nextInt();
		Scanner s = new Scanner(new File("file.txt"));
		ArrayList<Integer> Input = new ArrayList<Integer>();
		while (s.hasNext()){
		Input.add(s.nextInt());}
		
		Map<	Integer, Integer > hmap = new HashMap<	Integer, Integer>();
		for(int i=0;i<noOfPageFrames;i++)
		{
			hmap.put(0,0);
		}
		
		int pageFault = 0;
		
		for(int i=0;i<Input.size();i++)
		{	
			if(hmap.containsKey((Integer)Input.get(i)))
			{
				if(Input.get(i) != 0){
					
				for(Map.Entry<Integer, Integer> entry : hmap.entrySet())
				{
					hmap.put(entry.getKey(), entry.getValue()/2);
				}
				hmap.put(Input.get(i), hmap.get(Input.get(i)) + 128);
				}
				else{
					hmap.put(Input.get(i), hmap.get(Input.get(i)) + 128);
				}
			}
			else
			{
				
				
				Entry<Integer, Integer> min = null;
				for (Entry<Integer, Integer> entry1 : hmap.entrySet()) {
				    if (min == null || min.getValue() > entry1.getValue()) {
				        min = entry1;
				    }
				}
				
				Object[] crunchifyKeys = hmap.keySet().toArray();
				Integer key = (Integer)crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
				
				
				hmap.remove(key);
				hmap.put(Input.get(i), 0);
				pageFault++;
			}
		}
		System.out.println("Total number of page Faults: " + pageFault);		
		sc.close();
		s.close();
	}

}