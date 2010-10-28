//$HeadURL$
/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2009 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -

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
package org.deegree.metadata.persistence.iso.parsing.inspectation;

import org.apache.axiom.om.OMElement;
import org.deegree.metadata.persistence.MetadataStoreException;
import org.deegree.metadata.persistence.iso19115.jaxb.AbstractInspector;

/**
 * Abstract base class for all inspector implementations.
 * 
 * @author <a href="mailto:thomas@lat-lon.de">Steffen Thomas</a>
 * @author last edited by: $Author$
 * 
 * @version $Revision$, $Date$
 */
public interface RecordInspector {

    /**
     * Inpectation of one record. The metadatarecord goes into the chain of inspectation.
     * 
     * @param record
     * @return the inspected and (possibly) modified metadatarecord.
     * @throws MetadataStoreException
     */
    public OMElement inspect( OMElement record )
                            throws MetadataStoreException;

    /**
     * Proves the availability of the specific inspector. If there is no inspector available there should be run a
     * default action.
     * 
     * @param inspector
     * @return
     */
    public boolean checkAvailability( AbstractInspector inspector );

}