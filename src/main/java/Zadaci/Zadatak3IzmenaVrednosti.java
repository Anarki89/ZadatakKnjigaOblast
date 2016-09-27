package Zadaci;

import Model.Knjiga;
import Model.Oblast;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by android on 27.9.16..
 */
public class Zadatak3IzmenaVrednosti {

    static Dao<Oblast,Integer> oblastDao;
    static Dao<Knjiga,Integer> knjigaDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(konstante.DATABASE_URL);

            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);

            List<Oblast> oblasts = oblastDao.queryForAll();
            for (Oblast oblast : oblasts)
                System.out.println(oblast);

            List<Oblast> pocetnaStranaZaIzmenu = oblastDao.queryForEq(Oblast.POLJE_NAZIV,"Activity klasa");
            for (Oblast o : pocetnaStranaZaIzmenu) {
                o.setPocetnaStrana(35);
                oblastDao.update(o);
            }

            List<Oblast> oblasts1 = oblastDao.queryForAll();
            for (Oblast oblast : oblasts1)
                System.out.println(oblast);


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

