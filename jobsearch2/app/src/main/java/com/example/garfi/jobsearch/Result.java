package com.example.garfi.jobsearch;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

import static com.example.garfi.jobsearch.Questions.Position;
import static com.example.garfi.jobsearch.Questions.Where;
import static com.example.garfi.jobsearch.Questions.Work;
import static com.example.garfi.jobsearch.Questions2.Salary;
import static com.example.garfi.jobsearch.Questions2.Time;

public class Result extends AppCompatActivity {
    private Document htmlDocument;
    private String htmlPageUrl = "https://inducesmile.com/";
    private TextView Result1;
    private TextView Result2;
    private TextView Result3;
    private TextView Result4;
    private TextView Result5;
    private String htmlContentInStringFormat;
    private String htmlContentInStringFormat2;
    private String htmlContentInStringFormat3;
    private String htmlContentInStringFormat4;
    private String htmlContentInStringFormat5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Result1 = (TextView)findViewById(R.id.textView6);
        Result2 = (TextView)findViewById(R.id.textView7);
        Result3 = (TextView)findViewById(R.id.textView9);
        Result4 = (TextView)findViewById(R.id.textView8);
        Result5 = (TextView) findViewById(R.id.textView10);
        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                htmlDocument = Jsoup.connect("https://www.indeed.com/jobs?q=" + Work + "&l=" + Where + "%2C+CA").get();
                Element Company = htmlDocument.select("span[class='company']").get(0);
                String Company1 = Jsoup.parse(Company.toString()).text();
                Element Summary = htmlDocument.select("span[class='Summary']").get(0);
                String Summary1 = Jsoup.parse(Summary.toString()).text();
                Element Location = htmlDocument.select("span[class='location']").get(0);
                String Location1 = Jsoup.parse(Location.toString()).text();
                htmlContentInStringFormat = (Company1 + "\n" + Summary1 + "\n" + Location1);
                Element Company2 = htmlDocument.select("span[class='company']").get(1);
                String Company20 = Jsoup.parse(Company2.toString()).text();
                Element Summary2 = htmlDocument.select("span[class='Summary']").get(1);
                String Summary20 = Jsoup.parse(Summary2.toString()).text();
                Element Location2 = htmlDocument.select("span[class='location']").get(1);
                String Location20 = Jsoup.parse(Location2.toString()).text();
                htmlContentInStringFormat2 = (Company20 + "\n" + Summary20 + "\n" + Location20);
                Element Company3 = htmlDocument.select("span[class='company']").get(2);
                String Company30 = Jsoup.parse(Company3.toString()).text();
                Element Summary3 = htmlDocument.select("span[class='Summary']").get(2);
                String Summary30 = Jsoup.parse(Summary3.toString()).text();
                Element Location3 = htmlDocument.select("span[class='location']").get(2);
                String Location30 = Jsoup.parse(Location3.toString()).text();
                htmlContentInStringFormat3 = (Company30 + "\n" + Summary30 + "\n" + Location30);
                Element Company4 = htmlDocument.select("span[class='company']").get(3);
                String Company40 = Jsoup.parse(Company3.toString()).text();
                Element Summary4 = htmlDocument.select("span[class='Summary']").get(3);
                String Summary40 = Jsoup.parse(Summary4.toString()).text();
                Element Location4 = htmlDocument.select("span[class='location']").get(3);
                String Location40 = Jsoup.parse(Location4.toString()).text();
                htmlContentInStringFormat4 = (Company40 + "\n" + Summary40 + "\n" + Location40);
                Element Company5 = htmlDocument.select("span[class='company']").get(4);
                String Company50 = Jsoup.parse(Company5.toString()).text();
                Element Summary5 = htmlDocument.select("span[class='Summary']").get(4);
                String Summary50 = Jsoup.parse(Summary5.toString()).text();
                Element Location5 = htmlDocument.select("span[class='location']").get(4);
                String Location50 = Jsoup.parse(Location5.toString()).text();
                htmlContentInStringFormat5 = (Company50 + "\n" + Summary50 + "\n" + Location50);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Result1.setText(htmlContentInStringFormat);
            Result2.setText(htmlContentInStringFormat2);
            Result3.setText(htmlContentInStringFormat3);
            Result4.setText(htmlContentInStringFormat4);
            Result5.setText(htmlContentInStringFormat5);
        }
    }
    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void NewSearch (View view) {
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
    }
    public void Map2 (View view){
        Intent intent = new Intent(this, Ma  cNj
                \+Loc.class);
        startActivity(intent);
    }
}
