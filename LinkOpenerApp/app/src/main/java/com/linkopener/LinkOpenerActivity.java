package com.linkopener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URI;


public class LinkOpenerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.getAction() != Intent.ACTION_VIEW) {
            finish();
        } else {
            Uri uri = intent.getData();
            // TODO(csusanu):Do something with the URI.
        }
    }

}
