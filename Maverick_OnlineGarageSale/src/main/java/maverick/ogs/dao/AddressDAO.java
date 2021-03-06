package maverick.ogs.dao;

import maverick.ogs.beans.Address;

public interface AddressDAO {
	public String insertAddress(Address address);
	public Address getAddressById(String id);
	public Boolean deleteAddressById(String id);
}
