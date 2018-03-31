---------------------
SPBcal Program manual
---------------------


　We develop an algorithm called SPBcal under Java SE runtime environment 1.8.0_131 to calculate transport parameters of thermoelectric materials within the framework of single parabolic band (SPB) model. The following are some instructions, which contain a breif introduction to every files in the program, program Installation and program excution.

### *Program Introduciton ###

　There are six files in the program named "FD0.java","FD.java","FD12.java","program5.java","otherdata.java" and "Main3.java". The first three file is to calculate Fermi-Dirac Integral zero, integer and half integer values. "program5.java" is to determine reduced Fermi energy, "otherdata.java" is to calculate other ten related SPB transport parameters and "Main3.java" is to make integration of other files to build up Graphical interface.


### *Program Installation ###

　 The program installation is divided into two parts: 1. install java JRE 　2.install SPBcal program.

　　1. Install java JRE

　　　　java JRE can be downloaded here: [http://www.oracle.com/technetwork/java/javase/downloads/jre9-downloads-3848532.html](http://www.oracle.com/technetwork/java/javase/downloads/jre9-downloads-3848532.html)
　　　　

　　　　JRE download tutorial: [https://www.youtube.com/watch?v=z4c0YMtzxP0](https://www.youtube.com/watch?v=z4c0YMtzxP0) 

　　2. Install SPBcal program 

　　　　Our SPBcal program can be download edhere: [https://github.com/charliech17/SPBcal/releases](https://github.com/charliech17/SPBcal/releases)  (Note that the java JRE version on your computer should be higer or equal to 1.8_131. If you can not run SPBcal, please update the java JRE in your computer to higer version.)

### *Program Execution ###
   
　　1. Double click the SPBcal.jar, then you will see "How many temperatures are there to calculate?". Enter a number within 1~20 and click "enter" button to generate input text fields.

　　2. Enter the Seebeck coefficients (19~1464 uV/K) in the input text fields, then click "Calculate SPB transport parameters", the program will generate a table containing SPB parameters.
　　

　　3. Use "ctrl-C" and "ctrl-V" to copy the SPB transport parameters to Excel, then you can use these data for analysis, comparison, plotting graphs or some other uses.
　


### *Encounter problems? ###


　if you have any other problems about the Program, Please contact me.
 **my email address: charliech17@yahoo.com.tw 　or 　 
kobeisthebest8@gmail.com  


 
　　 





