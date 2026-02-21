package cmp269;
import java.io.*;

public class Main {

	//https://www.programiz.com/java-programming/printwriter
	//How to check location of students file
	//Go to text file 
	//right click properties
	//search for location
    public static void main(String[] args) {
    	   File f = new File("src/students"); 
           System.out.println("Absolute path: " + f.getAbsolutePath());
           System.out.println("Exists? " + f.exists());
           System.out.println("Size bytes: " + new java.io.File("src/students").length());
         try (BufferedReader bfr = new BufferedReader(new FileReader(
        		"src/students"
        		))) 
        	
        	{
            String st;

//            while ((st = bfr.readLine()) != null) {
//                System.out.println(st);
//            }
            System.out.println("Calcukating average...");
            
           
//            FileOutputStream file = new FileOutputStream("grades.txt");
//            // Creates a PrintWriter
//            PrintWriter output = new PrintWriter(file);
//            output.print(file);
//            output.close();
            
            String firstLine; 
            int namestart = 0;
            
           
            while ((st = bfr.readLine()) != null) {
            	namestart = st.indexOf(": ");
            	String name = st.substring(0, namestart);
            	//I did this to make sure I only get the numbers after that "i.e 
            	//the +2 (because thats where the numbers begin
            	//
         	    firstLine = st.substring( namestart + 2).trim();
         	    //because of the spaces in between the numbers use this "\\s+"
         	    //saying split into one or more spaces
         	    String[] parts = firstLine.split("\\s+");
            	int sum = 0;
            	
               
            	//so it it reaches to the end of the line meaning it reaches 
            	//one student continue (now go on to calc avrg)
               if (namestart == -1) {
            	  continue;
               }
               try {
            	    //parts are the grades so basically go up to how many grades have bee
            	   //been posted
            	   for (int i = 0; i < parts.length; i++ ) {
            		  {
            			  //convert to an int
            			   int score = Integer.parseInt(parts[i]);
                		   sum += score;
            		   }
            		  
            	   }
            	   //only 3 scores so that's a constant doesnt need a var. 
            	   double avg = (double) sum / 3;
                   System.out.println(name + ": " +  firstLine + " | Average: " + avg);

            		    

               } catch (NumberFormatException e) {
            	   //Handling error
                   System.out.println("invalid data. Skipping student: " +
               name);
               }
            	   
            	  
               
            }
           

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}