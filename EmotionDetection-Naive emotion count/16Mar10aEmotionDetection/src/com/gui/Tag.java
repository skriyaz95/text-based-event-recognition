/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gui;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.ArrayList;

/**
 *
 * @author Shaik Riyaz
 */
public class Tag {
    public Tag()
            {
                try
                {
                     MaxentTagger tagger = new MaxentTagger(
                "taggers/english-left3words-distsim.tagger");
                     String taggers= tagger.tagString("i dont care what anyone says i like hillary clinton");
                    ArrayList<String> some= new ArrayList<>();
                    System.out.println(taggers);
                     String[] arr= taggers.split("\\W+");
                   //  String some1[]= new String[100000];
                   //  System.out.println(arr[0]+arr[1]);
                        ArrayList<String> list = new ArrayList<String>();  

                        for(int i=0;i<arr.length;i++)
                        {
                            if (arr[i].substring(arr[i].lastIndexOf("_")+1).startsWith("J")||arr[i].substring(arr[i].lastIndexOf("_")+1).startsWith("V"))
                            {
                                list.add(arr[i].split("_")[0]);
                            }
                        }
                        for(int i=0;i<list.size();i++)
                        {
                            System.out.println(list.get(i));
                        }
                                     
                     
 
                }
                catch(Exception e)
                {
                    
                }
            }
    public static void main(String args[])
    {
        Tag tag= new Tag();
    }
}
