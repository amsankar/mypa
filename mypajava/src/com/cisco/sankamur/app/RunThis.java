package com.cisco.sankamur.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.Scanner;

public class RunThis  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(123);
		
		File parent=new File("C:\\sankar\\collections\\txt");
		
		 
		
		File[] files=parent.listFiles();
		
	 for (int i = 0; i < files.length; i++) {
		 File f=files[i];
		 
		 
		 
		 
		 
		 
		 
		 if (f.isDirectory()) {
			
		}
		 
		 if (f.isFile()) {
			 
			 if(f.exists()){
				 
				 String fileSize="";

					long size = f.length();
					
					if(size>1024) {
						size=size/1024;
						if(size>1024) {
							size=size/1024;
							if(size>1024) {
								size=size/1024;
								if(size>1024) {
									size=size/1024;
									
								}else {
									fileSize=size+" GB";
								}
							}else {
								fileSize=size+" MB";
							}
						}else {
							fileSize=size+" KB";
						}
					}else {
						fileSize=size+" B";
					}
					System.out.println("#####################################################################");
					System.out.println(f.getAbsolutePath()  +": -> : " + fileSize);
					System.out.println("-------------------------------------------------------");
					System.out.println(readFile(f.getAbsolutePath().toString()));
					System.out.println("#####################################################################");
									 
			 }
			 
			
				 
			}
		 
	//	System.out.println(files[i].getTotalSpace());
	}
	}
	
	
	private static String readFile(String pathname)  {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	     


	    try { 
	      	 Scanner scanner = new Scanner(file);
	 	    String lineSeparator = System.getProperty("line.separator");
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	       
	    }  catch(Exception e ) {}
	    
	    return fileContents.toString();
	}

}
