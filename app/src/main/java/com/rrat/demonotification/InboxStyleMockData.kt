package com.rrat.demonotification

import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object InboxStyleMockData {

    const val mContentTitle = "5 new emails"
    const val mContentText = "from Jane, Jay, Alex +2 more"
    const val mNumberOfNewEmails = 5
    const val mPriority = NotificationCompat.PRIORITY_DEFAULT

    const val mBigContentTitle = "5 new emails from Jane, Jay, Alex +2 more"
    const val mSummaryText = "New emails"

    fun mIndividualEmailSummary(): ArrayList<String>{

        val list = ArrayList<String>()

        list.add("Jane Faab - Launch Party is here...")
        list.add("Jay Walker - There is a turtle on the server!")
        list.add("Alex Chang - Check this out...")
        list.add("Jane Johns - Check in code?")
        list.add("John Smith - Movies later...")

        return  list
    }

    fun mParticipants(): ArrayList<String>{

        val list = ArrayList<String>()

        list.add("Jane Faab")
        list.add("Jay Walker")
        list.add("Alex Chang")
        list.add("Jane Johns")
        list.add("John Smith")

        return  list
    }

    const val mChannelID = "channel_email_1"
    const val mChannelName = "Sample Email"
    const val mChannelDescription = "Sample Email Notifications"
    const val mChannelImportance = NotificationManager.IMPORTANCE_DEFAULT
    const val mChannelEnableVibrate = true
    const val mChannelLockScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}