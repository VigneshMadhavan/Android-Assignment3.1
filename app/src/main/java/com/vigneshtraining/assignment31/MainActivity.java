package com.vigneshtraining.assignment31;

import android.app.SearchManager;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText searchTxt;
    private Button searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchTxt=(EditText)findViewById(R.id.searchText);
        searchBtn=(Button)findViewById(R.id.searchButton);
        searchBtn.setOnClickListener(this);

    }

    private void search(String searchTerm){
        Intent searchIntent=new Intent();

        searchIntent.putExtra(SearchManager.QUERY,searchTerm);
        searchIntent.setAction(Intent.ACTION_WEB_SEARCH);
        startActivity(searchIntent);
        Log.d("Debug::",searchTerm);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.searchButton:
                if(searchTxt.getText().toString().isEmpty()){
                    Toast.makeText(this,"Please enter the term in the text box to search",Toast.LENGTH_LONG).show();
                }else{
                    search(searchTxt.getText().toString());
                }

                break;


        }
    }
}
