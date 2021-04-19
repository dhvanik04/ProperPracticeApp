package com.example.properpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Context context = getApplicationContext();
//        CharSequence text = getString(R.string.TutorialToast);
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.alert_title_item);
        alert.setMessage(R.string.tutorial_message_item);
        alert.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            /**
             * @param dialog the dialog of the alert
             * @param which which button is selected
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Context context = getApplicationContext();
                CharSequence text = getString(R.string.thankyou);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        }).setNegativeButton(R.string.close, null);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}