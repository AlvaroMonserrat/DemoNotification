package com.rrat.demonotification

import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object BigPictureMockData {

    const val mContentTitle = "Bob's post"
    const val mContentText = "[Picture] the Earth"
    const val mPriority = NotificationCompat.PRIORITY_HIGH

    const val mBigImage = R.drawable.earth
    const val mBigContentTitle = "Bob's post"
    const val mSummaryText = "the Earth"

    fun mParticipants(): ArrayList<String>{

        val list = ArrayList<String>()

        list.add("Bob Smith")

        return  list
    }

    const val mChannelID = "channel_social_1"
    const val mChannelName = "Sample Social"
    const val mChannelDescription = "Sample Social Notifications"
    const val mChannelImportance = NotificationManager.IMPORTANCE_HIGH
    const val mChannelEnableVibrate = true
    const val mChannelLockScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}