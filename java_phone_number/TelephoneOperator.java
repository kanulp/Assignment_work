import java.util.*;

public class TelephoneOperator {
    public static void main(String[] args) {
        String n="";
        Scanner sc = new Scanner(System.in);
        System.out.println("<Welcoming message to the Telephone Operator program>");
        TelephoneOperator telephoneOperator = new TelephoneOperator();
        while(true) {
            System.out.println("Please enter a telephone number or -1 to exit");
            n = sc.next();
            //int length = (int) (Math.log10(n) + 1);
            int length = n.length();
            if(length==3)
                telephoneOperator.dialPhoneNumber(Integer.parseInt(n));
            else if(length==10){
                String stringNPA = n.substring(0,3);
                int intNPA = Integer.parseInt(stringNPA);
                String stringSN = n.substring(3,length);
                int intSN = Integer.parseInt(stringSN);
                if ((stringSN.charAt(0) == '0') || (stringSN.charAt(0)== '1')) {
                    System.out.println("Wrong local phone number entered !");
                } else {
                    telephoneOperator.dialPhoneNumber(intNPA, intSN);
                }
            }
            else if(length==11){
                String stringCC = String.valueOf(n.charAt(0));
                int intCC = Integer.parseInt(stringCC);
                
                String stringNPA = n.substring(1,4);
                int intNPA = Integer.parseInt(stringNPA);
                String stringSN = n.substring(4,length);
                int intSN = Integer.parseInt(stringSN);
                if ((stringSN.charAt(0) == '0') || (stringSN.charAt(0)== '1')) {
                    System.out.println("Wrong NA long distance phone number entered.");
                } else {
                    telephoneOperator.dialPhoneNumber(intCC,intNPA, intSN);
                }
            }
            else if(length==12){
                String stringAC = n.substring(0, 3);
                int intAC = Integer.parseInt(stringAC);
                System.out.println("HI AC : "+stringAC+" int "+intAC);
                String stringCC = n.substring(3, 6);
                int intCC = Integer.parseInt(stringCC);

                String stringMAC = n.substring(6, 8);
                int intMAC = Integer.parseInt(stringMAC);
                
                String stringSN = n.substring(8,length);
                int intSN = Integer.parseInt(stringSN);
                if ((stringAC.equals("011"))) {
                    telephoneOperator.dialPhoneNumber(intAC,intCC,intMAC, intSN);
                } else {
                    System.out.println("Wrong overseas long distance phone number entered!");
                }
            }
            else if(n.equals("-1"))
                break;
            else 
                System.out.println("Wrong number");
        }
    }

    void dialPhoneNumber(int SpN){
        System.out.println("Dialing special number "+SpN+" ...");
    }
    void dialPhoneNumber(int NPA,int SN){
        StringBuilder sb = new StringBuilder(15);
        StringBuilder temp = new StringBuilder(String.valueOf(NPA+""+SN));
        while (temp.length() < 10)
            temp.insert(0, "0");
        char[] chars = temp.toString().toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (i == 3)
                sb.append(" ");
            else if (i == 6)
                sb.append("-");
            sb.append(chars[i]);
        }
        System.out.println("Dialing local number "+sb.toString()+" ...");
    }
    void dialPhoneNumber(int CC,int NPA,int SN){
    
        StringBuilder sb = new StringBuilder(15);
        StringBuilder temp = new StringBuilder(String.valueOf(NPA+""+SN));
        while (temp.length() < 10)
            temp.insert(0, "0");
        sb.append(CC+" ");
        char[] chars = temp.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 3)
                sb.append(" ");
            else if (i == 6)
                sb.append("-");
            sb.append(chars[i]);
        }
        System.out.println("Dialing NA long distance number "+sb.toString()+" ...");   
    }
    void dialPhoneNumber(int AC,int CC,int MAC,int SN){
       StringBuilder sb = new StringBuilder(15);
       StringBuilder temp = new StringBuilder(String.valueOf("0"+AC+""+CC+""+MAC+""+SN));
       while (temp.length() < 10)
           temp.insert(0, "0");
       
       char[] chars = temp.toString().toCharArray();
       for (int i = 0; i < chars.length; i++) {
            if (i == 3)
               sb.append(" ");
            else if (i == 6)
               sb.append(" ");
            else if (i==8)
                sb.append("-");
           sb.append(chars[i]);
       }
       System.out.println("Dialing overseas long distance phone number "+sb.toString()+" ...");   
   }
}