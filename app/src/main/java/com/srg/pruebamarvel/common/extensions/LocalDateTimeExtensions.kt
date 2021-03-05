package com.srg.pruebamarvel.common.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by sebrodgar on 05/03/2021.
 */

fun LocalDateTime.marvelFormat(): String =
    this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
