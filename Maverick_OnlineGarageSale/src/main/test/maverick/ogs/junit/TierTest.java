package maverick.ogs.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import maverick.ogs.beans.Subscriptions;
import maverick.ogs.beans.Tier;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.SubscriptionsDAO;
import maverick.ogs.dao.SubscriptionsDAOImpl;
import maverick.ogs.dao.TierDAO;
import maverick.ogs.dao.TierDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.util.HibernateUtil;

public class TierTest {
	Integer tier1;
	Integer tier2;
	Integer tier3;
	Integer tier4;
	
	Tier unverified;
	Tier verified;
	Tier premium;
	Tier admin;
	
	List<Tier> unverifiedNotAdmin;
	List<Tier> verifiedNotAdmin;
	List<Tier> verifiedAdmin;
	List<Tier> unverifiedAdmin;
	

	String id1;
	String id2;
	String id3;
	String id4;
	String id5;
	String id6;
	String id7;
	String id8;
	String id9;
	String id10;
	
	
	
	Integer subscriptions1;
	Integer subscriptions2;
	Integer subscriptions3;
	Integer subscriptions4;
	Integer subscriptions5;
	Integer subscriptions6;
	Integer subscriptions7;
	Integer subscriptions8;
	Integer subscriptions9;
	Integer subscriptions10;
	
	Date now;
	
	@Before
	public void setUp() throws Exception {
		now = new Date();
		
		TierDAO tierDAO = new TierDAOImpl();
		
		tier1 = tierDAO.addTier(new Tier("Unverified"));
		tier2 = tierDAO.addTier(new Tier("Verified"));
		tier3 = tierDAO.addTier(new Tier("Premium"));
		tier4 = tierDAO.addTier(new Tier("Admin"));
		
		unverified = tierDAO.getTierById(tier1);
		verified = tierDAO.getTierById(tier2);
		premium = tierDAO.getTierById(tier3);
		admin = tierDAO.getTierById(tier4);
		
		unverifiedNotAdmin = new ArrayList<Tier>();
		verifiedNotAdmin = new ArrayList<Tier>();
		verifiedAdmin = new ArrayList<Tier>();
		unverifiedAdmin = new ArrayList<Tier>();
		
		unverifiedNotAdmin.add(unverified);
		
		verifiedNotAdmin.add(verified);
		
		verifiedAdmin.add(verified);
		verifiedAdmin.add(admin);
		
		unverifiedAdmin.add(unverified);
		unverifiedAdmin.add(admin);
		
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		id1 = userAccountDAO.insertAccount(new UserAccount("kkay", "password", "Kristina", "Kay", "kkay@email.com", now, true, false, true, false));
		id2 = userAccountDAO.insertAccount(new UserAccount("lkay", "password", "Leon", "Kay", "lkay@email.com", now, false, false, true, false));
		id3 = userAccountDAO.insertAccount(new UserAccount("mkay", "password", "Mason", "Kay", "mkay@email.com", now, true, false, true, false));
		id4 = userAccountDAO.insertAccount(new UserAccount("nkay", "password", "Nathan", "Kay", "nkay@email.com", now, false, false, true, false));
		id5 = userAccountDAO.insertAccount(new UserAccount("okay", "password", "Owen", "Kay", "okay@email.com", now, true, false, true, false));
		id6 = userAccountDAO.insertAccount(new UserAccount("pkay", "password", "Pam", "Kay", "pkay@email.com", now, false, false, false, false));
		id7 = userAccountDAO.insertAccount(new UserAccount("qkay", "password", "Quinoaycka", "Kay", "qkay@email.com", now, true, false, false, false));
		id8 = userAccountDAO.insertAccount(new UserAccount("rkay", "password", "Ryan", "Kay", "rkay@email.com", now, false, false, false, false));
		id9 = userAccountDAO.insertAccount(new UserAccount("skay", "password", "Shelby", "Kay", "skay@email.com", now, true, false, false, false));
		id10 = userAccountDAO.insertAccount(new UserAccount("tkay", "password", "Tonya", "Kay", "tkay@email.com", now, false, false, false, false));
		
		SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAOImpl();
		subscriptions1 = subscriptionsDAO.addSubscriptions(new Subscriptions(id1, verifiedAdmin, now));
		subscriptions2 = subscriptionsDAO.addSubscriptions(new Subscriptions(id2, unverifiedAdmin, now));
		subscriptions3 = subscriptionsDAO.addSubscriptions(new Subscriptions(id3, verifiedAdmin, now));
		subscriptions4 = subscriptionsDAO.addSubscriptions(new Subscriptions(id4, unverifiedAdmin, now));
		subscriptions5 = subscriptionsDAO.addSubscriptions(new Subscriptions(id5, verifiedAdmin, now));
		subscriptions6 = subscriptionsDAO.addSubscriptions(new Subscriptions(id6, unverifiedNotAdmin, now));
		subscriptions7 = subscriptionsDAO.addSubscriptions(new Subscriptions(id7, verifiedNotAdmin, now));
		subscriptions8 = subscriptionsDAO.addSubscriptions(new Subscriptions(id8, unverifiedNotAdmin, now));
		subscriptions9 = subscriptionsDAO.addSubscriptions(new Subscriptions(id9, verifiedNotAdmin, now));
		subscriptions10 = subscriptionsDAO.addSubscriptions(new Subscriptions(id10, unverifiedNotAdmin, now));
	}

	@After
	public void tearDown() throws Exception {
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		userAccountDAO.deleteAccountByUsername("kkay");
		userAccountDAO.deleteAccountByUsername("lkay");
		userAccountDAO.deleteAccountByUsername("mkay");
		userAccountDAO.deleteAccountByUsername("nkay");
		userAccountDAO.deleteAccountByUsername("okay");
		userAccountDAO.deleteAccountByUsername("pkay");
		userAccountDAO.deleteAccountByUsername("qkay");
		userAccountDAO.deleteAccountByUsername("rkay");
		userAccountDAO.deleteAccountByUsername("skay");
		userAccountDAO.deleteAccountByUsername("tkay");
		userAccountDAO.deleteAccountByUsername("ukay");
		
		SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAOImpl();
		subscriptionsDAO.deleteSubscriptionsById(subscriptions1);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions2);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions3);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions4);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions5);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions6);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions7);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions8);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions9);
		subscriptionsDAO.deleteSubscriptionsById(subscriptions10);
		
		TierDAO tierDAO = new TierDAOImpl();
		tierDAO.deleteTierById(tier1);
		tierDAO.deleteTierById(tier2);
		tierDAO.deleteTierById(tier3);
		tierDAO.deleteTierById(tier4);
	}
	
	//Tier Tests
	@Test
	public void countTiersCreated() {
		Session session = HibernateUtil.getSession();
		Long SubscriptionsCount = (Long) session.createCriteria(Tier.class).setProjection(
				Projections.count("tier_id")
				).uniqueResult();
		session.close();	
		
		// If 4 subscriptions were created assert true, test passes.
		assertTrue(SubscriptionsCount == 4L);
	}
	
	@Test
	public void getAllTiersTest() {
		// If 10 subscriptions were created assert true, test passes.
				TierDAO tierDAO = new TierDAOImpl();
				assertTrue(tierDAO.getAllTiers().size() == 4);
	}
	
	@Test
	public void getTierByIdTest() {
		//Assert true if successfully able to get created subscriptions
		TierDAO tierDAO = new TierDAOImpl();
		assertTrue(tierDAO.getTierById(tier1) != null);
		assertTrue(tierDAO.getTierById(tier2) != null);
		assertTrue(tierDAO.getTierById(tier3) != null);
		assertTrue(tierDAO.getTierById(tier4) != null);
		
	}
	
	@Test
	public void updateTierTest() {
		TierDAO tierDAO = new TierDAOImpl();
		Tier testtier = tierDAO.getTierById(tier1);
		testtier.setName("asdf");
		assertTrue(tierDAO.updateTier(testtier));
		testtier = tierDAO.getTierById(tier1);
		//check if tier name has been updated
		assertEquals(testtier.getName(),"asdf");
	}
}
