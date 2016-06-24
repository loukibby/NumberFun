package com.loukibby.athome.numberfun;

/**
 * Created by NewMachine on 5/6/2016.
 */
public class testNeighbor {
    public int[] xCoords=new int[2];
    public int[] yCoords=new int[2];
    public int rIndex=0;
    public int cIdex=0;


    public testNeighbor(){

    }

    public void findZero(String[][] bName ){
        int a=0; int b=0;

        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                if (bName[i][j].equals("")){
                    this.rIndex=i;
                    this.cIdex=j;
                }
            }
        }

    }

    public  Boolean Match(int mRow, int mCol, int sRow, int sCol){
        if(sRow==mRow){
            if(sCol==mCol+1){
                return true;
            }else if(sCol==mCol-1 ){
                return true;
            }
        }
        if(sCol==mCol){
            if(sRow==mRow+1){
                return true;
            }else if(sRow==mRow-1)
                return true;
        }
        return false;
    }
}
