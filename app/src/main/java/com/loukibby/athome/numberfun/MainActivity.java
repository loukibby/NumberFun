package com.loukibby.athome.numberfun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button[][] mButtonArray = new Button[3][3];


    private numberBox chart=new numberBox();
    private String[][] mainChart=chart.gameBox();

   // private gameChart myChart= new gameChart();
    private testNeighbor tNeighbor=new testNeighbor();

    //Got from class on using LogCat
    private final static String LOG_TAG = MainActivity.class.getSimpleName();


    private void fillChart(String[][] Chart){
       //Toast.makeText(getApplicationContext(),"YOU WON",Toast.LENGTH_LONG).show();==true
        String mTest="true";
        Log.i(LOG_TAG, "Win Rec attempt");



        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                mButtonArray[i][j].setText(Chart[i][j]);

            }
        }
    }



    private void findNswitch(int col, int row) {
        tNeighbor.findZero(mainChart);
        //Index ref for empty square
        int nRow = tNeighbor.rIndex;
        int nCol = tNeighbor.cIdex;
        if (tNeighbor.Match(nRow, nCol, col, row)) {
            mainChart[nRow][nCol] = mainChart[col][row];
            mainChart[col][row] = "";
            fillChart(mainChart);
            Log.v(LOG_TAG, "Win info  " + chart.myNumberBox(mainChart) );
            if (chart.myNumberBox(mainChart)){
                Toast.makeText(getApplicationContext(),"YOU WON",Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Cheat = (Button)findViewById(R.id.button);
        Button resetButton =  (Button) findViewById(R.id.shuffle);
        mButtonArray[0][0] = (Button) findViewById(R.id.button1);
        mButtonArray[0][1] = (Button) findViewById(R.id.button2);
        mButtonArray[0][2] = (Button) findViewById(R.id.button3);
        mButtonArray[1][0] = (Button) findViewById(R.id.button4);
        mButtonArray[1][1] = (Button) findViewById(R.id.button5);
        mButtonArray[1][2] = (Button) findViewById(R.id.button6);
        mButtonArray[2][0] = (Button) findViewById(R.id.button7);
        mButtonArray[2][1] = (Button) findViewById(R.id.button8);
        mButtonArray[2][2] = (Button) findViewById(R.id.button9);

        fillChart(mainChart);


        int mN=1; int mC=1;


        mButtonArray[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNswitch(0,0);
            }
        });
        mButtonArray[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(0, 1);
            }
        });
        mButtonArray[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(0, 2);
            }
        });
        mButtonArray[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(1, 0);
            }
        });
        mButtonArray[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(1, 1);
            }
        });
        mButtonArray[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(1, 2);
            }
        });
        mButtonArray[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(2, 0);
            }
        });
        mButtonArray[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(2, 1);
            }
        });
        mButtonArray[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNswitch(2, 2);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fillChart(chart.gameBox());
            }
        }
        );

        Cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myCheat [][] = {{"1","2","3"},{"4","5","6"},{"7","8",""}};
                fillChart(myCheat);
            }
        });
    }
}
