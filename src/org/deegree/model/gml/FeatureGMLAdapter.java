//$HeadURL: svn+ssh://mschneider@svn.wald.intevation.org/deegree/deegree3/commons/trunk/src/org/deegree/model/feature/Feature.java $
/*----------------    FILE HEADER  ------------------------------------------

 This file is part of deegree.
 Copyright (C) 2001-2008 by:
 EXSE, Department of Geography, University of Bonn
 http://www.giub.uni-bonn.de/deegree/
 lat/lon GmbH
 http://www.lat-lon.de

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 Contact:

 Andreas Poth  
 lat/lon GmbH 
 Aennchenstr. 19
 53115 Bonn
 Germany
 E-Mail: poth@lat-lon.de

 Prof. Dr. Klaus Greve
 Department of Geography
 University of Bonn
 Meckenheimer Allee 166
 53115 Bonn
 Germany
 E-Mail: greve@giub.uni-bonn.de


 ---------------------------------------------------------------------------*/
package org.deegree.model.gml;

import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.deegree.commons.xml.CommonNamespaces;
import org.deegree.commons.xml.XMLAdapter;
import org.deegree.commons.xml.XMLParsingException;
import org.deegree.model.feature.Feature;
import org.deegree.model.feature.GenericProperty;
import org.deegree.model.feature.Property;
import org.deegree.model.feature.types.FeaturePropertyType;
import org.deegree.model.feature.types.FeatureType;
import org.deegree.model.feature.types.GeometryPropertyType;
import org.deegree.model.feature.types.PropertyType;
import org.deegree.model.feature.types.SimplePropertyType;
import org.deegree.model.i18n.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO add documentation here
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider </a>
 * @author last edited by: $Author:$
 * 
 * @version $Revision:$, $Date:$
 */
public class FeatureGMLAdapter extends XMLAdapter {

    private static final Logger LOG = LoggerFactory.getLogger( FeatureGMLAdapter.class );

    private static String FID = "fid";

    private static String GMLID = "id";

    private static String GMLNS = CommonNamespaces.GMLNS;

    // key: feature type name, value: feature type
    private Map<QName, FeatureType> ftNameToFt = new HashMap<QName, FeatureType>();

    // keeps track of all features (with gml-ids) and properties that use local-xlinks to specifiy the property's value
    private GMLIdContext idContext;

    /**
     * Creates a new <code>FeatureGMLAdapter</code> instance instance that is configured for building features with the
     * specified feature types.
     * 
     * @param fts
     *            feature types
     */
    public FeatureGMLAdapter( List<FeatureType> fts ) {
        for ( FeatureType ft : fts ) {
            ftNameToFt.put( ft.getName(), ft );
        }
        idContext = new GMLIdContext();
    }

    /**
     * Returns the object representation for the feature element event that the cursor of the given
     * <code>XMLStreamReader</code> points at.
     * 
     * @param xmlStream
     *            cursor must point at the <code>START_ELEMENT</code> event of the feature element, afterwards points at
     *            the next event after the <code>END_ELEMENT</code> event of the feature element
     * @param srsName
     *            default SRS for all descendant geometry properties
     * @return object representation for the given feature element
     * @throws XMLStreamException
     */
    public Feature parseFeature( XMLStreamReader xmlStream, String srsName )
                            throws XMLStreamException {

        Feature feature = null;
        String fid = parseFeatureId( xmlStream );

        QName featureName = xmlStream.getName();
        FeatureType ft = lookupFeatureType( xmlStream, featureName );

        LOG.debug( "- parsing feature, gml:id=" + fid + " (begin): " + getCurrentEventInfo( xmlStream ) );

        // override defaultSRS with SRS information from boundedBy element (if present)
        // srsName = XMLTools.getNodeAsString( element, "gml:boundedBy/*[1]/@srsName", nsContext, srsName );

        // parse properties
        Iterator<PropertyType> declIter = ft.getPropertyDeclarations().iterator();
        PropertyType activeDecl = declIter.next();
        int propOccurences = 0;

        List<Property<?>> propertyList = new ArrayList<Property<?>>();
        while ( xmlStream.nextTag() == START_ELEMENT ) {
            QName propName = xmlStream.getName();
            LOG.debug( "- property '" + propName + "'" );

            if ( propName.equals( activeDecl.getName() ) ) {
                // current property element is equal to active declaration
                if ( activeDecl.getMaxOccurs() != -1 && propOccurences > activeDecl.getMaxOccurs() ) {
                    String msg = Messages.getMessage( "ERROR_PROPERTY_TOO_MANY_OCCURENCES", propName,
                                                      activeDecl.getMaxOccurs(), ft.getName() );
                    throw new XMLParsingException( this, xmlStream, msg );
                } else {
                    propOccurences++;
                }
            } else {
                // current property element is not equal to active declaration
                while ( declIter.hasNext() && !propName.equals( activeDecl.getName() ) ) {
                    if ( propOccurences < activeDecl.getMinOccurs() ) {
                        String msg = null;
                        if ( activeDecl.getMinOccurs() == 1 ) {
                            msg = Messages.getMessage( "ERROR_PROPERTY_MANDATORY", propName, ft.getName() );
                        } else {
                            msg = Messages.getMessage( "ERROR_PROPERTY_TOO_FEW_OCCURENCES", propName,
                                                       activeDecl.getMinOccurs(), ft.getName() );
                        }
                        throw new XMLParsingException( this, xmlStream, msg );
                    }
                    activeDecl = declIter.next();
                    propOccurences = 0;
                }
                if ( !propName.equals( activeDecl.getName() ) ) {
                    String msg = Messages.getMessage( "ERROR_PROPERTY_UNEXPECTED", propName, ft.getName() );
                    throw new XMLParsingException( this, xmlStream, msg );
                }
            }

            try {
                Property<?> property = parseProperty( xmlStream, activeDecl, srsName );
                if ( property != null ) {
                    propertyList.add( property );
                }
            } catch ( XMLParsingException e ) {
                LOG.debug( "Error parsing property '" + propName + "' of feature '" + featureName + "' with fid: "
                           + fid + ". " + e.getMessage() );
                throw e;
            }
        }

        LOG.debug( " - parsing feature (end): " + getCurrentEventInfo( xmlStream ) );

        feature = ft.newFeature( fid, propertyList );

        if ( fid != null && !"".equals( fid ) ) {
            if ( idContext.getFeature( fid ) != null ) {
                String msg = Messages.getMessage( "ERROR_FEATURE_ID_NOT_UNIQUE", fid );
                throw new XMLParsingException( this, xmlStream, msg );
            }
            idContext.addFeature( feature );
        }

        return feature;
    }

    /**
     * Returns the object representation for the given property element.
     * 
     * @param xmlStream
     *            cursor must point at the <code>START_ELEMENT</code> event of the property, afterwards points at the
     *            next event after the <code>END_ELEMENT</code> of the property
     * @param propDecl
     *            property declaration
     * @param srsName
     *            default SRS for all a descendant geometry properties
     * @return object representation for the given property element.
     * @throws XMLParsingException
     * @throws XMLStreamException
     */
    public Property<?> parseProperty( XMLStreamReader xmlStream, PropertyType propDecl, String srsName )
                            throws XMLParsingException, XMLStreamException {

        Property<?> property = null;
        QName propertyName = xmlStream.getName();
        LOG.debug( "- parsing property (begin): " + getCurrentEventInfo( xmlStream ) );
        LOG.debug( "- property declaration: " + propDecl );

        if ( propDecl instanceof SimplePropertyType ) {
            property = new GenericProperty<String>( propDecl, xmlStream.getElementText().trim() );
        } else if ( propDecl instanceof GeometryPropertyType ) {
            xmlStream.nextTag();
            // TODO geometry parsing
            // Geometry geometry = StAXGeometryParser.parseGeometry( xmlStream, srsName );
            // property = new GenericProperty (pt, geometry);
            LOG.debug( "- skipping parsing of '" + xmlStream.getName() + "' -- geometry parsing is not implemented yet" );
            skipElement( xmlStream );
            property = new GenericProperty<String>( propDecl, xmlStream.getName().toString() );

            xmlStream.nextTag();
        } else if ( propDecl instanceof FeaturePropertyType ) {
            String href = xmlStream.getAttributeValue( CommonNamespaces.XLNNS, "href" );
            if ( href != null ) {
                // remote feature (xlinked content)
                // if ( !href.startsWith( "#" ) ) {
                // String msg = Messages.format( "ERROR_EXTERNAL_XLINK_NOT_SUPPORTED", href );
                // throw new XMLParsingException( msg );
                // } else {
                // String fid = href.substring( 1 );
                // property = new XLinkedFeatureProperty( propertyName, fid );
                // xlinkProperties.add( (XLinkedFeatureProperty) property );
                // }
                xmlStream.nextTag();
            } else {
                // inline feature
                if ( xmlStream.nextTag() != START_ELEMENT ) {
                    String msg = Messages.getMessage( "ERROR_INVALID_FEATURE_PROPERTY", propertyName );
                    throw new XMLParsingException( this, xmlStream, msg );
                }
                Feature subFeature = parseFeature( xmlStream, srsName );
                property = new GenericProperty<Feature>( propDecl, subFeature );
                skipElement( xmlStream );
            }
        }
        LOG.debug( " - parsing property (end): " + getCurrentEventInfo( xmlStream ) );
        return property;
    }

    /**
     * Returns the feature type with the given name.
     * <p>
     * If no feature type with the given name is defined, an XMLParsingException is thrown.
     * 
     * @param xmlStreamReader
     * 
     * @param ftName
     *            feature type name to look up
     * @return the feature type with the given name
     * @throws XMLParsingException
     *             if no feature type with the given name is defined
     */
    protected FeatureType lookupFeatureType( XMLStreamReader xmlStreamReader, QName ftName )
                            throws XMLParsingException {
        FeatureType ft = null;
        ft = ftNameToFt.get( ftName );
        if ( ft == null ) {
            String msg = Messages.getMessage( "ERROR_SCHEMA_FEATURE_TYPE_UNKNOWN", ftName );
            throw new XMLParsingException( this, xmlStreamReader, msg );
        }
        return ft;
    }

    /**
     * Parses the feature id attribute from the feature <code>START_ELEMENT</code> event that the given
     * <code>XMLStreamReader</code> points to.
     * <p>
     * Looks after 'gml:id' (GML 3) first, if no such attribute is present, the 'fid' (GML 2) attribute is used.
     * 
     * @param xmlReader
     *            must point to the <code>START_ELEMENT</code> event of the feature
     * @return the feature id, or "" (empty string) if neither a 'gml:id' nor a 'fid' attribute is present
     */
    protected String parseFeatureId( XMLStreamReader xmlReader ) {

        String fid = xmlReader.getAttributeValue( GMLNS, GMLID );
        if ( fid == null ) {
            fid = xmlReader.getAttributeValue( null, FID );
        }

        // Check that the feature id has the correct form. "fid" and "gml:id" are both based
        // on the XML type "ID": http://www.w3.org/TR/xmlschema11-2/#NCName
        // Thus, they must match the NCName production rule. This means that they may not contain
        // a separating colon (only at the first position a colon is allowed) and must not
        // start with a digit.
        if ( fid != null && fid.length() > 0 && !fid.matches( "[^\\d][^:]+" ) ) {
            String msg = Messages.getMessage( "ERROR_INVALID_FEATUREID", fid );
            throw new IllegalArgumentException( msg );
        }
        return fid;
    }

    public void export( XMLStreamWriter writer, Feature feature )
                            throws XMLStreamException {

        QName featureName = feature.getName();
        System.out.println( "Exporting " + featureName );
        if ( featureName.getNamespaceURI() == null || featureName.getNamespaceURI().length() == 0 ) {
            writer.writeStartElement( featureName.getLocalPart() );
        } else {
            writer.writeStartElement( featureName.getNamespaceURI(), featureName.getLocalPart() );
        }
        if ( feature.getId() != null ) {
            writer.writeAttribute( GMLNS, "id", feature.getId() );
        }
        for ( Property<?> prop : feature.getProperties() ) {
            export( writer, prop );
        }
        writer.writeEndElement();
    }

    public void export( XMLStreamWriter writer, Property<?> property )
                            throws XMLStreamException {

        QName propName = property.getName();
        if ( propName.getNamespaceURI() == null || propName.getNamespaceURI().length() == 0 ) {
            writer.writeStartElement( propName.getLocalPart() );
        } else {
            writer.writeStartElement( propName.getNamespaceURI(), propName.getLocalPart() );
        }
        // TODO respect property type properly
        Object value = property.getValue();
        if ( value instanceof Feature ) {
            export( writer, (Feature) value );
        } else {
            writer.writeCharacters( value.toString() );
        }

        writer.writeEndElement();
    }
}
