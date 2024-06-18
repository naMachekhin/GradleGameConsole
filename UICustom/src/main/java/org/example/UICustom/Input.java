package org.example.UICustom;
import org.example.UICustom.Output;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input{
    public static String input_box(String prompt)
    {
        Scanner scnr=new Scanner(System.in);
        Output.delimeter();
        Output.same_line(prompt);
        String res=scnr.next();
        Output.delimeter();
        return res;

    }
}
