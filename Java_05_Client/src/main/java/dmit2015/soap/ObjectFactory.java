
package dmit2015.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dmit2015.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LuckyLottoNumberResponse_QNAME = new QName("http://localhost/", "luckyLottoNumberResponse");
    private final static QName _LuckyLottoNumber_QNAME = new QName("http://localhost/", "luckyLottoNumber");
    private final static QName _FindAllJobsResponse_QNAME = new QName("http://localhost/", "findAllJobsResponse");
    private final static QName _FindOneJob_QNAME = new QName("http://localhost/", "findOneJob");
    private final static QName _Job_QNAME = new QName("http://localhost/", "job");
    private final static QName _SortLuckyNumber_QNAME = new QName("http://localhost/", "sortLuckyNumber");
    private final static QName _FindAllJobs_QNAME = new QName("http://localhost/", "findAllJobs");
    private final static QName _FindOneJobResponse_QNAME = new QName("http://localhost/", "findOneJobResponse");
    private final static QName _SortLuckyNumberResponse_QNAME = new QName("http://localhost/", "sortLuckyNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dmit2015.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllJobsResponse }
     * 
     */
    public FindAllJobsResponse createFindAllJobsResponse() {
        return new FindAllJobsResponse();
    }

    /**
     * Create an instance of {@link FindOneJob }
     * 
     */
    public FindOneJob createFindOneJob() {
        return new FindOneJob();
    }

    /**
     * Create an instance of {@link LuckyLottoNumberResponse }
     * 
     */
    public LuckyLottoNumberResponse createLuckyLottoNumberResponse() {
        return new LuckyLottoNumberResponse();
    }

    /**
     * Create an instance of {@link LuckyLottoNumber }
     * 
     */
    public LuckyLottoNumber createLuckyLottoNumber() {
        return new LuckyLottoNumber();
    }

    /**
     * Create an instance of {@link FindOneJobResponse }
     * 
     */
    public FindOneJobResponse createFindOneJobResponse() {
        return new FindOneJobResponse();
    }

    /**
     * Create an instance of {@link SortLuckyNumberResponse }
     * 
     */
    public SortLuckyNumberResponse createSortLuckyNumberResponse() {
        return new SortLuckyNumberResponse();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new Job();
    }

    /**
     * Create an instance of {@link SortLuckyNumber }
     * 
     */
    public SortLuckyNumber createSortLuckyNumber() {
        return new SortLuckyNumber();
    }

    /**
     * Create an instance of {@link FindAllJobs }
     * 
     */
    public FindAllJobs createFindAllJobs() {
        return new FindAllJobs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LuckyLottoNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "luckyLottoNumberResponse")
    public JAXBElement<LuckyLottoNumberResponse> createLuckyLottoNumberResponse(LuckyLottoNumberResponse value) {
        return new JAXBElement<LuckyLottoNumberResponse>(_LuckyLottoNumberResponse_QNAME, LuckyLottoNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LuckyLottoNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "luckyLottoNumber")
    public JAXBElement<LuckyLottoNumber> createLuckyLottoNumber(LuckyLottoNumber value) {
        return new JAXBElement<LuckyLottoNumber>(_LuckyLottoNumber_QNAME, LuckyLottoNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllJobsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "findAllJobsResponse")
    public JAXBElement<FindAllJobsResponse> createFindAllJobsResponse(FindAllJobsResponse value) {
        return new JAXBElement<FindAllJobsResponse>(_FindAllJobsResponse_QNAME, FindAllJobsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "findOneJob")
    public JAXBElement<FindOneJob> createFindOneJob(FindOneJob value) {
        return new JAXBElement<FindOneJob>(_FindOneJob_QNAME, FindOneJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Job }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "job")
    public JAXBElement<Job> createJob(Job value) {
        return new JAXBElement<Job>(_Job_QNAME, Job.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SortLuckyNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "sortLuckyNumber")
    public JAXBElement<SortLuckyNumber> createSortLuckyNumber(SortLuckyNumber value) {
        return new JAXBElement<SortLuckyNumber>(_SortLuckyNumber_QNAME, SortLuckyNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllJobs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "findAllJobs")
    public JAXBElement<FindAllJobs> createFindAllJobs(FindAllJobs value) {
        return new JAXBElement<FindAllJobs>(_FindAllJobs_QNAME, FindAllJobs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOneJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "findOneJobResponse")
    public JAXBElement<FindOneJobResponse> createFindOneJobResponse(FindOneJobResponse value) {
        return new JAXBElement<FindOneJobResponse>(_FindOneJobResponse_QNAME, FindOneJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SortLuckyNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/", name = "sortLuckyNumberResponse")
    public JAXBElement<SortLuckyNumberResponse> createSortLuckyNumberResponse(SortLuckyNumberResponse value) {
        return new JAXBElement<SortLuckyNumberResponse>(_SortLuckyNumberResponse_QNAME, SortLuckyNumberResponse.class, null, value);
    }

}
