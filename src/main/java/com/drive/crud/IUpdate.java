package com.drive.crud;

import com.drive.tools.Result;

public interface IUpdate<T> {
    public Result<Integer> update(T value);
}
