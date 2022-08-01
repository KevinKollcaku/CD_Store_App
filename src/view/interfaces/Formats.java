package view.interfaces;

public interface Formats{

    static boolean Birthday(String input){
        if(input.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}"))
        return true;

        System.out.println("\n not this way your birthday");
        return false;
    }

    static boolean PhoneNumber(String input){
        if(input.matches("[0-9]{3}[-][0-9]{3}[-][0-9]{4}"))
        return true;

        System.out.println("Not this way your phone number");
        return false;
    }

    static boolean personal_pronouns(String input){
        if(input.matches("[A-Z][a-z]*$"))
        return true;

        System.out.println("Not this way your personal name/surname");
        return false;
    }
    
}
