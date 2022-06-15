package validate;

import model.Customer;

import java.util.regex.Pattern;

public class Validate {
//    public static boolean customerId(String customerId){
//        Pattern pattern=Pattern.compile("^KH\\-[0-9]{4}$");
//        if (pattern.matcher(customerId).matches()){
//            return true;
//        }
//        return false;
//    }

//    public static boolean serviceId(String serviceId){
//        Pattern pattern=Pattern.compile("^DV\\-[0-9]{4}$");
//        if (pattern.matcher(serviceId).matches()){
//            return true;
//        }
//        return false;
//    }

    public static boolean phone(String phone){
        Pattern pattern=Pattern.compile("^090[0-9]{7}|091[0-9]{7}$");
        if (!pattern.matcher(phone).matches()){
            return true;
        }
        return false;
    }

    public static boolean idCard(String idCard){
        Pattern pattern=Pattern.compile("^[0-9]{9}$");
        if (!pattern.matcher(idCard).matches()){
            return true;
        }
        return false;
    }

    public static boolean number(String number){
        Pattern pattern=Pattern.compile("^[0-9]{1,}$");
        if (!pattern.matcher(number).matches()){
            return true;
        }
        return false;
    }
    public  static boolean email(String email){
        Pattern pattern=Pattern.compile("^([a-z 0-9]{1,})@gmail.com$");
        if (!pattern.matcher(email).matches()){
            return true;
        }
        return false;
    }

//    public static boolean salary(double salary){
//        Pattern pattern=Pattern.compile("^([0-9]{1,})$");
//        if (!pattern.matcher(salary).matches()){
//
//            return true;
//        }
//        return false;
//    }
}
