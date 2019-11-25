package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDbProvider {

    private static DTSAppDatabase instance;
    private static DTSAppDatabase asynchronousInstance;
    private static DTSAppDatabase getAsynchronousInstance;

    public static DTSAppDatabase getAsynchronousInstance(Context context)
    {
        if(AppDbProvider.instance == null)
        {
            AppDbProvider.instance = Room.databaseBuilder(
                    context, DTSAppDatabase.class, "dtsapp.db").allowMainThreadQueries().build();
        }

        return AppDbProvider.getAsynchronousInstance;
    }
}