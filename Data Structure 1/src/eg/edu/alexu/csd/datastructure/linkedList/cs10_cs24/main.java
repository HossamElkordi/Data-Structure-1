package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

import java.util.Scanner;

public class main {
	
	public static int dat[]=new int[4];
    public static int[][] inputtaker(){
        Scanner dis=new Scanner(System.in);
        int input1[];
        String line;
        String[] lineVector;
        line = dis.nextLine();
        line=line.replaceAll("[ ]","");
        line=line.replaceAll("[)]","");
        line=line.replaceAll("[(]","");
        lineVector = line.split(",");
        input1=new int[lineVector.length];
        int i;
        for(i=0;i<lineVector.length;i++){
            input1[i]=Integer.parseInt(lineVector[i]);
        }
        int[][]input=new int[input1.length/2][2];
        int j=0;
        for(i=0;i<input1.length/2;i++){input[i][0]=input1[j++];input[i][1]=input1[j++];} 
        return input;
    }
    public static void array(char letter){
        if(letter=='A'){dat[0]=1;}
        if(letter=='B'){dat[1]=1;}
        if(letter=='C'){dat[2]=1;}
        if(letter=='R'){dat[3]=1;}
 
    }
    public static void arrayclear(char letter){
        if(letter=='A'){dat[0]=0;}
        if(letter=='B'){dat[1]=0;}
        if(letter=='C'){dat[2]=0;}
        if(letter=='R'){dat[3]=0;}
 
    }
 
    public static boolean isfilled(char letter){
        if(letter=='A'&&dat[0]==1){return true;}
        if(letter=='B'&&dat[1]==1){return true;}
        if(letter=='C'&&dat[2]==1){return true;}
        if(letter=='R'&&dat[3]==1){return true;}
        return false;
    }
    public static void main (String[] args) {int j;int i[][];char letter,letter2;
        PolynomialSolver p = new PolynomialSolver();
        while(true){
            System.out.print("Please choose an action\n" +
                    "-----------------------\n" +
                    "1- Set a polynomial variable\n" +
                    "2- Print the value of a polynomial variable\n" +
                    "3- Add two polynomials\n" +
                    "4- Subtract two polynomials\n5- Multiply two polynomials\n" +
                    "6- Evaluate a polynomial at some point\n" +
                    "7- Clear a polynomial variable\n" +
                    "====================================================================\n"
            );
           Scanner d=new Scanner(System.in);
           j=d.nextInt();
           if(j==1){
               System.out.print("Insert the variable name: A, B or C\n");
               letter=d.next().charAt(0);
               System.out.print("Insert the polynomial terms in the form:\n" +
                       "(coeff1, exponent1), (coeff2, exponent2), ..\n");
               i=inputtaker();
               p.setPolynomial(letter,i);
               array(letter);
 
           }
           else if(j==2){
               System.out.print("Insert the variable name: A, B or C\n");
               letter=d.next().charAt(0);
               if(isfilled(letter)){
               System.out.println(p.print(letter));}
               else{System.out.println("polynomial not filled");}
           }
           else if(j==3){
               System.out.print("Insert the first operand variable name: A, B or C\n");
               letter=d.next().charAt(0);
               if(isfilled(letter)){System.out.print("Insert the second operand variable name: A, B or C\n");
                   letter2=d.next().charAt(0);
                   if(isfilled(letter2)){p.add(letter,letter2);
                       System.out.println("Result set in R: "+p.print('R'));
                       array('R');
                   }
                   else{System.out.println("polynomial not filled");}
               }
               else{System.out.println("polynomial not filled");}
           }
           else if(j==4){System.out.print("Insert the first operand variable name: A, B or C\n");
               letter=d.next().charAt(0);
               if(isfilled(letter)){System.out.print("Insert the second operand variable name: A, B or C\n");
               letter2=d.next().charAt(0);
                   if(isfilled(letter2)){p.subtract(letter,letter2);
                    array('R');
                   System.out.println("Result set in R: "+p.print('R'));
                   }
                   else{System.out.println("polynomial not filled");}
               }
               else{System.out.println("polynomial not filled");}
 
           }
           else if(j==5){
               System.out.print("Insert the first operand variable name: A, B or C\n");
               letter=d.next().charAt(0);
               if(isfilled(letter)){System.out.print("Insert the second operand variable name: A, B or C\n");
                   letter2=d.next().charAt(0);
                   if(isfilled(letter2)){p.multiply(letter,letter2);
                       array('R');
                       System.out.println("Result set in R: "+p.print('R'));
                   }
                   else{System.out.println("polynomial not filled");}
               }
               else{System.out.println("polynomial not filled");}
 
           }
           else if(j==6){
               System.out.print("Insert the  operand variable name: A, B or C\n");
               letter=d.next().charAt(0);
               if(isfilled(letter)) {
                   System.out.print("Insert the  operand Value you want to use\n");
                   j = d.nextInt();
                   System.out.println(p.evaluatePolynomial(letter, j));
               }
               else{System.out.println("polynomial not filled");}
           }
           else if(j==7){
               System.out.print("Insert the  operand variable name: A, B or C\n");
               letter=d.next().charAt(0);
               p.clearPolynomial(letter);
                arrayclear(letter);
           }
        }
 
    }
}
