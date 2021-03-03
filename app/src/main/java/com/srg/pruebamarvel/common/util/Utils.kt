package com.srg.pruebamarvel.common.util

/**
 * Created by sebrodgar on 01/03/2021.
 */
inline fun <reified T : Enum<T>> fromEnum(enumValueStringName: String?, defaultValue: T) =
    if (enumValueStringName == null) defaultValue
    else {
        enumValues<T>().forEach { enumValue ->
            if (enumValue.toString().toUpperCase().trim() == enumValueStringName.toUpperCase()
                    .trim()
            ) {
                return enumValue
            }
        }
        defaultValue
    }