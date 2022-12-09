import java.io.*;
import java.lang.StringBuilder;


public class DriverC {
    public static void main(String[] args) {
       Cipher fileCipher = new Cipher();
       if(args[1].equalsIgnoreCase("-e")){
           try{
               File inFile = new File(args[0]);
               File outFile = new File("encrypted.txt");
               BufferedReader bfRead = new BufferedReader(new FileReader(inFile));
               BufferedWriter bfWrite = new BufferedWriter(new FileWriter(outFile));
               String line = bfRead.readLine();
               while(line != null){
                   if(line.length() <= 16){
                       fileCipher.init_StateBlock(line);
                   }else{
                       while(line.length() > 0){

                       }
                   }
               }

           }catch(IOException io){
                System.out.println(io.toString());
           }
       }

       if(args[1].equalsIgnoreCase("-d")){
           try{
               File inFile = new File(args[0]);
               File outFile = new File("decrypted.txt");

               BufferedReader bfRead = new BufferedReader(new FileReader(inFile));
               BufferedWriter bfWrite = new BufferedWriter(new FileWriter(outFile));

               String line = bfRead.readLine();
               while(line != null){
                   fileCipher.set_Ciphertext(line);
                   fileCipher.decrypt();
                   bfWrite.write(fileCipher.get_Plaintext());
                   fileCipher = new Cipher();
                   line = bfRead.readLine();
               }

           }catch(IOException io){
               System.out.println(io.toString());
           }
       }




    }
}



