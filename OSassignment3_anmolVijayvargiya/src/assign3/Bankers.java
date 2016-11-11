package assign3;

import java.util.ArrayList;
import java.util.Scanner;
public class Bankers{
	
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int noOfClients;
	int noOfAvailableResource;
	int clientResourceData[][];
	
	System.out.println("THIS IMPLEMENTATION OF BANKERS ALGORITHEM ASSUMES THE NUMBER OF RESOURCES TO BE ONE");
	
	
	//Initialize the value of total number of resources of a single(same) type
	System.out.println("Enter the number of available resource of a single type: ");
	noOfAvailableResource = sc.nextInt();
	
	//Initialize the value of total number of clients
	System.out.println("Enter the number of Clients");
	noOfClients = sc.nextInt();
	
	//initialize the size of allocation matrix
	clientResourceData = new int[noOfClients][2];
	
	//for loop to initialize the values in the required matrix
	for(int i=0;i<noOfClients;i++){
		System.out.println("Enter the number of resources requested by  client number " + (i+1));
		clientResourceData[i][0] = sc.nextInt();
		clientResourceData[i][1] = 0;
		
		}//for loop to initialize required matrix ends here
	
	
	ArrayList<Integer> queue = new ArrayList<Integer>();
	
	for(int i=0;i<noOfClients;i++){
		for(int j=0;j<noOfClients;j++){
			if(noOfAvailableResource>=clientResourceData[j][0] && clientResourceData[j][1]==0)
			{
				noOfAvailableResource=noOfAvailableResource+clientResourceData[j][0];
				clientResourceData[j][0] = 0;
				clientResourceData[j][1] = 1;
				queue.add(j);
			}
			else
			{continue;}
		}
	}
	
	int conditionDeadlock = 0;
	for(int i=0;i<noOfClients;i++){
		if(clientResourceData[i][1] == 1){
			continue;
		}
		else
		{
			conditionDeadlock = 1;
		}
	
	if(conditionDeadlock ==1)
	{
		System.out.println("The request's of the clients are unsafe and may create a deadlock");
	}
	else
	{
		System.out.println("The request's of the clients are safe and can be scheduled in the folowing que");
		for(int l=0;l<noOfClients;l++){
			System.out.println(queue);
		}
	}
	}
	
	sc.close();
	//final checking of bankers algorithm
	
		}

}

	

