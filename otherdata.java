//注意 積分算出來是 normallize 的值、課本公式是用非normallize 的
import java.math.BigDecimal;
class otherdata{
		
	
		int A=Main3.a;				
				String Rh[]=new String [A];		
				String L[]=new String[A];
				String ψ[]=new String[A];
				String κe[]=new String[A];
				String β[]=new String[A];
				String κl[]=new String[A];
				String μ0[]=new String[A];
				String n[]=new String[A];
				String mm[]=new String[A];
				String zT[]=new String[A];
				String eM[]=new String[A];
	//fermilavel (p4 getm)
	public String[] calRh(double[] fermilevel,int A,double[] tmp,double[] R,double[] κ,double[] nH,double[] s,double μH[]){
		double k=1.3806504*Math.pow(10,-23.0);
		double k2=8.6173303*Math.pow(10,-5);
		double e=1.602176487*Math.pow(10,-19.0);
		double c=3*Math.pow(10,8);
		double h=6.62607004*Math.pow(10,-34);
		double me=9.10938356*Math.pow(10,-31.0);
		double a=0;

		double f0a,f0b,f0x,f0f,f12a,f12b,f12x,f12f,fm12a,fm12b,fm12x,fm12f,f1a,f1b,f1x,f1f,f2a,f2b,f2x,f2f;

			int sign=0,b=0;
		
		
		
		
		for(int j=0;j<A;j++){
		

	
			FD0 fd0=new FD0();
			FD  fd=new FD();
			FD12 fd12=new FD12();
	
	
	
	
			f0f=fd0.calFD0(fermilevel[j]);
			f1f=fd.calFD(fermilevel[j],1);
			f2f=fd.calFD(fermilevel[j],2);
			f12f=fd12.calFD12(fermilevel[j],0.5);
			fm12f=fd12.calFD12(fermilevel[j],-0.5);
	
				
			
			
				double aa=Math.pow(Math.PI,(0.5));
				double bb=2*me*k/h/h;
			double cc=(3.0/2.0)*aa*aa/2.0*f12f*fm12f/2.0/(Math.pow(f0f,2.0));
			double ee=nH[j]*cc;
			double ii=ee*Math.pow(10,18)/(4*Math.PI*f12f*Math.sqrt(Math.PI)/2.0);
			
			Rh[j]=String.valueOf(cc);
			//μH[j]=String.valueOf(Math.pow(10,-15)*1.0/(R[j]*nH[j]*e));  //前面乘 10^-15 是因為 10^-18(載子濃度在分母)*10^3(單位換算)
			μ0[j]=String.valueOf(μH[j]*2*f0f/(fm12f*Math.sqrt(Math.PI)));
			L[j]=String.valueOf((3.0*f0f*f2f*2-4.0*f1f*f1f)/(f0f*f0f));
			ψ[j]=String.valueOf(e*(8.0/3.0)*Math.PI*f0f*Math.pow(bb,(1.5)));
			κe[j]=String.valueOf(1000*Math.pow(10,5)*tmp[j]*k*k/e/e*Double.valueOf(L[j])/R[j]);
			κl[j]=String.valueOf(κ[j]-Double.valueOf(κe[j])/1000.0);	
			n[j]=String.valueOf(ee);
			eM[j]=String.valueOf(h*h/(2*k*tmp[j])*Math.pow(ii,(2.0/3.0))*Math.pow(10,4));
			
			double dd=Double.valueOf(eM[j])/me;
			mm[j]=String.valueOf(dd);
			β[j]=String.valueOf(Double.valueOf(μ0[j])*Math.pow(dd,1.5)*Math.pow(tmp[j],2.5)/Double.valueOf(κl[j])/10000);  //最後除1萬是因為單位換算
			
			double ff=k*k/e/e*Double.valueOf(L[j]);
			double gg=1.0/(Double.valueOf(ψ[j])*Double.valueOf(β[j]));
			double hh=s[j]*s[j];
			double zTf=hh/(ff+gg)*Math.pow(10,-12);
			zT[j]=String.valueOf(zTf);
			
		}
	
			return Rh;
	
	
}



public String[] getL(){
	return L;
}

public String[] getψ(){
	return ψ;
}

public String[] getμ0(){
	return μ0;
}

public String[] getκe(){
	return κe;
}

public String[] getκl(){
	return κl;
}

public String[] getβ(){
	return β;
}

public String[] getn(){
	return n;
}

public String[] getmm(){
	return mm;
}

public String[] getzT(){
	return zT;
}

public String[] geteM(){
	return eM;
}
	
	}
	
	