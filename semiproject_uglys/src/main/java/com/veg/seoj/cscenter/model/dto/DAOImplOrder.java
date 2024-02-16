package com.veg.seoj.cscenter.model.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brief description of functions
 *
 * @author J
 * @version 2023-11-21
 */

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DAOImplOrder  implements ResultSetMapper<DAOImplOrder> {
    @Builder.Default
    private long orderNo=0;
    @Builder.Default
    private int MemberNo=0;
    @Builder.Default
    private String orderName="";
    @Builder.Default
    private String orderPhone="";
    @Builder.Default
    private String orderAddress="";
    @Builder.Default
    private String orderAddressDetail="";
    @Builder.Default
    private String orderComment="";
    @Builder.Default
    private int orderCount=0;
    @Builder.Default
    private int totalPrice=0;
    @Builder.Default
    private int deliveryPay=0;
    @Builder.Default
    private String payment="";
    @Builder.Default
    private String orderStatus="";
    @Builder.Default
    private long trakingNumber=0;
    @Builder.Default
    private Date orderDate=null;



    @Override
    public DAOImplOrder fromResultSet(ResultSet rs, String type) throws SQLException {
        DAOImplOrderBuilder builder = DAOImplOrder.builder()
                .orderNo(rs.getLong("ORDER_NO"))
                .MemberNo(rs.getInt("MEMBER_NO"))
                .orderName(rs.getString("ORDER_NAME"))
                .orderPhone(rs.getString("ORDER_PHONE"))
                .orderAddress(rs.getString("ORDER_ADDRESS"))
                .orderComment(rs.getString("ORDER_COMMENT"))
                .orderCount(rs.getInt("ORDER_COUNT"))
                .totalPrice(rs.getInt("TOTAL_PRICE"))
                .deliveryPay(rs.getInt("DELIVERY_PAY"))
                .payment(rs.getString("PAYMENT"))
                .orderStatus(rs.getString("ORDER_STATUS"))
                .trakingNumber(rs.getLong("TRAKING_NUMBER"))
                .orderDate(rs.getDate("ORDER_DATE"));
        return builder.build();
    }
}
