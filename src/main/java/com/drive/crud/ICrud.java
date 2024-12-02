package com.drive.crud;

public interface ICrud<T> extends ICreate<T>, IRead<T>, IUpdate<T>, IDelete<T> {
}
