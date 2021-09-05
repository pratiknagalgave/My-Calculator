package com.technopratik.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class converter extends AppCompatActivity {

    Spinner from,to;
    TextView tv_converter, result;
    EditText et;
    Button check;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_converter );

        from = findViewById ( R.id.from );
        to=findViewById ( R.id.to );
        result = findViewById ( R.id.result );
        check = findViewById ( R.id.check );

        tv_converter= findViewById ( R.id.tv_converter );
        et=findViewById ( R.id.et );

        ActionBar actionBar = getSupportActionBar();


        actionBar.setDisplayHomeAsUpEnabled(true);

        String[] From= {"METER", "KILOMETER","CENTIMETER","MILLIMETER", "MICROMETER","MILE"};

        ArrayAdapter<String> apter = new  ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item ,From );
        from.setAdapter ( apter );





        String[] To= {"METER", "KILOMETER","CENTIMETER","MILLIMETER", "MICROMETER","MILE"};
        ArrayAdapter<String> adpter2 = new ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item , To );
        to.setAdapter ( adpter2 );

        check.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Double givenNo;
                Double ans=0.0;
                givenNo= Double.parseDouble (  et.getText ().toString ());

                if(from.getSelectedItem ().toString ()=="METER" ){
                    if(to.getSelectedItem ().toString ()=="METER" ){
                        ans = givenNo;
                    }else if(to.getSelectedItem ().toString ()=="KILOMETER" ){
                        ans= givenNo/1000;
                    }
                    else if(to.getSelectedItem ().toString ()=="CENTIMETER" ){
                        ans= givenNo*100;
                    }
                    else if(to.getSelectedItem ().toString ()=="MILLIMETER" ){
                        ans= givenNo*1000;
                    }
                    else if(to.getSelectedItem ().toString ()=="MICROMETER" ){
                        ans= givenNo*1000000;}
                    else if(to.getSelectedItem ().toString ()=="MILE" ){
                            ans= givenNo/1609.344;  }




                    }

                    else if(from.getSelectedItem ().toString ()=="KILOMETER" ) {
                    if ( to.getSelectedItem ().toString () == "METER" ) {
                        ans = givenNo * 1000;
                    } else if ( to.getSelectedItem ().toString () == "KILOMETER" ) {
                        ans = givenNo;
                    } else if ( to.getSelectedItem ().toString () == "CENTIMETER" ) {
                        ans = givenNo * 100000;
                    } else if ( to.getSelectedItem ().toString () == "MILLIMETER" ) {
                        ans = givenNo * 1000000;
                    } else if ( to.getSelectedItem ().toString () == "MICROMETER" ) {
                        ans = givenNo * 1000000000;
                    } else if ( to.getSelectedItem ().toString () == "MILE" ) {
                        ans = givenNo / 1.609344;
                    }
                }





                else if(from.getSelectedItem ().toString ()=="CENTIMETER" ) {
                    if ( to.getSelectedItem ().toString () == "METER" ) {
                        ans = givenNo / 100;
                    } else if ( to.getSelectedItem ().toString () == "KILOMETER" ) {
                        ans = givenNo / 100000;
                    } else if ( to.getSelectedItem ().toString () == "CENTIMETER" ) {
                        ans = givenNo;
                    } else if ( to.getSelectedItem ().toString () == "MILLIMETER" ) {
                        ans = givenNo * 10;
                    } else if ( to.getSelectedItem ().toString () == "MICROMETER" ) {
                        ans = givenNo * 10000;
                    } else if ( to.getSelectedItem ().toString () == "MILE" ) {
                        ans = 0.0;
                        Toast.makeText ( converter.this,"Error" , Toast.LENGTH_SHORT ).show ();
                    }
                }

                    else if(from.getSelectedItem ().toString ()=="MILLIMETER" ) {
                        if ( to.getSelectedItem ().toString () == "METER" ) {
                            ans = givenNo / 1000;
                        } else if ( to.getSelectedItem ().toString () == "KILOMETER" ) {
                            ans = givenNo / 1000000;
                        } else if ( to.getSelectedItem ().toString () == "CENTIMETER" ) {
                            ans = givenNo / 10;
                        } else if ( to.getSelectedItem ().toString () == "MILLIMETER" ) {
                            ans = givenNo;
                        } else if ( to.getSelectedItem ().toString () == "MICROMETER" ) {
                            ans = givenNo * 1000;
                        } else if ( to.getSelectedItem ().toString () == "MILE" ) {
                            ans = 0.0;
                            Toast.makeText ( converter.this,"Error" , Toast.LENGTH_SHORT ).show ();
                        }
                    }

                        else if(from.getSelectedItem ().toString ()=="MICROMETER" ) {
                            if ( to.getSelectedItem ().toString () == "METER" ) {
                                ans = givenNo / 1000000;
                            } else if ( to.getSelectedItem ().toString () == "KILOMETER" ) {
                                ans = givenNo / 1000000000;
                            } else if ( to.getSelectedItem ().toString () == "CENTIMETER" ) {
                                ans = givenNo / 10000;
                            } else if ( to.getSelectedItem ().toString () == "MILLIMETER" ) {
                                ans = givenNo / 1000;
                            } else if ( to.getSelectedItem ().toString () == "MICROMETER" ) {
                                ans = givenNo;
                            } else if ( to.getSelectedItem ().toString () == "MILE" ) {
                                ans = 0.0;
                                Toast.makeText ( converter.this , "Error" , Toast.LENGTH_SHORT ).show ();
                            }
                        }


                            else {
                            if ( to.getSelectedItem ().toString () == "METER" ) {
                                ans = givenNo * 1609.344;
                            } else if ( to.getSelectedItem ().toString () == "KILOMETER" ) {
                                ans = givenNo / 1.609344;
                            } else if ( to.getSelectedItem ().toString () == "CENTIMETER" ) {
                                ans = givenNo / 160934.4;
                            } else if ( to.getSelectedItem ().toString () == "MILLIMETER" ) {
                                ans = givenNo / 1609344;
                            } else if ( to.getSelectedItem ().toString () == "MICROMETER" ) {
                                ans = givenNo * 1609344000;
                            } else if ( to.getSelectedItem ().toString () == "MILE" ) {
                                ans = givenNo;

                            }

                        }



                result.setText ( Double.toString (ans));











            }
        } );}
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
