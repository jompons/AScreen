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

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AScreen {

    private static AScreen aScreen;
    private Context context;
    private DisplayMetrics displaymetrics;
    public AScreen(Context context)
    {
        this.context = context;
        displaymetrics = context.getResources().getDisplayMetrics();
    }

    public static synchronized AScreen getInstance(Context context)
    {
        if( aScreen == null )   aScreen = new AScreen(context);
        return aScreen;
    }

    public int getScreenWidth( )
    {
        return displaymetrics.widthPixels;
    }

    public int getScreenHeight( )
    {
        return displaymetrics.heightPixels;
    }

    public int getScreenMinSize( )
    {
        return (getScreenWidth() > getScreenHeight())? getScreenHeight(): getScreenWidth();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getPx(Context context, int dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int getPx(Context context, int value, int unit)
    {
        return (int) TypedValue.applyDimension(unit, value, context.getResources().getDisplayMetrics());
    }

    public static int getDimension(Context context, int id)
    {
        return context.getResources().getDimensionPixelSize(id);
    }
}
