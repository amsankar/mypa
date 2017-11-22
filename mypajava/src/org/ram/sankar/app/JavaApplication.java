package org.ram.sankar.app;

import java.util.*;

public class JavaApplication {

	public static int[] dashsize = { 50, 150 };

	public static String[][] dashcontent = new String[dashsize[0]][dashsize[1]];
	
	public static String widgetborderhr="-";
	public static String widgetbordervr="|";

	public static void main(String[] arg) {
		header();
		displaydash();
		
		hrline();
		 getInputValue();

		//updatedash("phone", "Sankar Murugesan 9972315212   dsafsa fsa f sa fsa f sa f sa f sa df sa fsa df sa fsa f asd fdas fa sdf sad fdsafsadfdsafdsafdsa f");
		updatewidgetcontent("name", "Sankar Murugesan");
		updatewidgetcontent("email", "amsankar@gmail.com");
		updatewidgetcontent("phone", "9972315212");
		
		refreshDashDisplay();

		  getInputValue();

	}

	private static void getInputValue() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your Name: ");
		String name = scanner.nextLine();
		
		updatewidgetcontent("name", name);
		
		refreshDashDisplay();

		System.out.print("Enter your options - 'exit' to exit: ");
		String options = scanner.nextLine();
		
		if(options.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		
		
		 getInputValue();
		 
	}
	
	public static void hrline() {
		String line="";
		for (int i = 0; i < dashsize[1]; i++) {
			line=line+"-";
		}
		System.out.println(line);
	}

	public static void header() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");

		}

		 

		for (int i = 0; i < dashsize[0]; i++) {
			for (int j = 0; j < dashsize[1]; j++) {
				dashcontent[i][j] = " ";
				
				if (j==0 || j==dashsize[1]-1) {
					dashcontent[i][j] = "|"; 
				}

			}

		}

		hrline();
		System.out.println(
				"|     Sankar Murugesan       9972315212      amsankar@gmail.com     |                                                  "
						+ new Date() + "  |");
		hrline();

	}

	public static void dashboardblank()

	{

		for (int i = 0; i < 50; i++) {
			System.out.println(
					"|                                                                                                                                                        |");

		}

	}

	public static void displaydash()

	{

		for (int i = 0; i < dashsize[0]; i++) {
			for (int j = 0; j < dashsize[1]; j++) {
				System.out.print(dashcontent[i][j]);

			}
			System.out.println("");

		}

	}

	public static void updatedash(String widget, String content)

	{

		int[] intaxis = getWidgetCoordinates(widget); 
		writeBorderForWidgetOnDash(intaxis); 
		writeContentForWidgetOnDash(intaxis, content);

		for (int i = 0; i < dashsize[0]; i++) {
			for (int j = 0; j < dashsize[1]; j++) {
				System.out.print(dashcontent[i][j]);

			}
			System.out.println("");

		}

	}
	
	
	public static void refreshDashDisplay()

	{ 

		for (int i = 0; i < dashsize[0]; i++) {
			for (int j = 0; j < dashsize[1]; j++) {
				System.out.print(dashcontent[i][j]);

			}
			System.out.println("");

		}

	}
	
	
	public static void updatewidgetcontent(String widget, String content)

	{

		int[] intaxis = getWidgetCoordinates(widget); 
		writeBorderForWidgetOnDash(intaxis); 
		writeContentForWidgetOnDash(intaxis, content); 
	}

	private static void writeBorderForWidgetOnDash(int[] intaxis) {
		
		

			
				for (int i = intaxis[0]; i < intaxis[2]; i++) { 
					for (int j = intaxis[1]; j < intaxis[3]; j++) { 
				dashcontent[i][j] = " "; 
				
				if (i==intaxis[0] || i==intaxis[2]-1 ) {
					dashcontent[i][j] = widgetborderhr; 
				}				
				
				if (j==intaxis[1] || j==intaxis[3]-1 ) {
					dashcontent[i][j] = widgetbordervr; 
				}
				
			}

		}
	}
	
	
	private static void writeContentForWidgetOnDash(int[] intaxis,String content) {
		int contentIndex=0;
		int margin = getDynamicMargin(intaxis, content);
		
	//	System.out.println("widget content : "+ content.length());
	//	System.out.println("widget margin : "+ margin);
			for (int i = intaxis[0]+margin; i < intaxis[2]-(margin); i++) { 
				for (int j = intaxis[1]+margin; j < intaxis[3]-(margin); j++) { 
			dashcontent[i][j] = " ";  
			
			if (content.length()> contentIndex) {
				dashcontent[i][j] = content.substring(contentIndex, contentIndex+1); 
			}				
			
			contentIndex++;
			
			}
		}

	 
 
	}

	private static int getDynamicMargin(int[] intaxis, String content) {
		int margin=1;
		
		int widwidth=intaxis[3]-intaxis[1];
		int widheight=intaxis[2]-intaxis[0];
		
		
		
		for (int i = 2; i < 10; i++) {
			if ((widwidth-(i*2)>0) && (widheight-(i*2)>0) ){
				if((content.length()-1)<((widwidth-(i*2)) * (widheight-(i*2)) )) {
					margin=i;
				}
			}
		}
		
 
		
		return margin;
	}

	private static int[] getWidgetCoordinates(String widget) {
		String coordinates = (String) getwidgets().get(widget);
		
		String[] axis=coordinates.split("\\s*,\\s*");
		int[] intaxis=new int[4];
		 
		for (int i = 0; i < axis.length; i++) {
			intaxis[i]=Integer.parseInt(axis[i]); 
		}
		return intaxis;
	}

	public static Map getwidgets()

	{

		HashMap widgets = new HashMap(); 
		widgets.put("name", "0,0,5,30");
		widgets.put("phone", "0,30,5,45");
		widgets.put("email", "0,45,5,70"); 
		return widgets;
	}

}