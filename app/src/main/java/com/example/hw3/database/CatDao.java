package com.example.hw3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw3.model.Cat;

import java.util.List;

@Dao
public interface CatDao {
    //Get all cats
    @Query("SELECT * FROM cat")
    List<Cat> getAll();


    //Get cat by it's id
    @Query("SELECT * FROM cat WHERE id = :id")
    Cat findCatById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Cat> cats);

    @Delete
    void delete(Cat cat);
}
