import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DevOpsCalculator {
    private static final Logger logger = LogManager.getLogger(DevOpsCalculator.class);
    private static Scanner scanner=new Scanner(System.in);


    public DevOpsCalculator(){

    }
    public static void main(String[] args) {
        DevOpsCalculator calculator=new DevOpsCalculator();
        double number1,number2,result;

        do{
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print("Press 1 for Square Root\n Press 2 for Factorial\n Press 3 for Log\n Press 4 for Power\n"+
                    "Press 5 for Exit\n");
            System.out.print("Enter Your Choice:");
            int choice;

            try{
                choice=scanner.nextInt();
            }catch(InputMismatchException error){
                logger.error("Invalid input, Entered choice is not a number");
                return;
            }
            if(choice==5){
                System.out.println("Exiting");
                return;
            }
            try{
                System.out.println("Enter the number:");
                number1=scanner.nextDouble();
            }catch(InputMismatchException error){
                logger.error("Invalid input,Entered number is not a number");
                return;
            }
            switch (choice){
                case 1:
                    result=calculator.Sqrt(number1);
                    System.out.println("Square root of "+ number1+" is :"+ result);
                    break;
                case 2:
                    result=calculator.factorial(number1);
                    System.out.println("Factorial of "+ number1+" is :"+ result);
                    break;
                case 3:
                    result=calculator.naturalLog(number1);
                    System.out.println("Natural Log(Base e) of "+ number1+" is :"+ result);
                    break;
                case 4:
                    try{
                        System.out.println("Enter second number: ");
                        number2=scanner.nextDouble();
                    }catch (InputMismatchException error){
                        logger.error("Invalid input,Entered number is not a number");
                        return;
                    }
                    result=calculator.power(number1,number2);
                    System.out.println("Power of "+ number1+" and " +number2+ " is :"+ result);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (true);


    }

    private  double power(double number1,double number2){
        logger.info("[Power of] - "+number1 +", "+number2 );
        double result= Math.pow(number1,number2);
        logger.info("[Result - Power]"+result);
        return result;
    }
    private double naturalLog(double number1) {
        logger.info("[Natural Log of] - "+number1);
        double result= Math.log(number1);
        logger.info("[Result - Log]"+result);
        return result;
    }

    private double factorial(double number1) {
        if(number1<0){
            return Double.NaN;
        }
        if (number1 <= 1)
            return 1;
        else
            return number1 * factorial(number1-1);
    }


    private double Sqrt(double number1) {
        logger.info("[Square root of] - "+number1);
        double result= Math.sqrt(number1);
        logger.info("[Result - Square Root]"+result);
        return result;
    }
}
