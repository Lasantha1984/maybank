
package javaassignment.memoryerror;

import java.time.LocalTime;


public class ResolveMemoryErrorWithGC {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        try {
            
            System.out.println(start.toString());

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sb.append("Record : " + i);
                if(i%1000==0){
                  System.gc();
                }
            }
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
        LocalTime end = LocalTime.now();
        System.out.println(end.toString());
        System.out.println("Time Difference is :"+(end.getSecond()-start.getSecond()));
        
    }
}
