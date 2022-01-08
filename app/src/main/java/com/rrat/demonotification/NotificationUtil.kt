package com.rrat.demonotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class NotificationUtil {

    fun createInboxStyleNotificationChannel(context: Context) : String{

        val channelID: String = InboxStyleMockData.mChannelID

        val channelName: String = InboxStyleMockData.mChannelName
        val channelDescription: String = InboxStyleMockData.mChannelDescription
        val channelImportance: Int = InboxStyleMockData.mChannelImportance
        val channelEnableVibrate: Boolean = InboxStyleMockData.mChannelEnableVibrate
        val channelLocksScreenVisibility: Int = InboxStyleMockData.mChannelLockScreenVisibility


        //Iniciar Notification Channel
        val notificationChannel = NotificationChannel(channelID, channelName, channelImportance)

        notificationChannel.description = channelDescription
        notificationChannel.enableVibration(channelEnableVibrate)
        notificationChannel.lockscreenVisibility = channelLocksScreenVisibility

        //Crear Notification Manager
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        return channelID
    }


    fun createBigPictureStyleNotificationChannel(context: Context) : String{

        val channelID: String = BigPictureMockData.mChannelID

        val channelName: String = BigPictureMockData.mChannelName
        val channelDescription: String = BigPictureMockData.mChannelDescription
        val channelImportance: Int = BigPictureMockData.mChannelImportance
        val channelEnableVibrate: Boolean = BigPictureMockData.mChannelEnableVibrate
        val channelLocksScreenVisibility: Int = BigPictureMockData.mChannelLockScreenVisibility


        //Iniciar Notification Channel
        val notificationChannel = NotificationChannel(channelID, channelName, channelImportance)

        notificationChannel.description = channelDescription
        notificationChannel.enableVibration(channelEnableVibrate)
        notificationChannel.lockscreenVisibility = channelLocksScreenVisibility

        //Crear Notification Manager
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        return channelID
    }
}