package com.br.tecbacV2.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SqlResultSetMapping(
        name="ClientesCarrinhoMapping",
        classes={
                @ConstructorResult(
                        targetClass= Cliente.class,
                        columns={
                                @ColumnResult(name="id", type=Long.class),
                                @ColumnResult(name="nome")})})

@Getter
@Setter
public class Carrinho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer tamanho;
    private String Setor;

}
