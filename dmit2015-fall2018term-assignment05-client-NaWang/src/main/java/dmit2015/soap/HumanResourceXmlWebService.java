
package dmit2015.soap;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HumanResourceXmlWebService", targetNamespace = "http://localhost/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HumanResourceXmlWebService {


    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "luckyLottoNumber", targetNamespace = "http://localhost/", className = "dmit2015.soap.LuckyLottoNumber")
    @ResponseWrapper(localName = "luckyLottoNumberResponse", targetNamespace = "http://localhost/", className = "dmit2015.soap.LuckyLottoNumberResponse")
    public int luckyLottoNumber();

}