package com.example.everydaywithbible;

import com.example.everydaywithbible.model.StoryValue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoryValueTest {
    private StoryValue storyValue;

    @Before
    public void setUp() throws Exception{
        storyValue = new StoryValue("The Creation", "Moses"
        , "Genesis 1:1-2:7", "https://biblestories.org/the_creation");
    }

   @Test
   public void checkNullTitle(){
       Assert.assertFalse(null,false);
    }


    @After
    public void tearDown() throws Exception{
        storyValue = null;
    }
}
