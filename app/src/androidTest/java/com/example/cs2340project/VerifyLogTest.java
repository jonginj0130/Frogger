package com.example.cs2340project;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import static org.junit.Assert.*;

public class VerifyLogTest {
    @Test
    public void testLogExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("log", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for log.png", drawable);
    }

    @Test
    public void testRockExists() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("rock", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for rock.png", drawable);
    }
    @Test
    public void testGameWin() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Resources resources = appContext.getResources();
        int resourceId = resources.getIdentifier("rock", "drawable", appContext.getPackageName());
        Drawable drawable = resources.getDrawable(resourceId, null);
        assertNotNull("Drawable not found for rock.png", drawable);
    }


}
