package com.drive.crud;

import com.drive.tools.Result;

public interface ICreate<T> {
    public Result<T> create(T value);
}