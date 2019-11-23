package com.aqacourses.xpath;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(OpenPage.class);
    }

}
