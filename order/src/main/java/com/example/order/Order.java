package com.example.order;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @SequenceGenerator(
            name="orders_id_sequence",
            sequenceName="orders_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_id_sequence"
    )
    private long id;
    private long userId;
    private long productId;
    private Date createdAt;
}
