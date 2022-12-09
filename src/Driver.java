import java.io.*;

public class Driver {
    public static void main(String[] args){
        final String newLine = System.lineSeparator();
        Cipher fileCipher = new Cipher();
        if(args[0].contains("-e")){
            try{
                File inFile = new File(args[1]);
                File outFile = new File("Encrypted.txt");

                BufferedReader bfRead = new BufferedReader(new FileReader(inFile));
                BufferedWriter bfWrite = new BufferedWriter(new FileWriter(outFile));

                String line = bfRead.readLine();
                while(line != null){
                    fileCipher.set_Plaintext(line);
                    fileCipher.encrypt();
                    String out = fileCipher.get_Ciphertext();
                    bfWrite.write(out + newLine);

                    line = bfRead.readLine();
                    fileCipher = new Cipher();
                }
            }catch(IOException io){
                System.out.println(io.toString());
            }
        }
        else if(args[0].contains("-d")){
            try{
                File inFile = new File(args[1]);
                BufferedReader bfRead = new BufferedReader(new FileReader(inFile));

                File outFile = new File("decrypted.txt");
                BufferedWriter bfWrite = new BufferedWriter(new FileWriter(outFile));

                String line = bfRead.readLine();
                while(line != null){
                    fileCipher.set_Plaintext(line);
                    fileCipher.encrypt();
                    String out = fileCipher.get_Plaintext();
                    bfWrite.write(out + newLine);
                    line = bfRead.readLine();
                    fileCipher = new Cipher();
                }
            }catch(IOException io){
                System.out.println(io.toString());
            }
        }
    }
}
