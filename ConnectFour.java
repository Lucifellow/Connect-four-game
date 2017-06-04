//IMPORT STATEMENTS
import java.util.Scanner;
/**
   * @author  Carlos Cabello- 100262333  , Hrishikesh Vyas-100271549 , 
   * @version 1.0
   * Course:  CPSC 1150
   * Section: 005
   * Date:    March 26,2017
   * Asst:    9
   *    A two-player connection game in which the players take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid.
   */

public class ConnectFour {
	public static void main(String[] args) {
		
		String[][] pattern = createPattern();
		printPattern(pattern);
		boolean found = true;
		int count = 0;
		while(found){
			//let red player have first turn
			if(count%2==0){
				redPlayer(pattern);
				}
			else{
				yellowPlayer(pattern);
				}
			count++;
			printPattern(pattern);
			if(checkWinner(pattern)!=null){
				if(checkWinner(pattern)=="R"){
					System.out.println("Congratulations,the red player won.");
					}
					else if(checkWinner(pattern)=="Y"){
					System.out.println("Congratulations,the yellow player won");
					}
					found=false;
            
				}
        
		}
         
	}//end main
	/**
   * Creates a pattern of 2D array of size 7X15 for the suspended grid
   *
   * @return A 2D array of string representing the grid of suspended columns of game  
   *   
   */
	public static String[][] createPattern() {
		
		String[][] pattern = new String[7][15];
		for (int row = 0 ; row < pattern.length ; row ++) {
			for (int column = 0; column < pattern[row].length; column ++) {
				
				if (column % 2 == 0) {
					pattern[row][column] = "|";
				} else {
					pattern[row][column] = " ";
				}
            
            if(row==6){
               
             pattern[row][column]=" ";  
               
            }
				
			}//end column for
		}//end row for
		
		return pattern;
		
	}//end method
   
   
   /**
   * Prints 2D row and column  
   *
   * @param pattern  A 2d string that we want to print
   *
   */
	public static void printPattern(String[][] pattern) {
		
		for (int row = 0; row < pattern.length; row++) {
			for (int column = 0; column < pattern[row].length; column++) {
				
				System.out.print(pattern[row][column]);
				
			}//end column for
			
			System.out.println();
			
		}//end row for
	}//end method
   
   
   /**
   * Gets and validates Red player input and inserts the element into the array  
   *
   * @param pattern  A 2d array string representing the grid of columns
   *
   */
	
   public static void redPlayer(String[][] pattern){
    
	   int column = 0 ;
      System.out.println("Select an empty column (0-6) to drop a Red disk into:");
      Scanner sc=new Scanner(System.in);
       boolean error=false;
       do{
      
     
         while(!sc.hasNextInt()){
            
           
            System.out.println("Sorry, you have entered an invalid column number.");  
            System.out.println("Select an empty column (0-6) to drop a red disk into:");
            sc.next();
           
         }
         
        
         column=2*sc.nextInt()+1;
         
         if(column<0 || column>14){
             System.out.println("Sorry, you have entered an invalid column number.");  
             System.out.println("Select an empty column (0-6) to drop a red disk into:");
          
          
             error=true; 
            
            }
         else{
            
            error=false;
            
            }
         }while(error==true);
    
      for(int i=5;i>=0;i--){
         
         if(pattern[i][column]==" "){
         
               pattern[i][column]="R";
               break;
         }   
         
      
      } 
      }
   /**
   * Gets and validates Yellow player input and inserts the element into the array  
   *
   * @param pattern  A 2d array string representing the grid of columns
   *
   */     
   
   public static void yellowPlayer(String[][] pattern){
        
      int column = 0 ;
      System.out.println("Select an empty column (0-6) to drop a Yellow disk into:");
          Scanner sc=new Scanner(System.in);
      boolean error=false;
      do{
      
  
         while(!sc.hasNextInt()){
            
           
            System.out.println("Sorry, you have entered an invalid column number.");  
            System.out.println("Select an empty column (0-6) to drop a Yellow disk into:");
            sc.next();
           
         }
  
         column=2*sc.nextInt()+1;
         
         if(column<0 || column>14){
            
            System.out.println("Sorry, you have entered an invalid column number.");  
            System.out.println("Select an empty column (0-6) to drop a Yellow disk into:");
          
             error=true; 
            
            }
         else{
            
            error=false;
            
            }
         }while(error==true);
    
      for(int i=5;i>=0;i--){
         
         if(pattern[i][column]==" "){
         
               pattern[i][column]="Y";
               break;
         }   
         
      
      } 
   }
    /**
   *  Checks horizontal vertical and diagonal lines and returns the winner or returns null if no pattern found  
   *
   * @param pattern  A 2d array string representing the grid of columns
   *
   * @return A string element present in the column after finding the horizontal vertical or diagonal pattern
   */     
   
   public static String checkWinner(String[][] pattern){
         //horizontal
      for(int i=0; i<7;i++){
         for (int j=0;j<7;j=j+2){
         if((pattern[i][j+1]!= " ")
            &&(pattern[i][j+3] != " ")
            &&(pattern[i][j+5] != " ")
            && (pattern[i][j+7] != " ")
            && ((pattern[i][j+1] == pattern[i][j+3])
            && (pattern[i][j+3] == pattern[i][j+5])
            && (pattern[i][j+5] == pattern[i][j+7]))){
            
            return pattern[i][j+1];
            }
         }
      }
         //vertical
          for (int i=1;i<15;i+=2){
               for (int j =0;j<3;j++){

                  if((pattern[j][i] != " ")
                  && (pattern[j+1][i] != " ")
                  && (pattern[j+2][i] != " ")
                  && (pattern[j+3][i] != " ")
                  && ((pattern[j][i] == pattern[j+1][i])
                  && (pattern[j+1][i] == pattern[j+2][i])
                  && (pattern[j+2][i] == pattern[j+3][i]))){

                           return pattern[j][i]; 
                  }
               }   

            }
            
         //left to right diagonal
         for (int i=0;i<3;i++){
            for (int j=1;j<9;j=j+2){
               
               if((pattern[i][j] != " ")
                  && (pattern[i+1][j+2] != " ")
                  && (pattern[i+2][j+4] != " ")
                  && (pattern[i+3][j+6] != " ")
                  && ((pattern[i][j] == pattern[i+1][j+2])
                  && (pattern[i+1][j+2] == pattern[i+2][j+4])
                  && (pattern[i+2][j+4] == pattern[i+3][j+6]))){
                  return pattern[i][j]; 
               }
            }
            
            
         }
            //right to left diagonal
         for (int i=0;i<3;i++){
            for (int j=7;j<15;j+=2){
               if((pattern[i][j] != " ")
               && (pattern[i+1][j-2] != " ")
               && (pattern[i+2][j-4] != " ")
               && (pattern[i+3][j-6] != " ")
               && ((pattern[i][j] == pattern[i+1][j-2])
               && (pattern[i+1][j-2] == pattern[i+2][j-4])
               && (pattern[i+2][j-4] == pattern[i+3][j-6]))){
                     return pattern[i][j];
               }
            } 
         }
       return null;     
      }
   
  
  
   }  
   
//end class