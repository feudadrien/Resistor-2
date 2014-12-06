
import javax.swing.JList; 


public class ColorChooser{
	public final static String []RESISTOR_BAND_COLORS ={"black","brown","red","orange","yellow","green","blue","violet","grey","white","gold","silver"};
	public final static int MODE_ALL = 0;
	public final static int MODE_TOLERANCE=1;
	public final static int MODE_MULTIPLIER=2;
	public final static int MODE_COEFFICIENT=3;
	private String[] myColors=null;
	private JList colorChooserJlist;
	ColorChooser(int MODE){
		
		if (MODE == MODE_ALL)
		{
			myColors = new String [RESISTOR_BAND_COLORS.length];
			int index = 0;
			
			for (String i : RESISTOR_BAND_COLORS){
				myColors[index] = new String(i);//Deep copy ?? TODO CHECK 
				index++;
			}
		}
		if (MODE == MODE_TOLERANCE){
			
			
		}
		
		
		
		colorChooserJlist = new JList<>(myColors);
	}
	
	public int colorToInt(String color){
		
		for (int i = 0; i < RESISTOR_BAND_COLORS.length;i++){
			if (color.equals(RESISTOR_BAND_COLORS[i]))
				return i;
			
		}
		return -1;
	}
	
	

	String colorToMulti(int arg){
	    if (arg==0) return "1 OHM";                             //black
	    else if (arg ==1) return "10 OHM";                      //brown
	    else if (arg ==2) return "100 OHM";                     //red
	    else if (arg ==3) return "1K OHM";                      //orange
	    else if (arg ==4) return "10K OHM";                     //yellow
	    else if (arg ==5) return "100K OHM";                    //green
	    else if (arg ==6) return "1M OHM";                      //blue
	    else if (arg ==7) return "10M OHM";                     //violet
	    else if (arg ==10) return "0.1 OHM";                    //gold 
	    else if (arg ==11) return "0.01 OHM";                   //silver
	    else return "ERR no such multiplier";   // FU -eq FuckYou there is no such color ;v 
	}

	String colorToTolerance(int arg){
	    if (arg==0) return "(+/-)1 %";                          //black
	    else if (arg ==1) return "(+/-)1 %";                    //brown
	    else if (arg ==2) return "(+/-)1 %";                    //red
	    else if (arg ==5) return "(+/-)0.5 %";                  //green
	    else if (arg ==6) return "(+/-)0.25 %";                 //blue
	    else if (arg ==7) return "(+/-)0.10 %";                 //violet
	    else if (arg ==8) return "(+/-)0.05 %";                 //grey
	    else if (arg ==10) return "(+/-)5 %";                   //gold 
	    else if (arg ==11) return "(+/-)10 %";                  //silver
	    else return "ERR no such tolerance";   // FU -eq FuckYou there is no such color ;v 
	}

	String colorToCoeffcient(int arg){

	    if (arg==0) return "bl";        //black
	    else if (arg ==1) return "100 ppm";  //brown
	    else if (arg ==2) return "50 ppm";  //red
	    else if (arg ==3) return "15 ppm";  //orange
	    else if (arg ==4) return "25 ppm";  //yellow
	    else if (arg ==6) return "10 ppm";  //blue
	    else if (arg ==7) return "5 ppm";  //violet
	    else return "ERR no such Coefficient"; // FU -eq FuckYou there is no such color :D

	}
	
}
