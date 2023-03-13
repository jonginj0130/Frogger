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
}
