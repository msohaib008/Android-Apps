package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean check = false;
    private double firstNumber = 0;
    private int secondNumberIndex = 0;
    private char currOperation;
    private boolean dotCheck = false;
    private TextView screen ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_layout);

        screen = (TextView) findViewById(R.id.textscreen);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button0 = (Button) findViewById(R.id.button0);
        final Button buttondot = (Button) findViewById(R.id.buttonpoint);
        final Button buttonequal = (Button) findViewById(R.id.buttonequal);
        final Button buttonPlus = (Button) findViewById(R.id.buttonplus);
        final Button buttonMinus = (Button) findViewById(R.id.buttonminus);
        final Button buttonMultiply = (Button) findViewById(R.id.buttonproduct);
        final Button buttonDivide = (Button) findViewById(R.id.buttondivide);
        final Button buttonSquare = (Button) findViewById(R.id.buttonsquare);
        final Button buttonMod = (Button) findViewById(R.id.buttonmod);
        final Button buttonDel = (Button) findViewById(R.id.buttondel);
        final Button buttonClear = (Button) findViewById(R.id.buttonac);


        View.OnClickListener callistener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    case R.id.button0:
                        screen.append("0");
                        break;
                    case R.id.button1:
                        screen.append("1");
                        break;
                    case R.id.button2:
                        screen.append("2");
                        break;
                    case R.id.button3:
                        screen.append("3");
                        break;
                    case R.id.button4:
                        screen.append("4");
                        break;
                    case R.id.button5:
                        screen.append("5");

                        break;
                    case R.id.button6:
                        screen.append("6");

                        break;
                    case R.id.button7:
                        screen.append("7");

                        break;
                    case R.id.button8:
                        screen.append("8");

                        break;
                    case R.id.button9:
                        screen.append("9");

                        break;
                    case R.id.buttonplus:
                        operation('+');
                        break;
                    case R.id.buttonequal:
                        if (check) {

                            String str1 = screen.getText().toString();
                            double secondNumber = Double.parseDouble(str1.substring(secondNumberIndex));
                            double ans = 0;
                            if (currOperation == '+') {
                                ans = firstNumber + secondNumber;

                            } else if (currOperation == '-') {
                                ans = firstNumber - secondNumber;
                            } else if (currOperation == '/') {
                                if (secondNumber == 0)
                                    return;
                                ans = firstNumber / secondNumber;
                            } else if (currOperation == '*') {
                                ans = firstNumber * secondNumber;
                            }
                            else if(currOperation=='%'){
                                ans=firstNumber%secondNumber;
                            }

                            screen.setText(String.valueOf(ans));
                            check = false;
                        }
                        break;
                    case R.id.buttonminus:
                      operation('-');
                        break;
                    case R.id.buttonproduct:
                        operation('*');
                        break;
                    case R.id.buttondivide:
                      operation('/');
                        break;
                    case R.id.buttonsquare:
                        if(check==false&&dotCheck==false){
                            int sqr=Integer.parseInt(screen.getText().toString());
                            sqr=sqr*sqr;
                            screen.setText(String.valueOf(sqr));
                        }
                        break;
                    case R.id.buttonmod:
                        operation('%');

                        break;
                    case R.id.buttonpoint:
                        if (dotCheck == false) {
                            screen.append(".");
                            dotCheck = true;
                        }
                        break;


                }


            }


        };

        button0.setOnClickListener(callistener);
        button1.setOnClickListener(callistener);
        button2.setOnClickListener(callistener);
        button3.setOnClickListener(callistener);
        button4.setOnClickListener(callistener);
        button5.setOnClickListener(callistener);
        button6.setOnClickListener(callistener);
        button7.setOnClickListener(callistener);

        button8.setOnClickListener(callistener);
        button9.setOnClickListener(callistener);
buttonequal.setOnClickListener(callistener);
        buttondot.setOnClickListener(callistener);

        buttonDel.setOnClickListener(callistener);
        buttonClear.setOnClickListener(callistener);
        buttonPlus.setOnClickListener(callistener);
        buttonMinus.setOnClickListener(callistener);
        buttonMultiply.setOnClickListener(callistener);
        buttonDivide.setOnClickListener(callistener);
        buttonSquare.setOnClickListener(callistener);
        buttonMod.setOnClickListener(callistener);

    final Button del = (Button) findViewById(R.id.buttondel);
        del.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){
        String str = screen.getText().toString();
        int len = str.length();
        if (len > 0) {
            str = str.substring(0, len - 1);
            screen.setText(str);
        }
    }
    });

    final Button clear = findViewById(R.id.buttonac);
       clear.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        screen.setText("");
        check = false;
        dotCheck = false;

    }
    });
}

    private void operation(char c){
        if(check){
            return;
        }
        int lengthCheck=screen.getText().toString().length();
        if(lengthCheck<1){
            return;
        }
        firstNumber=Double.parseDouble(screen.getText().toString());
        secondNumberIndex=screen.getText().toString().length()+1;
        if(c=='*'){
            String s="×";
            screen.append(s);
            check=true;
            dotCheck=false;
            currOperation=c;
            return;
        }
        if(c=='/'){
            String s="÷";
            screen.append(s);
            check=true;
            dotCheck=false;
            currOperation=c;
            return;
        }
        screen.append(String.valueOf(c));
        check=true;
        dotCheck=false;
        currOperation=c;
    }
}
