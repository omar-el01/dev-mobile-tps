package ma.enset.tp3.models;

import java.io.Serializable;

public class NewsSource implements Serializable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
