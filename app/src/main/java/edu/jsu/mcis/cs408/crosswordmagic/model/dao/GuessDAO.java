package edu.jsu.mcis.cs408.crosswordmagic.model.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

public class GuessDAO {

    private final DAOFactory daoFactory;

    GuessDAO(DAOFactory daoFactory) { this.daoFactory = daoFactory; }

    public int create(HashMap<String, String> params) {

        /* use this method if there is NOT already a SQLiteDatabase open */

        SQLiteDatabase db = daoFactory.getWritableDatabase();
        int result = create(db, params);
        db.close();
        return result;

    }

    public int create(SQLiteDatabase db, HashMap<String, String> params) {

        /* use this method if there IS already a SQLiteDatabase open */

        String puzzleid = daoFactory.getProperty("sql_field_puzzleid");
        String wordid = daoFactory.getProperty("sql_field_wordid");

        ContentValues values = new ContentValues();
        values.put(puzzleid, params.get(puzzleid));
        values.put(wordid, params.get(wordid));

        int key = (int)db.insert(daoFactory.getProperty("sql_table_guesses"), null, values);

        return key;

    }
}
