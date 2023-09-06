package com.example.code;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    //initialize variables special code
    EditText etinput,etoutput;
    Button btnEncode,btnDecode,btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        etinput=findViewById(R.id.editview3);
        etoutput=findViewById(R.id.editview4);
        btnDecode=findViewById(R.id.btndecode1);
        btnEncode=findViewById(R.id.btnencoder1);
        btnclear=findViewById(R.id.btn1);


        final String[] AlphaNumeric =new String[37];
        final String[] AlphaNumeric1 =new String[37];


        AlphaNumeric[0]="A";
        AlphaNumeric[1]="B";
        AlphaNumeric[2]="C";
        AlphaNumeric[3]="D";
        AlphaNumeric[4]="E";
        AlphaNumeric[5]="F";
        AlphaNumeric[6]="G";
        AlphaNumeric[7]="H";
        AlphaNumeric[8]="I";
        AlphaNumeric[9]="J";
        AlphaNumeric[10]="K";
        AlphaNumeric[11]="L";
        AlphaNumeric[12]="M";
        AlphaNumeric[13]="N";
        AlphaNumeric[14]="O";
        AlphaNumeric[15]="P";
        AlphaNumeric[16]="Q";
        AlphaNumeric[17]="R";
        AlphaNumeric[18]="S";
        AlphaNumeric[19]="T";
        AlphaNumeric[20]="U";
        AlphaNumeric[21]="V";
        AlphaNumeric[22]="W";
        AlphaNumeric[23]="X";
        AlphaNumeric[24]="Y";
        AlphaNumeric[25]="Z";
        AlphaNumeric[26]="0";
        AlphaNumeric[27]="1";
        AlphaNumeric[28]="2";
        AlphaNumeric[29]="3";
        AlphaNumeric[30]="4";
        AlphaNumeric[31]="5";
        AlphaNumeric[32]="6";
        AlphaNumeric[33]="7";
        AlphaNumeric[34]="8";
        AlphaNumeric[35]="9";
        AlphaNumeric[36]=" ";

        AlphaNumeric1[0]="{";
        AlphaNumeric1[1]="]";
        AlphaNumeric1[2]=")";
        AlphaNumeric1[3]="!";
        AlphaNumeric1[4]="%";
        AlphaNumeric1[5]="&";
        AlphaNumeric1[6]="@";
        AlphaNumeric1[7]="-";
        AlphaNumeric1[8]="+";
        AlphaNumeric1[9]="^";
        AlphaNumeric1[10]="*";
        AlphaNumeric1[11]="/";
        AlphaNumeric1[12]="|";
        AlphaNumeric1[13]=";";
        AlphaNumeric1[14]=":";
        AlphaNumeric1[15]="'";
        AlphaNumeric1[16]=">";
        AlphaNumeric1[17]="~";
        AlphaNumeric1[18]="$";
        AlphaNumeric1[19]="#";
        AlphaNumeric1[20]="(";
        AlphaNumeric1[21]="}";
        AlphaNumeric1[22]="[";
        AlphaNumeric1[23]="<";
        AlphaNumeric1[24]=",";
        AlphaNumeric1[25]=".";
        AlphaNumeric1[26]="2";
        AlphaNumeric1[27]="3";
        AlphaNumeric1[28]="4";
        AlphaNumeric1[29]="5";
        AlphaNumeric1[30]="6";
        AlphaNumeric1[31]="7";
        AlphaNumeric1[32]="8";
        AlphaNumeric1[33]="9";
        AlphaNumeric1[34]="0";
        AlphaNumeric1[35]="1";
        AlphaNumeric1[36]="/";


        btnEncode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=etinput.getText().toString();
                String output="";
                int l=input.length();
                int i,j;
                for(i=0;i<l;i++)
                {
                    String ch=input.substring(i,i+1);
                    for(j=0;j<37;j++) {
                        if (ch.equalsIgnoreCase(AlphaNumeric[j])) {
                            output = output.concat(AlphaNumeric1[j]).concat(" ");
                        }
                    }

                }
                etoutput.setText(output);
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etinput.setText("");
                etoutput.setText("");
            }
        });
        btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1=etinput.getText().toString();
                String input=input1.concat(" ");
                int l=input.length();

                int i,j,p=0;
                int pos=0;
                String letter="";//to store the extracted morse code for each Alphabet,number or space
                String output="";//a to store the output in it
                for(i=0;i<l;i++){
                    int flag=0;
                    String ch=input.substring(i,i+1);//to extract each token at a time
                    if(ch.equalsIgnoreCase(" ")){
                        p=i;
                        letter=input.substring(pos,p);
                        pos=p+1;
                        flag=1;
                    }
                    String letter1=letter.trim();
                    if(flag==1){
                        for(j=0;j<=36;j++) {
                            if (letter1.equalsIgnoreCase(AlphaNumeric1[j])) {
                                output = output.concat(AlphaNumeric[j]);
                                break;
                            }
                        }

                    }

                }
                etoutput.setText(output);//to display the output
            }
        });
    }
}