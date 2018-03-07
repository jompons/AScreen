/*
 * Copyright (C) 2018 jompons.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jompon.ascreen.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jompon.ascreen.AScreen;

public class MainActivity extends AppCompatActivity {

    private TextView txtScreenWidth;
    private TextView txtScreenHeight;
    private TextView txtStatusBarHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        bindingView();
        bindingData();
    }

    private void bindingView( )
    {
        txtScreenWidth = (TextView) findViewById(R.id.txt_screen_width);
        txtScreenHeight = (TextView) findViewById(R.id.txt_screen_height);
        txtStatusBarHeight = (TextView) findViewById(R.id.txt_status_bar_height);
    }

    private void bindingData( )
    {
        txtScreenWidth.append(AScreen.getInstance(this).getScreenWidth()+" px");
        txtScreenHeight.append(AScreen.getInstance(this).getScreenHeight()+" px");
        txtStatusBarHeight.append(AScreen.getInstance(this).getStatusBarHeight()+" px");
    }
}
