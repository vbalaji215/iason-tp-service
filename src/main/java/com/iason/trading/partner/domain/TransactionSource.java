package com.iason.trading.partner.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: TransactionSource
 * Inside the package - com.iason.trading.partner.domain
 * Created Date: 5/21/2020
 * Created Time: 3:49 PM
 **/
@Entity
@Slf4j
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TransactionSource {

    /**
     * Internal id generated by the DB. This
     * will not be exposed to outside users of the
     * APIs
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ts_sequence")
    @SequenceGenerator(name="ts_sequence", sequenceName = "ts_sequence",
            initialValue = 20001, allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long transactionSourceId;

    @Column(name="transaction_source_name", nullable = false)
    private String transactionSourceName;

    @Column(name="sender_id", nullable = false)
    private String senderId;

    @Column(name="receiver_id",nullable = false)
    private String receiverId;

    @Column(name="market_place_type",nullable = false)
    private String marketPlaceType;

    /**
     * The trading partner that is associated with the transaction source
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trading_partner_id", nullable = false)
    private TradingPartner tradingPartner;

    @Column(name="effective_date", nullable = false)
    private Timestamp effectiveDate;

    @Column(name="end_date")
    private Timestamp endDate;

    @CreationTimestamp
    @Column(name="created_date", updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name="last_modified_date", updatable = false)
    private Timestamp lastModifiedDate;

}