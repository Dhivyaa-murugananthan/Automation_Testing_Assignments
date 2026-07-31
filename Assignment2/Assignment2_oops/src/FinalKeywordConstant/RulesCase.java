package FinalKeywordConstant;

/*Create a class GovernmentRules with a final variable MAX_WORKING_HOURS = 8
Try modifying it inside main and observe compile-time restriction.*/

class GovernmentRules {
    final int MAX_WORKING_HOURS = 8;


}

public class RulesCase {
    public static void main(String[] args) {
        GovernmentRules gr = new GovernmentRules();
        System.out.println("Max working hours: " + gr.MAX_WORKING_HOURS);

        // Compile-time error if you try:
        // gr.MAX_WORKING_HOURS = 10; 
        // Error: cannot assign a value to final variable MAX_WORKING_HOURS
    }
}
