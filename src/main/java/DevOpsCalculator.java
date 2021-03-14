import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            System.out.print("Press 1 for Square Root\nPress 2 for Factorial\nPress 3 for Log\nPress 4 for Power\n"+
                    "Press 5 for Exit\n");
            System.out.print("Enter Your Choice:");
            int choice;

            try{
                choice=scanner.nextInt();
            }catch(InputMismatchException error){
                logger.error("Invalid input,Entered choice is not a number");
                return;
            }
            if(choice==5){
                System.out.println("Exiting");
                logger.info("Exiting");
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
                    result=calculator.sqrt(number1);
                    System.out.println("Square root of "+ number1+" is : "+ result);
                    break;
                case 2:
                    result=calculator.factorial(number1);
                    System.out.println("Factorial of "+ number1+" is : "+ result);
                    break;
                case 3:
                    result=calculator.naturalLog(number1);
                    System.out.println("Natural Log(Base e) of "+ number1+" is : "+ result);
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
                    System.out.println(number1+" Power "+number2+ " is : "+ result);
                    break;
                default:
                    System.out.println("Invalid choice");
                    logger.info("Invalid choice");
                    break;
            }
        }while (true);


    }

    public double power(double number1,double number2){
        logger.info("[Power of] :"+number1 +", "+number2 );
        double result= Math.pow(number1,number2);
        logger.info("[Result of Power]"+result);
        return result;
    }
    public double naturalLog(double number1) {
        logger.info("[Natural Log of] : "+number1);
        double result= Math.log(number1);
        logger.info("[Result of Log]"+result);
        return result;
    }

    public double factorial(double number1) {
        logger.info("[Factorial of] :"+number1);
        double result = 1;
        try{
            if(number1 != (int)number1){
                result = Double.NaN;
            }
            if(number1==Double.POSITIVE_INFINITY){
                result=Double.POSITIVE_INFINITY;
            }
            if(number1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN if < 0");
            }

            if(number1 == 0 || number1 == 1) {
                return 1;
            }

            for(int i = 1; i <= number1; i++){
                result *= i;
            }
        }
        catch(ArithmeticException error) {
            logger.error("Number cannot be negative " + error.getMessage());
        }
        finally {
            logger.info("Result of factorial is: " + result);
        }
        return result;
    }


    public double sqrt(double number1) {
        logger.info("[Square root of] : "+number1);
        double result= Math.sqrt(number1);
        logger.info("[Result of Square Root]"+result);
        return result;
    }
}
