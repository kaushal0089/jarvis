package in.kkd.programs;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


    public class digitAccess {

        static String extractInt(String str)
        {
            // Replacing every non-digit number
            // with a space(" ")
            str = str.replaceAll("[^\\d]", " ");

            // Remove extra spaces from the beginning
            // and the ending of the string
            str = str.trim();

            // Replace all the consecutive white
            // spaces with a single space
            str = str.replaceAll(" +", " ");

            if (str.equals(""))
                return "-1";

            return str;
        }

        // Driver code
        public static void main(String[] args)
        {
            int total = 0;
            String str = "avbkjd1122klj4 543 af";
            System.out.print(extractInt(str));
            StringTokenizer strToken = new StringTokenizer(extractInt(str)," ");
            while(strToken.hasMoreTokens()){
                String test = strToken.nextToken();
                total = total + Integer.parseInt(test);
            }
            System.out.println("total is "+total);
        }
    }


