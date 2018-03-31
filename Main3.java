import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

class Main3{
	private JFrame f;
	private JLabel lb1,lb2,lb3;
	private JTextField tf1,tf2,tf3;
	private JButton btn1,btn2,btn3,btn4;
	private JTable t1;
	public static int a;
	
	public Main3(){
		
		
		f=new JFrame("SPBcal");
	JPanel panel = new JPanel();
		
		//f.getContentPane().setBackground(Color.WHITE);  
		f.getContentPane().setForeground(Color.GRAY);
		lb1=new JLabel("How many temperature to calculate?");
		lb1.setBounds(5,10,250,20);
		f.add(lb1);
		
		
		tf1=new JTextField("1");
		tf1.setBounds(230,10,80,20);
		f.add(tf1);
		
		
		
		btn1=new JButton("Enter");
		btn1.setBounds(320,10,70,20);
		f.add(btn1);
//輸入後的反應
try{
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				
				btn1.setEnabled(false);
				int A=Integer.parseInt(tf1.getText()); 
				a=A;
				
			if(!(A>0)||A>20){
					
					 JOptionPane.showMessageDialog(panel, "Please enter: 1~20", "Error", JOptionPane.ERROR_MESSAGE);
					 btn1.setEnabled(true);
				}
				
			else{
				String tmp[]= {"T1","T2","T3","T4","T5","T6","T7","T8","T9","T10","T11","T12","T13","T14","T15","T16","T17","T18","T19","T20"};
				String[] parameter={" Temperature(K)"," Seebeck(μV/K)","nH(10^(18)cm-3)","  resistivity(mΩ-cm)","      κ(W/mK)", "  μH(cm^2/V*s)"};
				
				JTextField[] jtf1=new JTextField[tmp.length];
				JTextField[] jtf2=new JTextField[tmp.length];
				JTextField[] jtf3=new JTextField[tmp.length];
				JTextField[] jtf4=new JTextField[tmp.length];
				JTextField[] jtf5=new JTextField[tmp.length];
				JTextField[] jtf6=new JTextField[tmp.length];
				
				JLabel[] tmps = new JLabel[tmp.length];
				JLabel[] pm = new JLabel[parameter.length];
		
				
				
				
		for(int i = 0; i <=5; i++){
			pm[i]=new JLabel(parameter[i]);
			pm[i].setBounds((100+130*i),35,150,20);
			f.add(pm[i]);
		}
		
				
		for (int i = 0; i < A; i++)
		{
			tmps[i] = new JLabel( tmp[i] );
			tmps[i].setBounds(5,(60+i*25),100,20);
			
			jtf1[i]=new JTextField("0");
			jtf2[i]=new JTextField("0");
			jtf3[i]=new JTextField("0");
			jtf4[i]=new JTextField("0");
			jtf5[i]=new JTextField("0");
			jtf6[i]=new JTextField("0");
			
			jtf1[i].setBounds(110,(60+i*25),70,20);
			jtf2[i].setBounds(240,(60+i*25),70,20);
			jtf3[i].setBounds(370,(60+i*25),70,20);
			jtf4[i].setBounds(500,(60+i*25),70,20);
			jtf5[i].setBounds(630,(60+i*25),70,20);
			jtf6[i].setBounds(760,(60+i*25),70,20);
			
			f.add(tmps[i]);
			f.add(jtf1[i]);
			f.add(jtf2[i]);
			f.add(jtf3[i]);
			f.add(jtf4[i]);
			f.add(jtf5[i]);
			f.add(jtf6[i]);
			f.setSize(880,(200+i*25));
	}
				btn3=new JButton("Calculate SPB transport parameters");
				btn3.setBounds(70,(90+(A-1)*25),345,40);
				f.add(btn3);
				btn3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e3){
						  long startTime = System.currentTimeMillis(); //計算時間
						
						DefaultTableModel model = new DefaultTableModel();
						JTable table = new JTable(model);
		
						project5 p5=new project5();
						otherdata od=new otherdata();
						
						double[] SeebeckCovert=new double[A];
						String[] temperatureCovert=new String[A];
						double[] temperatureCovert2=new double[A];
						double[] carrierconcentration=new double[A];
						double[] TC=new double[A];
						double[] μH=new double[A];
						double[] r=new double[A];
						double[] m=p5.getm();
						int[] t=p5.gettimes();
						int[] bv=p5.getbvalue();
						
						
						for(int i=0;i<A;i++){
							SeebeckCovert[i]=Math.abs(Double.valueOf(jtf2[i].getText()));
							temperatureCovert[i]=String.valueOf(jtf1[i].getText());
							temperatureCovert2[i]=Double.valueOf(jtf1[i].getText());
							carrierconcentration[i]=Math.abs(Double.valueOf(jtf3[i].getText()));
							r[i]=Double.valueOf(jtf4[i].getText());
							TC[i]=Double.valueOf(jtf5[i].getText());
							μH[i]=Double.valueOf(jtf6[i].getText());
							
						}
						boolean b=true;
						for(int i=0;i<A;i++){
						if(SeebeckCovert[i]<19 || SeebeckCovert[i]>1464){	
							 
	 JOptionPane.showMessageDialog(panel, "Please enter Seebeck coefficient value within 19~1464 μV/K", "Error", JOptionPane.ERROR_MESSAGE);
	  b=false;
	  break;
	  }
						}
						
					if(b==true){	
						model.addColumn("Temperature(K)",temperatureCovert);
						model.addColumn("reduced fermi energy",p5.cal(A,SeebeckCovert));
						model.addColumn("Hall factor",od.calRh(p5.getm(),A,temperatureCovert2,r,TC,carrierconcentration,SeebeckCovert,μH));
						model.addColumn("n (10^18 cm^(-3))",od.getn());
						model.addColumn("effective mass (Kg)",od.geteM());
						model.addColumn("m*/m0",od.getmm());
						model.addColumn("μ0(cm^(2)/(Vs))",od.getμ0());
						model.addColumn("Lorenz number((kB/e)^2)",od.getL());
						model.addColumn("ψ CK^(-3/2)m^(-3)",od.getψ());			
						model.addColumn("κe(mW/mK)",od.getκe());
						model.addColumn("κL(W/mK)",od.getκl());
						model.addColumn("β(m^(3)*K^(7/2)/(W*V*s))",od.getβ());
						model.addColumn("zT",od.getzT());
						
						JFrame f2 = new JFrame("TE parameter Tabel");
    f2.setSize(1200, 150);
    f2.add(new JScrollPane(table));
    f2.setVisible(true);
	
	f2.setDefaultCloseOperation(f2.DISPOSE_ON_CLOSE);
			long endTime = System.currentTimeMillis();
			long totTime = endTime - startTime;
			
System.out.println(totTime);
			}	
						
					}
				});
	
	
				btn4=new JButton("Renew number of Temperature");
				btn4.setBounds(435,(90+(A-1)*25),345,40);
				f.add(btn4);
				btn4.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e2){
					for(int i=0;i<A;i++){
						f.remove(jtf1[i]);
						f.remove(jtf2[i]);
						f.remove(jtf3[i]);
						f.remove(jtf4[i]);
						f.remove(jtf5[i]);
						f.remove(jtf6[i]);
						f.remove(tmps[i]);
						
					}
					for(int i = 0; i <pm.length; i++){
						f.remove(pm[i]);
					}
					
					f.remove(btn3);
					f.remove(btn4);
					f.setSize(430,100);
					btn1.setEnabled(true);
					
				}
		
		
		
		});		
			}
			}
		
//重新輸入的按鈕
			
				
		});
		

}
catch(Exception e){
	JOptionPane.showMessageDialog(panel, "Please close the window and restart the program", "Error", JOptionPane.ERROR_MESSAGE);
	
}
		
////////////////////////////////////////////////沒有null會跑出奇怪的格式 、且以下四行要把在最後不然無法顯示///////////////////////////////////////////////////////////
	
		
		
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(430,100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				
				
			
	}
	


	
	
	public static void main(String arg[]){
		
		new Main3();
	}
	
	
	
	
	
}