package com.google.cloud.android.reminderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by 이상원 on 2017-08-06.
 *
 * 알람이 울려야 할 시간이 되었을 때, 녹음 파일과, 리마인더 텍스트를 가져와 알람을 울리도록 하는
 * @see AlarmSoundService
 * 로 intent를 통해 정보를 보낸다.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent mServiceintent = new Intent(context, AlarmSoundService.class);

        String fileName = intent.getStringExtra("filename");
        String alarmText = intent.getStringExtra("alarmtext");
        System.out.println("알람텍스트 in AlarmReceiver : " + alarmText);
        mServiceintent.putExtra("filename", fileName);
        mServiceintent.putExtra("alarmtext", alarmText);

        context.startService(mServiceintent);
    }
}