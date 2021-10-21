package wcs.cda;

public class ACodeSimplification {
    // Instruction : rewrite this function in one line
    // WITHOUT using ternary operator
    public static boolean hasLegalAge(int age) {
    	//
    	if(age >= 18) return true; else return false;
        //with using ternary operator
        //return age >= 18 ? true : false;
    }

    // Instruction : rewrite this function in one line
    // WITH ternary operator
    public static char studentGroup(int number) {
       //
    	return number % 2 == 0 ? 'A' : 'B'; 
    	//
    	/*char result;
        if(number % 2 == 0) {
            result = 'A';
        }
        else {
            result = 'B';
        }
        return result;*/
    }
}
