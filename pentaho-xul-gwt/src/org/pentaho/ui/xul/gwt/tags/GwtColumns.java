/*!
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2002-2013 Pentaho Corporation..  All rights reserved.
 */

package org.pentaho.ui.xul.gwt.tags;

import org.pentaho.ui.xul.containers.XulColumn;
import org.pentaho.ui.xul.containers.XulColumns;
import org.pentaho.ui.xul.containers.XulGrid;
import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.gwt.AbstractGwtXulContainer;
import org.pentaho.ui.xul.gwt.GwtXulHandler;
import org.pentaho.ui.xul.gwt.GwtXulParser;

public class GwtColumns extends AbstractGwtXulContainer implements XulColumns {

  public static void register() {
    GwtXulParser.registerHandler( "columns", //$NON-NLS-1$
        new GwtXulHandler() {
          public Element newInstance() {
            return new GwtColumns();
          }
        } );
  }

  public GwtColumns() {
    super( "columns" ); //$NON-NLS-1$
    setManagedObject( "empty" );
  }

  public void addColumn( XulColumn column ) {
    super.addChild( column );
  }

  public XulColumn getColumn( int index ) {
    return (XulColumn) this.children.get( index );
  }

  public int getColumnCount() {
    return this.children.size();
  }

  public XulGrid getGrid() {
    return (XulGrid) getParent();
  }

  public void layout() {

  }

}
