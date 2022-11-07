package com.example.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {
    @Id
    @SequenceGenerator(
            name="seller_id_sequence",
            sequenceName="seller_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seller_id_sequence"
    )
    private long id;
    private long productId;
    private long customerId;
    private Date orderDate;
    private Date createdAt;
    private String status;
}
