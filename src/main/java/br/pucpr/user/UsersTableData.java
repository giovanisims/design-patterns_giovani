package br.pucpr.user;

import br.pucpr.table.model.ColumnTableData;
import java.util.Collection;
import java.util.List;

public class UsersTableData extends ColumnTableData<User> {

  public UsersTableData(Collection<? extends User> users, boolean maskCpf) {
    super(
        users,
        List.of(new IdColumn(), new NameColumn(), new CpfColumn(maskCpf), new EmailColumn()));
  }

  public UsersTableData(Collection<? extends User> users) {
    this(users, true);
  }
}
