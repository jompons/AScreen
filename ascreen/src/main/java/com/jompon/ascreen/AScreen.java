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

package com.jompon.ascreen;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AScreen {

    private Activity activity;
    private DisplayMetrics displaymetrics;
    public AScreen(Activity activity)
    {
        this.activity = activity;
        displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    }

    public int getWidth( )
    {
        return displaymetrics.widthPixels;
    }

    public int getHeight( )
    {
        return displaymetrics.heightPixels;
    }

    public int getMinSize( )
    {
        return (getWidth() > getHeight())? getHeight(): getWidth();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getPx(Context context, int dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int getDimension(Context context, int id)
    {
        return context.getResources().getDimensionPixelSize(id);
    }
}
