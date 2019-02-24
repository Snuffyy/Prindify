package ee.taltech.prindify.dto;


import lombok.Getter;
import lombok.Setter;

public class EntityQuery<T> extends ObjectQuery<T> {

    @Getter
    @Setter
    private int id;
}
