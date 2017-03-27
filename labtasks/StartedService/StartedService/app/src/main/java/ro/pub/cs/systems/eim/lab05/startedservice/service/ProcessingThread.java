package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

import static android.content.ContentValues.TAG;

/**
 * Created by Cata on 3/27/2017.
 */

public class ProcessingThread extends Thread {
    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true){
            sendMessage(Constants.MESSAGE_INTEGER);
            Log.i(TAG, "run: send integer");
            sleep();

            sendMessage(Constants.MESSAGE_STRING);
            Log.i(TAG, "run: send string");
            sleep();

            sendMessage(Constants.MESSAGE_ARRAY_LIST);
            Log.i(TAG, "run: send array");
            sleep();
        }
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch (messageType){
            case Constants.MESSAGE_INTEGER:
                intent.setAction(Constants.ACTION_INTEGER);
                intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
                break;

            case Constants.MESSAGE_STRING:
                intent.setAction(Constants.ACTION_STRING);
                intent.putExtra(Constants.DATA, Constants.STRING_DATA);
                break;

            case Constants.MESSAGE_ARRAY_LIST:
                intent.setAction(Constants.ACTION_ARRAY_LIST);
                intent.putExtra(Constants.DATA, Constants.ACTION_ARRAY_LIST);
                break;
        }

        context.sendBroadcast(intent);
    }

    private void sleep(){
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            Log.i(TAG, "sleep: " + e.getMessage());
        }
    }
}
