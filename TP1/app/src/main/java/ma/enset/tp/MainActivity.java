package ma.enset.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Calculer();
       }
   });
    }

    public void Calculer() {

        EditText editTextnumbr1 = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText editTextoperation=(EditText) findViewById(R.id.editTextTextPersonName3);
        EditText editTextnumbr2= (EditText) findViewById(R.id.editTextTextPersonName2);
        TextView textView = (TextView) findViewById(R.id.textView);

        String numbr1 = editTextnumbr1.getText().toString();
        String numbr2 =editTextnumbr2.getText().toString();
        String operator=editTextoperation.getText().toString();

        if (numbr1 == null) {
            textView.setText("Please enter a numbr");
        }
        else if(numbr2 == null){
            textView.setText("Please enter a numbr");
        }
        else{
           int numb1 =Integer.parseInt(numbr1.toString());
           int numb2 = Integer.parseInt(numbr2.toString());

           char c =operator.charAt(0);
            switch (c){
                case '+':
                    textView.setText(""+(numb1+numb2));
                    break;
                case '-':
                    textView.setText(""+(numb1-numb2));
                    break;
                case '*':
                    textView.setText(""+(numb1*numb2));
                    break;
                case '/':
                    textView.setText(""+(numb1/numb2));
                    break;
                default:
                    textView.setText("check your operations");
            };
        }
    }

    }