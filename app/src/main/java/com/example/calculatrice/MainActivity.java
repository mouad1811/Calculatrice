package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button b0 ;
    private Button b1 ;
    private Button b2 ;
    private Button b3 ;
    private Button b4 ;
    private Button b5 ;
    private Button b6 ;
    private Button b7 ;
    private Button b8 ;
    private Button b9 ;
    private Button bvirgule ;
    private Button begale ;
    private Button bplus ;
    private Button bmoins ;
    private Button bdiv ;
    private Button bmultp ;
    private Button bln ;
    private Button blog ;
    private Button bex ;
    private Button bpuissance ;
    private Button bclear ;
    private Button bcos ;
    private Button bsin ;
    private Button babs ;
    private TextView vSai ;
    private TextView vRes ;
    private final char ADD = '+' ;
    private final char SUB = '-' ;
    private final char MUL = '*' ;
    private final char DIV = '/' ;
    private final char EQU = 0 ;
    private final char PUI = '^' ;
    private double val1 = Double.NaN ;
    private double val2 ;
    private char action ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBtnViews();

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + "9");
            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = ADD ;
                vRes.setText(String.valueOf(val1) + "+");
                vSai.setText(null);
            }
        });

        bmoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = SUB ;
                vRes.setText(String.valueOf(val1) + "-");
                vSai.setText(null);
            }
        });

        bmultp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = MUL ;
                vRes.setText(String.valueOf(val1) + "*");
                vSai.setText(null);
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = DIV ;
                vRes.setText(String.valueOf(val1) + "/");
                vSai.setText(null);
            }
        });

        begale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = EQU ;
                vRes.setText(vRes.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                vSai.setText(String.valueOf(val1));
            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vSai.getText().length() > 0) {
                    CharSequence name = vSai.getText().toString() ;
                    vSai.setText(name.subSequence(0,name.length()-1)) ;
                }
                else {
                    val1 = Double.NaN ;
                    val2 = Double.NaN ;
                    vSai.setText(null) ;
                    vRes.setText(null) ;
                }
            }
        });

        bvirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vSai.setText(vSai.getText() + ".") ;
            }
        });

        bex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.exp(val1) ;
                vRes.setText("ex("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.log10(val1) ;
                vRes.setText("log("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });

        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.log(val1) ;
                vRes.setText("ln("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });

        bpuissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
                action = PUI ;
                vRes.setText(String.valueOf(val1) + "^");
                vSai.setText(null);
            }
        });

        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.cos(val1) ;
                vRes.setText("ln("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });

        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.sin(val1) ;
                vRes.setText("ln("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });

        babs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(vSai.getText().toString()) ;
                val1 = Math.abs(val1) ;
                vRes.setText("ln("+vSai.getText().toString()+")="+String.valueOf(val1)) ;
                vSai.setText(String.valueOf(val1)) ;
            }
        });
    }

    private void setupBtnViews() {

        b0 = (Button) findViewById(R.id.btn0) ;
        b1 = (Button) findViewById(R.id.btn1) ;
        b2 = (Button) findViewById(R.id.btn2) ;
        b3 = (Button) findViewById(R.id.btn3) ;
        b4 = (Button) findViewById(R.id.btn4) ;
        b5 = (Button) findViewById(R.id.btn5) ;
        b6 = (Button) findViewById(R.id.btn6) ;
        b7 = (Button) findViewById(R.id.btn7) ;
        b8 = (Button) findViewById(R.id.btn8) ;
        b9 = (Button) findViewById(R.id.btn9) ;
        bvirgule = (Button) findViewById(R.id.btnvirgule) ;
        begale = (Button) findViewById(R.id.btnegale) ;
        bplus = (Button) findViewById(R.id.btnplus) ;
        bmoins = (Button) findViewById(R.id.btnmoins) ;
        bdiv = (Button) findViewById(R.id.btndiv) ;
        bmultp = (Button) findViewById(R.id.btnmultp) ;
        bln = (Button) findViewById(R.id.btnln) ;
        blog = (Button) findViewById(R.id.btnlog) ;
        bex = (Button) findViewById(R.id.btnex) ;
        bpuissance = (Button) findViewById(R.id.btnpuissance) ;
        bclear = (Button) findViewById(R.id.btnclear) ;
        bcos = (Button) findViewById(R.id.btncos) ;
        bsin = (Button) findViewById(R.id.btnsin) ;
        babs = (Button) findViewById(R.id.btnabs) ;
        vSai = (TextView) findViewById(R.id.sai) ;
        vRes = (TextView) findViewById(R.id.res) ;

    }

    private void calculer() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(vSai.getText().toString()) ;

            switch (action) {
                case ADD:
                    val1 = val1 + val2 ;
                    break ;

                case SUB:
                    val1 = val1 - val2 ;
                    break ;

                case MUL:
                    val1 = val1 * val2 ;
                    break ;

                case DIV:
                    val1 = val1 / val2 ;
                    break ;

                case PUI:
                    val1 = Math.pow(val1,val2) ;
                    break;

                case EQU:
                    break;
            }
        }
        else {
            val1 = Double.parseDouble(vSai.getText().toString());
        }
    }
}