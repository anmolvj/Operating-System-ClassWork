package assign3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AssignB {

	int totalAvailableCurrentResources,numberOfClients;
    int[] currentAllocationMatrix;
    int[] maximumNeedMatrix;
    int[] requiredResourceMatrix;
    int[] order;
    public void ask() throws IOException{                                       /*it takes input from the user and intializes necsessary data structres*/ 
        File file = new File("/home/tanaydesai14/assignment3_output_file.txt");
    if (!file.exists()) {
                        file.createNewFile();
		}
    FileWriter fw  = new FileWriter(file.getAbsoluteFile(),true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);                                      /*this logs the requests and decisions in the file*/
    pw.write("New instance:\n\n");
        System.out.println("Enter number of clients:");
        Scanner s = new Scanner(System.in);
        numberOfClients = s.nextInt();
        pw.write("Number of clients are :"+numberOfClients);
        currentAllocationMatrix = new int[numberOfClients];
        maximumNeedMatrix = new int[numberOfClients];
        requiredResourceMatrix = new int[numberOfClients];
        order = new int[numberOfClients];
        System.out.println("Enter the current allocation of resources for each client:");
        for(int i = 0;i<currentAllocationMatrix.length;i++)
            currentAllocationMatrix[i]=s.nextInt();
        pw.write("\nThe current allocation vector is:\n");
        for(int i = 0;i<currentAllocationMatrix.length;i++)
            pw.write(currentAllocationMatrix[i]+" ");
        
        System.out.println("\nEnter the maximum need of resources for each client:");
        for(int i = 0;i<maximumNeedMatrix.length;i++)
            maximumNeedMatrix[i]=s.nextInt();
        pw.write("\nThe maximum need is\n");
        for(int i = 0;i<maximumNeedMatrix.length;i++)
            pw.write(maximumNeedMatrix[i]+" ");
        for(int i = 0;i<numberOfClients;i++)
            requiredResourceMatrix[i] = maximumNeedMatrix[i] - currentAllocationMatrix[i];
        pw.write("\nThe request vector is\n");
        for(int i = 0;i<requiredResourceMatrix.length;i++)
            pw.write(requiredResourceMatrix[i]+" ");
        System.out.println("\nEnter available resources from the bank:");
        totalAvailableCurrentResources=s.nextInt();
        pw.write("\nAvailable resource is :"+totalAvailableCurrentResources);
        pw.close();
    }
    public void state() throws IOException{                                     /*this determines whether the state is safe or unsafe*/
        ask();
        File file = new File("/home/tanaydesai14/assignment3_output_file.txt");
    if (!file.exists()) {
                        file.createNewFile();
		}
    FileWriter fw  = new FileWriter(file.getAbsoluteFile(),true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);
        boolean finished[] = new boolean[numberOfClients];
        int finished_clients = 0;
        while(finished_clients<numberOfClients){
            boolean no_allocation = true;
            for(int i = 0;i < numberOfClients ; i++){
                if(finished[i]==false && requiredResourceMatrix[i]<=totalAvailableCurrentResources){
                	totalAvailableCurrentResources = totalAvailableCurrentResources + currentAllocationMatrix[i];
                        order[finished_clients] = i;
                        finished[i] = true;
                        no_allocation = false;
                        finished_clients++;
                    
                }
                
            }
            if(no_allocation)
                    break;
        }
        
        if(finished_clients==numberOfClients){
            System.out.println("This is a safe state and the order of execution is :");
            pw.write("\nThis is a safe state and the order of execution is :");
            for(int i =0;i<order.length;i++){
                System.out.println("Process "+order[i]);
                pw.write("\nProcess "+order[i]);}
        }
        else{
            System.out.println("There is a deadlock. The total number of processes not able to finish is : "+(numberOfClients - finished_clients));
            pw.write("\nThere is a deadlock. The total number of processes not able to finish is : "+(numberOfClients - finished_clients));
}       pw.write("\n________________________________________________________________________________________________________________________________________________\n");
    pw.close();
    }
    
    

}
