package com.example.workexprecovery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    LinearLayout back_ground;
    Button button, button2, button3, button4, button5, button6, button7, button8, button9, playbutton;//, multi;
    ArrayList<Integer> usequence = new ArrayList<>();
    ArrayList<Integer> sequence = new ArrayList<>();
    private int numberOfClicks = 0;
    private int numberOfPlays = 0;
    private int currentRound = 3;
    int p=1;
    int pl=1;
    boolean sequenceShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        playbutton = (Button) findViewById(R.id.playbutton);
        //multi = (Button) findViewById(R.id.multi);

        button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
        playbutton.getBackground().setColorFilter(Color.parseColor("#00ffff"), PorterDuff.Mode.MULTIPLY);

        playbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                playbutton.setText("Good Luck!");

                sequence.clear();
                usequence.clear();
                currentRound = 3;
                numberOfClicks = 0;
                numberOfPlays++;
                //using function to make correct sequence

                randomSequence(currentRound);

                //printing sequence
                sequenceWithIntervals();

                //recording user's sequence
                //setupButtons();

            }
        });

    }

    public void sequenceWithIntervals()
    {
        //printing sequence to user
        Button[] buttonSequence = {button, button2, button3, button4, button5, button6, button7, button8, button9};
        String [] colours = {"#00ffff", "#00ff00", "#0000ff", "#ff0000", "#ffff00", "#ff9900", "#ff6699", "#006600", "#990066"};
        sequenceShown = false;
        for (int i = 0; i<currentRound;i++) {
            buttonSequence[sequence.get(i) - 1].getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
            int finalI = i;
            new CountDownTimer(500+500* finalI, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    buttonSequence[sequence.get(finalI) - 1].getBackground().setColorFilter(Color.parseColor(colours[sequence.get(finalI) - 1]), PorterDuff.Mode.MULTIPLY);
                    new CountDownTimer(500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            buttonSequence[sequence.get(finalI) - 1].getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        }
                    }.start();
                }
            }.start();

            /*if (sequence.get(i) == 1) {
                button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button.getBackground().setColorFilter(Color.parseColor("#00ffff"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();
            }

            if (sequence.get(i) == 2) {
                button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button2.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();
            }
            if (sequence.get(i) == 3) {
                button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button3.getBackground().setColorFilter(Color.parseColor("#0000ff"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();
            }
            if (sequence.get(i) == 4) {
                button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button4.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();


            }
            if (sequence.get(i) == 5) {
                button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button5.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();
            }
            if (sequence.get(i) == 6) {
                button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button6.getBackground().setColorFilter(Color.parseColor("#ff9900"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();
            }
            if (sequence.get(i) == 7) {
                button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button7.getBackground().setColorFilter(Color.parseColor("#ff6699"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();

            }
            if (sequence.get(i) == 8) {
                button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500+500*i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button8.getBackground().setColorFilter(Color.parseColor("#006600"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();

            }
            if (sequence.get(i) == 9) {
                button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(500 + 500 * i, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button9.getBackground().setColorFilter(Color.parseColor("#990066"), PorterDuff.Mode.MULTIPLY);
                        new CountDownTimer(500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            }
                        }.start();
                    }
                }.start();

            }*/

        }
        new CountDownTimer(10+500*currentRound, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                sequenceShown = true;
                setupButtons();
            }
        }.start();

    }



    public void setupButtons() {
        //input of user sequence
        Button[] buttonSetup = {button, button2, button3, button4, button5, button6, button7, button8, button9};
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            buttonSetup[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // click button code here
                    if (sequenceShown) {
                        usequence.add(finalI +1);
                        numberOfClicks++;
                        checkUserFinished();
                    }
                }
            });
        }

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(1);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(2);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(3);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(4);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(5);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(6);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(7);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(8);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click button code here
                if (sequenceShown) {
                    usequence.add(9);
                    numberOfClicks++;
                    checkUserFinished();
                }
            }
        });*/
    }


    public void checkUserFinished() {
        if (numberOfClicks == currentRound) {
            System.out.println(usequence);
            boolean isFinished=true;
            sequenceShown = false;
            for (int i = 0; i < currentRound; i++) {
                if (usequence.get(i) != sequence.get(i)) {
                    button.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button2.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button3.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button4.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button5.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button6.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button7.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button8.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
                    button9.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);

                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                            if (currentRound == 3) {
                                playbutton.setText("Unlucky! Feel free to try again...");
                            } else {
                                int result = currentRound - 3;
                                //playbutton.setTextSize(10);
                                if (result == 1) {
                                    playbutton.setText("Unlucky!\nWell done for completing\n" + result + " round!");
                                } else {
                                    playbutton.setText("Unlucky!\nWell done for completing\n" + result + " rounds!");
                                }
                            }
                            new CountDownTimer(3000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    playbutton.setTextSize(15);
                                    if (numberOfPlays == 1) {
                                        playbutton.setText("Thanks for playing! \nClick here to play again!");
                                    } else {
                                        playbutton.setText("Thanks for playing " + numberOfPlays + " times! \nClick here to play again!");
                                    }
                                    playbutton.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View view) {
                                            playbutton.setText("Here we go again! Good Luck!");

                                            sequence.clear();
                                            usequence.clear();
                                            currentRound=3;
                                            numberOfClicks = 0;
                                            numberOfPlays++;
                                            //using function to make correct sequence

                                            randomSequence(currentRound);

                                            //printing sequence
                                            sequenceWithIntervals();

                                            //recording user's sequence
                                            //setupButtons();

                                        }
                                    });

                                }

                            }.start();
                        }
                    }.start();

                    isFinished = false;
                    break;
                }
            }
            if (isFinished) {

                button.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button2.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button3.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button4.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button5.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button6.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button7.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button8.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                button9.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                        nextRoundGen();
                    }
                }.start();


            }


        }
    }

    public void nextRoundGen()
    {
        sequence.clear();
        usequence.clear();
        currentRound++;
        numberOfClicks = 0;
        sequenceShown = false;
        randomSequence(currentRound);
        new CountDownTimer(750, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                sequenceWithIntervals();
                new CountDownTimer(250, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish()
                    {
                        //setupButtons();
                    }
                }.start();
            }
        }.start();

    }


    public void randomSequence(int count)
    {
        for (int j= 0;j<count;j++){
            Random r = new Random();
            if (j>0){
                int newNumber = r.nextInt(10 - 1)+1;
                while (newNumber == sequence.get(j-1))
                {
                    newNumber = r.nextInt(10 - 1)+1;
                }
                if (newNumber != sequence.get(j-1))
                {
                    sequence.add(newNumber);
                }
            }
            else
            {
                int newNumber = r.nextInt(10 - 1) + 1;
                sequence.add(newNumber);
            }
        }
        System.out.println(sequence);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            button.getBackground().setColorFilter(Color.parseColor("#00ffff"), PorterDuff.Mode.MULTIPLY);
            button2.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.MULTIPLY);
            button3.getBackground().setColorFilter(Color.parseColor("#0000ff"), PorterDuff.Mode.MULTIPLY);
            button4.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.MULTIPLY);
            button5.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            button6.getBackground().setColorFilter(Color.parseColor("#ff9900"), PorterDuff.Mode.MULTIPLY);
            button7.getBackground().setColorFilter(Color.parseColor("#ff6699"), PorterDuff.Mode.MULTIPLY);
            button8.getBackground().setColorFilter(Color.parseColor("#006600"), PorterDuff.Mode.MULTIPLY);
            button9.getBackground().setColorFilter(Color.parseColor("#990066"), PorterDuff.Mode.MULTIPLY);
            new CountDownTimer(1500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    button.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button2.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button3.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button4.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button5.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button6.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button7.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button8.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                    button9.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.MULTIPLY);
                }
            }.start();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


