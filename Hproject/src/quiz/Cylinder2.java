package quiz;

public class Cylinder2 {
   
   int  radius1 ;
   int height2 ;
   
   
   double getVolume(int  radius, int height) {
	   radius1 = radius;
	   height2=  height;
	   
	   double v = Math.PI * radius1* radius1* height2;
	   return v;
   }
   double getArea(int radius, int height) {
	   radius1 = radius;
	   height2=  height;
	   double a = Math.PI * radius1 * radius1 * 2 + (2*Math.PI*radius1) *height2;
	
	   return a;
   }
	  
   
   
}
