class FD12{
	public double calFD12(double eta,double aj){

	double range=8;
	if(eta>0){
		range=Math.sqrt(eta+64);
		}
		
		double h=0.5;
		double nmax=range/h;
		double sum=0;
	if (aj== (-0.5)){
   sum=1.0/(1.0+Math.exp(-eta));
   }
   
for(int i=1;i<nmax;i++){
	
	 double u=i*h;
   double ff=2.0*(Math.pow(u,(2.0*aj+1)))/(1.0+Math.exp(u*u-eta));
   sum=sum+ff;
}

double pol=0.;
int npole=0;

double bk1=0;
while (bk1 <= 14.0*Math.PI){
   npole=npole+1;
   double bk=(2*npole -1)*Math.PI;
   double rho=Math.sqrt(eta*eta+bk*bk);
   double t1=1;
   double t2=0;
   double tk=0;
   if (eta < 0){
     tk=- aj*(Math.atan(-bk/eta)+Math.PI);
   }
   else if (eta ==0){
      tk=0.5*Math.PI*aj;
	  }
   else{
      
      tk=aj*Math.atan(bk/eta);
   }
  double rk=-1.0*Math.pow(rho,aj) ;
    tk=tk+0.5*Math.atan(t2/t1);
   
   if (eta < 0){
      rk= -rk;
   }
   double ak=(2.0*Math.PI/h)*Math.sqrt(0.5*(rho+eta));
    bk1=(2.0*Math.PI/h)*Math.sqrt(0.5*(rho-eta));
   if (bk1 <= (14.0*Math.PI)){
   double gama=Math.exp(bk1);
   t1=gama*Math.sin(ak+tk)-Math.sin(tk);
   t2=1.0-2.0*gama*Math.cos(ak)+gama*gama;
   pol=pol+4.0*Math.PI*rk*t1/t2;
   }
   }
  
  npole=npole-1;
  double fdp=sum*h+pol;
	double PI=0;

  if(aj==0.5){
	  
	 PI=Math.pow(Math.PI,0.5)/(2.0);
  }
  
    if(aj==-0.5){
	  
	 PI=Math.pow(Math.PI,0.5);
  }





return fdp/PI;





}
  
		
		


}