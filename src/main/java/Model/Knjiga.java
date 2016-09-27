package Model;

import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by android on 27.9.16..
 */
@DatabaseTable(tableName = "knjiga")

public class Knjiga {

    public static final String POLJE_NASLOV = "naslov";
    public static final String POLJE_BROJ_STRANA = "broj_strana";
    public static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja";

    private int id;
    private String naslov;
    private int brojStrana;
    private Date datumIzdanja;
    private boolean prisutna;
}
