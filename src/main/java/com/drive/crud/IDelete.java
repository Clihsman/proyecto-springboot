package com.drive.crud;

import com.drive.tools.Result;

public interface IDelete<T> {
    public Result<Integer> delete(T id);
    public Result<Integer> deleteById(int id);
}
