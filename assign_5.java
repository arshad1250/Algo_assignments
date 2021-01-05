import java.util.Scanner;

class DecimalToBinary{    

    public static void toBinary(int decimal){    
         int binary[] = new int[40];    
         int index = 0;    
         while(decimal > 0){    
           binary[index++] = decimal%2;    
           decimal = decimal/2;    
         }    
         for(int i = index-1;i >= 0;i--){    
           System.out.print(binary[i]);    
         }    
    System.out.println();//new line  
    }    
    public static void main(String args[]){      
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value: ");
        try{
            int value = scanner.nextInt();
            System.out.printf("Decimal of %d is: ",value);  
            toBinary(value);
            scanner.close();
        }catch(Exception e){
            System.out.println("Invalide value!");
            System.out.println(e);
            System.exit(1);
        }
        
    }
}      