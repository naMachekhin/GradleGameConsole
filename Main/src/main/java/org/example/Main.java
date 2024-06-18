package org.example;
import org.example.UICustom.Output;
import org.example.UICustom.Input;
import org.example.ScoreSaver.FileReader;
import org.example.ScoreSaver.ScoreMap;
import java.io.IOException;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        FileReader file = new FileReader("..\\ScoreSaver\\src\\main\\resources\\Score.txt");
        ScoreMap score = new ScoreMap(file.get_string_from_file());


        String p_name="";
        while(p_name.isEmpty() || p_name.contains(" "))
            if (!p_name.contains(" "))
                p_name=Input.input_box("Enter your name: ");
            else
                p_name=Input.input_box("Enter your name (without spaces): ");
        Output.skip(2);
        Output.line("Hi, "+p_name+", today we will play a game. " +
                "I memorised a number between 1 and 100, try to guess it!");
        Output.skip(2);


        Random r = new Random();
        int target_number = r.nextInt(100) + 1;
        int player_number=-1;
        int p_score=50;
        String p_input;

        while (player_number!=target_number)
        {
            boolean succes=false;
            do {
                p_input=Input.input_box("Type in number: ");
                try
                {
                    player_number=Integer.parseUnsignedInt(p_input);
                    succes=true;
                }catch (Exception e)
                {
                    succes=false;
                }

            }while (!succes);
            Output.skip(2);
            if(player_number>target_number) {
                p_score=Math.max(0, p_score-1);
                Output.line("My number is smaller than " + player_number);
            }
            if(player_number<target_number) {
                p_score=Math.max(0, p_score-1);
                Output.line("My number is bigger than " + player_number);
            }
        }
        Output.line("You guessed correctly! My number was "+target_number+"!");
        Output.line("Your score for this round is "+p_score+"!");
        if(score.has_name(p_name))
        {
            score.add_score(p_name, p_score+score.get_score(p_name));
            Output.line("Your total score is "+score.get_score(p_name)+"!");
        }else {
            Output.line("Your score is saved.");
            score.add_score(p_name, p_score);
        }
        file.save_string_to_file(score.toString());

        Output.line("Do you want to see scoreboard?");
        p_input=Input.input_box("(y/n): ");
        if(p_input.equals("y") || p_input.equals("Y"))
            Output.line(score.toString());

    }
}