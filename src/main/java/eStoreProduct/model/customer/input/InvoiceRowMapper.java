package eStoreProduct.model.customer.input;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

public class InvoiceRowMapper implements RowMapper<Invoice> {
	@Override
	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoice invoice = new Invoice();
		invoice.setOrderId(rs.getLong("ordr_id"));
		invoice.setBillNo(rs.getString("ordr_billno"));
		invoice.setOrderDate(rs.getObject("ordr_odate", LocalDate.class));
		invoice.setPaymentMode(rs.getString("ordr_paymode"));
		invoice.setShippingAddress(rs.getString("ordr_saddress"));
		invoice.setShipmentDate(rs.getObject("ordr_shipment_date", LocalDate.class));
		invoice.setQuantity(rs.getInt("orpr_qty"));
		invoice.setGst(rs.getDouble("orpr_gst"));
		invoice.setPrice(rs.getDouble("orpr_price"));
		return invoice;
	}
}
