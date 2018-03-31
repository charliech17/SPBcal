public class FD{

   static double f(double t,double eta,double j) {
		double x=Math.exp(t-Math.exp(-t));
		double ff=x*(1+Math.exp(-t))*Math.pow(x,j)/(1+Math.exp(x-eta));
		return ff;
   }

   //間距 a、b                                  區間     費米能階  算1或2
   static double calFD(double eta,double j) {
	   double a=-15;
	   double b=15;
	   int N=1500;
      double h = (b - a) / N;              // step size
     double sum = 0.5 * (f(a,eta,j) + f(b,eta,j));    // area
      for (int i = 1; i < N; i++) {
         double x = a + h * i;
         sum = sum + f(x,eta,j);
      }
  
      return sum * h/j;
   }
   
   
   }