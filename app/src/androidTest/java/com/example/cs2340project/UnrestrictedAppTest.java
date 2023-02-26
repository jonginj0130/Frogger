package com.example.cs2340project;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * UnrestrictedAppTest tests the app's context.
 *
 * If the context is restricted (i.e., it is a Context instance
 * that has been sandboxed or otherwise restricted by the system),
 * this test will fail.
 *
 * Made by Race Williams.
 */
@RunWith(AndroidJUnit4.class)
public class UnrestrictedAppTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals(false, appContext.isRestricted());
    }
}