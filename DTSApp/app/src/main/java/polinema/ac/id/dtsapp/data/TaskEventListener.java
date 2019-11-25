package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.RoomDatabase;

public interface TaskEventListener {

    Object runDatabaseOperation(RoomDatabase database, Object... params);
    void onDatabaseOperationFinished(Object... results);
}
