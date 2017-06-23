
package com.aleksus.handtohand1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class RegisterActivity extends AppCompatActivity {
//    private final static java.text.SimpleDateFormat SIMPLE_DATE_FORMAT = new java.text.SimpleDateFormat("yyyy/MM/dd");

    private EditText passwordField;
    private EditText nameField;
    private EditText emailField;

    private Button registerButton;

//    private java.util.Date created;
    private String password;
    private String name;
//    private String ownerId;
//    private String objectId;
//    private java.util.Date updated;
    private String email;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initUI();
    }

    private void initUI() {
        passwordField = (EditText) findViewById(R.id.passwordField);
        nameField = (EditText) findViewById(R.id.nameField);
        emailField = (EditText) findViewById(R.id.emailField);

        registerButton = (Button) findViewById(R.id.registerButton);

//    final java.util.Calendar createdCalendar = java.util.Calendar.getInstance();
//    createdField.setOnClickListener( new View.OnClickListener()
//    {
//      @Override
//      public void onClick( View view )
//      {
//        new DatePickerDialog( RegisterActivity.this, new DatePickerDialog.OnDateSetListener()
//        {
//          @Override
//          public void onDateSet( DatePicker datePicker, int year, int monthOfYear, int dayOfMonth )
//          {
//            createdCalendar.set( java.util.Calendar.YEAR, year );
//            createdCalendar.set( java.util.Calendar.MONTH, monthOfYear );
//            createdCalendar.set( java.util.Calendar.DAY_OF_MONTH, dayOfMonth );
//           createdField.setText( SIMPLE_DATE_FORMAT.format( createdCalendar.getTime() ) );
//          }
//        }, createdCalendar.get( java.util.Calendar.YEAR ), createdCalendar.get( java.util.Calendar.MONTH ), createdCalendar.get( java.util.Calendar.DAY_OF_MONTH ) ).show();
//      }
//    } );


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterButtonClicked();
            }
        });
    }

    private void onRegisterButtonClicked() {
//        String createdText = "";
        String passwordText = passwordField.getText().toString().trim();
        String nameText = nameField.getText().toString().trim();
//        String ownerIdText = "";
//        String objectIdText = "";
//        String updatedText = "";
        String emailText = emailField.getText().toString().trim();

        if (passwordText.isEmpty()) {
            showToast("Поле 'Пароль' не может быть пустым.");
            return;
        }

        if (emailText.isEmpty()) {
            showToast("Поле 'Логин (EMail)' не может быть пустым.");
            return;
        }

//    if( !createdText.isEmpty() )
//    {
//      try
//      {
//        created = SIMPLE_DATE_FORMAT.parse( createdText );
//      }
//      catch( java.text.ParseException e )
//      {
//        showToast( e.getMessage() );
//        return;
//      }
//    }

        if (!passwordText.isEmpty()) {
            password = passwordText;
        }

        if (!nameText.isEmpty()) {
            name = nameText;
        }

//    if( !ownerIdText.isEmpty() )
//    {
//      ownerId = ownerIdText;
//    }
//
//    if( !objectIdText.isEmpty() )
//    {
//      objectId = objectIdText;
//    }

//    if( !updatedText.isEmpty() )
//    {
//      try
//      {
//        updated = SIMPLE_DATE_FORMAT.parse( updatedText );
//      }
//      catch( java.text.ParseException e )
//      {
//        showToast( e.getMessage() );
//        return;
//      }
//    }

        if (!emailText.isEmpty()) {
            email = emailText;
        }

        ExampleUser user = new ExampleUser();

//        if (created != null) {
//            user.setCreated(created);
//        }

        if (password != null) {
            user.setPassword(password);
        }

        if (name != null) {
            user.setName(name);
        }
//
//        if (ownerId != null) {
//            user.setOwnerId(ownerId);
//        }
//
//        if (objectId != null) {
//            user.setObjectId(objectId);
//        }
//
//        if (updated != null) {
//            user.setUpdated(updated);
//        }

        if (email != null) {
            user.setEmail(email);
        }

        Backendless.UserService.register(user, new DefaultCallback<BackendlessUser>(RegisterActivity.this) {
            @Override
            public void handleResponse(BackendlessUser response) {
                super.handleResponse(response);
                startActivity(new Intent(RegisterActivity.this, RegistrationSuccessActivity.class));
                finish();
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
                