
package dmit2015.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HumanResourceService", targetNamespace = "http://localhost/", wsdlLocation = "http://192.168.48.128:8080/dmit2015-fall2018term-assignment05-server-start/HumanResourceService?wsdl")
public class HumanResourceService
    extends Service
{

    private final static URL HUMANRESOURCESERVICE_WSDL_LOCATION;
    private final static WebServiceException HUMANRESOURCESERVICE_EXCEPTION;
    private final static QName HUMANRESOURCESERVICE_QNAME = new QName("http://localhost/", "HumanResourceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.48.128:8080/dmit2015-fall2018term-assignment05-server-start/HumanResourceService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HUMANRESOURCESERVICE_WSDL_LOCATION = url;
        HUMANRESOURCESERVICE_EXCEPTION = e;
    }

    public HumanResourceService() {
        super(__getWsdlLocation(), HUMANRESOURCESERVICE_QNAME);
    }

    public HumanResourceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HUMANRESOURCESERVICE_QNAME, features);
    }

    public HumanResourceService(URL wsdlLocation) {
        super(wsdlLocation, HUMANRESOURCESERVICE_QNAME);
    }

    public HumanResourceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HUMANRESOURCESERVICE_QNAME, features);
    }

    public HumanResourceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HumanResourceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HumanResourceXmlWebService
     */
    @WebEndpoint(name = "HumanResourcePort")
    public HumanResourceXmlWebService getHumanResourcePort() {
        return super.getPort(new QName("http://localhost/", "HumanResourcePort"), HumanResourceXmlWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HumanResourceXmlWebService
     */
    @WebEndpoint(name = "HumanResourcePort")
    public HumanResourceXmlWebService getHumanResourcePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost/", "HumanResourcePort"), HumanResourceXmlWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HUMANRESOURCESERVICE_EXCEPTION!= null) {
            throw HUMANRESOURCESERVICE_EXCEPTION;
        }
        return HUMANRESOURCESERVICE_WSDL_LOCATION;
    }

}
