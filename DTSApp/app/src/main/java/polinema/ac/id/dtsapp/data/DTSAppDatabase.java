package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import polinema.ac.id.dtsapp.data.User;
import polinema.ac.id.dtsapp.data.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DTSAppDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
}
