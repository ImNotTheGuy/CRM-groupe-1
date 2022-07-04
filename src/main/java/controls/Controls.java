package controls;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controls {

    // used in servlets: if length > 0 then error(s) should be returned
    List<String> errorMessages = new ArrayList<>();

    // Below hashmaps are re-created each time the Controls class is called,
    // probably a better way to do it

    // Map to keep track of min and max length restrictions for each field
    Map<String, int[]> minMaxLengthMap = new HashMap<>();

    // Map to keep track if a certain field can be null
    Map<String, Boolean> canBeNullMap = new HashMap<>();


    public Controls() {

        // Add to each field the min and max length according to the SQL table restrictions
        minMaxLengthMap.put("companyName", new int[]{2, 100});
        minMaxLengthMap.put("firstName", new int[]{2, 100});
        minMaxLengthMap.put("lastName", new int[]{2, 100});
        minMaxLengthMap.put("typePresta", new int[]{2, 100});
        minMaxLengthMap.put("designation", new int[]{2, 100});
        minMaxLengthMap.put("email", new int[]{2, 100});
        minMaxLengthMap.put("phone", new int[]{2, 15});
        minMaxLengthMap.put("zipCode", new int[]{2, 15});
        minMaxLengthMap.put("city", new int[]{2, 15});
        minMaxLengthMap.put("country", new int[]{2, 15});
        minMaxLengthMap.put("address", new int[]{2, 255}); // Address has no limit in SQL table but set to 255

        // Add to each field if it can be null according to the SQL table restrictions
        canBeNullMap.put("companyName", false);
        canBeNullMap.put("firstName", false);
        canBeNullMap.put("lastName", false);
        canBeNullMap.put("typePresta", false);
        canBeNullMap.put("designation", false);
        canBeNullMap.put("email", false);
        canBeNullMap.put("phone", false);
        canBeNullMap.put("zipCode", false);
        canBeNullMap.put("city", false);
        canBeNullMap.put("country", false);
        canBeNullMap.put("address", false);
        canBeNullMap.put("clientState", true);
        canBeNullMap.put("orderState", false);
        canBeNullMap.put("unitPrice", false);
        canBeNullMap.put("nbDays", false);

    }
    
    public List<String> getErrorMessages(){
    	return this.errorMessages;
    }

    public void checkRestriction(String name, String parameter) {

        // For specific fields

        // clientState CAN be null but can only take values 0,1,2
        if (name == "clientState") {
            stateControl(name, parameter);
            return;
        }

        // orderState CANNOT be null but can only take values 0,1,2
        if (name == "orderState") {
            stateControl(name, parameter);
            return;
        }

        // Can't be negative nor null + Although no upper limit, restrict to 360 days for reasonability purposes.
        if (name == "nbDays") {
            nbDaysControl(name, parameter);
            return;
        }

        // Can't be negative nor null
        if (name == "unitPrice") {
            unitPriceControl(name, parameter);
            return;
        }

        // For the rest, just get the min and max length, check if can be null and do it each time
        int paramLength = parameter.length();
        int minLength = minMaxLengthMap.get(name)[0];
        int maxLength = minMaxLengthMap.get(name)[1];
        boolean canBeNull = canBeNullMap.get(name);

        boolean isNull = checkNullity(parameter);
        boolean nullityRespected = !canBeNull?!isNull:false;
        boolean lengthRestrictionRespected = (paramLength <= maxLength && paramLength >= minLength);

        if (!nullityRespected) {
            errorMessage("Nullity for parameter [" + name + "] was not respected !");
            return;
        }

        if (!lengthRestrictionRespected) {
            errorMessage("Length restriction for parameter [" + name + "] was not respected !");
            return;
        }
    }

    void stateControl(String name, String parameter) {

        boolean canBeNull = canBeNullMap.get(name);
        boolean isNull = checkNullity(parameter);

        if (canBeNull && isNull) {
            return;
        }

        try {
            int paramInt = Integer.parseInt(parameter);
            if (paramInt < 0 || paramInt > 2) {
                errorMessage("State field only takes values (0,1,2) ! You entered: " + paramInt);
                return;
            }
        } catch (NumberFormatException nfExc) {
            errorMessage("Unable to parse a number for following value: " + parameter + "!");
            return;
        }
    }

    boolean checkNullity(String parameter) {
        if (parameter == null || parameter.isEmpty() || parameter.isBlank()) {
            return true;
        }
        return false;
    }

    void nbDaysControl(String name, String parameter) {
        boolean canBeNull = canBeNullMap.get(name);
        boolean isNull = checkNullity(parameter);

        if (canBeNull && isNull) {
            return;
        }

        try {
            int paramInt = Integer.parseInt(parameter);
            if (paramInt < 0) {
                errorMessage(name + "must be positive ! You entered: " + paramInt);
                return;
            }

            if (paramInt > 360){
                errorMessage(name + "must be less than 360 days ! You entered: " + paramInt);
            }
        } catch (NumberFormatException nfExc) {
            errorMessage("Unable to parse a number for following value: " + parameter + "!");
            return;
        }
    }

    void unitPriceControl(String name, String parameter) {
        boolean canBeNull = canBeNullMap.get(name);
        boolean isNull = checkNullity(parameter);

        if (canBeNull && isNull) {
            return;
        }

        try {
            float paramFloat = Float.parseFloat(parameter);
            if (paramFloat < 0) {
                errorMessage(name + " must be positive ! You entered: " + paramFloat);
                return;
            }
            if (paramFloat > 1_000_000){
                errorMessage(name + " must be less than 1 million ! You entered: " + paramFloat);
            }
        } catch (NumberFormatException nfExc) {
            errorMessage("Unable to parse a number for following value: " + parameter + "!");
            return;
        }
    }


    void errorMessage(String message) {
        // not very useful for now as a simple .add can be done directly in the control methods
        errorMessages.add(message);
    }


}
