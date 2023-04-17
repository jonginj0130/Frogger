package com.example.cs2340project;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * VerifyAssetsExist ensures that sprites and other game access are properly loaded.
 *
 * Made by Race Williams.
 */
public class VerifyAssetsExist {
    @Test
    public void testCoinPngExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("coin", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for coin.png", drawable);
    }

    @Test
    public void testRedFrogExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("red_frog", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for Red Frog.png", drawable);
    }

    @Test
    public void testBlueFrogExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("green_frog", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for Green Frog.png", drawable);
    }

    @Test
    public void testGreenFrogExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("blue_frog", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for Blue Frog.png", drawable);
    }

    @Test
    public void testBigTruckExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("big_truck", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for big_truck.png", drawable);
    }

    @Test
    public void testSmallTruckExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("small_truck", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for small_truck.png", drawable);
    }
}