package com.mintra.backend.entities;

import com.mintra.backend.enums.Status;
import com.mintra.backend.enums.OrderPaymentStatus;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "ORDERS")
@NamedQueries({@NamedQuery(name = "getOrdersByUserName", query = "SELECT o FROM Orders o WHERE o.userName =:userName"),
        @NamedQuery(name = "getOrdersById", query = "SELECT o FROM Orders o WHERE o.id =:id"),
        @NamedQuery(name = "getOrdersByIdAndUserName", query = "SELECT o FROM Orders o WHERE o.id =:id AND o.userName =:userName")})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "productId")
    private long productId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "userName")
    private String userName;
    @Column(name = "deliveryAddressId")
    private long deliveryAddressId;
    @Column(name = "orderPaymentStatus")
    private OrderPaymentStatus orderPaymentStatus;
    @Column(name = "status")
    private Status status;
    @Column(name = "expectedDeliveryDate")
    private Date expectedDeliveryDate;

    public Orders() {
    }

    public Orders(long productId, int quantity, String userName, long deliveryAddressId,
                  OrderPaymentStatus orderPaymentStatus, Status status, Date expectedDeliveryDate) {
        this.productId = productId;
        this.quantity = quantity;
        this.userName = userName;
        this.deliveryAddressId = deliveryAddressId;
        this.orderPaymentStatus = orderPaymentStatus;
        this.status = status;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
