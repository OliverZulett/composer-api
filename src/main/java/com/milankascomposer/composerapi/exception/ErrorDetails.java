package com.milankas.training.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ErrorDetails {

    private final String message;
    private final String details;

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.forLanguageTag("en"))
                .format(ZonedDateTime.now(ZoneId.of("America/La_Paz")));
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
