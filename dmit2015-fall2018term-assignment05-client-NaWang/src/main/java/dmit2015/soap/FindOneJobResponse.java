
package dmit2015.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findOneJobResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findOneJobResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="findOneJob" type="{http://localhost/}job" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findOneJobResponse", propOrder = {
    "findOneJob"
})
public class FindOneJobResponse {

    protected Job findOneJob;

    /**
     * Gets the value of the findOneJob property.
     * 
     * @return
     *     possible object is
     *     {@link Job }
     *     
     */
    public Job getFindOneJob() {
        return findOneJob;
    }

    /**
     * Sets the value of the findOneJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link Job }
     *     
     */
    public void setFindOneJob(Job value) {
        this.findOneJob = value;
    }

}
