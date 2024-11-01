package mockito.presentation.h.argumentcapturing;

import lombok.ToString;

@ToString
public class Booking {

    private Table table;

    public Booking(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}
