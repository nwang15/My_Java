package dmit2015.oe.web;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Messages;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import dmit2015.oe.entity.Customer;
import dmit2015.oe.entity.Order;
import dmit2015.oe.service.OrderEntryService;

@Named
@ViewScoped
public class OrderQueryController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrderEntryService oeService;
	
	@NotNull(message="Order ID field value is required.")
	private Long queryOrderId;						// +getter +setter
	private Order queryOrderSingleResult;			// +getter
	
	private Date queryStartDate;					// +getter +setter
	private Date queryEndDate;						// +getter +setter
	private List<Order> queryOrderResultList;		// +getter
	
	private String queryCustomerValue;				// +getter +setter
	private Customer queryCustomerSingleResult;		// +getter
	private MapModel geoLocationModel;
	
		
	public Long getQueryOrderId() {
		return queryOrderId;
	}
	public void setQueryOrderId(Long queryOrderId) {
		this.queryOrderId = queryOrderId;
	}
	public Date getQueryStartDate() {
		return queryStartDate;
	}
	public void setQueryStartDate(Date queryStartDate) {
		this.queryStartDate = queryStartDate;
	}
	public Date getQueryEndDate() {
		return queryEndDate;
	}
	public void setQueryEndDate(Date queryEndDate) {
		this.queryEndDate = queryEndDate;
	}
	public String getQueryCustomerValue() {
		return queryCustomerValue;
	}
	public void setQueryCustomerValue(String queryCustomerValue) {
		this.queryCustomerValue = queryCustomerValue;
	}
	public Order getQueryOrderSingleResult() {
		return queryOrderSingleResult;
	}
	public List<Order> getQueryOrderResultList() {
		return queryOrderResultList;
	}
	public Customer getQueryCustomerSingleResult() {
		return queryCustomerSingleResult;
	}
	public MapModel getGeoLocationModel() {
		return geoLocationModel;
	}


	@PostConstruct
	void init() {
		queryStartDate = Date.from(LocalDate.of(2004, 3, 20).atStartOfDay(ZoneId.systemDefault()).toInstant());
		queryEndDate = Date.from(LocalDate.of(2008, 8, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		geoLocationModel = new DefaultMapModel();
	}
	
	
	public void findOrder() {
		// TODO: Complete the code for this method
		try
		{
			queryOrderSingleResult = oeService.findOneOrder(queryOrderId);
			
			if(queryOrderSingleResult == null)
			{
				Messages.addGlobalWarn("Unknown orderId \"{0}\". We found 0 results", queryOrderId);
			}
			else {
				Messages.addGlobalInfo("Found 1 result.");
			}				
		}
			catch (Exception e) {
			Messages.addGlobalError("Unable to perform search.");
		}
	}
	
	public void findOrder(Long orderId) {
		queryOrderId = orderId;
		findOrder();
	}
	
	public void findOrdersByDateRange() {
		// TODO: Complete the code for this method
		try {
			
		queryOrderResultList=null;
		queryOrderResultList = oeService.findAllOrderByDateRange(queryStartDate, queryEndDate);
		if(queryOrderResultList == null ||queryOrderResultList.size()== 0)
		{
			Messages.addGlobalWarn("Unknown date \"{0}{1}\". We found 0 results", queryStartDate,queryEndDate);
			
		} else {
			Messages.addGlobalInfo("Found {0} result(s).", queryOrderResultList.size());
		}
		}catch (Exception e) {
			Messages.addGlobalError("search findOrderByDateRange failed.");
		}
	}
	
	public void findCustomer() {
		// TODO: Complete the code for this method
		try
		{
			queryOrderResultList = new ArrayList<Order>();
			queryOrderResultList = oeService.findAllOrderByCustomerId(queryCustomerSingleResult.getCustomerId());
			if(queryOrderResultList == null || queryOrderResultList.size() ==0)
			{
				Messages.addGlobalWarn("Unknown Customer ID \"{0}\". We found 0 results", queryOrderId);
				
			}else
			{
				Messages.addGlobalInfo("Found {0} result(s).", queryOrderResultList.size());
			}
		}catch (Exception e) {
			Messages.addGlobalError("search findOrderByDateRange failed.");
		}
		
	}
	
	public void findOrdersByCustomer() {
		// TODO: Complete the code for this method
		try
		{
			queryOrderResultList = oeService.findAllOrderByCustomerId(queryOrderId);
			
			if(queryOrderResultList == null || queryOrderResultList.size() == 0)
			{
				Messages.addGlobalWarn("Unknown customerId \"{0}\". We found 0 results", queryOrderId);
			} 
			else {
				Messages.addGlobalInfo("Found {0} result(s).", queryOrderResultList.size());
			} 					
			
		}catch (Exception e) {
			Messages.addGlobalError("Unable to perform search.");
		}	
	}


		
	
	
	public void cancel() {
		queryOrderId = null;
		queryCustomerValue = null;
		queryOrderSingleResult = null;
		queryOrderResultList = null;
		queryCustomerSingleResult = null;
	}

}
