package com.linkopener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Main LinkOpener activity. It reads the file from the intent and then opens the link inside it.
 */
public class LinkOpenerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.getAction() != Intent.ACTION_VIEW) {
            finish();
        } else {
            Uri uri = intent.getData();
            try {
                File file = new File(uri.getPath());
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String firstLine = bufferedReader.readLine();
                Log.i("linkopener", "Opening link: " + firstLine);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(firstLine));
                startActivity(browserIntent);
            } catch (FileNotFoundException e) {
                Log.e("linkopener", "Did not find file: " + uri.toString() + " due to: " + e);
            } catch (IOException e) {
                Log.e("linkopener", "Error reading file: " + uri.toString() + " due to: " + e);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}
