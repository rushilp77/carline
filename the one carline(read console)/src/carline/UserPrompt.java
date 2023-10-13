package carline;
import java.io.*;
/**
 * 
 * @author lancaster
 * @version 9/14/05
 * 
 */
public class UserPrompt {

	private String response;
	private int theInt;
	private double theDouble;
	private InputStreamReader inReader;
	private BufferedReader bReader;
	
	/**
	 * Constructs a UserPrompt and instantiates the readers.
	 */
	public UserPrompt(){
		response="";
		inReader=new InputStreamReader(System.in);
		bReader=new BufferedReader(inReader);
	}
	
	/**
	 * @param question The question to ask the user
	 * @return The user's response
	 */
	public String ask(String question){
	
		try{
			System.out.print(question + ": ");
			response=bReader.readLine();
			return response;			
		} 
		catch(IOException e){
			System.out.println("InputStream error");
			return "Error";
		}
	}
	
	/**
	 * 
	 * @param question The question to ask the user
	 * @return The user's int value
	 */
	public int getInt(String question){
		
		try{
			System.out.print(question + ": ");
			response=bReader.readLine();
			theInt=Integer.parseInt(response);
			return theInt;			
		} 
		catch(IOException e){
			System.out.println("InputStream error");
			return -1;
		}
		catch(NumberFormatException e){
			System.out.println("NOT a Number!");
			return -1;
		}
	}
	
	/**
	 * 
	 * @param question The question to ask the user
	 * @return The user's double value
	 */
	public double getDouble(String question){
		
		try{
			System.out.print(question + ": ");
			response=bReader.readLine();
			theDouble=Double.parseDouble(response);
			return theDouble;			
		} 
		catch(IOException e){
			System.out.println("InputStream error");
			return 0;
		}
		catch(NumberFormatException e){
			System.out.println("NOT a Number!");
			return 0;
		}
	}
		
	public String getResponse(){
		return response;
	}
	
	public int getTheInt(){
		return theInt;
	}
	
	public double getTheDouble(){
		return theDouble;
	}
	
	public String toString(){
		return "Current Response: " + response + ", theInt: " + theInt + ", theDouble: " + theDouble;
	}
}
