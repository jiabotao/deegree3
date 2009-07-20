//$HeadURL: svn+ssh://mschneider@svn.wald.intevation.org/deegree/deegree3/commons/trunk/src/org/deegree/model/feature/Feature.java $
/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2009 by:
 Department of Geography, University of Bonn
 and
 lat/lon GmbH

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/

package org.deegree.feature.gml;

import static org.deegree.commons.xml.CommonNamespaces.GMLNS;
import static org.deegree.commons.xml.CommonNamespaces.XLNNS;
import static org.deegree.commons.xml.CommonNamespaces.XSINS;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.deegree.commons.types.Length;
import org.deegree.commons.types.Measure;
import org.deegree.commons.types.ows.CodeType;
import org.deegree.feature.Feature;
import org.deegree.feature.GenericFeatureCollection;
import org.deegree.feature.Property;
import org.deegree.feature.types.LengthPropertyType;
import org.deegree.feature.types.property.CodePropertyType;
import org.deegree.feature.types.property.EnvelopePropertyType;
import org.deegree.feature.types.property.FeaturePropertyType;
import org.deegree.feature.types.property.GeometryPropertyType;
import org.deegree.feature.types.property.MeasurePropertyType;
import org.deegree.feature.types.property.PropertyType;
import org.deegree.feature.types.property.SimplePropertyType;
import org.deegree.geometry.Envelope;
import org.deegree.geometry.Geometry;
import org.deegree.geometry.gml.GML311GeometryExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exporter class for Features and properties that delegates exporting tasks to the <code>GML311GeometryExporter</code>
 * .
 * 
 * @author <a href="mailto:schneider@lat-lon.de">Markus Schneider </a>
 * @author <a href="mailto:ionita@lat-lon.de">Andrei Ionita</a>
 * @author last edited by: $Author:$
 * 
 * @version $Revision:$, $Date:$
 */
public class GMLFeatureExporter {

    private static final Logger LOG = LoggerFactory.getLogger( GMLFeatureExporter.class );

    private Set<String> exportedIds = new HashSet<String>();

    private XMLStreamWriter writer;

    private GML311GeometryExporter geometryExporter;

    public GMLFeatureExporter( XMLStreamWriter writer ) {
        this.writer = writer;
        geometryExporter = new GML311GeometryExporter( writer, exportedIds );
    }

    // public void export( FeatureCollection featureCol ) throws XMLStreamException {
    // QName fcName = featureCol.getName();
    // LOG.debug( "Exporting FeatureCollection " + fcName );
    // writeStartElementWithNS( fcName.getNamespaceURI(), fcName.getLocalPart() );
    // if ( firstElement ) {
    // writer.writeAttribute( schemaAttributeName, schemaAttributeValue ); //set schema
    // firstElement = false;
    // }
    // Iterator<Feature> iterator = featureCol.iterator();
    // while ( iterator.hasNext() ) {
    // Feature f = iterator.next();
    // writer.writeStartElement( GMLNS, "featureMember" );
    // export( ( Property<?> ) f );
    // writer.writeEndElement();
    // }
    // writer.writeEndElement();
    // }

    public void export( Feature feature )
                            throws XMLStreamException {
        QName featureName = feature.getName();
        LOG.debug( "Exporting Feature {} with ID {}", featureName, feature.getId() );
        writeStartElementWithNS( featureName.getNamespaceURI(), featureName.getLocalPart() );
        if ( feature.getId() != null )
            writer.writeAttribute( GMLNS, "id", feature.getId() );
        for ( Property<?> prop : feature.getProperties() )
            export( prop );
        writer.writeEndElement();
    }

    /**
     * @param col
     * @param schemaLocation
     *            may be null
     * @throws XMLStreamException
     */
    public void export( GenericFeatureCollection col, String schemaLocation )
                            throws XMLStreamException {
        LOG.debug( "Exporting generic feature collection." );
        writer.setPrefix( "gml", GMLNS );
        writer.writeStartElement( "FeatureCollection" );
        if ( schemaLocation != null ) {
            writer.setPrefix( "xsi", XSINS );
            writer.writeAttribute( XSINS, "noNamespaceSchemaLocation", schemaLocation );
        }
        writer.writeStartElement( "http://www.opengis.net/gml", "featureMembers" );
        for ( Feature f : col ) {
            export( f );
        }
        writer.writeEndElement();
        writer.writeEndElement();
    }

    private void export( Property<?> property )
                            throws XMLStreamException {
        QName propName = property.getName();
        PropertyType propertyType = property.getType();
        Object value = property.getValue();
        if ( propertyType instanceof FeaturePropertyType ) {
            Feature fValue = (Feature) value;
            if ( fValue.getId() != null && exportedIds.contains( fValue.getId() ) ) {
                writeEmptyElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
                writer.writeAttribute( XLNNS, "href", "#" + fValue.getId() );
            } else {
                exportedIds.add( fValue.getId() );
                writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
                export( fValue );
                writer.writeEndElement();
            }
        } else if ( propertyType instanceof SimplePropertyType ) {
            writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
            writer.writeCharacters( value.toString() );
            writer.writeEndElement();

        } else if ( propertyType instanceof GeometryPropertyType ) {
            Geometry gValue = (Geometry) value;
            if ( gValue.getId() != null && exportedIds.contains( gValue.getId() ) ) {
                writeEmptyElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
                writer.writeAttribute( XLNNS, "href", "#" + gValue.getId() );
            } else {
                exportedIds.add( gValue.getId() );
                writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
                geometryExporter.export( (Geometry) value );
                writer.writeEndElement();
            }

        } else if ( propertyType instanceof CodePropertyType ) {
            writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
            CodeType codeType = (CodeType) value;
            if ( codeType.getCodeSpace() != null && codeType.getCodeSpace().length() > 0 )
                writer.writeAttribute( "codeSpace", codeType.getCodeSpace() );
            writer.writeCharacters( codeType.getCode() );
            writer.writeEndElement();

        } else if ( propertyType instanceof EnvelopePropertyType ) {
            geometryExporter.export( (Envelope) value );

        } else if ( propertyType instanceof LengthPropertyType ) {
            Length length = (Length) value;
            writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
            writer.writeAttribute( "uom", length.getUomUri() );
            writer.writeCharacters( String.valueOf( length.getValue() ) );
            writer.writeEndElement();

        } else if ( propertyType instanceof MeasurePropertyType ) {
            Measure measure = (Measure) value;
            writeStartElementWithNS( propName.getNamespaceURI(), propName.getLocalPart() );
            writer.writeAttribute( "uom", measure.getUomUri() );
            writer.writeCharacters( String.valueOf( measure.getValue() ) );
            writer.writeEndElement();
        }
    }

    void writeStartElementWithNS( String namespaceURI, String localname )
                            throws XMLStreamException {
        if ( namespaceURI == null || namespaceURI.length() == 0 )
            writer.writeStartElement( localname );
        else
            writer.writeStartElement( namespaceURI, localname );
    }

    void writeEmptyElementWithNS( String namespaceURI, String localname )
                            throws XMLStreamException {
        if ( namespaceURI == null || namespaceURI.length() == 0 )
            writer.writeEmptyElement( localname );
        else
            writer.writeEmptyElement( namespaceURI, localname );
    }

}
