package org.example.ScoreSaver;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.*;

public class ScoreMap {
    private TreeMap<String, Integer> score;

    public ScoreMap(String scores) {
        score = new TreeMap<>();
        try{
            String[] lines = scores.split("\n");
            for(int i=0; i<lines.length; i++)
            {
                if(!lines[i].equals(""))
                {
                    String[] parts=lines[i].split(" ");
                    score.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        }catch (Exception e)
        {
            ;
        }
    }

    public void add_score(String name, Integer n)
    {
        score.put(name, n);
    }

    @Override
    public String toString()
    {
        String res="";
        for(String i: score.keySet())
        {
            res+=i+" "+score.get(i).toString()+'\n';
        }
        return res;
    }
}
