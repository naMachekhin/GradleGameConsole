package org.example;
import org.example.UICustom.Output;
import org.example.UICustom.Input;
import org.example.ScoreSaver.FileReader;
import org.example.ScoreSaver.ScoreMap;

public class Main
{
    public static void main(String[] args)
    {
        FileReader file = new FileReader("..\\ScoreSaver\\src\\main\\resources\\Score.txt");
        ScoreMap score = new ScoreMap(file.get_string_from_file());
        score.add_score("Me", 1234);
        System.out.println(score.toString());
    }
}