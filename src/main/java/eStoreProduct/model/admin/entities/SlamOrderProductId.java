package eStoreProduct.model.admin.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SlamOrderProductId implements Serializable {

	private SlamOrderModel slamOrder;
	private Integer productId;

	// Constructors, equals, and hashCode methods (omitted for brevity)
}
