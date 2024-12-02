package com.drive.tools;

public class Result<T> {
    private final T value;
    private final Exception exception;
    private final String errorRoute;

    public Result(T value, Exception exception, String errorRoute) {
        this.value = value;
        this.exception = exception;
        this.errorRoute = errorRoute;
    }

    public T getValue() {
        return value;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.exception.getMessage();
    }

    public String getErrorRoute() {
        return errorRoute;
    }

    public boolean isError() {
        return exception != null;
    }

    public boolean isOk() {
        return exception == null;
    }

    public static <T> Result<T> error(Result<?> result) {
        return new Result<T>(null, result.exception, result.errorRoute);
    }

    public static <T> Result<T> error(Exception exception, Class<?> _class, String method) {
        return new Result<T>(null, exception, String.format("%s::%s", _class.getName(), method));
    }

    public static <T> Result<T> error(String exception, Class<?> _class, String method) {
        return new Result<T>(null, new Exception(exception), String.format("%s::%s", _class.getName(), method));
    }

    public static <T> Result<T> success(T value) {
        return new Result<T>(value, null, "");
    }
}
