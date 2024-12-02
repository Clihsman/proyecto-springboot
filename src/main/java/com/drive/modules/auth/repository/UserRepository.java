package com.drive.modules.auth.repository;

import com.drive.crud.ICrud;
import com.drive.tools.Result;

public class UserRepository<UserModel> implements ICrud<UserModel> {

    @Override
    public Result<UserModel> create(Object value) {
        return Result.error("Unimplemented method 'create'", UserRepository.class, "create");
    }

    @Override
    public Result<UserModel> readById(int id) {
        return Result.error("Unimplemented method 'readById'", UserRepository.class, "readById");
    }

    @Override
    public Result<UserModel[]> readAll() {
        return Result.error("Unimplemented method 'readAll'", UserRepository.class, "readAll");
    }

    @Override
    public Result<Integer> update(Object value) {
        return Result.error("Unimplemented method 'update'", UserRepository.class, "update");
    }

    @Override
    public Result<Integer> delete(Object id) {
        return Result.error("Unimplemented method 'delete'", UserRepository.class, "delete");
    }

    @Override
    public Result<Integer> deleteById(int id) {
        return Result.error("Unimplemented method 'deleteById'", UserRepository.class, "deleteById");
    }
}
