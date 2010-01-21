//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.19 at 11:21:02 AM MEZ 
//


package org.deegree.commons.configuration;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Parameters that deegree uses to connect to
 *           other resources on the network.
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProxyHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpProxyHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FtpProxyHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProxyPort" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="HttpProxyPort" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="FtpProxyPort" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="ProxyUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpProxyUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FtpProxyUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProxyPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpProxyPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FtpProxyPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NonProxyHosts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HttpNonProxyHosts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FtpNonProxyHosts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="overrideSystemSettings" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "proxyHost",
    "httpProxyHost",
    "ftpProxyHost",
    "proxyPort",
    "httpProxyPort",
    "ftpProxyPort",
    "proxyUser",
    "httpProxyUser",
    "ftpProxyUser",
    "proxyPassword",
    "httpProxyPassword",
    "ftpProxyPassword",
    "nonProxyHosts",
    "httpNonProxyHosts",
    "ftpNonProxyHosts"
})
@XmlRootElement(name = "ProxyConfiguration")
public class ProxyConfiguration {

    @XmlElement(name = "ProxyHost")
    protected String proxyHost;
    @XmlElement(name = "HttpProxyHost")
    protected String httpProxyHost;
    @XmlElement(name = "FtpProxyHost")
    protected String ftpProxyHost;
    @XmlElement(name = "ProxyPort")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger proxyPort;
    @XmlElement(name = "HttpProxyPort")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger httpProxyPort;
    @XmlElement(name = "FtpProxyPort")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger ftpProxyPort;
    @XmlElement(name = "ProxyUser")
    protected String proxyUser;
    @XmlElement(name = "HttpProxyUser")
    protected String httpProxyUser;
    @XmlElement(name = "FtpProxyUser")
    protected String ftpProxyUser;
    @XmlElement(name = "ProxyPassword")
    protected String proxyPassword;
    @XmlElement(name = "HttpProxyPassword")
    protected String httpProxyPassword;
    @XmlElement(name = "FtpProxyPassword")
    protected String ftpProxyPassword;
    @XmlElement(name = "NonProxyHosts")
    protected String nonProxyHosts;
    @XmlElement(name = "HttpNonProxyHosts")
    protected String httpNonProxyHosts;
    @XmlElement(name = "FtpNonProxyHosts")
    protected String ftpNonProxyHosts;
    @XmlAttribute
    protected Boolean overrideSystemSettings;

    /**
     * Gets the value of the proxyHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * Sets the value of the proxyHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyHost(String value) {
        this.proxyHost = value;
    }

    /**
     * Gets the value of the httpProxyHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpProxyHost() {
        return httpProxyHost;
    }

    /**
     * Sets the value of the httpProxyHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpProxyHost(String value) {
        this.httpProxyHost = value;
    }

    /**
     * Gets the value of the ftpProxyHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpProxyHost() {
        return ftpProxyHost;
    }

    /**
     * Sets the value of the ftpProxyHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpProxyHost(String value) {
        this.ftpProxyHost = value;
    }

    /**
     * Gets the value of the proxyPort property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProxyPort() {
        return proxyPort;
    }

    /**
     * Sets the value of the proxyPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProxyPort(BigInteger value) {
        this.proxyPort = value;
    }

    /**
     * Gets the value of the httpProxyPort property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHttpProxyPort() {
        return httpProxyPort;
    }

    /**
     * Sets the value of the httpProxyPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHttpProxyPort(BigInteger value) {
        this.httpProxyPort = value;
    }

    /**
     * Gets the value of the ftpProxyPort property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFtpProxyPort() {
        return ftpProxyPort;
    }

    /**
     * Sets the value of the ftpProxyPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFtpProxyPort(BigInteger value) {
        this.ftpProxyPort = value;
    }

    /**
     * Gets the value of the proxyUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyUser() {
        return proxyUser;
    }

    /**
     * Sets the value of the proxyUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyUser(String value) {
        this.proxyUser = value;
    }

    /**
     * Gets the value of the httpProxyUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpProxyUser() {
        return httpProxyUser;
    }

    /**
     * Sets the value of the httpProxyUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpProxyUser(String value) {
        this.httpProxyUser = value;
    }

    /**
     * Gets the value of the ftpProxyUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpProxyUser() {
        return ftpProxyUser;
    }

    /**
     * Sets the value of the ftpProxyUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpProxyUser(String value) {
        this.ftpProxyUser = value;
    }

    /**
     * Gets the value of the proxyPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * Sets the value of the proxyPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyPassword(String value) {
        this.proxyPassword = value;
    }

    /**
     * Gets the value of the httpProxyPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpProxyPassword() {
        return httpProxyPassword;
    }

    /**
     * Sets the value of the httpProxyPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpProxyPassword(String value) {
        this.httpProxyPassword = value;
    }

    /**
     * Gets the value of the ftpProxyPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpProxyPassword() {
        return ftpProxyPassword;
    }

    /**
     * Sets the value of the ftpProxyPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpProxyPassword(String value) {
        this.ftpProxyPassword = value;
    }

    /**
     * Gets the value of the nonProxyHosts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonProxyHosts() {
        return nonProxyHosts;
    }

    /**
     * Sets the value of the nonProxyHosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonProxyHosts(String value) {
        this.nonProxyHosts = value;
    }

    /**
     * Gets the value of the httpNonProxyHosts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpNonProxyHosts() {
        return httpNonProxyHosts;
    }

    /**
     * Sets the value of the httpNonProxyHosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpNonProxyHosts(String value) {
        this.httpNonProxyHosts = value;
    }

    /**
     * Gets the value of the ftpNonProxyHosts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpNonProxyHosts() {
        return ftpNonProxyHosts;
    }

    /**
     * Sets the value of the ftpNonProxyHosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpNonProxyHosts(String value) {
        this.ftpNonProxyHosts = value;
    }

    /**
     * Gets the value of the overrideSystemSettings property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverrideSystemSettings() {
        return overrideSystemSettings;
    }

    /**
     * Sets the value of the overrideSystemSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverrideSystemSettings(Boolean value) {
        this.overrideSystemSettings = value;
    }

}
