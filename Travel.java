/*
Richard Clarke
Salesman's Travel
https://www.codewars.com/kata/salesmans-travel/

************************************************************************************************************************************************************
BACKGROUND 
************************************************************************************************************************************************************
A traveling salesman has to visit clients. He got each client's address e.g. "432 Main Long Road St. Louisville OH 43071" as a list.
The basic zipcode format usually consists of two capital letters followed by a white space and five digits. The list of clients to visit was given 
as a string of all addresses, each separated from the others by a comma, e.g. :

"123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".

To ease his travel he wants to group the list by zipcode.
************************************************************************************************************************************************************
TASK
************************************************************************************************************************************************************
The function travel will take two parameters r (addresses' list of all clients' as a string) and zipcode and returns a string in the following format:

zipcode:street and town,street and town,.../house number,house number,...

The street numbers must be in the same order as the streets where they belong.
If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"

************************************************************************************************************************************************************
EXAMPLES
************************************************************************************************************************************************************
r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"

travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"

travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"

travel(r, "NY 5643") --> "NY 5643:/"
*/
import java.util.ArrayList;

public class Travel { 
 public static void main (String[] args) { 
  String addresses = "123 Main Street St. Louisville OH 4307,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville OH 43071";
  String zipcode = "OH 43071";
  travel(addresses, zipcode);
 } 

 public static void travel(String r, String zipcode) {
  ArrayList<String> showMe = new ArrayList<>();
  String address = "";
  ;
  //Confirm zipcode is of proper length 
   if (zipcode.length() != 8)
    System.out.println(zipcode + ":/");

  //Confirm zipcode is in the list r
  //Use a do while loop for extracting data and adding to the list of street numbers and street names while the original list contains the zipcode 
   if (r.contains(zipcode)) {
    do{ 
     
  //See if the address is at the beginning of the list and remove the first address
     if (r.indexOf(zipcode) == r.indexOf(",") - 8){
      address = getAddress(1, r, zipcode);
      r = r.substring(address.length() + 1);
     }

  //See if the address is at the end of the list and remove the last address
     else if ((r.indexOf(zipcode) == r.length() - 8) && (r.charAt(r.length() - 1) != ',')){
      address = getAddress(3, r, zipcode);
      r = r.substring(0, (r.indexOf(address) - 1));
    }

  //See if the address is in the middle of the list and remove it
    else {
     String beforeAddress = "", afterAddress = "";
     address = getAddress(2, r, zipcode);

     beforeAddress = r.substring(0, (r.indexOf(address) - 1));
     afterAddress =r.substring(r.indexOf(address) + address.length());
     r = (beforeAddress + afterAddress);
    }

  //Get the street number and street name of the address
    String streetNumber = getStreetNumber(address);
    String streetName = address.substring((streetNumber.length() + 1), (address.indexOf(zipcode) - 1));
    
    showMe.add(streetNumber + "\n" + streetName);    
    }while(r.contains(zipcode));
   }

   else {
    showMe.add("NO RESULTS");
   }
   
    System.out.println(showMe.size());
    showMe.forEach(addy -> System.out.println(addy + "\n\n"));
 }
 

 public static String getAddress (int option, String list, String zipcode){
  String address = "";
  int commaIndex = 0;
   
   switch (option){
    case(1): commaIndex = list.indexOf(",");
             address = list.substring(0, commaIndex);
             break;

    case(2): list = list.substring(0, list.indexOf(zipcode) + 8);

    case(3): commaIndex = list.lastIndexOf(",");
             address = list.substring(++commaIndex, list.length());
   }
   
  return address;
 }

 public static String getStreetNumber (String address){
  String streetNumber = "";
  int spaceIndex = 0;
  
  spaceIndex = address.indexOf(" ");
  streetNumber = address.substring(0, spaceIndex);

  return streetNumber;
 }
}
