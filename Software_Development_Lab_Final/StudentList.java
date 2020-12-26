import java.io.*;
import java.text.*;
import java.util.*;


public class StudentList 
{
	// creating static method for invalid arguments that can be used in different places
	public static void showUsage()
	{
		System.out.println("Incorrect parameters. Usage: java StudentList -a | -r | -c | +WORD | ?WORD");
	}

	//Declaring reader and writer outside of methods and making public, so they can be accessed from all methods
	static BufferedReader reader;
	static BufferedWriter writer;

	// Putting all duplicate read/write logic into one method
	public static void fileMethods()
	{
		try 
		{
			 reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			 writer = new BufferedWriter(new FileWriter("students.txt", true));
		}

		catch(Exception ex)
		{
			System.out.println("Could not open a file");
		}
	}

	public static void main(String[] args) 
	{
		//Loads all the files for reading/writing
		fileMethods();

		// Checks for arguments
		// Checks for number of arguments and terminates early if arg number is incorrect

		if(args == null || args.length != 1) 
		{
			showUsage(); // showing message for invalid arguments 
			return; // Early exit
		}

		else if(args[0].equals(Constants.SHOW_ALL)) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				String readString = reader.readLine();
				// spiting same stirng into string array using delimiter of ","
				String words[] = readString.split(Constants.DELIMITER);			
				for(String word : words) 
				{
					 System.out.println(word);
				}
			} 
			catch (Exception ex)
			{
				System.out.println("Could not open file");
			}

			System.out.println("Data Loaded.");
		}

		else if(args[0].equals(Constants.SHOW_RANDOM)) 
		{
			System.out.println("Loading data ...");			
			try 
			{ 
				String readString = reader.readLine();
				System.out.println(readString);
				String words[] = readString.split(Constants.DELIMITER);	
				Random randomGenarator = new Random();
				int random = randomGenarator.nextInt();
				System.out.println(words[2]);
			} 
			catch (Exception ex)
			{
				System.out.println("Could not open file");
			}

			System.out.println("Data Loaded.");			
		}

		else if(args[0].contains(Constants.ADD_WORD))
		{
			System.out.println("Loading data ...");			
			try 
			{
				String subString = args[0].substring(1);
	        	Date date = new Date();
	        	String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				writer.write(", " + subString + "\nList last updated on " + dateFormat.format(date));
				writer.close();
			} 
			catch (Exception ex)
			{
				System.out.println("Could not open file");
			}
							
			System.out.println("Data Loaded.");	
		}

		else if(args[0].contains(Constants.SEARCH_WORD)) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				String readString = reader.readLine();
				String words[] = readString.split(Constants.DELIMITER);	
				
				//boolean done = false;
				String query = args[0].substring(1);
				for(int idx = 0; idx < words.length; idx++) 
				{
					if(words[idx].equals(query)) 
					{
						System.out.println("We found " + query + " at " + idx);
						break;
						//done = true;
					}

					else if(idx == words.length)
					{
						System.out.println(query + " was not found.");
						break;
					}
				}
			} 
			catch (Exception ex)
			{
				System.out.println("Could not open file");
			} 
			
			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains(Constants.SHOW_COUNT)) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				String storedString = reader.readLine();
				String splittedString[] = storedString.split(Constants.DELIMITER);
			
				System.out.println(splittedString.length + " word(s) found ");
			} 
			catch (Exception ex)
			{
				System.out.println("Could not open file");
			} 
			
			System.out.println("Data Loaded.");				
		}
		// when no argument is given
		else
		{
			showUsage(); // printing for invalid arguments
		}
	}
}