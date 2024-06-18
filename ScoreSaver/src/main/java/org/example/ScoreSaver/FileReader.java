package org.example.ScoreSaver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader {
    private String path;
    public FileReader()
    {
        path="";
    }

    public FileReader(String file_with_score)
    {
        path=file_with_score;
    }
    public String get_string_from_file()
    {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String data="";
            while (myReader.hasNextLine()) {
                data+= myReader.nextLine()+'\n';
            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }

    public void save_string_to_file(String str){
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(str);
            writer.close();
        }catch (IOException e)
        {
            ;
        }



    }



}
