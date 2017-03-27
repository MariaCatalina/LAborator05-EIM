package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.TextView;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

import static android.content.ContentValues.TAG;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 9 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView

        Log.i(TAG, "onReceive: on receive intent");
        
        String action = intent.getAction();
        String data = null;
        if(Constants.ACTION_INTEGER.equals(action)){
            data = String.valueOf(intent.getIntExtra(Constants.DATA, 0));
            Log.i(TAG, "onReceive: " + data);
        }

        if(Constants.ACTION_STRING.equals(action)){
            data = intent.getStringExtra(Constants.DATA);
        }


        if(Constants.ACTION_ARRAY_LIST.equals(action)){
            data = intent.getStringExtra(Constants.DATA);
        }

        if(messageTextView != null) {
            messageTextView.setText(messageTextView.getText().toString() + "\n" + data);
        }

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
