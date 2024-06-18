package org.example.UICustom;

public class Output
{
    public static void delimeter()
    {
        System.out.println("_______________________");
    }

    public static void line(String text)
    {
        System.out.println(text);
    }

    public static void next_line()
    {
        System.out.println();
    }

    public static void same_line(String text)
    {
        System.out.print(text);
    }

    public static void skip(int n)
    {
        for(int i=0; i<n; i++)Output.next_line();
    }
}
