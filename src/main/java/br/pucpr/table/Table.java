package br.pucpr.table;

import br.pucpr.user.Theme;
import java.util.List;

public class Table {
    private static final String INITIAL_SEPARATOR = "| ";
    private static final String SEPARATOR = " | ";
    private static final String FINAL_SEPARATOR = " |\n";
    private static final String RIGHT_ALIGN_PADDING = " ".repeat(20);

    public <T extends TableData<T>> void print(List<T> items, boolean allignRight, Theme theme) {
        if (items == null || items.isEmpty()) {
            System.out.println("ERRO: Lista de usuários vazia ou nula.");
            return;
        }

        final String borderChar = theme.getBorderChar();
        TableData<T> tableData = items.get(0);
        List<String> headers = tableData.getHeaders();

        int headerLength = 0;
        for (String header : headers) {
            headerLength += header.length();
        }

        int borderWidth = headerLength + (headers.size() * SEPARATOR.length()) + INITIAL_SEPARATOR.length();

        var sb = new StringBuilder();

        // WRITE HEADER
        sb.repeat(borderChar, borderWidth).append("\n");
        sb.append(INITIAL_SEPARATOR);
        for (int i = 0; i < headers.size(); i++) {
            sb.append(headers.get(i));
            if (i < headers.size() - 1) {
                sb.append(SEPARATOR);
            }
        }
        sb.append(FINAL_SEPARATOR);
        sb.repeat(borderChar, borderWidth).append("\n");

        // WRITE ROWS
        for (T item : items) {
            if (item == null) {
                continue;
            }

            List<String> row = tableData.getRowValues(item);
            sb.append(INITIAL_SEPARATOR);
            for (int i = 0; i < headers.size(); i++) {
                int columnWidth = headers.get(i).length();
                String column = (i < row.size() && row.get(i) != null) ? row.get(i) : "";
                sb.append(String.format("%-" + columnWidth + "s", column));
                if (i < headers.size() - 1) {
                    sb.append(SEPARATOR);
                }
            }
            sb.append(FINAL_SEPARATOR);
        }

        sb.repeat(borderChar, borderWidth).append("\n");

        if (allignRight) {
            var lines = sb.toString().split("\n");
            for (var line : lines) {
                System.out.println(RIGHT_ALIGN_PADDING + line);
            }
        } else {
            System.out.print(sb);
        }
    }
}
