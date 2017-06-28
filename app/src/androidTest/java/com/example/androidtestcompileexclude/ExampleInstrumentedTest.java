package com.example.androidtestcompileexclude;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.WeekFields;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final DateTimeFormatter YEAR_WEEK = new DateTimeFormatterBuilder()
            .appendPattern("YYYY-w")
            .parseDefaulting(WeekFields.ISO.dayOfWeek(), 1)
            .toFormatter(Locale.getDefault());

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.androidtestcompileexclude", appContext.getPackageName());
    }

    @Test
    public void testDate() {
        final TemporalField WEEK = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();

        LocalDate current = LocalDate.now();

        int weekOfYear = current.get(WEEK);
        assertNotEquals(0, weekOfYear);
    }
}
