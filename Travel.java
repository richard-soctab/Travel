/*
Client's address e.g. "432 Main Long Road St. Louisville OH 43071" as a list.
The basic zipcode format usually consists of two capital letters followed by a white space and five digits. 
The list of clients to visit was given as a string of all addresses, each separated from the others by a comma, e.g. :

"123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".

Group by State and Zipcode

The function travel will take two parameters r 
(addresses' list of all clients' as a string) 
and zipcode and returns a string in the following format:

zipcode:street and town,street and town,.../house number,house number,...

The street numbers must be in the same order as the streets where they belong.
If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"

Examples
r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"

travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"

travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"

travel(r, "NY 5643") --> "NY 5643:/"
-----
Confirm r contains State/Zipcode
 If not, return SS ZZZZZ:/
 If so,
  Get address
  Get Street Number
  Get Street Name
  Determine whether address is at the start, middle, or end of the list r
   Start
   Middle
   End

  Remove address from r
  Output String = "SS ZZZZZ:Street Name1,Street Number1"
Confirm r contains State/Zipcode
 If so,
  Get address
  Get Street Number
  Get Street Name
  Remove address from r
  Output String = "SS ZZZZZ:Street Name1,(add Street Name2)/StreetNumber1,(add Street Name2)"
*/

public class Travel { 
 public static void main (String[] args) { 
  String addresses = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
  String zipcode = "NY 56432";
  System.out.print(travel(addresses, zipcode));
 } 

 public static String travel(String r, String zipcode) {
  //Confirm zipcode is in the list r
   if (r.contains(zipcode + '\0') && r.indexOf('\0') == r.indexOf(zipcode + 8)){
  //Get address
    int addressIndex = r.indexOf(zipcode);
    String address = r.substring(0, (addressIndex + 8));
    return address;

   }
   // do{
  //  String say = "Hellow";
   //  return (("He"));
     //return "It's HERE";
    
   // }while(r.contains(zipcode));
   else
    return zipcode + ":/";
 }
}