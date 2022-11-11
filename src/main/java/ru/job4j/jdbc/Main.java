package ru.job4j.jdbc;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String tableName = "test";
        Properties properties = PropertiesUtil.getProperties();
        try (TableEditor editor = new TableEditor(properties)) {
            editor.createTable(tableName);
            System.out.println(editor.getTableScheme(tableName));
            editor.addColumn(tableName, "id", "serial primary key");
            System.out.println(editor.getTableScheme(tableName));
            editor.renameColumn(tableName, "id", "uid");
            System.out.println(editor.getTableScheme(tableName));
            editor.dropColumn(tableName, "uid");
            System.out.println(editor.getTableScheme(tableName));
            editor.dropTable(tableName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
