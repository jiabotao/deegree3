//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.01 at 03:58:03 PM CEST 
//


package org.deegree.services.wms.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.deegree.commons.configuration.BoundingBoxType;
import org.deegree.commons.configuration.ScaleDenominatorsType;
import org.deegree.commons.datasource.configuration.AbstractDataSourceType;
import org.deegree.commons.datasource.configuration.AbstractGeospatialDataSourceType;
import org.deegree.commons.datasource.configuration.AbstractWebBasedDataSourceType;
import org.deegree.commons.datasource.configuration.ConstrainedDatabaseDataSourceType;
import org.deegree.commons.datasource.configuration.DCRecordStoreType;
import org.deegree.commons.datasource.configuration.DatabaseDataSourceType;
import org.deegree.commons.datasource.configuration.DirectSQLDataSourceType;
import org.deegree.commons.datasource.configuration.ElevationModelDataSource;
import org.deegree.commons.datasource.configuration.FeatureStoreReferenceType;
import org.deegree.commons.datasource.configuration.FeatureStoreType;
import org.deegree.commons.datasource.configuration.FileSystemDataSourceType;
import org.deegree.commons.datasource.configuration.GeospatialFileSystemDataSourceType;
import org.deegree.commons.datasource.configuration.ISORecordStoreType;
import org.deegree.commons.datasource.configuration.MemoryFeatureStoreType;
import org.deegree.commons.datasource.configuration.MultiResolutionDataSource;
import org.deegree.commons.datasource.configuration.PostGISFeatureStoreType;
import org.deegree.commons.datasource.configuration.RasterDataSource;
import org.deegree.commons.datasource.configuration.RecordStoreType;
import org.deegree.commons.datasource.configuration.ShapefileDataSourceType;
import org.deegree.commons.datasource.configuration.WMSDataSourceType;
import org.deegree.services.jaxb.metadata.KeywordsType;


/**
 * <p>Java class for AbstractLayerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractLayerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deegree.org/services/wms}BaseAbstractLayerType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Abstract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://www.deegree.org/commons}Keywords" minOccurs="0"/>
 *         &lt;element ref="{http://www.deegree.org/commons}BoundingBox" minOccurs="0"/>
 *         &lt;element name="CRS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dimension" type="{http://www.deegree.org/services/wms}DimensionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.deegree.org/commons}ScaleDenominators" minOccurs="0"/>
 *           &lt;element name="ScaleUntil" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *           &lt;element name="ScaleAbove" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.deegree.org/services/wms}AbstractLayer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.deegree.org/datasource}AbstractDataSource" minOccurs="0"/>
 *         &lt;element name="DirectStyle" type="{http://www.deegree.org/services/wms}DirectStyleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SLDStyle" type="{http://www.deegree.org/services/wms}SLDStyleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SupportedFeatures" type="{http://www.deegree.org/services/wms}SupportedFeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractLayerType", propOrder = {
    "name",
    "title",
    "_abstract",
    "keywords",
    "boundingBox",
    "crs",
    "dimension",
    "scaleDenominators",
    "scaleUntil",
    "scaleAbove",
    "abstractLayer",
    "abstractDataSource",
    "directStyle",
    "sldStyle",
    "supportedFeatures"
})
@XmlSeeAlso({
    LogicalLayer.class,
    UnrequestableLayer.class,
    RequestableLayer.class
})
public class AbstractLayerType
    extends BaseAbstractLayerType
{

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "Abstract")
    protected String _abstract;
    @XmlElement(name = "Keywords", namespace = "http://www.deegree.org/commons")
    protected KeywordsType keywords;
    @XmlElement(name = "BoundingBox", namespace = "http://www.deegree.org/commons")
    protected BoundingBoxType boundingBox;
    @XmlElement(name = "CRS")
    protected String crs;
    @XmlElement(name = "Dimension")
    protected List<DimensionType> dimension;
    @XmlElement(name = "ScaleDenominators", namespace = "http://www.deegree.org/commons")
    protected ScaleDenominatorsType scaleDenominators;
    @XmlElement(name = "ScaleUntil")
    protected Double scaleUntil;
    @XmlElement(name = "ScaleAbove")
    protected Double scaleAbove;
    @XmlElementRef(name = "AbstractLayer", namespace = "http://www.deegree.org/services/wms", type = JAXBElement.class)
    protected List<JAXBElement<? extends BaseAbstractLayerType>> abstractLayer;
    @XmlElementRef(name = "AbstractDataSource", namespace = "http://www.deegree.org/datasource", type = JAXBElement.class)
    protected JAXBElement<? extends AbstractDataSourceType> abstractDataSource;
    @XmlElement(name = "DirectStyle")
    protected List<DirectStyleType> directStyle;
    @XmlElement(name = "SLDStyle")
    protected List<SLDStyleType> sldStyle;
    @XmlElement(name = "SupportedFeatures")
    protected SupportedFeaturesType supportedFeatures;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbstract(String value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsType }
     *     
     */
    public KeywordsType getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsType }
     *     
     */
    public void setKeywords(KeywordsType value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the boundingBox property.
     * 
     * @return
     *     possible object is
     *     {@link BoundingBoxType }
     *     
     */
    public BoundingBoxType getBoundingBox() {
        return boundingBox;
    }

    /**
     * Sets the value of the boundingBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoundingBoxType }
     *     
     */
    public void setBoundingBox(BoundingBoxType value) {
        this.boundingBox = value;
    }

    /**
     * Gets the value of the crs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRS() {
        return crs;
    }

    /**
     * Sets the value of the crs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRS(String value) {
        this.crs = value;
    }

    /**
     * Gets the value of the dimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getDimension() {
        if (dimension == null) {
            dimension = new ArrayList<DimensionType>();
        }
        return this.dimension;
    }

    /**
     * Gets the value of the scaleDenominators property.
     * 
     * @return
     *     possible object is
     *     {@link ScaleDenominatorsType }
     *     
     */
    public ScaleDenominatorsType getScaleDenominators() {
        return scaleDenominators;
    }

    /**
     * Sets the value of the scaleDenominators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaleDenominatorsType }
     *     
     */
    public void setScaleDenominators(ScaleDenominatorsType value) {
        this.scaleDenominators = value;
    }

    /**
     * Gets the value of the scaleUntil property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScaleUntil() {
        return scaleUntil;
    }

    /**
     * Sets the value of the scaleUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScaleUntil(Double value) {
        this.scaleUntil = value;
    }

    /**
     * Gets the value of the scaleAbove property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScaleAbove() {
        return scaleAbove;
    }

    /**
     * Sets the value of the scaleAbove property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScaleAbove(Double value) {
        this.scaleAbove = value;
    }

    /**
     * Gets the value of the abstractLayer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractLayer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractLayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link RequestableLayer }{@code >}
     * {@link JAXBElement }{@code <}{@link DynamicLayer }{@code >}
     * {@link JAXBElement }{@code <}{@link UnrequestableLayer }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseAbstractLayerType }{@code >}
     * {@link JAXBElement }{@code <}{@link LogicalLayer }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BaseAbstractLayerType>> getAbstractLayer() {
        if (abstractLayer == null) {
            abstractLayer = new ArrayList<JAXBElement<? extends BaseAbstractLayerType>>();
        }
        return this.abstractLayer;
    }

    /**
     * Gets the value of the abstractDataSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ElevationModelDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShapefileDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WMSDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FileSystemDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RasterDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWebBasedDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCRecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MemoryFeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConstrainedDatabaseDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ISORecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeospatialFileSystemDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PostGISFeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DatabaseDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiResolutionDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeospatialDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectSQLDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeospatialDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStoreReferenceType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractDataSourceType> getAbstractDataSource() {
        return abstractDataSource;
    }

    /**
     * Sets the value of the abstractDataSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ElevationModelDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ShapefileDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WMSDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FileSystemDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RasterDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWebBasedDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DCRecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MemoryFeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConstrainedDatabaseDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ISORecordStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeospatialFileSystemDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PostGISFeatureStoreType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DatabaseDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiResolutionDataSource }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeospatialDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectSQLDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeospatialDataSourceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStoreReferenceType }{@code >}
     *     
     */
    public void setAbstractDataSource(JAXBElement<? extends AbstractDataSourceType> value) {
        this.abstractDataSource = ((JAXBElement<? extends AbstractDataSourceType> ) value);
    }

    /**
     * Gets the value of the directStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectStyleType }
     * 
     * 
     */
    public List<DirectStyleType> getDirectStyle() {
        if (directStyle == null) {
            directStyle = new ArrayList<DirectStyleType>();
        }
        return this.directStyle;
    }

    /**
     * Gets the value of the sldStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sldStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSLDStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SLDStyleType }
     * 
     * 
     */
    public List<SLDStyleType> getSLDStyle() {
        if (sldStyle == null) {
            sldStyle = new ArrayList<SLDStyleType>();
        }
        return this.sldStyle;
    }

    /**
     * Gets the value of the supportedFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedFeaturesType }
     *     
     */
    public SupportedFeaturesType getSupportedFeatures() {
        return supportedFeatures;
    }

    /**
     * Sets the value of the supportedFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedFeaturesType }
     *     
     */
    public void setSupportedFeatures(SupportedFeaturesType value) {
        this.supportedFeatures = value;
    }

}
