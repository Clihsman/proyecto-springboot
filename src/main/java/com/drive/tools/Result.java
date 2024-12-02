package com.drive.tools;

/**
 * A generic class used to represent the result of an operation. It can
 * encapsulate a successful result
 * or an error, allowing better handling of success and failure scenarios in
 * your application.
 * 
 * @param <T> The type of the result value. Can be any object that you want to
 *            return as a result.
 */
public class Result<T> {

    /**
     * The value of the result, which is present if the operation was successful.
     */
    private final T value;

    /**
     * The exception that was encountered during the operation, if any.
     */
    private final Exception exception;

    /**
     * The route or location where the error occurred, typically a method or class.
     */
    private final String errorRoute;

    /**
     * Constructs a Result object with the provided value, exception, and error
     * route.
     * 
     * @param value      The successful result value, can be null if an error
     *                   occurred.
     * @param exception  The exception encountered, or null if the operation was
     *                   successful.
     * @param errorRoute The route of the error, typically a method or class name.
     */
    private Result(T value, Exception exception, String errorRoute) {
        this.value = value;
        this.exception = exception;
        this.errorRoute = errorRoute;
    }

    /**
     * Gets the result value.
     * 
     * @return The value of the result, or null if there was an error.
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets the exception that occurred during the operation.
     * 
     * @return The exception encountered, or null if there was no error.
     */
    public Exception getException() {
        return this.exception;
    }

    /**
     * Checks if the stored exception is of the specified type.
     *
     * @param exception the {@code Class} object representing the exception type to
     *                  compare against.
     * @return {@code true} if the stored exception is of the specified type,
     *         {@code false} otherwise.
     * @throws NullPointerException if the provided {@code exception} class is null.
     */
    public boolean isException(Class<?> exception) {
        return this.exception.getClass().equals(exception);
    }

    /**
     * Gets the error message from the exception, if present.
     * 
     * @return The message of the exception, or null if there was no exception.
     */
    public String getMessage() {
        return this.exception != null ? this.exception.getMessage() : null;
    }

    /**
     * Gets the route where the error occurred, typically a class and method name.
     * 
     * @return The error route as a string.
     */
    public String getErrorRoute() {
        return errorRoute;
    }

    /**
     * Checks if the operation resulted in an error.
     * 
     * @return true if there was an error, false if the operation was successful.
     */
    public boolean isError() {
        return exception != null;
    }

    /**
     * Checks if the operation was successful.
     * 
     * @return true if the operation was successful, false if there was an error.
     */
    public boolean isOk() {
        return exception == null;
    }

    /**
     * Creates a Result indicating an error, based on another Result instance.
     * 
     * @param result The Result instance containing the error.
     * @param <T>    The type of the result value.
     * @return A new Result instance with the error information.
     */
    public static <T> Result<T> error(Result<?> result) {
        return new Result<T>(null, result.exception, result.errorRoute);
    }

    /**
     * Creates a Result indicating an error with the provided exception and error
     * 
     * @param exception The exception encountered.
     * @param <T>       The type of the result value.
     * @return A new Result instance with the error information.
     */
    public static <T> Result<T> error(Exception exception) {
        return new Result<T>(null, exception, "");
    }

    /**
     * Creates a Result indicating an error with the provided exception and error
     * route.
     * 
     * @param exception The exception encountered.
     * @param _class    The class where the error occurred.
     * @param method    The method where the error occurred.
     * @param <T>       The type of the result value.
     * @return A new Result instance with the error information.
     */
    public static <T> Result<T> error(Exception exception, Class<?> _class, String method) {
        return new Result<T>(null, exception, String.format("%s::%s", _class.getName(), method));
    }

    /**
     * Creates a Result indicating an error with a string message and error route.
     * 
     * @param exception The string message representing the error.
     * @param _class    The class where the error occurred.
     * @param method    The method where the error occurred.
     * @param <T>       The type of the result value.
     * @return A new Result instance with the error information.
     */
    public static <T> Result<T> error(String exception, Class<?> _class, String method) {
        return new Result<T>(null, new Exception(exception), String.format("%s::%s", _class.getName(), method));
    }

    /**
     * Creates a Result indicating a successful operation, with the provided value.
     * 
     * @param value The value representing the successful result.
     * @param <T>   The type of the result value.
     * @return A new Result instance indicating success with the provided value.
     */
    public static <T> Result<T> success(T value) {
        return new Result<T>(value, null, "");
    }
}