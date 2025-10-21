package com.apmaco.login_sample_ahmadvand.utils;

public class XmlParser {
    public static String extractTagValue(String xml, String tagName) {
        String startTag = "<" + tagName + ">";
        String endTag = "</" + tagName + ">";
        int start = xml.indexOf(startTag);
        int end = xml.indexOf(endTag);
        if (start != -1 && end != -1) {
            return xml.substring(start + startTag.length(), end);
        }
        return "";
    }
}