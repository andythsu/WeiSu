package example.com.weisu;

import android.os.AsyncTask;
import android.os.Build;

/**
 * @Author: Andy Su
 * @Date: 2019-01-26
 */
public class Util {
    public static AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
}
