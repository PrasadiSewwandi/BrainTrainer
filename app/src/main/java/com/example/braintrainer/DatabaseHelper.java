package com.example.braintrainer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BrainTainer.db";
    public static final String TABLE_NAME = "Details_of_all_game_levels";
    public static final String COL_1 = "Level";
    public static final String COL_2 = "Max_Marks";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public int getCurrentLevel(){
        ArrayList<ScoreEntry> scoreEntries = getScoreEntries();
       if(scoreEntries.size()==0){
           return 1;
       }
        ScoreEntry scoreEntry = scoreEntries.get(scoreEntries.size() - 1);
       return scoreEntry.getLevel();

    }

    public void insertScoreEntry(ScoreEntry scoreEntry){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "insert or replace into " + TABLE_NAME + "("+COL_1+","+COL_2+") values (" +
                scoreEntry.getLevel()+ ","+scoreEntry.getScore()+")";
        db.execSQL(sql);
    }

    public ArrayList<ScoreEntry> getScoreEntries (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        ArrayList<ScoreEntry> scoreEntries = new ArrayList<>();
        while (cursor.moveToNext()){
            ScoreEntry scoreEntry = new ScoreEntry(cursor.getInt(0),cursor.getInt(1));
            scoreEntries.add(scoreEntry);

        }
        return scoreEntries;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME + "(Level INTEGER PRIMARY KEY,  Max_Marks INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int scoreReturner(Integer curenetLevel){
        int curentLevelScore=0;
        ArrayList<ScoreEntry> scoreEntries = getScoreEntries();
        for (int i = 0; i < scoreEntries.size(); i++) {
            if(scoreEntries.get(i).getLevel()==curenetLevel){
                 curentLevelScore = scoreEntries.get(i).getScore();
            }

        }
        return curentLevelScore;
    }
    public void dropDataBase(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " +TABLE_NAME );

    }


}
