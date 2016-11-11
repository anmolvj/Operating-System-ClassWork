package assign3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankersImplementation {
	
	int needMatrix[][];
	int allocateMatrix[][];
	int availMatrix[][];
	int noOfResources;
	int noOfClients;
	int maxMatrix[][];
	
    
     
    public int[][] needMatrixCalculation(){
       for(int i=0;i<noOfClients;i++)
       {
         for(int j=0;j<noOfResources;j++) 
         {
          needMatrix[i][j]=allocateMatrix[i][j]-allocateMatrix[i][j];
         }
       }
       return needMatrix;
    }
    
    
    public void ask(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter number of clients and number of type of resources : ");
        noOfClients=sc.nextInt();
        noOfResources=sc.nextInt();  
        
        needMatrix=new int[noOfClients][noOfResources];  
        allocateMatrix=new int[noOfClients][noOfResources];
        allocateMatrix=new int[noOfClients][noOfResources];
        availMatrix=new int[1][noOfResources];
         
        System.out.println("Enter allocation matrix -->");
        for(int i=0;i<noOfClients;i++)
             for(int j=0;j<noOfResources;j++)
             {
            	 allocateMatrix[i][j]=sc.nextInt();
             }
          
        System.out.println("Enter max matrix -->");
        for(int i=0;i<noOfClients;i++)
             for(int j=0;j<noOfResources;j++)
             {
            	 allocateMatrix[i][j]=sc.nextInt(); 
             }
          
           System.out.println("Enter available matrix -->");
           for(int j=0;j<noOfResources;j++)
           {
        	   availMatrix[0][j]=sc.nextInt(); 
           }
            
           sc.close();
       }
  
    public boolean check(int i){
      
       for(int j=0;j<noOfResources;j++) 
       {
	       if(availMatrix[0][j]<needMatrix[i][j])
	          return false;
       }
    return true;
    }
 
    public void isSafe(){
    	try {
    		File f = new File("outputBankers.txt");
    	
    	FileOutputStream fos;
		
			fos = new FileOutputStream(f);
		
    	PrintWriter pw = new PrintWriter(fos);
       ask();
       needMatrixCalculation();
       boolean done[]=new boolean[noOfClients];
       int j=0;
 
       while(j<noOfClients){ 
       boolean allocated=false;
       for(int i=0;i<noOfClients;i++)
        if(!done[i] && check(i)){  
            for(int k=0;k<noOfResources;k++)
            availMatrix[0][k]=availMatrix[0][k]-needMatrix[i][k]+allocateMatrix[i][k];
         System.out.println("Allocated process : "+i);
         pw.write("Allocated process : "+i);
         allocated=done[i]=true;
               j++;
             }
          if(!allocated) break; 
       }
       if(j==noOfClients)  
       {
        System.out.println("\nAll the needs of clients were safely fulfilled by resources..!! ");
        pw.write("All the needs of clients were safely fulfilled by resources..!!");
       }
       else
       {
        System.out.println("All clients cannot be allocated the required resources safely");
        pw.write("All the needs of clients were safely fulfilled by resources..!!");
       }
       
       pw.flush();
       fos.close();
       pw.close();
    } catch (IOException e) {
		
		e.printStackTrace();
	}
		
}}
