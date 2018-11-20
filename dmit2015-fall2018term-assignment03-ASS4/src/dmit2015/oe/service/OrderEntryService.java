
package dmit2015.oe.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.omnifaces.util.Messages;

import dmit2015.oe.entity.Category;
import dmit2015.oe.entity.Customer;
import dmit2015.oe.entity.Order;
import dmit2015.oe.entity.ProductDescription;
import dmit2015.oe.entity.ProductInformation;
import dmit2015.oe.report.CategorySales;
import dmit2015.oe.report.ProductSales;

@Stateless
@PermitAll
@DeclareRoles({"Investor","	Auditor"})
public class OrderEntryService {

	@Inject
	private EntityManager entityManager;
	
	public Order findOneOrder(long orderId) {
		// TODO: Complete the code for this method	
		Order querySingleResult = null;
		try {					
			querySingleResult = entityManager.createQuery
				("SELECT o FROM Order o JOIN FETCH o.orderItems WHERE o.orderId = :idValue",
				Order.class)
				.setParameter("idValue", orderId)
				.getSingleResult();
		}catch(NoResultException e)
		{
			querySingleResult = null;
		}
		return querySingleResult;
				
//		entityManager.find(Order.class , orderId);
	}		
	public List<Order> findAllOrderByDateRange(Date startDate, Date endDate) {
		// TODO: Complete the code for this method
		 SimpleDateFormat pattern = new SimpleDateFormat ("yyyy-MM-dd");
		 try
		 {
			 startDate = pattern.parse(pattern.format(startDate));
			 Calendar newCalendar = Calendar.getInstance();
			 newCalendar.set(Calendar.HOUR_OF_DAY,23);
			 newCalendar.set(Calendar.MINUTE,59);
			 endDate=newCalendar.getTime();
		 }catch(ParseException e)
		 {
			 Messages.addGlobalError(e.getMessage());
		 }
		List<Order> orderList = new ArrayList<Order>();
		try {
			orderList = entityManager.createQuery(
					"SELECT e FROM Order e WHERE e.orderDate BETWEEN :startDate And :endDate",
					Order.class)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate)
					.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			orderList = null;
		}
		
		return orderList;
	}
		
	public List<Order> findAllOrderByCustomerId(Long customerId) {
		// TODO: Complete the code for this method
		
		return entityManager.createQuery
				("SELECT c FROM Order c WHERE c.Customer.customerId = :customerIdValue ", 
				Order.class)
				.setParameter("customerIdValue", customerId)
				.getResultList();
				
	}
	
	public Customer findOneCustomer(long customerId) {
		// TODO: Complete the code for this method
		
		return entityManager.find(Customer.class, customerId);
	}
	
	public Customer findOneCustomerByUniqueValue(String queryValue) { 
		// TODO: Complete the code for this method
		Customer querySingleResult = null;
		
		try
		{
			//long custmerId = long.parseLong(queryValue);
			long customerId = Long.parseLong(queryValue);
			querySingleResult = findOneCustomer(customerId);
					
		}catch(Exception e)
		{
			querySingleResult = (Customer)entityManager.createNativeQuery(
					"SELECT * FROM CUSTOMER c, TABLE(c.PHONE_NUMBERS) p "
					+ "WHERE c.CU_EMAIL = :emailQueryValue "
					+ "OR p.COLUMN_Value = :emailQueryValue",Customer.class)
					.setParameter("emailQueryValue", queryValue)
					.getSingleResult();
		}
		
		
		return querySingleResult;
	}
	
	
	public List<ProductInformation> findAllProductInformationByPattern(String pattern) {
		// TODO: Complete the code for this method
		List<ProductInformation> resultList = null;
		try
		{
			resultList = entityManager.createQuery
					("SELECT p FROM ProductInformation p"
					+ "WHERE p.productName LIKE :pattern", ProductInformation.class)
					.setMaxResults(30)
					.setParameter("pattern", "%"+pattern+"%")
					.getResultList();
		}catch (NoResultException e) {
			resultList = null;
		}
				
		return resultList;
	}
	
	public ProductDescription findOneProductDescription(Long productId, String languageId) {
		// TODO: Complete the code for this method
		ProductDescription querySingleResult = null;
		try
		{
			querySingleResult = entityManager.createQuery(
					"SELECT p FROM ProductInformation p"
					+"WHERE p.id.productId = :productId AND"
					+"p.id.languageId = :languageId",ProductDescription.class)
					.setParameter("productId", productId)
					.setParameter("languageId", languageId)
					.getSingleResult();
		}catch(NoResultException e) {
			querySingleResult = null;
		}
		return querySingleResult;
		
		
	}
	
	public ProductInformation findOneProductInformation(long productId) {
		// TODO: Write the code for this method
		return entityManager.find(ProductInformation.class, productId);
	}
	
	
	public Category findOneCategory(long categoryId) {
		// TODO: Complete the code for this method
		
		return entityManager.find(Category.class, categoryId);
	}

	public List<Integer> findYearsWithOrders() {
		// TODO: Write the code for this method
		return entityManager.createQuery(
				"SELECT YEAR(o.orderDate) FROM Order o GROUP BY YEAR(o.orderDate) ORDER BY YEAR(o.orderDate)"
				, Integer.class)
				.getResultList();
	}
	
	public List<Category> findOnlineCatalogCategories() {
		// TODO: Complete the code for this method
		
		return entityManager.createQuery(
				"SELECT c FROM Category c WHERE c.parentCategory.categoryId = 90 ORDER BY c.categoryName"
				, Category.class)
				.getResultList();
	}
	@RolesAllowed({"Investor","Auditor"})
	public List<CategorySales> findCategorSalesForOnlineCatalog() {
		// TODO: Write the code for this method
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(pc.categoryName, SUM(od.unitPrice * od.quantity)) "
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (c.parentCategory) pc,IN (od.order) o "	
				+ " Where c.parentCategory.categoryId = 10 or c.parentCategory.categoryId = 20 or c.parentCategory.categoryId = 30 "
				+ " GROUP BY pc.categoryName",
				CategorySales.class)
				.getResultList();	
	}
	
	@RolesAllowed({"Investor","	Auditor"})
	public List<CategorySales> findCategorSalesForOnlineCatalogYear(Integer year) {
		// TODO: Complete the code for this method
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(c.parentCategory.categoryName, SUM(oi.unitPrice * oi.quantity)) "
						+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c, IN (oi.order) o "
						+ " WHERE c.parentCategory.categoryId <> :checkId AND YEAR(o.orderDate) = :yearValue "
						+ " GROUP BY c.parentCategory.categoryName",
				CategorySales.class)
				.setParameter("checkId",90L)
				.setParameter("yearValue", year)
				.getResultList();
	}
	
	@RolesAllowed({"Investor","	Auditor"})
	public List<CategorySales> findCategorSalesForParentCategoryId(Long parentCategoryId) {
		// TODO: Complete the code for this method
		
		if (parentCategoryId == 90L) {		
			return entityManager.createQuery(				
					"SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(oi.unitPrice * oi.quantity)) "
						+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c "		
						+ " WHERE c.parentCategory.categoryId IN (10,20,30) "
						+ " GROUP BY c.categoryName"
						+ " ORDER BY c.categoryName",
					CategorySales.class)				
					.getResultList();			
		} else {
			return entityManager.createQuery(				
					"SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(oi.unitPrice * oi.quantity)) "
						+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c "		
						+ " WHERE c.parentCategory.categoryId = :checkId "
						+ " GROUP BY c.categoryName"
						+ " ORDER BY c.categoryName",
					CategorySales.class)
					.setParameter("checkId",parentCategoryId)
					.getResultList();
			}	
	}
	
	@RolesAllowed({"Investor","	Auditor"})
	public List<CategorySales> findCategorSalesForParentCategoryIdAndYear(Long parentCategoryId, Integer year) {
		// TODO: Complete the code for this method
		if(parentCategoryId != null && parentCategoryId == 90)
		{
			return entityManager.createQuery("SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(oi.unitPrice * oi.quantity))"
					+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c, IN (oi.order) o "		
					+ " WHERE c.parentCategory.categoryId IN (10,20,30) AND YEAR(o.orderDate) = :yearValue "
					+ " GROUP BY c.categoryName"
					+ " ORDER BY c.categoryName",
					CategorySales.class)
					.setParameter("yearValue", year)
					.getResultList();
		} else 
		{
			return entityManager.createQuery(
					"SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(oi.unitPrice * oi.quantity)) "
						+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c, IN (oi.order) o "		
						+ " WHERE c.parentCategory.categoryId = :checkId AND YEAR(o.orderDate) = :yearValue "
						+ " GROUP BY c.categoryName"
						+ " ORDER BY c.categoryName",
						CategorySales.class)
						.setParameter("checkId", parentCategoryId)
					    .setParameter("yearValue", year)
					    .getResultList();
		}
		
	}
	@RolesAllowed({"Investor"})
	public List<ProductSales> findProductSales(int maxResult) {
		// TODO: Complete the code for this method
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.ProductSales"
				+"(pi.productName, SUM(oi.unitPrice * oi.quantity), c.categoryName, SUM(oi.quantity), pi.productId) "
				+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c, IN (oi.order) o "	
				+ " GROUP BY pi.productName,c.categoryName, pi.productId "
				+ " ORDER BY SUM(oi.unitPrice * oi.quantity) DESC",
				ProductSales.class).setMaxResults(maxResult).getResultList();
	}
	@RolesAllowed({"Investor"})
	public List<ProductSales> findProductSalesForYear(Integer year, int maxResult) {
		// TODO: Complete the code for this method
		
		return entityManager.createQuery("SELECT new dmit2015.oe.report.ProductSales"
				+ "(pi.productName, SUM(oi.unitPrice * oi.quantity), c.categoryName, SUM(oi.quantity), pi.productId) "
				+ " FROM OrderItem oi, IN (oi.productInformation) pi, IN (pi.category) c, IN (oi.order) o "		
				+ " WHERE YEAR(o.orderDate) = :yearValue "
				+ " GROUP BY pi.productName,c.categoryName, pi.productId "
				+ " ORDER BY SUM(oi.unitPrice * oi.quantity)",
				ProductSales.class).setParameter("yearValue", year).setMaxResults(maxResult).getResultList();
	}
	
}
