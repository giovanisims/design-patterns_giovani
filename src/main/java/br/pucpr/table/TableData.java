package br.pucpr.table;

import java.util.List;

public interface TableData<T> {
    List<String> getHeaders();

    List<String> getRowValues(T row);
}
