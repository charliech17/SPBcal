//���O�覡�A��X�}�C

					//import java.util.Scanner;(��JOptionPane���N)
			
				
import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class project5{

	
	//�~������ܼƶ��]�k�ץ��A���n��[100]
	int abc=100;
	private int[] times=new int[abc];
	private double[] f00=new double[abc];
	private int[] bvalue=new int[abc];
	double[] m=new double[abc];

	
	public String [] cal(int k,double[] Seebeck){
			

		String[] OM=new String[k];
		
	for(int j=1;j<=k;j++){
		
		FD0 fd0=new FD0();
		FD  fd=new FD();
		FD12 fd12=new FD12();
	
	
	
		double s1=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(0.1,1)/fd0.calFD0(0.1)-0.1)));
		double s2=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(0,1)/fd0.calFD0(0)-0)));
		double s3=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(-0.1,1)/fd0.calFD0(-0.1)+0.1)));
		
						
		double s4,s5=0,s6,s7; //s4�Bs5�O�P�_�j�p���̾ڡBs6�Bs7�O�P�_�j���ɰ���C
		double a=0,b=0,c,d; //a�Oreduced fermi energy
		
		double sign=0;
		
		if(s3>s2&&s2>s1){
			sign=1;
			s4=s1;
		}
		if(s1>s2&&s2>s3){
			sign=-1;	
			s4=s3;
		}
		else{
			sign=1;
			s4=s2;
		}
	
	for(int i=0;i<=150;i++){
		b=i*0.1*sign;
		c=b+0.1;
		d=b-0.1;
		s5=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(b,1)/fd0.calFD0(b)-b)));
		if(s5<=s4){
			s4=s5;
			a=b;
			s6=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(c,1)/fd0.calFD0(c)-(c))));
			s7=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(d,1)/fd0.calFD0(d)-(d))));
			
			
			if(s4<s6&&s4<s7){
				break;
			}
			
		}
	}
	
	/*�ˬd�p��᪺"fermi level" �M "��" �O�_���T
	System.out.println(s4);
	System.out.println(a);
	*/
	
	double e=a+0.01;
		double f=a-0.01;
		double g,h,o,l=0; //�p��p���I��ĤT�ĥ|�쪺��
	
		 s7=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(e,1)/fd0.calFD0(e)-e)));
		double s8=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(a,1)/fd0.calFD0(a)-a)));
		double s9=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(f,1)/fd0.calFD0(f)+f)));	
		double s10=0,s11,s12;
		
		if(s9>s8&&s8>s7){
			sign=1;
			s4=s7;
		}
		if(s7>s8&&s8>s9){
			sign=-1;	
			s4=s9;
		}
		else{
			sign=1;
			s4=s8;
		}
		
		for(int i=0;i<=100;i++){
			g=a+0.001*i*sign;
			h=g+0.001;
			o=g-0.001;
			s10=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(g,1)/fd0.calFD0(g)-g)));
			if(s10<=s4){
				s4=s10;
				l=g;
				s11=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(h,1)/fd0.calFD0(h)-h)));
				s12=Math.abs(Seebeck[j-1]-(86.17*(2*fd.calFD(o,1)/fd0.calFD0(o)-o)));
			
			if(s4<s11 && s4<s12){
				break;
			}
			
			}
		}
	/*	�ˬd�p��᪺"fermi level" �M "��" �O�_���T
	System.out.println(s4);
	System.out.println(l);
	*/
	
	 m[j-1]=l;
			
			
	
	 BigDecimal bd= new BigDecimal(m[j-1]);
	 bd=bd.setScale(4, BigDecimal.ROUND_HALF_UP);
	 //String.valueOf(m[j-1])
	 
	 OM[j-1]=String.valueOf(bd.doubleValue()); 
	 
	 times[j-1]=0;
	}
	
		return OM;
	}
	
	public int[] gettimes(){
		
		return times;
	}
	
	public double[] getm(){
		
		return m;
	}
	
	public int[] getbvalue(){
		
		return bvalue;
	}
	
	public double[] getf00(){
		return f00;
	}
	

		

}