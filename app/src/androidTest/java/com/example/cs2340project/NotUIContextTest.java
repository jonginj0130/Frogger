package com.example.cs2340project;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * NotUIContextTest verifies that the app's primary context is not wrongly
 * created as a UI context.
 *
 * Made by Race Williams.
 */
@RunWith(AndroidJUnit4.class)
public class NotUIContextTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals(false, appContext.isUiContext());
    }
}