import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
public class ResistorDrawer extends Canvas{

	private final Color background = new Color(240,230,140);
	private final Color black = Color.BLACK;
	private final Color brown = new Color(139,69,19);
	private final Color red = Color.RED;
	private final Color orange = Color.ORANGE; 
	private final Color yellow = Color.YELLOW; 
	private final Color green = Color.GREEN; 
	private final Color blue = Color.BLUE;
	private final Color violet = new Color(148,0,211);
	//Gray = grey I WAS affraid that I have mistake in whole project
	private final Color grey = Color.GRAY;
	private final Color white = Color.WHITE; 
	private final Color gold = new Color(218,165,32);
	private final Color silver = new Color(218,165,32);
	private int first,second,third,fourth,fifth,sixth;
	private Color colorFirst,colorSecond,colorThird,colorFourth,colorFifth,colorSixth;
	private Color intToColor(int arg){
		if (arg==0) return black;
		if (arg==1) return brown;
		if (arg==2) return red;
		if (arg==3) return orange;
		if (arg==4) return yellow;
		if (arg==5) return green;
		if (arg==6) return violet;
		if (arg==7) return grey;
		if (arg==8) return white;
		if (arg==9) return white;
		if (arg==10) return gold;
		if (arg==11) return silver;
		else
			return background;
	}
	private void initColor(){
		colorSixth=colorFifth=colorSecond=colorThird=colorFourth=colorFirst=background;
	}
	private void initInts(){
		first=second=third=fourth=fifth=-1;
	}
	public ResistorDrawer() {
		setPreferredSize(new Dimension(480, 400));
		initColor();
		initInts();
	}
	public void setResistor(int first,int second,int third, int fourth, int fifth,
			int sixth){
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
	}
	
		
		
		
	
	private void paintResistor(Graphics graphics){
	
		
		Graphics2D g2 = (Graphics2D)graphics;
		g2.setPaint(background);
		g2.fillRect(230, 140, 20, 20);
		/*Todo Painting
		 * Project the resistor view
		 */
		
		
	}
	public void paint(Graphics graphics) {
		paintResistor(graphics);
		//	paintResistor(graphics);
		
		
		
	}

}
