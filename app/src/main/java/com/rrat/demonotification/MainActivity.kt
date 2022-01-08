package com.rrat.demonotification

import android.app.Notification
import android.app.PendingIntent
import android.app.Person
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.rrat.demonotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val NOTIFICATION_ID = 888
    private lateinit var mNotificationManagerCompat: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mNotificationManagerCompat = NotificationManagerCompat.from(this@MainActivity)

        binding.btnInbox.setOnClickListener {
            generateInboxStyle()
        }

        binding.btnBigImage.setOnClickListener {
            generateBigPicture()
        }

    }

    private fun generateInboxStyle()
    {
        val notificationChannelID : String =
            NotificationUtil().createInboxStyleNotificationChannel(this)


        val inboxStyle = NotificationCompat.InboxStyle()
            .setBigContentTitle(InboxStyleMockData.mBigContentTitle)
            .setSummaryText(InboxStyleMockData.mSummaryText)

        for(summary in InboxStyleMockData.mIndividualEmailSummary())
        {
            inboxStyle.addLine(summary)
        }

        val mainIntent =  Intent(this, MainActivity::class.java)

        val mainPendingIntent = PendingIntent.getActivity(
            this,
            0,
            mainIntent,
            PendingIntent.FLAG_UPDATE_CURRENT,
        )

        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext,
            notificationChannelID
        )

        notificationCompatBuilder.setStyle(inboxStyle)
            .setContentTitle(InboxStyleMockData.mContentTitle)
            .setContentText(InboxStyleMockData.mContentText)
            .setSmallIcon(R.drawable.ic_stat_notification)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_person_24))
            .setContentIntent( mainPendingIntent )
            .setSubText(InboxStyleMockData.mNumberOfNewEmails.toString())
            .setCategory(Notification.CATEGORY_EMAIL)
            .setPriority(InboxStyleMockData.mPriority)
            .setVisibility(InboxStyleMockData.mChannelLockScreenVisibility)
            .setDefaults(NotificationCompat.DEFAULT_ALL).color =
            ContextCompat.getColor(applicationContext, R.color.purple_500)


        for (name in InboxStyleMockData.mParticipants())
        {
            notificationCompatBuilder.addPerson(name)
        }

        val notification = notificationCompatBuilder.build()

        mNotificationManagerCompat.notify(NOTIFICATION_ID, notification)
    }

    private fun generateBigPicture()
    {
        val notificationChannelID : String =
            NotificationUtil().createBigPictureStyleNotificationChannel(this)


        val bigPictureStyle = NotificationCompat.BigPictureStyle()
            .bigPicture(BitmapFactory.decodeResource(resources, BigPictureMockData.mBigImage))
            .setBigContentTitle(BigPictureMockData.mBigContentTitle)
            .setSummaryText(BigPictureMockData.mSummaryText)


        val mainIntent =  Intent(this, MainActivity::class.java)

        val mainPendingIntent = PendingIntent.getActivity(
            this,
            0,
            mainIntent,
            PendingIntent.FLAG_UPDATE_CURRENT,
        )

        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext,
            notificationChannelID
        )

        notificationCompatBuilder.setStyle(bigPictureStyle)
            .setContentTitle(BigPictureMockData.mContentTitle)
            .setContentText(BigPictureMockData.mContentText)
            .setSmallIcon(R.drawable.ic_stat_notification)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_person_24))
            .setContentIntent( mainPendingIntent )
            .setSubText(1.toString())
            .setCategory(Notification.CATEGORY_SOCIAL)
            .setPriority(BigPictureMockData.mPriority)
            .setVisibility(BigPictureMockData.mChannelLockScreenVisibility)
            .setDefaults(NotificationCompat.DEFAULT_ALL).color =
            ContextCompat.getColor(applicationContext, R.color.purple_500)


        for (name in BigPictureMockData.mParticipants())
        {
            notificationCompatBuilder.addPerson(name)
        }

        val notification = notificationCompatBuilder.build()

        mNotificationManagerCompat.notify(NOTIFICATION_ID, notification)
    }
}