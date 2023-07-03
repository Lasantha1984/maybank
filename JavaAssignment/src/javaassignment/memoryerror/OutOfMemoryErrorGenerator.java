
package javaassignment.memoryerror;


public class OutOfMemoryErrorGenerator {
    
    public static void main(String[] args) {
        try{
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append("Record : "+i);
        }
        }catch(OutOfMemoryError error){
            error.printStackTrace();
        }
    }
    
}
