package br.com.gourmetgame.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class No {

    private No leftNo;
    private No rightNo;
    private String value;

    public No(String value) {
        this.value = value;
    }

}
