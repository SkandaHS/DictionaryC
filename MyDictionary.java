package com.uttara.prjcts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MyDictionary {
		
	public static void wrtWrd(String wFile, String wrd) { 					//Method to write words in the file
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		try
		{
			bw = new BufferedWriter(new FileWriter("D:/Dictionary/"+wFile+".txt",true));
			br = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
			if((br.readLine())!=null) {
			bw.newLine();
			}
			if(wrd!=null) bw.write(wrd+"=");
			else System.out.println("Cannot enter nothing ");
			
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void wrtdeet(String wFile, String dtl) { 					//Method to write details in the file details= meaning+example
		
		BufferedWriter bw = null;
		
		try
		{
			bw = new BufferedWriter(new FileWriter("D:/Dictionary/"+wFile+".txt",true));
			if(dtl!=null) bw.write(dtl);
			else System.out.println("Enter something please");
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}	
	
public static void sortAlph(String wFile) { 					//Method to reading and sorting alphabetically
		
		BufferedReader bw = null;
		String line = null;
		String[] sArr = null;
		String sArrU = null;
		ArrayList<String> word = new ArrayList<String>();
		
		try
		{
			bw = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
			while((line=bw.readLine())!=null) {
				sArr = line.split("=");
			if(sArr[0]!=null) {
				sArrU = sArr[0].toUpperCase();
				word.add(sArrU);
			}
			}
			Collections.sort(word);
			System.out.print(word);
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}	


public static void sortLn(String wFile) { 					//Method to reading and sorting according to string length
	
	BufferedReader bw = null;
	String line = null;
	String[] sArr = null;
	String sArrU = null;
	ArrayList<String> word = new ArrayList<String>();
	
	try
	{
		StringLengthCmp s = new StringLengthCmp();
		bw = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
		while((line=bw.readLine())!=null) {
			sArr = line.split("=");
		if(sArr[0]!=null) {
			sArrU = sArr[0].toUpperCase();
			word.add(sArrU);
		}
		}
		Collections.sort(word,s);
		System.out.print(word);
	}
	catch(IOException e) {
		
		e.printStackTrace();
	}
	finally
	{
		if(bw!=null) {
			try {
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}	


public static void strSearch(String wFile, String find) { 					//Method to search given string and return the number of repetiitons
	
	BufferedReader bw = null;
	BufferedReader bm = null;
	BufferedReader be = null;
	String line = null;
	String line1 = null;
	String line2 = null;
	String[] sArr = null;
	String[] sArr1 = null;
	String[] sArr2 = null;
	
	int countw=0;
	int countm=0;
	int counte=0;
	
	try
	{
	
		bw = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
		
		while((line=bw.readLine())!=null) {							//loop to find string in words
			sArr = line.split("=");
		if(sArr[0]!=null) {
		    if(sArr[0].equalsIgnoreCase(find))
			countw++;
		}
		}
		

		bm = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
		while((line1=bm.readLine())!=null) {							//loop to find string in meaning
			sArr1 = line1.split(":");
			int i=0;
		for(String a: sArr1) {
			if(i==0||i%2==0)
			{
				i++;
			
				continue;
				}
			
			else {
				i++;
			if(a!=null) {
		    if(a.contains(find))
			countm++;
		}
		}
		}
		}
		
		
		be = new BufferedReader(new FileReader("D:/Dictionary/"+wFile+".txt"));
		while((line2=be.readLine())!=null) {							//loop to find string in meaning
			sArr2 = line2.split(":");
			int i=0;
		for(String a: sArr2) {
			if(i==0||i%2!=0)
			{
				i++;
				continue;
				}
			else {
				i++;
			if(a!=null) {
		    if(a.contains(find))
			counte++;
		}
		}
		}
		}
		
		
		System.out.println("'"+find+"'"+" is repeated in words list "+countw+" time/s.");
		System.out.println("'"+find+"'"+" is repeated in meanings list "+countm+" time/s.");
		System.out.println("'"+find+"'"+" is repeated in examples list "+counte+" time/s.");
	}
	catch(IOException e) {
		
		e.printStackTrace();
	
	}
	finally
	{
		if(bw!=null) {
			try {
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}	
	
	//Main method starts from below
	
	public static void main(String args[]) throws IOException {
		
		int ch1=0,ch2=0,ch3=0,ch4=0,ch5=0;
			
		Scanner sc1 = new Scanner(System.in);
				
		
		while(ch1!=3) {
			ch2=0;
			System.out.println("Press 1 to Create a dictionary");
			System.out.println("Press 2 to Load a dictionary");
			System.out.println("Press 3 to Exit a dictionary");
		
		
		while(!sc1.hasNextInt()) {
			System.out.println("Please enter a valid input");
			sc1.next();
		}
		
		ch1 = sc1.nextInt();
		switch(ch1) {
		
		//Creating a dicitonary
		
		case 1:
			String word=null;
			String meaning=null;
			String ex=null;
			String meaningE = null;
			String exE = null;
			String fname=null;
			
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Creating a dictionary");
			System.out.println("Enter the dictionary name: ");
			fname = sc2.next();
			String absFilePath = "D:/Dictionary/"+fname+".txt";
			File file = new File(absFilePath);
			if(file.createNewFile()) {
				System.out.println(fname+" dictionary created ");
			}
			else 
				System.out.println("Chose a differnet name,dictionary aready exists at "+absFilePath);

			
			//If u chose 1, add dictionary
			
			while(ch2!=6) {
				ch3=0;ch4=0;ch5=0;
				System.out.println("Press 1 to Add a word");
				System.out.println("Press 2 to Edit a word");
				System.out.println("Press 3 to Remove a word");
				System.out.println("Press 4 to List the words");
				System.out.println("Press 5 to Search word");
				System.out.println("Press 6 to Go back");
				
				while(!sc1.hasNextInt()) {
					System.out.println("Please enter a valid input");
					sc1.next();
				}
				
				ch2=sc1.nextInt();
				switch(ch2) {

				case 1:
					Scanner scW = new Scanner(System.in);
					System.out.println("Adding a word");
					System.out.println("Enter the word:");
					word = scW.next();				
					wrtWrd(fname,word);	
					
					//if add word is chosen
					
					System.out.println("Chose the part of speech");
					
					while(ch3!=10) {
						System.out.println("Press 1 if the word is a Noun");
						System.out.println("Press 2 if the word is a Verb");
						System.out.println("Press 3 if the word is a Pronoun");
						System.out.println("Press 4 if the word is an Adverb");
						System.out.println("Press 5 if the word is an Adjective");
						System.out.println("Press 6 if the word is a Conjunction");
						System.out.println("Press 7 if the word is an Article");
						System.out.println("Press 8 if the word is a Preposition");
						System.out.println("Press 9 if the word is an Interjection");
						System.out.println("Press 10 to go back");
						
						while(!sc1.hasNextInt()) {
							System.out.println("Please enter a valid input");
							sc1.next();
						}
						
						ch3=sc1.nextInt();
						switch(ch3) {
						
						//After chosing(1 out of 9)  POS enter the meaning and example usage of the word
						
						case 1:
							Scanner scEx1 = new Scanner(System.in);
							Scanner scWM1= new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Noun:");
								meaning = scWM1.nextLine();
								System.out.println("Enter the example use of the word as a Noun");
								ex = scEx1.nextLine();
								String deets = "Noun:"+meaning+":"+ex+"|";
							    wrtdeet(fname,deets);
							}
							break;
							
							
						case 2:
							Scanner scEx2 = new Scanner(System.in);
							Scanner scWM2 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Verb");
								meaning = scWM2.nextLine();
								System.out.println("Enter the example use of the word as a Verb");
								ex = scEx2.nextLine();
								String deets = "Verb:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							
							break;
							
						case 3:
							Scanner scEx3 = new Scanner(System.in);
							Scanner scWM3 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Pronoun");
								meaning = scWM3.nextLine();
								System.out.println("Enter the example use of the word as a Pronoun");
								ex = scEx3.nextLine();
								String deets = "Pronoun:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							break;
							
						case 4:
							Scanner scEx4 = new Scanner(System.in);
							Scanner scWM4 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Adverb");
								meaning = scWM4.nextLine();
								System.out.println("Enter the example use of the word as a Adverb");
								ex = scEx4.nextLine();
								String deets = "Adverb:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							break;
							
						case 5:
							Scanner scEx5 = new Scanner(System.in);
							Scanner scWM5 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Adjective");
								meaning = scWM5.nextLine();
								System.out.println("Enter the example use of the word as a Adjective");
								ex = scEx5.nextLine();
								String deets = "Adjective:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							break;
							
						case 6:
							Scanner scEx6 = new Scanner(System.in);
							Scanner scWM6 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Conjunction");
								meaning = scWM6.nextLine();
								System.out.println("Enter the example use of the word as a Conjunction");
								ex = scEx6.nextLine();
								String deets = "Conjunction:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							break;
							
						case 7:
							Scanner scEx7 = new Scanner(System.in);
							Scanner scWM7 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Article");
								meaning = scWM7.nextLine();
								System.out.println("Enter the example use of the word as a Article");
								ex = scEx7.nextLine();
								String deets = "Article:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
							break;
							
						case 8:
							Scanner scEx8 = new Scanner(System.in);
							Scanner scWM8 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Preposition");
								meaning = scWM8.nextLine();
								System.out.println("Enter the example use of the word as a Preposition");
								ex = scEx8.nextLine();
								String deets = "Preposition:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
						
							break;
							
						case 9:
							Scanner scEx9 = new Scanner(System.in);
							Scanner scWM9 = new Scanner(System.in);
							if(word!=null) {
								System.out.println("Enter the meaning of the word as a Interjection");
								meaning = scWM9.nextLine();
								System.out.println("Enter the example use of the word as a Interjection");
								ex = scEx9.nextLine();
								String deets = "Interjection:"+meaning+":"+ex+"|";
								wrtdeet(fname,deets);
						}
														
							break;
							
						case 10:
							System.out.println("Going back to the previous menu screen");
							break;
							
						default:
							System.out.println("Enter a valid input");
							break;
							
							
						}
						
					
					}
					break;
					
				case 2:
					System.out.println("Editing a word");
					Scanner scEw = new Scanner(System.in);
					System.out.println("Enter the word to Edit");
					
					String edWrd = scEw.nextLine();
					BufferedReader bw = new BufferedReader(new FileReader("D:/Dictionary/"+fname+".txt"));
					String edline = null;
					String sArEd[] = null;
					int counta=0;
					
					while((edline=bw.readLine())!=null) {							
						sArEd = edline.split("=");
					if(sArEd[0]!=null) {
					    if(sArEd[0].equalsIgnoreCase(edWrd))
						counta++;
					}
					}
					
					//when editing is selected
					
					if(counta==1) {
						while(ch4!=3) {
							System.out.println("Press 1 to add semantics");
							System.out.println("Press 2 to remove semantics");
							System.out.println("Press 3 to Exit a dictionary");
						
						
						while(!sc1.hasNextInt()) {
							System.out.println("Please enter a valid input");
							sc1.next();
						}
						
						ch4 = sc1.nextInt();
						switch(ch4) {
						//inside editing menu
						
						case 1:
							System.out.println("Add new semantics");
							
							System.out.println("Chose the part of speech");
							
							while(ch3!=10) {
								System.out.println("Press 1 if the word is a Noun");
								System.out.println("Press 2 if the word is a Verb");
								System.out.println("Press 3 if the word is a Pronoun");
								System.out.println("Press 4 if the word is an Adverb");
								System.out.println("Press 5 if the word is an Adjective");
								System.out.println("Press 6 if the word is a Conjunction");
								System.out.println("Press 7 if the word is an Article");
								System.out.println("Press 8 if the word is a Preposition");
								System.out.println("Press 9 if the word is an Interjection");
								System.out.println("Press 10 to go back");
								
								while(!sc1.hasNextInt()) {
									System.out.println("Please enter a valid input");
									sc1.next();
								}
								
								ch3=sc1.nextInt();
								switch(ch3) {
								
								//After chosing(1 out of 9)  POS enter the meaning and example usage of the word
								
								case 1:
									Scanner scanEx1 = new Scanner(System.in);
									Scanner scanWM1= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Noun:");
										meaningE = scanWM1.nextLine();
										System.out.println("Enter the example use of the word as a Noun");
										exE = scanEx1.nextLine();
										String detls = "Noun:"+meaningE+":"+exE+"|";
									    wrtdeet(fname,detls);
									}
									break;
									
									
								case 2:
									Scanner scanEx2 = new Scanner(System.in);
									Scanner scanWM2 = new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Verb:");
										meaningE = scanWM2.nextLine();
										System.out.println("Enter the example use of the word as a Verb");
										exE = scanEx2.nextLine();
										String details = "Verb:"+meaningE+":"+exE+"|";
									    wrtdeet(fname,details);
									}
									
									break;
									
								case 3:
									Scanner scanEx3 = new Scanner(System.in);
									Scanner scanWM3= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Pronoun:");
										meaningE = scanWM3.nextLine();
										System.out.println("Enter the example use of the word as a Pronoun");
										exE = scanEx3.nextLine();
										String details = "Pronoun:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
									break;
									
								case 4:
									Scanner scanEx4 = new Scanner(System.in);
									Scanner scanWM4= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Adverb:");
										meaningE = scanWM4.nextLine();
										System.out.println("Enter the example use of the word as a Adverb");
										exE = scanEx4.nextLine();
										String details = "Adverb:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
									break;
									
								case 5:
									Scanner scanEx5 = new Scanner(System.in);
									Scanner scanWM5= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Adjective:");
										meaningE = scanWM5.nextLine();
										System.out.println("Enter the example use of the word as a Adjective");
										exE = scanEx5.nextLine();
										String details = "Adjective:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
									break;
									
								case 6:
									Scanner scanEx6 = new Scanner(System.in);
									Scanner scanWM6= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Conjunction:");
										meaningE = scanWM6.nextLine();
										System.out.println("Enter the example use of the word as a Conjunction");
										exE = scanEx6.nextLine();
										String details = "Conjunction:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
									break;
									
								case 7:
									Scanner scanEx7 = new Scanner(System.in);
									Scanner scanWM7= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Article:");
										meaningE = scanWM7.nextLine();
										System.out.println("Enter the example use of the word as a Article");
										exE = scanEx7.nextLine();
										String details = "Article:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
									break;
									
								case 8:
									Scanner scanEx8 = new Scanner(System.in);
									Scanner scanWM8= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Preposition:");
										meaningE = scanWM8.nextLine();
										System.out.println("Enter the example use of the word as a Preposition");
										exE = scanEx8.nextLine();
										String details = "Preposition:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
								
									break;
									
								case 9:
									Scanner scanEx9 = new Scanner(System.in);
									Scanner scanWM9= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Interjection:");
										meaningE = scanWM9.nextLine();
										System.out.println("Enter the example use of the word as a Interjection");
										exE = scanEx9.nextLine();
										String details = "Interjection:"+meaningE+":"+exE+"|";
										wrtdeet(fname,details);
									}
															
									break;
									
								case 10:
									System.out.println("Going back to the previous menu screen");
									break;
									
								default:
									System.out.println("Enter a valid input");
									break;
									
									
								}
								
							
							}
							break;
							
						//end of add semantics in edit
							
						case 2:
							System.out.println("Remove existing semantics");
							System.out.println("Enter the meaning to remove that semantic");
							
							Scanner scM = new Scanner(System.in);
							String mng = scM.nextLine();
							String[] sArM = null;
							String line = null;
							
							BufferedReader bM = new BufferedReader(new FileReader(file));
							File tempFile = new File("D:/Dictionary/"+fname+".tmp");
							tempFile.createNewFile();
							
							BufferedWriter bwTemp = new BufferedWriter(new FileWriter(tempFile, true));
							
							while((line=bM.readLine())!=null) {							
							int i=0;
							if(line.startsWith(edWrd+"=")) {
								sArM = line.split(":");
							for(String a: sArM) {
								if(i==0||i%2==0)
								{
									i++;								
									continue;
									}
								else {
									i++;
								if(a!=null) {
							    if(a.contains(mng)) {
							    	continue;
							    }
							    else {
									bwTemp.write(line);
									bwTemp.newLine();
								}
							}
							}
							}
							}
							}
							bwTemp.flush();
							bM.close();
							bwTemp.close();
							
							file.delete();
							boolean f = tempFile.renameTo(file);
							
							if(f) System.out.println("Semantic removed");
							else System.out.println("Semantic not found");
							
							break;


						case 3:
							System.out.println("Go back to the previous menu");
							break;
						
							
						default:
							System.out.println("Enter valid inputs");
							break;
						}
					}
				}
						else
							System.out.println("Word does not exist");
						break;
				
				case 3:
					System.out.println("Removing a word");
					Scanner scRem = new Scanner(System.in);
					System.out.println("Enter the word");
					String remWrd = scRem.nextLine();
					
					BufferedReader bre = new BufferedReader(new FileReader(file));
					
					File tempFile = new File("D:/Dictionary/"+fname+".tmp");
					tempFile.createNewFile();
					
					BufferedWriter bwTemp = new BufferedWriter(new FileWriter(tempFile, true));
					
					String line = null;
					while((line=bre.readLine())!=null) {
						if (line.startsWith(remWrd+"=")) {
							continue;
						}
						else {
							bwTemp.write(line);
							bwTemp.newLine();
						}
					}
					bwTemp.flush();
					
					bre.close();
					bwTemp.close();
					
					file.delete();
					boolean f = tempFile.renameTo(file);
					
					if(f)
						System.out.println("'"+remWrd+"'"+" has been removed from the dictionary");
					else
						System.out.println("'"+remWrd+"'"+" does not exsist");
					break;
					
				case 4:
					System.out.println("Listing words");
					while(ch5!=3) {
						System.out.println("Press 1 to list words alphabetically");
						System.out.println("Press 2 to list words by word length(ascending)");
						System.out.println("Press 3 to Go back to the main menu");
					
					
					while(!sc1.hasNextInt()) {
						System.out.println("Please enter a valid input");
						sc1.next();
					}
					
					ch5 = sc1.nextInt();
					switch(ch5) {
					//Listing switch
					
					case 1:
						System.out.println("Alphabetical Order");
						sortAlph(fname);
						sortAlph(fname);
						break;
						
					case 2:
						System.out.println("Lengthwise Ascending");
						sortLn(fname);
						break;
						
					case 3:
						System.out.println("Going back to previous menu");
						break;
						
					default:
						System.out.println("Enter a valid input");
						break;
					}
				}
					break;
					
				case 5:
					String fnd=null;
					Scanner search = new Scanner(System.in);
					System.out.println("Seaching the word");
					System.out.println("Enter the word:");
					fnd = search.nextLine();
					strSearch(fname, fnd);;
					
					break;
					
				case 6:
					System.out.println("Going back to main menu");
					break;	
					
				default:
					System.out.println("Enter valid input");
					break;
				}
			}
			break;
			
			
		//Loading dictionary
			
		case 2:
			String meaning1=null;
			String ex1=null;
			String fileld=null;
			
			Scanner scf = new Scanner(System.in);
			System.out.println("Loading dictionary");
			System.out.println("Enter dictionary name:");
			fileld = scf.next();
			String ldFilePath = "D:/Dictionary/"+fileld+".txt";
			File ldfile = new File(ldFilePath);
			if(ldfile.exists()) {
				System.out.println(fileld+" found");
				
				while(ch2!=6) {
					ch3=0;ch4=0;ch5=0;
					System.out.println("Press 1 to Add a word");
					System.out.println("Press 2 to Edit a word");
					System.out.println("Press 3 to Remove a word");
					System.out.println("Press 4 to List the words");
					System.out.println("Press 5 to Search word");
					System.out.println("Press 6 to Go back");
					
					while(!sc1.hasNextInt()) {
						System.out.println("Please enter a valid input");
						sc1.next();
					}
					
					ch2=sc1.nextInt();
					switch(ch2) {

					case 1:
						Scanner scW = new Scanner(System.in);
						System.out.println("Adding a word");
						System.out.println("Enter the word:");
						word = scW.next();				
						wrtWrd(fileld,word);	
						
						//if add word is chosen
						
						System.out.println("Chose the part of speech");
						
						while(ch3!=10) {
							System.out.println("Press 1 if the word is a Noun");
							System.out.println("Press 2 if the word is a Verb");
							System.out.println("Press 3 if the word is a Pronoun");
							System.out.println("Press 4 if the word is an Adverb");
							System.out.println("Press 5 if the word is an Adjective");
							System.out.println("Press 6 if the word is a Conjunction");
							System.out.println("Press 7 if the word is an Article");
							System.out.println("Press 8 if the word is a Preposition");
							System.out.println("Press 9 if the word is an Interjection");
							System.out.println("Press 10 to go back");
							
							while(!sc1.hasNextInt()) {
								System.out.println("Please enter a valid input");
								sc1.next();
							}
							
							ch3=sc1.nextInt();
							switch(ch3) {
							
							//After chosing(1 out of 9)  POS enter the meaning and example usage of the word
							
							case 1:
								Scanner scanEx1 = new Scanner(System.in);
								Scanner scanWM1= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Noun:");
									meaning1 = scanWM1.nextLine();
									System.out.println("Enter the example use of the word as a Noun");
									ex1 = scanEx1.nextLine();
									String detls = "Noun:"+meaning1+":"+ex1+"|";
								    wrtdeet(fileld,detls);
								}
								break;
								
								
							case 2:
								Scanner scanEx2 = new Scanner(System.in);
								Scanner scanWM2 = new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Verb:");
									meaning1 = scanWM2.nextLine();
									System.out.println("Enter the example use of the word as a Verb");
									ex1 = scanEx2.nextLine();
									String details = "Verb:"+meaning1+":"+ex1+"|";
								    wrtdeet(fileld,details);
								}
								
								break;
								
							case 3:
								Scanner scanEx3 = new Scanner(System.in);
								Scanner scanWM3= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Pronoun:");
									meaning1 = scanWM3.nextLine();
									System.out.println("Enter the example use of the word as a Pronoun");
									ex1 = scanEx3.nextLine();
									String details = "Pronoun:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
								break;
								
							case 4:
								Scanner scanEx4 = new Scanner(System.in);
								Scanner scanWM4= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Adverb:");
									meaning1 = scanWM4.nextLine();
									System.out.println("Enter the example use of the word as a Adverb");
									ex1 = scanEx4.nextLine();
									String details = "Adverb:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
								break;
								
							case 5:
								Scanner scanEx5 = new Scanner(System.in);
								Scanner scanWM5= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Adjective:");
									meaning1 = scanWM5.nextLine();
									System.out.println("Enter the example use of the word as a Adjective");
									ex1 = scanEx5.nextLine();
									String details = "Adjective:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
								break;
								
							case 6:
								Scanner scanEx6 = new Scanner(System.in);
								Scanner scanWM6= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Conjunction:");
									meaning1 = scanWM6.nextLine();
									System.out.println("Enter the example use of the word as a Conjunction");
									ex1 = scanEx6.nextLine();
									String details = "Conjunction:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
								break;
								
							case 7:
								Scanner scanEx7 = new Scanner(System.in);
								Scanner scanWM7= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Article:");
									meaning1 = scanWM7.nextLine();
									System.out.println("Enter the example use of the word as a Article");
									ex1 = scanEx7.nextLine();
									String details = "Article:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
								break;
								
							case 8:
								Scanner scanEx8 = new Scanner(System.in);
								Scanner scanWM8= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Preposition:");
									meaning1 = scanWM8.nextLine();
									System.out.println("Enter the example use of the word as a Preposition");
									ex1 = scanEx8.nextLine();
									String details = "Preposition:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
							
								break;
								
							case 9:
								Scanner scanEx9 = new Scanner(System.in);
								Scanner scanWM9= new Scanner(System.in);
								if(word!=null) {
									System.out.println("Enter the meaning of the word as a Interjection:");
									meaning1 = scanWM9.nextLine();
									System.out.println("Enter the example use of the word as a Interjection");
									ex1 = scanEx9.nextLine();
									String details = "Interjection:"+meaning1+":"+ex1+"|";
									wrtdeet(fileld,details);
								}
														
								break;
								
							case 10:
								System.out.println("Going back to the previous menu screen");
								break;
								
							default:
								System.out.println("Enter a valid input");
								break;
								
								
							}
							
						
						}
						break;
						
					case 2:
						System.out.println("Editing a word");
						Scanner scEw = new Scanner(System.in);
						System.out.println("Enter the word to Edit");
						
						String edWrd = scEw.nextLine();
						BufferedReader bw = new BufferedReader(new FileReader("D:/Dictionary/"+fileld+".txt"));
						String edline = null;
						String sArEd[] = null;
						int count=0;
						
						while((edline=bw.readLine())!=null) {							
							sArEd = edline.split("=");
						if(sArEd[0]!=null) {
						    if(sArEd[0].equalsIgnoreCase(edWrd))
							count++;
						}
						}
						
						//when editing is selected
						
						if(count==1) {
						while(ch4!=2) {
							System.out.println("Press 1 to add semantics");
							System.out.println("Press 2 to remove semantics");
							System.out.println("Press 3 to Exit a dictionary");
						
						
						while(!sc1.hasNextInt()) {
							System.out.println("Please enter a valid input");
							sc1.next();
						}
						
						ch4 = sc1.nextInt();
						switch(ch4) {
						//inside editing menu
						
						case 1:
							System.out.println("Add new semantics");
							
							System.out.println("Chose the part of speech");
							
							while(ch3!=10) {
								System.out.println("Press 1 if the word is a Noun");
								System.out.println("Press 2 if the word is a Verb");
								System.out.println("Press 3 if the word is a Pronoun");
								System.out.println("Press 4 if the word is an Adverb");
								System.out.println("Press 5 if the word is an Adjective");
								System.out.println("Press 6 if the word is a Conjunction");
								System.out.println("Press 7 if the word is an Article");
								System.out.println("Press 8 if the word is a Preposition");
								System.out.println("Press 9 if the word is an Interjection");
								System.out.println("Press 10 to go back");
								
								while(!sc1.hasNextInt()) {
									System.out.println("Please enter a valid input");
									sc1.next();
								}
								
								ch3=sc1.nextInt();
								switch(ch3) {
								
								//After chosing(1 out of 9)  POS enter the meaning and example usage of the word
								
								case 1:
									Scanner scanEx1 = new Scanner(System.in);
									Scanner scanWM1= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Noun:");
										meaning1 = scanWM1.nextLine();
										System.out.println("Enter the example use of the word as a Noun");
										ex1 = scanEx1.nextLine();
										String detls = "Noun:"+meaning1+":"+ex1+"|";
									    wrtdeet(fileld,detls);
									}
									break;
									
									
								case 2:
									Scanner scanEx2 = new Scanner(System.in);
									Scanner scanWM2 = new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Verb:");
										meaning1 = scanWM2.nextLine();
										System.out.println("Enter the example use of the word as a Verb");
										ex1 = scanEx2.nextLine();
										String details = "Verb:"+meaning1+":"+ex1+"|";
									    wrtdeet(fileld,details);
									}
									
									break;
									
								case 3:
									Scanner scanEx3 = new Scanner(System.in);
									Scanner scanWM3= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Pronoun:");
										meaning1 = scanWM3.nextLine();
										System.out.println("Enter the example use of the word as a Pronoun");
										ex1 = scanEx3.nextLine();
										String details = "Pronoun:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
									break;
									
								case 4:
									Scanner scanEx4 = new Scanner(System.in);
									Scanner scanWM4= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Adverb:");
										meaning1 = scanWM4.nextLine();
										System.out.println("Enter the example use of the word as a Adverb");
										ex1 = scanEx4.nextLine();
										String details = "Adverb:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
									break;
									
								case 5:
									Scanner scanEx5 = new Scanner(System.in);
									Scanner scanWM5= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Adjective:");
										meaning1 = scanWM5.nextLine();
										System.out.println("Enter the example use of the word as a Adjective");
										ex1 = scanEx5.nextLine();
										String details = "Adjective:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
									break;
									
								case 6:
									Scanner scanEx6 = new Scanner(System.in);
									Scanner scanWM6= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Conjunction:");
										meaning1 = scanWM6.nextLine();
										System.out.println("Enter the example use of the word as a Conjunction");
										ex1 = scanEx6.nextLine();
										String details = "Conjunction:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
									break;
									
								case 7:
									Scanner scanEx7 = new Scanner(System.in);
									Scanner scanWM7= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Article:");
										meaning1 = scanWM7.nextLine();
										System.out.println("Enter the example use of the word as a Article");
										ex1 = scanEx7.nextLine();
										String details = "Article:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
									break;
									
								case 8:
									Scanner scanEx8 = new Scanner(System.in);
									Scanner scanWM8= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Preposition:");
										meaning1 = scanWM8.nextLine();
										System.out.println("Enter the example use of the word as a Preposition");
										ex1 = scanEx8.nextLine();
										String details = "Preposition:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
								
									break;
									
								case 9:
									Scanner scanEx9 = new Scanner(System.in);
									Scanner scanWM9= new Scanner(System.in);
									if(edWrd!=null) {
										System.out.println("Enter the meaning of the word as a Interjection:");
										meaning1 = scanWM9.nextLine();
										System.out.println("Enter the example use of the word as a Interjection");
										ex1 = scanEx9.nextLine();
										String details = "Interjection:"+meaning1+":"+ex1+"|";
										wrtdeet(fileld,details);
									}
															
									break;
									
								case 10:
									System.out.println("Going back to the previous menu screen");
									break;
									
								default:
									System.out.println("Enter a valid input");
									break;
									
									
								}
								
							
							}
							break;
							
						//end of add semantics in edit
							
						/*case 2:
							System.out.println("Remove existing semantics");
							System.out.println("Enter the meaning to remove that semantic");
							
							Scanner scM = new Scanner(System.in);
							String mng = scM.nextLine();
							String[] sArM = null;
							String line = null;
							
							BufferedReader bM = new BufferedReader(new FileReader(ldfile));
							File tempFile = new File("D:/Dictionary/"+fileld+".tmp");
							tempFile.createNewFile();
							
							BufferedWriter bwTemp = new BufferedWriter(new FileWriter(tempFile, true));
							
							while((line=bM.readLine())!=null) {							
							int i=0;
							if(line.startsWith(edWrd+"=")) {
								sArM = line.split(":");
							for(String a: sArM) {
								if(i==0||i%2==0)
								{
									i++;								
									continue;
									}
								else {
									i++;
								if(a!=null) {
							    if(a.contains(mng)) {
							    	continue;
							    }
							    else {
									bwTemp.write(line);
									bwTemp.newLine();
								}
							}
							}
							}
							}
							}
							bwTemp.flush();
							bM.close();
							bwTemp.close();
							
							ldfile.delete();
							boolean f = tempFile.renameTo(ldfile);
							
							if(f) System.out.println("Semantic removed");
							else System.out.println("Semantic not found");
							
							break;*/


						case 2:
							System.out.println("Go back to the previous menu");
							break;
						
							
						default:
							System.out.println("Enter valid inputs");
							break;
						}
					}
				}
						else
							System.out.println("Word does not exist");
						break;
					
					case 3:
						
						System.out.println("Removing a word");
						Scanner scRem = new Scanner(System.in);
						System.out.println("Enter the word");
						String remWrd = scRem.nextLine();
						
						BufferedReader bre = new BufferedReader(new FileReader(ldfile));
						
						File tempFile = new File("D:/Dictionary/"+fileld+".tmp");
						tempFile.createNewFile();
						
						BufferedWriter bwTemp = new BufferedWriter(new FileWriter(tempFile, true));
						
						String line = null;
						while((line=bre.readLine())!=null) {
							if (line.startsWith(remWrd+"=")) {
								continue;
							}
							else {
								bwTemp.write(line);
								bwTemp.newLine();
							}
						}
						bwTemp.flush();
						
						bre.close();
						bwTemp.close();
						
						ldfile.delete();
						boolean f = tempFile.renameTo(ldfile);
						
						if(f)
							System.out.println("'"+remWrd+"'"+" has been removed from the dictionary");
						else
							System.out.println("'"+remWrd+"'"+" does not exsist");
						break;
						
					case 4:
						System.out.println("Listing words");
						while(ch5!=3) {
							System.out.println("Press 1 to list words alphabetically");
							System.out.println("Press 2 to list words by word length(ascending)");
							System.out.println("Press 3 to Go back to the main menu");
						
						
						while(!sc1.hasNextInt()) {
							System.out.println("Please enter a valid input");
							sc1.next();
						}
						
						ch5 = sc1.nextInt();
						switch(ch5) {
						//Listing switch
						
						case 1:
							System.out.println("Alphabetical Order");
							sortAlph(fileld);
							break;
							
						case 2:
							System.out.println("Lengthwise Ascending");
							sortLn(fileld);
							break;
							
						case 3:
							System.out.println("Going back to previous menu");
							break;
							
						default:
							System.out.println("Enter a valid input");
							break;
						}
					}
						break;
						
					case 5:
						String fnd=null;
						Scanner search = new Scanner(System.in);
						System.out.println("Seaching the word");
						System.out.println("Enter the word:");
						fnd = search.nextLine();
						strSearch(fileld,fnd);
						break;
						
					case 6:
						System.out.println("Going back to main menu");
						break;	
						
					default:
						System.out.println("Enter valid input");
						break;
					}
				}
				break;
			}
			else
				System.out.println(fileld+" does not exist.");
			break;
			
			//end of load switch

		case 3:
			System.out.println("Exiting BYe");
			break;
			
		default:
			System.out.println("Please enter a valid input");
			break;
			}
			}
		sc1.close();
		}

	}


