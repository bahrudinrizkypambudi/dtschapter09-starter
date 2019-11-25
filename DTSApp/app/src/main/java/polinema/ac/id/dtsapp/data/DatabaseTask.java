package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class DatabaseTask extends AsyncTask<Object, Void, Void> {
    private WeakReference<Context> databaseContext;
    private DatabaseTaskEventListener eventListener;
    private Object operationResult;

    public DatabaseTask(Context databaseContext, DatabaseTaskEventListener eventListener)
    {
        this.databaseContext = new WeakReference<>(databaseContext);
        this.eventListener = eventListener;
    }

    @Override
    protected Void doInBackground(Object... objects)
    {
        // Mendapatkan instance database asynchronous dari AppDbProvider
        RoomDatabase database = AppDbProvider.getAsynchronousInstance(this.databaseContext.get());

        // Melemparkan instance database tadi ke event listener untuk diambil DAO-nya nanti
        this.operationResult = this.eventListener.runDatabaseOperation(database, objects);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        // Memberitahukan ke event listener bahwasanya operasi yang dilakukan di-background telah selesai
        this.eventListener.onDatabaseOperationFinished(this.operationResult);
    }
}
