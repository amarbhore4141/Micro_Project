package com.neosoft.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "PRODUCT_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_PRICE")
    private double price;
    @Column(name = "PRODUCT_QUANTITY")
    private long quantity;
    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "MODIFIED_DATE",insertable = false)
    @UpdateTimestamp
    private LocalDate modifiedDate;
}
