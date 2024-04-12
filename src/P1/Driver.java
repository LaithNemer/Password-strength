package P1;
import java.util.*;

public class Driver {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Password");
		String password=input.nextLine();
		if(password.length()<=8) {
			System.out.println("Password is not accsept ...password must be more than 8 digit\n try agian ");
			System.exit(0);
			
		}
		else {
			System.out.println("password is accsept");
		}
		
		String strength=StrengthOfPassword(password);
	;
		System.out.println("Strength password is : " + strength);
		System.out.println("choice one\n1.See the roule\n2.does not see ");
		int n=input.nextInt();
		if(n==1) {
			System.out.println("the roule is :\n1.Strrong if password have\na.number\nb.upper case\nc.lower case\nd.speical Character\ne.varnice more than 500 and Entropy is more than 3\n\n2.mediam must have all rule in strog password but varnice is less than 500 and Entropy is less than 3\n\n3.Weak if any roule in strong does not exit and u can see using code        ");
		}
		

	
		
		
		
	
	}
	public static String StrengthOfPassword(String password) {
		boolean haveNumber=haveNumber(password);
		boolean haveUpperCase=haveUpperCase(password);
		boolean haveLowerCase=haveLowerCase(password);
		boolean haveSpeicalCharcter=haveSpecialCharacter(password);
		double Varnice=calculateVariance(password);
		double Entropy=calculateEntropy(password);
		
		if(haveNumber&& haveUpperCase&& haveLowerCase&& haveSpeicalCharcter) {
			if(Varnice>=500&& Entropy>=3) {
				System.out.println("Entropy = " + calculateEntropy(password));
				System.out.println("Varince = " + calculateVariance(password));
				return "Strong";
			}else {
				System.out.println("Entropy = " + calculateEntropy(password));
				System.out.println("Varince = " + calculateVariance(password));
				return "Medium";
			}
			
		}else {
			return "Weak";
		}
		
	
		
		
		
		
	}
	
	public static double calculateVariance(String password) {
		double sum=0;
		double mean=calculateMean(password);
		for(int i=0;i<password.length();i++) {
			double value=password.charAt(i);
			double diffrence=value-mean;
			sum=sum+Math.pow(diffrence, 2);
			
		}
		return sum/password.length();
		
		

	}
	
	public static double calculateMean(String password) {
		double sum=0;
		for(int i=0;i<password.length();i++) {
			char characte=password.charAt(i);
			sum=sum+characte;
			
			
		}
		return sum/password.length();
	}

	 private static double calculateEntropy(String password) {
	        int uniqueChars = (int) password.chars().distinct().count();
	        return Math.log(uniqueChars) / Math.log(2);
	        
	    }
	  
	  public static boolean haveNumber(String password) {
		  for(int i=0;i<password.length();i++) {
			  int character=password.charAt(i);
			 
			  if(character>=48&&character<=57) {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public static boolean haveUpperCase(String password) {
		  String sum="";
		  int y=-1;
		  for(int i=0;i<password.length();i++ ) {
			  int character=password.charAt(i);
			  if(character>=65&& character<=90) {
				  sum=sum+character;
				 y=1;
			  }
		  }
		  
		  
		  if(y==1){
			 return true; 
		  }
		  return false;
	  }
	  
	  public static boolean haveLowerCase(String password) {
		  
		  for(int i=0;i<password.length();i++) {
			  int character=password.charAt(i);
			  if(character>=97&& character<=122) {
				 return true;
			  }
		  }
		  return false;
	  }
	  public static boolean haveSpecialCharacter(String password) {
		  for(int i=0;i<password.length();i++) {
			  int character=password.charAt(i);
			  if(character>=91&&character<=96 || character<65|| character>=123) {
				  return true;
			  }
		  }
		  return false;
	  }
}
