package com.technopratik.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnplus,btnminus,btnmult,btndev,btnper,btnequal,btncancle,btnback,btndot;
    TextView tvin,tvout;
    String data;
    Button button;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

       btn1 = findViewById ( R.id.btn1 );
        btn2 =  findViewById ( R.id.btn2 ) ;
        btn3 =  findViewById ( R.id.btn3 ) ;
        btn4 =  findViewById ( R.id.btn4) ;
        btn5 =  findViewById ( R.id.btn5 ) ;
        btn6 =  findViewById ( R.id.btn6 ) ;
        btn7 =  findViewById ( R.id.btn7 ) ;
        btn8 =  findViewById ( R.id.btn8 ) ;
        btn9 =  findViewById ( R.id.btn9 ) ;
        btn0 =  findViewById ( R.id.btn0 ) ;

        btnplus =  findViewById ( R.id.btnplus ) ;
        btnminus =  findViewById ( R.id.btnminu ) ;
        btnmult =  findViewById ( R.id.btnmult ) ;
        btndev =  findViewById ( R.id.btndiv ) ;
        btnequal =  findViewById ( R.id.btnequal ) ;
        btnper =  findViewById ( R.id.btnper) ;
        btncancle =  findViewById ( R.id.btncancle ) ;
        btnback =  findViewById ( R.id.btnback ) ;
        btndot= findViewById ( R.id.btndot );


        tvin = (TextView) findViewById ( R.id.textView );
        tvout =(TextView ) findViewById ( R.id.textView2 );

        button = findViewById ( R.id.button );



        btn1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View v ) {
               data = tvin.getText ().toString ();
               tvin.setText ( data+ "1" );
            }
        } );
        btn2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "2" );
            }
        } );
        btn3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "3" );
            }
        } );
        btn4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "4" );
            }
        } );
        btn5.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "5" );
            }
        } );
        btn6.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "6" );
            }
        } );
        btn7.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "7" );
            }
        } );
        btn8.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "8" );
            }
        } );
        btn9.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "9" );
            }
        } );
        btn0.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "0" );
            }
        } );
        btnplus.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "+" );
            }
        } );
        btnminus.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();

                tvin.setText ( data+ "-" );
            }
        } );
        btnper.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "%" );
            }
        } );
        btnmult.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "×" );
            }
        } );
        btndev.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "÷" );
            }
        } );
        btncancle.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                tvin.setText ( "" );
                tvout.setText ( "" );
                data = "";
            }
        } );
        btndot.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                data = tvin.getText ().toString ();
                tvin.setText ( data+ "." );
            }
        } );






        btnequal.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                try {

                    data = tvin.getText ().toString ();
                    tvout.setText ( data );
                    data = data.replaceFirst (  "÷", "/");
                    data = data.replaceFirst (  "×", "*");
                    data = data.replaceFirst (  "%", "/100");
                    Context rhino = Context.enter ();
                    rhino.setOptimizationLevel ( -1 );
                    String finalResult = "";
                    Scriptable scriptable = rhino.initSafeStandardObjects ();
                    finalResult= rhino.evaluateString ( scriptable,data,"JavaScript",1,null ).toString ();
                    tvin.setText ( "= "+finalResult );
                }
                catch(Exception e) {
                   Toast.makeText ( MainActivity.this,"Error",Toast.LENGTH_SHORT ).show ();
                }



            }
        } );
        btnback.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                try {
                    StringBuffer sb= new StringBuffer(tvin.getText ().toString ());


                    sb.deleteCharAt(sb.length()-1);
                    tvin.setText ( sb );
                }
                catch(Exception e) {
                    Toast.makeText ( MainActivity.this,"Error",Toast.LENGTH_SHORT ).show ();
                }






            }
        } );

        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Intent intent = new Intent (MainActivity.this,converter.class);
                startActivity ( intent );
            }
        } );


    }
}