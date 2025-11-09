import java.io.IOException;
//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileReader;
import java.io.FileWriter;
import java.lang.Exception;



class Logger{
    private String path;
    Logger(String path) throws IOException{
        File file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }

        this.path = path;
    }

    public void log(String message){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
              bw.write(message);
        }              
                       
        catch(IOException e){
             System.out.println("IO Caught ");
        }
        catch(Exception e){
             System.out.println("Failed to log this Message : "+ message);
        }
    }
}

public class FileHandling {
    public static void main(String[] args) throws IOException{
        //BufferedWriter bw = null;
       
        //try(  BufferedReader br = new BufferedReader(new FileReader("testing.txt"))){
            //bw = new BufferedWriter(new FileWriter("testing.txt"));
           // bw.write("Hey I Am Writing into the testing.txt using the File Writer \n");
           // bw.write("This to you in the name of the \"Seven Gods \".");
           ;
         //  String ch; 
         //   while((ch = br.readLine()) != null){
          //          System.out.print(ch + "");
          //  }
       //     
//}
       // catch(IOException e){
      //          System.out.println("IO Caught");
       // }
       // catch(Exception e){
       //         System.out.println("Exception Caught");
       // }
       // finally{
       //     //bw.close();
       //    // br.close();
       // }


       Logger lg = new Logger("/home/vighnesh/Desktop/LEARNing/logging.txt");
       lg.log("This is the testing of the Logger Class from the main to able to write in the testing.txt \n that is provided in the path of the COnstructor of the Logger CLass , Without even have to  \n write about the code of the \n  Logger Class that has been already been written by the Autor of the Logger Class ");

        lg.log("This is the testing of the Logger Class from the main to able to write in the testing.txt \n that is provided in the path of the COnstructor of the Logger CLass , Without even have to  \n write about the code of the \n  Logger Class that has been already been written by the Autor of the Logger Class ");
        System.gc();

    }
}
