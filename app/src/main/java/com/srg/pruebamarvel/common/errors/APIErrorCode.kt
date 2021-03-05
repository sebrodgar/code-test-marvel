package com.srg.pruebamarvel.common.errors

/**
 * Created by sebrodgar on 01/03/2021.
 */
enum class APIErrorCode(val value: String) {
    CHARACTER_NOT_FOUND("Character not found"),
    LIMIT_GREATER_THAN_100("Limit greater than 100"),
    LIMIT_INVALID_OR_BELOW_1("Limit invalid or below 1"),
    EMPTY_PARAMETER("Empty parameter"),
    INVALID_ORDERING("Invalid or unrecognized ordering parameter"),
    MISSING_API_KEY("Missing API Key"),
    MISSING_HASH("Missing Hash"),
    MISSING_TIMESTAMP("Missing Timestamp"),
    METHOD_NOT_ALLOWED("Method Not Allowed"),
    INVALID_REFERER("Invalid Referer"),
    FORBIDDEN("Forbidden"),
    UNKNOWN("unknown")

}