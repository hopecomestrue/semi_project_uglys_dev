package com.veg.seoj.cscenter.model.dto;

import com.veg.seoj.cscenter.model.dao.ResultSetMapper;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brief description of functions
 *
 * @author J
 * @version 2023-11-21
 */
@Data
@Builder
public class DAOImplRefund  implements ResultSetMapper<DAOImplRefund> {
    @Builder.Default
    private int refundNo = 0;
    @Builder.Default
    private int orderNo = 0;
    @Builder.Default
    private String refundReason = "";
    @Builder.Default
    private String refundResult = "";
    @Builder.Default
    private Date refundDate = null;


    @Override
    public DAOImplRefund fromResultSet(ResultSet rs, String type) throws SQLException {
        DAOImplRefundBuilder builder = DAOImplRefund.builder()
                .refundNo(rs.getInt("REFUND_NO"))
                .orderNo(rs.getInt("ORDER_NO"))
                .refundReason(rs.getString("REFUND_REASON"))
                .refundResult(rs.getString("REFUND_RESULT"))
                .refundDate(rs.getDate("REFUND_DATE"));
        return builder.build();
    }

}
