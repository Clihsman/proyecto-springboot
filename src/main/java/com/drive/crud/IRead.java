package com.drive.crud;

import com.drive.tools.Result;

public interface IRead<T> {
    public Result<T> readById(int id);
    public Result<T[]> readAll();
}

