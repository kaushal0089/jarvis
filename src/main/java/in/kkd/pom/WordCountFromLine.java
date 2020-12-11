package in.kkd.pom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordCountFromLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String wordToFind = "my";
        int count = 0;
        String[] words= line.split(" ");
        for (int i=0;i<=words.length-1; i++){
            if(words[i].equalsIgnoreCase(wordToFind) == true){
                //System.out.println(words[i]);
                count++;
            }
        }
        System.out.println(wordToFind+" is occured :"+count+"times");
    }
}
