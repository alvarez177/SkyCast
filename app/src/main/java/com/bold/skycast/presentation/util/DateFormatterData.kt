package com.bold.skycast.presentation.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

class DateFormatterData @Inject constructor(
    private val locale: Locale
) : DateFormatter {

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun dayOfWeek(date: String): String {
        val parsedDate = LocalDate.parse(date, formatter)
        val today = LocalDate.now()

        return if (parsedDate.isEqual(today)) {
            "Hoy"
        } else {
            parsedDate.dayOfWeek.getDisplayName(
                TextStyle.FULL,
                locale
            )
        }
    }
}