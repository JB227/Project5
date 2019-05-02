import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HammingDistance extends JFrame{
	
    JPanel LPanel = new JPanel(new GridBagLayout());
    JPanel RPanel = new JPanel(new GridBagLayout());
    JLabel distLabel = new JLabel("Enter Hamming Distance:");
    JTextField distEnter = new JTextField(15);
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 1,4,2);
    JButton ShowStation = new JButton("Show Station");
    JScrollPane scrollPane = new JScrollPane();
    JButton fakeButton = new JButton("SOMETHING CREATIVE! It's unique at least");
    JLabel compWith = new JLabel("Compare with:");
    String[] choices = {"ACME","ADAX","ALTU","ALV2" ,"ANT2" ,"APAC" ,"ARD2" ,"ARNE" ,"BEAV" ,"BESS" ,"BIXB" ,"BLAC" ,"BOIS","BREC","BRIS","BROK","BUFF","BURB","BURN","BUTL","BYAR","CAMA","CARL","CENT","CHAN","CHER" ,"CHEY" ,"CHIC" ,"CLAY" ,"CLOU" ,"COOK" ,"COPA" , 
    		"DURA","ELKC","ELRE","ERIC","EUFA","EVAX","FAIR","FITT","FORA","FREE","FTCB","GOOD","GRA2","GUTH","HASK","HECT","HINT","HOBA","HOLD","HOLL","HOOK","HUGO","IDAB","INOL","JAYX","KENT","KETC","KIN2","LAHO" ,"LANE" ,"MADI" ,"MANG" , 
    		"MARE","MAYR","MCAL","MEDF","MEDI","MIAM","MINC","MRSH","MTHE","NEWK","NEWP","NOWA","NRMN","OILT","OKCE","OKEM","OKMU","PAUL","PAWN","PERK","PORT","PRYO","PUTN","REDR","RING","SALL","SEIL","SEMI","SHAW" ,"SKIA" ,"SLAP" ,"SPEN" , 
    		"STIG","STIL","STUA","SULP","TAHL","TALA","TALI","TIPT","TISH","TULN","VALL","VINI","WAL2","WASH","WATO","WAUR","WEAT","WEBR","WEST","WILB","WIST","WOOD","WYNO","YUKO"};
    JComboBox<String> roller = new JComboBox<String>(choices);
    JButton calcHD = new JButton("Calculate HD");
    JLabel Dist0 = new JLabel("Distance 0");
    JLabel Dist1 = new JLabel("Distance 1");
    JLabel Dist2 = new JLabel("Distance 2");
    JLabel Dist3 = new JLabel("Distance 3");
    JLabel Dist4 = new JLabel("Distance 4");
    JTextField dist0 = new JTextField(10);
    JTextField dist1 = new JTextField(10);
    JTextField dist2 = new JTextField(10);
    JTextField dist3 = new JTextField(10);
    JTextField dist4 = new JTextField(10);
    JButton addStation = new JButton("Add Station");
    JTextField adder = new JTextField();

    public HammingDistance() {

    	super("Hamming Distance"); 
    	this.setSize(700, 820);
    	this.setLayout(new GridLayout(1,2));
    	distEnter.setEditable(false);

    	GridBagConstraints DL = new GridBagConstraints();
    	DL.anchor = GridBagConstraints.NORTHWEST;
    	DL.insets = new Insets(10,10,0,0);
    	DL.gridx = 0;
    	DL.gridy = 0;
    	DL.weighty = 1;
    	DL.weightx = 0.5;
    	LPanel.add(distLabel, DL);
    	
    	DL.fill = GridBagConstraints.HORIZONTAL;
    	DL.weightx = 0.5;
    	DL.gridx = 1;
    	DL.gridy = 0;
    	LPanel.add(distEnter, DL);

    	DL.gridy = 1;
    	DL.gridx = 0;
    	DL.gridwidth = 2;
    	DL.weightx = 1;
    	DL.insets = new Insets(0,50,0,50);
    	slider.setMajorTickSpacing(1);
    	slider.setPaintTicks(true);
    	slider.setPaintLabels(true);
    	LPanel.add(slider, DL);
    	
    	DL.insets = new Insets(0,10,0,0);
    	DL.gridwidth = 1;
    	DL.gridy = 2;
    	DL.weightx = 0;
    	LPanel.add(ShowStation, DL);

    	DL.insets = new Insets(0,10,0,50);
    	DL.gridwidth = 2;
    	DL.ipady = 200;
    	DL.gridy = 3;
    	LPanel.add(scrollPane, DL);

    	DL.ipady = 0;
    	DL.gridy = 4;
    	LPanel.add(compWith, DL);
    	
    	DL.gridx = 1;
    	LPanel.add(roller, DL);
    	
    	DL.gridwidth = 1;
    	DL.gridy = 5;
    	DL.gridx = 0;
    	LPanel.add(calcHD, DL);

    	DL.gridwidth = 2;
    	DL.gridx = 0;
    	DL.gridy = 6;
    	LPanel.add(Dist0, DL);
    	DL.gridy = 7;
    	LPanel.add(Dist1, DL);
    	DL.gridy = 8;
    	LPanel.add(Dist2, DL);
    	DL.gridy = 9;
    	LPanel.add(Dist3, DL);
    	DL.gridy = 10;
    	LPanel.add(Dist4, DL);
    	
    	DL.gridx = 1;
    	DL.gridy = 6;
    	LPanel.add(dist0, DL);
    	DL.gridy = 7;
    	LPanel.add(dist1, DL);
    	DL.gridy = 8;
    	LPanel.add(dist2, DL);
    	DL.gridy = 9;
    	LPanel.add(dist3, DL);
    	DL.gridy = 10;
    	LPanel.add(dist4, DL);
    	
    	DL.gridwidth = 1;
    	DL.gridx = 0;
    	DL.gridy = 11;
    	LPanel.add(addStation, DL);
    	DL.gridx = 1;
    	LPanel.add(adder, DL);
    	
    	GridBagConstraints right = new GridBagConstraints();
    	RPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    	LPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	right.gridheight=0;
    	right.gridwidth=0;
    	right.fill = GridBagConstraints.BOTH;
    	right.weightx = 1;
    	right.weighty = 1;
    	RPanel.add(fakeButton, right);
    	
    	this.add(LPanel, BorderLayout.WEST);
    	this.add(RPanel, BorderLayout.EAST);
    	distEnter.setText(Integer.toString(slider.getValue()));
    	
    	
    	
    	slider.addChangeListener(new ChangeListener() {
    		public void stateChanged(ChangeEvent e) {
    			distEnter.setText(Integer.toString(slider.getValue()));
    		}
    	});
    	
    	calcHD.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			calcHammDist((String)roller.getSelectedItem());
    		}
    	});

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    }
    
    public void calcHammDist(String stID) {
    	int h0 = 0;
    	int h1 = 0;
    	int h2 = 0;
    	int h3 = 0;
    	int h4 = 0;
    	for(int j = 0; j<choices.length; j++) {
    		int count = 0;
    		for(int k = 0; k<4; k++) {
    			if(stID.charAt(k) != choices[j].charAt(k)) {
    				++count;
    			}
    		}
    		if(count == 0) {
    			h0++;
    		}
    		if(count == 1) {
    			h1++;
    		}
    		if(count == 2) {
    			h2++;
    		}
    		if(count == 3) {
    			h3++;
    		}
    		if(count == 4) {
    			h4++;
    		}
    	}
    	dist0.setText(Integer.toString(h0));
    	dist1.setText(Integer.toString(h1));
    	dist2.setText(Integer.toString(h2));
    	dist3.setText(Integer.toString(h3));
    	dist4.setText(Integer.toString(h4));
    }
    
    public void findMatches(String stID, int num) {
    	ArrayList<String> matches = new ArrayList<String>();
    	for(int j = 0; j<choices.length; j++) {
    		int count = 0;
    		for(int k = 0; k<4; k++) {
    			if(stID.charAt(k) != choices[j].charAt(k)) {
    				++count;
    			}
    			if(count == num) {
    				matches.add(choices[j]);
    			}
    		}
    	}
    }
	public static void main (String [] args) {

    new HammingDistance();

	}
}
