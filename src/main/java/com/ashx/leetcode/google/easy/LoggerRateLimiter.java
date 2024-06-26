package com.ashx.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/logger-rate-limiter/">Leetcode</a>
 */
public class LoggerRateLimiter {
    private final Map<String, Integer> logs;

    public LoggerRateLimiter() {
        logs = new HashMap<>();
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1, "foo")); // true
        System.out.println(logger.shouldPrintMessage(2, "bar")); // true
        System.out.println(logger.shouldPrintMessage(3, "foo")); // false
        System.out.println(logger.shouldPrintMessage(8, "bar")); // false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // true
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer tp = logs.get(message);
        if (tp == null || timestamp - tp >= 10) {
            logs.put(message, timestamp);
            return true;
        }
        return false;
    }
}
