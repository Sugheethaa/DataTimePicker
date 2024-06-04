package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextRollNo, editTextAge, editTextEmail, editTextCourse;
    private DatePicker datePickerEnrollment;
    private TimePicker timePickerProjectSubmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        editTextName = findViewById(R.id.editTextName);
        // Initialize other EditTexts similarly

        datePickerEnrollment = findViewById(R.id.datePickerEnrollment);
        timePickerProjectSubmission = findViewById(R.id.timePickerProjectSubmission);

        // Set onClickListener for Submit Button
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()) {
                    // Get values from views
                    String name = editTextName.getText().toString();
                    // Get other values similarly

                    // Get Date of Enrollment
                    int day = datePickerEnrollment.getDayOfMonth();
                    int month = datePickerEnrollment.getMonth();
                    int year =  datePickerEnrollment.getYear();

                    // Get Final Project Submission Time
                    int hour = timePickerProjectSubmission.getCurrentHour();
                    int minute = timePickerProjectSubmission.getCurrentMinute();

                    // Create Intent to start next Activity
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", name);
                    // Put other extras

                    // Put Date and Time
                    intent.putExtra("enrollmentDate", day + "/" + (month + 1) + "/" + year);
                    intent.putExtra("submissionTime", hour + ":" + minute);

                    // Start Activity
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateForm() {
        // Validate each field
        // Return true if all fields are valid, otherwise return false
        return true;
    }
}
