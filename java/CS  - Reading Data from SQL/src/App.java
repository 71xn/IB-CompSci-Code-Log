

public class App {

    static public SQL sqlObj = new SQL("localhost","cs","root","password");

    public static SQL getSqlObj() {
        return sqlObj;
    }

    public static void main(String[] args) {

        GUI.main(new String[]{""});

    }

}
