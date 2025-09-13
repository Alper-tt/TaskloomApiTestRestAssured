package taskloom.base;

public final class AuthContext {
    private static final ThreadLocal<String> ACCESS_TOKEN = new ThreadLocal<>();

    private AuthContext() {}

    public static void setToken(String token) { ACCESS_TOKEN.set(token); }
    public static String getToken() { return ACCESS_TOKEN.get(); }
    public static void clear() { ACCESS_TOKEN.remove(); }
}