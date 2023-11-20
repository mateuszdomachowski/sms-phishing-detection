package org.mateuszdomachowski;

import java.util.List;

public class Recipient {

    private String number;
    private boolean filterEnable;

    public Recipient() {

        Recipient recipient1 = new Recipient("48700800999", true);
        Recipient recipient2 = new Recipient("48700123456", false);
        Recipient recipient3 = new Recipient("48900200399", false);
    }

    public Recipient(String number, boolean filterEnable) {
        this.number = number;
        this.filterEnable = filterEnable;
    }

    private List
}
