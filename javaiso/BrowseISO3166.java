import java.util.*;

public class BrowseISO3166 {

    //defining array
    String array[][] = new String[249][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BrowseISO3166 bIso = new BrowseISO3166();
        bIso.init();
        System.out.println("Welcome to Browse ISO-3166. Enter “bye” anytime to end.");

        String input = null;
        String matchString = null;

        while (true) {
            System.out.println("Please enter a country code or a country name:");
            input = sc.nextLine();
            if(input.equals("bye")){
                System.out.println("Bye.");
                System.exit(0);
            }
            if(input.length()<2){
                System.out.println("Matching string cannot be less than two letters, please enter another matching string: ");
            }
            String countryName = bIso.getCountryName(input);
            String countryCode = bIso.getCountryCode(input);

            if(countryName!="" || !countryName.equals("") )
                System.out.println("The country name for the country code entered "+input+" is "+countryName);
            
            if(countryCode!="" || !countryCode.equals("")){
                System.out.println("The country code for the country name entered "+input+" is "+countryCode);   
            }

            if(!countryCode.equals("") || !countryName.equals("")){
            System.out.println("Please Enter matching string for country names");
            while (true) {
                matchString = sc.nextLine();
                //matching input
                if(matchString.equalsIgnoreCase("bye"))
                    System.exit(0);
                if(matchString.length()<2)
                    System.out.println("Matching string cannot be less than two letters, please enter another matching string : ");
                else{
                    //calling matchcountry method.
                    String matchedStrings[] = bIso.getMatchedCountries(matchString);
                    System.out.println("Result count : "+matchedStrings.length);
                    if(matchedStrings.length>0){
                        for (int i = 0; i < matchedStrings.length; i++) {
                            System.out.println(matchedStrings[i]);
                        }
                        break;
                    }else{
                        System.out.println("No match for matching string entered ! ");
                        break;
                        }
                    }
                }
            }else{
                System.out.println("No country code or country name found.");
            }
        }
    }

    public void init(){

        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < array.length; i++) {
            array[i][0] = countryCodes[i];
            array[i][1] = getMyCountryName(countryCodes[i]);
        }
    }

    //used this to simply get the countryname from the countrycode.
    public String getMyCountryName(String countryCode){
        Locale locale = new Locale("", countryCode);
        return locale.getDisplayCountry();
    }

    //get country name from the countrycode in array as stated in assignment.
    public String getCountryName(String countryCode){
        String countryName="";
        for (int i = 0; i < array.length; i++) {
                if(array[i][0].equalsIgnoreCase(countryCode)){
                    countryName = array[i][1];
                    break;
            }
        }
        return countryName;
    }


    public String getCountryCode(String countryName){
        String countryCode="";
        for (int i = 0; i < array.length; i++) {
            //if countryname is equals to 1st column of array as 0th is for code.
            if(array[i][1].equalsIgnoreCase(countryName)){
                countryCode = array[i][0];
                break;
            }
        }
        return countryCode;
    }

    //matching countries
    public String[] getMatchedCountries(String matchString){
        ArrayList<String> aList = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            //checking if matchedstring is found in 1st column in array which is country name itself
            if(array[i][1].toLowerCase().contains(matchString.toLowerCase())){
                aList.add(array[i][1]+" ("+array[i][0]+")");
            } 
        }
        String[] tempArr = new String[aList.size()]; 
        return (String[]) aList.toArray(tempArr);
    }


}