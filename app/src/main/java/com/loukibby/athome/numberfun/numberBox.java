package com.loukibby.athome.numberfun;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by NewMachine on 5/12/2016.
 */
public class numberBox {

    public String[] mainArray = {"1","2","3","4","5","6","7","8",""};
    public String[][] workingArray = new String[3][3];

    public String[][] gameBox(){
        Collections.shuffle(Arrays.asList(mainArray));
        int count = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                count = count +1;
                workingArray[i][j]=mainArray[count-1];
                //System.out.println(workingArray[i][j] + " count");
            }

        }
        System.out.println(count + " test");
        return workingArray;
    }

    public Boolean myNumberBox(String[][] gameBox){
        String[][] standard = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8",""}
        };

        if(Arrays.equals(standard, gameBox)){
            // Do something
            return true;

        }

        return false;
    }
}
