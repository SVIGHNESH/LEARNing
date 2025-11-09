// import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.lang.Exception;

public class FileHandling {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            bw = new BufferedWriter(new FileWriter("testing.txt"));
            bw.write("Hey I Am Writing into the testing.txt using the File Writer \n");
            bw.write("This to you in the name of the \"Seven Gods \".");
            br = new BufferedReader(new FileReader("testing.txt"));
            System.out.println(br.readLine());
            
        }
        catch(IOException e){
                System.out.println("IO Caught");
        }
        catch(Exception e){
                System.out.println("Exception Caught");
        }
        finally{
            bw.close();
            br.close();
        }


    }
}
