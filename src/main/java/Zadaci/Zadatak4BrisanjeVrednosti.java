package Zadaci;

import Model.Knjiga;
import Model.Oblast;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by android on 27.9.16..
 */
public class Zadatak4BrisanjeVrednosti {
    static Dao<Knjiga,Integer> knjigaDao;
    static Dao<Oblast,Integer> oblastDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(konstante.DATABASE_URL);

            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);

            List<Oblast> oblasts = oblastDao.queryForAll();
            for (Oblast o:oblasts)
                System.out.println(o);


            List<Oblast> oblastZaBrisanje = oblastDao.queryForEq(Oblast.POLJE_NAZIV,"Aritmeticki operatori");
            for (Oblast o : oblastZaBrisanje) {
                o.setNaziv("Aritmeticki operatori");
                oblastDao.delete(o);
            }

            List<Oblast> oblasts1 = oblastDao.queryForAll();
            for (Oblast o:oblasts1)
                System.out.println(o);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
