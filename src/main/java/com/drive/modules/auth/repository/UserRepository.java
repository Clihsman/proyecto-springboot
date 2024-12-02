package com.drive.modules.auth.repository;

import org.springframework.stereotype.Service;

import com.drive.crud.ICrud;
import com.drive.tools.Result;
import com.drive.modules.auth.model.UserModel;

@Service
public class UserRepository implements ICrud<UserModel> {

    @Override
    public Result<UserModel> create(UserModel value) {
        return Result.error("Unimplemented method 'create'", UserRepository.class, "create");
    }

    @Override
    public Result<UserModel> readById(int id) {
        return Result.error("Unimplemented method 'readById'", UserRepository.class, "readById");
    }

    public Result<UserModel> readByEmail(String email) {

        if (email.equals("clihsman.cs@gmail.com"))
            return Result.success(new UserModel("clihsman.cs@gmail.com"));
        return Result.success(null);
    }

    @Override
    public Result<UserModel[]> readAll() {
        return Result.error("Unimplemented method 'readAll'", UserRepository.class, "readAll");
    }

    @Override
    public Result<Integer> update(UserModel value) {
        return Result.error("Unimplemented method 'update'", UserRepository.class, "update");
    }

    @Override
    public Result<Integer> delete(UserModel id) {
        return Result.error("Unimplemented method 'delete'", UserRepository.class, "delete");
    }

    @Override
    public Result<Integer> deleteById(int id) {
        return Result.error("Unimplemented method 'deleteById'", UserRepository.class, "deleteById");
    }
}
